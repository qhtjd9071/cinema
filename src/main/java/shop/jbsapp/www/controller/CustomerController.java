package shop.jbsapp.www.controller;

import java.security.Principal;
import java.sql.Date;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ch.qos.logback.classic.Logger;
import shop.jbsapp.www.service.CustomersService;
import shop.jbsapp.www.util.PageUtil;
import shop.jbsapp.www.vo.CustomersVo;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	private static Logger logger = (Logger) LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	private CustomersService customersService;
	
	@GetMapping("/main")
	public String main() {
		return "customer/main";
	}
	
	@GetMapping("/insert")
	public String insertForm() {
		return "customer/insert";
	}
	
	@PostMapping("/insert")
	public String insert(@RequestParam(defaultValue = "0") int id, 
								 @RequestParam(defaultValue = "0") int ref, 
								 @RequestParam(defaultValue = "0") int lev, 
								 @RequestParam(defaultValue = "0") int step,
								 String title, String content, Date createDate, Principal principal) {
		CustomersVo vo = new CustomersVo(id, title, content, ref, lev, step, createDate, principal.getName());
		int result = customersService.insert(vo);
		if (result > 0) {
			return "redirect:list";
		}
		return "fail/fail";
	}
	
	@GetMapping("/list")
	public ModelAndView list(String pageNum) {
		ModelAndView mv = new ModelAndView("customer/list");
		int spageNum = 1;
		if (pageNum != null) {
			spageNum = Integer.parseInt(pageNum);
		}
		int count = customersService.count();
		PageUtil pageUtil = new PageUtil(spageNum, 2, 2, count);
		List<CustomersVo> list = customersService.findAllPaging(pageUtil);
		mv.addObject("list", list);
		mv.addObject("pageUtil", pageUtil);
		return mv;
	}
	
	@GetMapping("/detail")
	public ModelAndView detail(int id) {
		ModelAndView mv = new ModelAndView("customer/detail");
		CustomersVo vo = customersService.findById(id);
		mv.addObject("vo", vo);
		return mv;
	}
	
	@GetMapping("/update")
	public ModelAndView updateForm(int id) {
		ModelAndView mv = new ModelAndView("customer/update");
		CustomersVo vo = customersService.findById(id);
		mv.addObject("vo", vo);
		return mv;
	}
	
	@PostMapping("/update")
	public String update(CustomersVo vo) {
		logger.info("{} : {}", vo.getId(), vo.getContent());
		int result = customersService.update(vo);
		if (result > 0) {
			return "redirect:list";
		}
		return "fail/fail";
	}
	
	@GetMapping("/delete")
	public String delete(int id) {
		int result = customersService.deleteById(id);
		if (result > 0) {
			return "redirect:list";
		}
		return "fail/fail";
	}
}
