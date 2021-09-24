package shop.jbsapp.www.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import shop.jbsapp.www.service.ShowsService;
import shop.jbsapp.www.util.PageUtil;

@Controller
@RequestMapping(value = "/show")
public class ShowController {
	@Autowired
	private ShowsService showService;
	
	private static final Logger logger = LoggerFactory.getLogger(ShowController.class);
	
	@GetMapping("/insert")
	public String showInsertForm() {
		return "show/insert";
	}
	
	@PostMapping("/insert")
	public String showInsert(int movieId, String begin, String end, int roomId, int price) {
		
		Map<String, Object> map = new HashMap<>();
		map.put("movieId", movieId);
		map.put("beginTime", begin);
		map.put("endTime", end);
		map.put("roomId", roomId);
		map.put("price", price);
		
		showService.insert(map);
		return "redirect:list";
	}
	
	@GetMapping("/list")
	public ModelAndView showList(@RequestParam(value = "pageNum", required = false) String spageNum) {
		int pageNum = 1;
		if(spageNum != null) {
			pageNum = Integer.parseInt(spageNum);
		}
		PageUtil pageUtil = new PageUtil(pageNum, 2, 2, showService.count());
		List<Map<String, Object>> list = showService.showListPaging(pageUtil);
		ModelAndView mv = new ModelAndView("show/list");
		mv.addObject("list", list);
		mv.addObject("pageUtil", pageUtil);
		return mv;
	}
	
	@GetMapping("/delete")
	public String showDelete(int id) {
		showService.deleteById(id);
		return "redirect:list";
	}
	
}
