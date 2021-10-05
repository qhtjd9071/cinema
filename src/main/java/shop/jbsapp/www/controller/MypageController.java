package shop.jbsapp.www.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import shop.jbsapp.www.service.MypageService;
import shop.jbsapp.www.util.PageUtil;
import shop.jbsapp.www.vo.CustomersVo;

@Controller
@RequestMapping(value = "/mypage")
public class MypageController {
	
	@Autowired
	private MypageService mypageService;
	
	private static final Logger logger = LoggerFactory.getLogger(MypageController.class);
	
	@GetMapping("/payList")
	public ModelAndView payList(Principal principal) {
		String id = principal.getName();
		List<Map<String, Object>> list = mypageService.myBook(id);
		ModelAndView mv = new ModelAndView("mypage/mypage");
		mv.addObject("page", "myBook");
		mv.addObject("list", list);
		mv.addObject("target", "payList");
		return mv;
	}
	
	@GetMapping("/inquiry")
	public ModelAndView inquiry(@RequestParam(value = "pageNum", required = false) String spageNum, Principal principal) {
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
		mv.addObject("page", "inquiry");
		mv.addObject("list", list);
		mv.addObject("pageUtil", pageUtil);
		mv.addObject("target", "inquiry");
		return mv;
	}
	
	@GetMapping("/myInfo")
	public ModelAndView myinfo() {
		ModelAndView mv = new ModelAndView("mypage/mypage");
		mv.addObject("page", "info");
		mv.addObject("target", "myInfo");
		return mv;
	}
	
	@GetMapping("/delAccount")
	public ModelAndView delAccount() {
		ModelAndView mv = new ModelAndView("mypage/mypage");
		mv.addObject("page", "withdrawal");
		mv.addObject("target", "delAccount");
		return mv;
	}
}