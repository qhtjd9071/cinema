package shop.jbsapp.www.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import shop.jbsapp.www.service.MoviesService;
import shop.jbsapp.www.util.PageUtil;
import shop.jbsapp.www.vo.MoviesVo;

@Controller
@RequestMapping("/movie")
public class MovieController {

	@Autowired
	private MoviesService moviesService;

	@GetMapping("/main")
	public ModelAndView main() {
		ModelAndView mv = new ModelAndView("movie/main");
		List<MoviesVo> list = moviesService.findAll();
		mv.addObject("list", list);
		return mv;
	}
	
	@GetMapping("/insert")
	public String insertForm() {
		return "movie/insert";
	}
	
	@PostMapping("/insert")
	public String insert(MoviesVo vo) {
		System.out.println(vo.toString());
		int result = moviesService.insert(vo);
		if (result > 0) {
			return "redirect:list";
		}
		return "fail/fail";
	}
	
	@GetMapping("/list")
	public ModelAndView list(String pageNum) {
		ModelAndView mv = new ModelAndView("movie/list");
		int spageNum = 1;
		if (pageNum != null) {
			spageNum = Integer.parseInt(pageNum);
		}
		int count = moviesService.count();
		PageUtil pageUtil = new PageUtil(spageNum, 2, 2, count);
		List<MoviesVo> list = moviesService.findAllPaging(pageUtil);
		mv.addObject("list", list);
		mv.addObject("pageUtil", pageUtil);
		return mv;
	}
	
	@GetMapping("/delete")
	public String delete(int id) {
		int result = moviesService.deleteById(id);
		if (result > 0) {
			return "redirect:list";
		}
		return "fail/fail";
	}
	
	@PostMapping("/movieList")
	public @ResponseBody List<MoviesVo> movieList() {
		List<MoviesVo> list = moviesService.findAll();
		return list;
	}
}
