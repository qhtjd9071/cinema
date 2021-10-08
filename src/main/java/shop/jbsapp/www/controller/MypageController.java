package shop.jbsapp.www.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import shop.jbsapp.www.service.MypageService;
import shop.jbsapp.www.service.UsersService;
import shop.jbsapp.www.util.PageUtil;
import shop.jbsapp.www.vo.CustomersVo;
import shop.jbsapp.www.vo.UsersVo;

@Controller
@RequestMapping(value = "/mypage")
public class MypageController {
	
	@Autowired
	private MypageService mypageService;
	
	@Autowired
	private UsersService usersService;
	
	private static final Logger logger = LoggerFactory.getLogger(MypageController.class);
	
	@GetMapping("/payList")
	public ModelAndView payList(Principal principal) {
		String id = principal.getName();
		List<Map<String, Object>> list = mypageService.myBook(id);
		ModelAndView mv = new ModelAndView("mypage/mypage");
		mv.addObject("list", list);
		mv.addObject("target", "payList");
		return mv;
	}
	
	@GetMapping("/inquiry")
	public ModelAndView inquiry(@RequestParam(value = "pageNum", required = false) String spageNum, Principal principal) {
		System.out.println("check1");
		int pageNum = 1;
		if(spageNum != null) {
			pageNum = Integer.parseInt(spageNum);
		}
		PageUtil pageUtil = new PageUtil(pageNum, 2, 2, mypageService.countByUserId(principal.getName()));//spagenum,count
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pageUtil", pageUtil);
		map.put("userId", principal.getName());
		
		List<CustomersVo> list = mypageService.inquiryList(map);
		ModelAndView mv = new ModelAndView("mypage/mypage");
		mv.addObject("list", list);
		mv.addObject("pageUtil", pageUtil);
		mv.addObject("target", "myInquiry");
		return mv;
	}
	
	@GetMapping("/myInfo")
	public ModelAndView myinfo(Principal principal) {
		String id = principal.getName();
		ModelAndView mv = new ModelAndView("mypage/mypage");
		UsersVo vo = usersService.findById(id);
		mv.addObject("vo", vo);
		mv.addObject("target", "myInfo");
		return mv;
	}
	
	@GetMapping("/delAccount")
	public ModelAndView delAccount() {
		ModelAndView mv = new ModelAndView("mypage/mypage");
		mv.addObject("target", "delAccount");
		return mv;
	}
	
	@GetMapping("/updatePwd")
	public String pwdUpdateForm() {
		return "mypage/pwdUpdateForm";
	}
	
	@PostMapping("/updatePwd")
	public String pwdUpdate(Authentication authentication, Principal principal, String currpwd, String newpwd1) {
		boolean checkPwd = usersService.checkPwd(currpwd, authentication);
		String userId = principal.getName();
		if (checkPwd) {
			usersService.updatePwd(userId, newpwd1);
			return "redirect:/";
		} else {
			return "/fail/fail";
		}
	}
	
	@PostMapping("/delete")
	public String deleteUser(Authentication authentication, Principal principal, String pwd, String newpwd1, HttpSession session) {
		boolean checkPwd = usersService.checkPwd(pwd, authentication);
		String userId = principal.getName();
		if (checkPwd) {
			usersService.deleteById(userId);
			return "redirect:/logout";
		} else {
			return "/fail/fail";
		}
	}
}