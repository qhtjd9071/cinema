package shop.jbsapp.www.controller.api;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import shop.jbsapp.www.service.PaysService;

@RestController
@RequestMapping("/api/pay")
public class PayRestController {

	@Autowired
	private PaysService paysService;
	
	@PostMapping("/kakaoPayReady")
	public String kakaoPayReady(@RequestBody Map<String, Object> params) {
		return paysService.kakaoPayReady(params);
	}
	
	@GetMapping("/kakaoPayApprove")
	public String kakaoPayApprove(String partner_order_id, String pg_token, Principal principal) {
		Map<String, String> map = new HashMap<>();
		map.put("partner_order_id", partner_order_id);
		map.put("pg_token", pg_token);
		map.put("id", principal.getName());
		paysService.kakaoPayApprove(map);
		return "/";
	}
}
