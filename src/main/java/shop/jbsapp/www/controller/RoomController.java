package shop.jbsapp.www.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import shop.jbsapp.www.service.RoomsService;
import shop.jbsapp.www.util.PageUtil;
import shop.jbsapp.www.vo.RoomsVo;

@Controller
@RequestMapping("/room")
public class RoomController {
	
	@Autowired
	private RoomsService roomsService;
	
	@GetMapping("/insert")
	public String insertForm() {
		return "room/insert";
	}
	
	@PostMapping("/insert")
	public String insert(RoomsVo vo) {
		int result = roomsService.insert(vo);
		if(result > 0) {
			return "redirect:list";
		}
		return "fail/fail";
	}
	
	@GetMapping("/list")
	public ModelAndView list(String pageNum) {
		ModelAndView mv = new ModelAndView("room/list");
		int spageNum = 1;
		if (pageNum != null) {
			spageNum = Integer.parseInt(pageNum);
		}
		int count = roomsService.count();
		PageUtil pageUtil = new PageUtil(spageNum, 2, 2, count);
		List<RoomsVo> list = roomsService.findAllPaging(pageUtil);
		mv.addObject("list", list);
		mv.addObject("pageUtil", pageUtil);
		return mv;
	}
	
	@GetMapping("/delete")
	public String delete(int id) {
		int result = roomsService.deleteById(id);
		if(result > 0) {
			return "redirect:list";
		}
		return "fail/fail";
	}
	
	@PostMapping("/roomList")
	public @ResponseBody List<RoomsVo> movieList() {
		List<RoomsVo> list = roomsService.findAll();
		return list;
	}
}
