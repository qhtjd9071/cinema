package shop.jbsapp.www.controller.api;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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
	
}
