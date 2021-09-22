package shop.jbsapp.www.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import shop.jbsapp.www.service.EventsService;
import shop.jbsapp.www.util.PageUtil;
import shop.jbsapp.www.vo.EventsVo;

@Controller
public class EventController {
	
	@Autowired
	private EventsService eventsService;
	
	@GetMapping("/event/main")
	public ModelAndView eventMain() {
		ModelAndView mv = new ModelAndView("event/eventMain");
		List<EventsVo> list = eventsService.findAll();
		mv.addObject("list", list);
		return mv;
	}
	
	@GetMapping("/event/detail")
	public ModelAndView eventDetail(int id) {
		ModelAndView mv = new ModelAndView("event/eventDetail");
		EventsVo vo = eventsService.findById(id);
		mv.addObject("vo", vo);
		return mv;
	}
	
	@GetMapping("/event/insert")
	public String eventForm() {
		return "event/eventEnroll";
	}
	
	@PostMapping("/event/insert")
	public String eventInsert(EventsVo vo) {
		int result = eventsService.insert(vo);
		if (result > 0) {
			return "redirect:list";
		}
		return "fail/fail";
	}
	
	@GetMapping("/event/list")
	public ModelAndView eventList(String pageNum) {
		ModelAndView mv = new ModelAndView("event/eventEnrollList");
		int spageNum = 1;
		if (pageNum != null) {
			spageNum = Integer.parseInt(pageNum);
		}
		int count = eventsService.count();
		PageUtil pageUtil = new PageUtil(spageNum, 2, 2, count);
		List<EventsVo> list = eventsService.findAllPaging(pageUtil);
		mv.addObject("list", list);
		mv.addObject("pageUtil", pageUtil);
		return mv;
	}
	
	@GetMapping("/event/delete")
	public String eventDelete(int id) {
		int result = eventsService.deleteById(id);
		if (result > 0) {
			return "redirect:list";
		}
		return "fail/fail";
	}
}
