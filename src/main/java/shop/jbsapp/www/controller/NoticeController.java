package shop.jbsapp.www.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ch.qos.logback.classic.Logger;
import shop.jbsapp.www.service.NoticesService;
import shop.jbsapp.www.util.PageUtil;
import shop.jbsapp.www.vo.NoticesVo;

@Controller
@RequestMapping("/notice")
public class NoticeController {
	
	private static Logger logger = (Logger) LoggerFactory.getLogger(NoticeController.class);
	@Autowired
	private NoticesService noticesService;
	
	@GetMapping("/insert")
	public String insertForm() {
		return "notice/insert";
	}
	
	@PostMapping("/insert")
	public String insert(NoticesVo vo) {
		int result = noticesService.insert(vo);
		if (result > 0) {
			return "redirect:list";
		}
		return "fail/fail";
	}
	
	@GetMapping("/list")
	public ModelAndView list(String pageNum) {
		ModelAndView mv = new ModelAndView("notice/list");
		int spageNum = 1;
		if (pageNum != null) {
			spageNum = Integer.parseInt(pageNum);
		}
		int count = noticesService.count();
		PageUtil pageUtil = new PageUtil(spageNum, 2, 2, count);
		List<NoticesVo> list = noticesService.findAllPaging(pageUtil);
		mv.addObject("list", list);
		mv.addObject("pageUtil", pageUtil);
		return mv;
	}
	
	@GetMapping("/detail")
	public ModelAndView detail(int id) {
		ModelAndView mv = new ModelAndView("notice/detail");
		NoticesVo vo = noticesService.findById(id);
		mv.addObject("vo", vo);
		return mv;
	}
	
	@GetMapping("/update")
	public ModelAndView updateForm(int id) {
		ModelAndView mv = new ModelAndView("notice/update");
		NoticesVo vo = noticesService.findById(id);
		mv.addObject("vo", vo);
		return mv;
	}
	
	@PostMapping("/update")
	public String update(NoticesVo vo) {
		logger.info("{} : {}", vo.getId(), vo.getContent());
		int result = noticesService.update(vo);
		if (result > 0) {
			return "redirect:list";
		}
		return "fail/fail";
	}
	
	@GetMapping("/delete")
	public String delete(int id) {
		int result = noticesService.deleteById(id);
		if (result > 0) {
			return "redirect:list";
		}
		return "fail/fail";
	}
}
