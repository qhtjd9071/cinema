package shop.jbsapp.www.controller;

import java.security.Principal;

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
	private PaysService payService;
	
	private static final Logger logger = LoggerFactory.getLogger(PayController.class);
	
	@GetMapping("/kakaoPayCancel")
	public void kakaoPayCancel(String partner_order_id) {
		payService.kakaoPayCancel(partner_order_id);
	}
	
	@GetMapping("/kakaoPayFail")
	public void kakaoPayFail(Principal principal) {
		payService.kakaoPayFail(principal.getName());
	}
}
