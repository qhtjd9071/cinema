package shop.jbsapp.www.controller;

import java.security.Principal;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaseController {

	@GetMapping("/")
	public String home(@AuthenticationPrincipal Principal principal) {
		if (principal != null) {
			String authority = principal.getName();
			if (authority != null && authority.equals("admin")) {
				return "admin/main";
			}
		}
		return "layout/main";
	}

}
