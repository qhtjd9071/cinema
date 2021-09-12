package shop.jbsapp.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import shop.jbsapp.www.service.UsersService;
import shop.jbsapp.www.vo.UsersVo;

@Controller
@RequestMapping("/member")
public class UserController {

	@Autowired
	private UsersService usersService;
	
	@GetMapping("/loginForm")
	public String loginForm() {
		return "member/loginForm";
	}
	
	@GetMapping("/joinForm")
	public String joinForm() {
		return "member/joinForm";
	}
	
	@PostMapping("/join")
	public String join(UsersVo vo) {
		usersService.join(vo);
		return "redirect:/";
	}
	
	@GetMapping("/checkId")
	@ResponseBody
	public String checkId(String id) {
		UsersVo vo = usersService.checkId(id);
		if (vo != null) {
			return "true";
		} else {
			return "false";
		}
	}
	
	@GetMapping("/accessDenied")
	public String accessDenied() {
		return "member/accessDenied";
	}
}
