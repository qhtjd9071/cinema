package shop.jbsapp.www.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import shop.jbsapp.www.mapper.BooksMapper;
import shop.jbsapp.www.mapper.PaysMapper;
import shop.jbsapp.www.util.BookCancel;
import shop.jbsapp.www.vo.PaysVo;

@Service
@Transactional
public class PaysService {

	@Autowired
	private PaysMapper payMapper;
	@Autowired
	private BooksMapper bookMapper;

	private static final Logger logger = LoggerFactory.getLogger(PaysService.class);

	private final String HOST = "https://kapi.kakao.com";

	// @Value("${HomePageUrl}")
	private String HomePageUrl = "http://localhost:8090";

	public String kakaoPayReady(Map<String, Object> map) {

		logger.info("kakaoPayReady=================================================={}", map.toString());
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK " + "2668af820c7a5e9072a3f9629c1cc7da");// KaKaoAK + Admin key

		String partner_order_id = (String) map.get("bookId");
		String partner_user_id = (String) map.get("userId");
		String item_name = (String) map.get("title");
		String quantity = Integer.toString((int) map.get("count"));
		String total_amount = Integer.toString((int) map.get("total"));

		String approval_url = HomePageUrl + "/pay/kakaoPayApprove?partner_order_id=" + partner_order_id;
		String cancel_url = HomePageUrl + "/pay/kakaoPayCancel";
		String fail_url = HomePageUrl + "/pay/kakaoPayFail";

		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("cid", "TC0ONETIME");
		params.add("partner_order_id", partner_order_id);
		params.add("partner_user_id", partner_user_id);
		params.add("item_name", item_name);
		params.add("quantity", quantity);
		params.add("total_amount", total_amount);
		params.add("tax_free_amount", total_amount);
		params.add("approval_url", approval_url);
		params.add("cancel_url", cancel_url);
		params.add("fail_url", fail_url);

		HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String, String>>(params, headers);

		Map<String, Object> responseMap = null;
		try {
			responseMap = restTemplate.postForObject(new URI(HOST + "/v1/payment/ready"), body, Map.class);
		} catch (RestClientException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		String tid = null;
		String next_redirect_pc_url = null;
		try {
			logger.info("response from kakao {}", responseMap.toString());

			tid = (String) responseMap.get("tid");
			next_redirect_pc_url = (String) responseMap.get("next_redirect_pc_url");
		} catch (NullPointerException e) {
			logger.info("Response Data not exist");
		}
		PaysVo vo = new PaysVo();
		vo.setId(tid);
		vo.setBookId(Integer.parseInt(partner_order_id));
		
		payMapper.insert(vo);

		return next_redirect_pc_url;
	}

	public void kakaoPayApprove(Map<String, String> map) {

		logger.info("kakaoPayApprove");
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK " + "2668af820c7a5e9072a3f9629c1cc7da");

		String partner_order_id = map.get("partner_order_id");
		String partner_user_id = map.get("id");
		String pg_token = map.get("pg_token");

		int bookNum = Integer.parseInt(partner_order_id);
		String tid = null;
		try {
			PaysVo vo = payMapper.findByBookId(bookNum);
			tid = vo.getId();
		} catch (NullPointerException ne) {
			logger.info("Book not exist");
		}

		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("cid", "TC0ONETIME");
		params.add("tid", tid);
		params.add("partner_order_id", partner_order_id);
		params.add("partner_user_id", partner_user_id);
		params.add("pg_token", pg_token);

		logger.info("tid {}, pod {}, pud {}, pg {}", tid, partner_order_id, partner_user_id, pg_token);

		HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String, String>>(params, headers);

		Map<String, Object> responseMap = null;
		try {
			responseMap = restTemplate.postForObject(new URI(HOST + "/v1/payment/approve"), body, Map.class);
		} catch (RestClientException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		String payment_method_type = null;
		Map<String, Object> amount = null;
		int total = 0;
		try {
			logger.info("response from kakao {}", responseMap.toString());

			payment_method_type = (String) responseMap.get("payment_method_type");
			amount = (Map<String, Object>) responseMap.get("amount");
			logger.info("total {}", amount.get("total"));
			total = (int) amount.get("total");
		} catch (NullPointerException e) {
			logger.info("Response Data not exist");
		}
		PaysVo vo = new PaysVo();
		vo.setId(tid);
		vo.setMethod(payment_method_type);
		vo.setTotal(total);
		payMapper.update(vo);
	}

	public void kakaoPayCancel(String partner_order_id) {

		logger.info("kakaoPayCancel");
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK " + "2668af820c7a5e9072a3f9629c1cc7da");

		int bookNum = Integer.parseInt(partner_order_id);
		PaysVo vo = payMapper.findByBookId(bookNum);
		String tid = vo.getId();
		String cancel_amount = Integer.toString(vo.getTotal());

		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("cid", "TC0ONETIME");
		params.add("tid", tid);
		params.add("cancel_amount", cancel_amount);
		params.add("cancel_tax_free_amount", cancel_amount);

		HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String, String>>(params, headers);

		Map<String, Object> responseMap = null;
		try {
			responseMap = restTemplate.postForObject(new URI(HOST + "/v1/payment/cancel"), body, Map.class);
		} catch (RestClientException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		String responsePOD = null;
		try {
			logger.info("response from kakao {}", responseMap.toString());
			responsePOD = (String) responseMap.get("partner_order_id");
			int responseBookNum = Integer.parseInt(responsePOD);
			payMapper.deleteByBookId(responseBookNum);
			bookMapper.deleteById(responseBookNum);
		} catch (NullPointerException e) {
			logger.info("Response Data not exist => Fail to cancel");
		}

	}

	public void kakaoPayFail(String id) {
		logger.info("Fail to pay");
		BookCancel.cancel(payMapper, bookMapper, id);
	}
}