package shop.jbsapp.www.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import shop.jbsapp.www.service.PaysService;

@Controller
@RequestMapping(value = "/pay")
public class PayController {
	@Autowired
	private PaysService paysService;
	
	private static final Logger logger = LoggerFactory.getLogger(PayController.class);
	
	@GetMapping("/kakaoPayCancel")
	public void kakaoPayCancel(String partner_order_id) {
		paysService.kakaoPayCancel(partner_order_id);
	}
	
	@GetMapping("/kakaoPayApprove")
	public String kakaoPayApprove(String partner_order_id, String pg_token, Principal principal) {
		Map<String, String> map = new HashMap<>();
		map.put("partner_order_id", partner_order_id);
		map.put("pg_token", pg_token);
		map.put("id", principal.getName());
		paysService.kakaoPayApprove(map);
		return "redirect:/mypage/payList";
	}
	
	@GetMapping("/kakaoPayFail")
	public void kakaoPayFail(Principal principal) {
		paysService.kakaoPayFail(principal.getName());
	}
	
}
