package shop.jbsapp.www.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import lombok.val;
import shop.jbsapp.www.service.CommentsService;
import shop.jbsapp.www.service.MoviesService;
import shop.jbsapp.www.vo.CommentsVo;
import shop.jbsapp.www.vo.MoviesVo;

@Controller
@RequestMapping(value = "/comments")
public class CommentController {
	
	@Autowired
	private CommentsService commentsService;
	@Autowired
	private MoviesService movieService;
	
	private static final Logger logger = LoggerFactory.getLogger(CommentController.class);
	
	@GetMapping("/main")
	public ModelAndView commentsForm(int movieNum) {
		MoviesVo vo = movieService.findById(movieNum);
		double grade = commentsService.getAvgStarByMovieId(movieNum);
		ModelAndView mv = new ModelAndView("movie/moviecomments");
		mv.addObject("vo", vo);
		mv.addObject("grade", grade);
		return mv;
	}
	
	@GetMapping("/insert")
	public @ResponseBody boolean insert(@Param(value = "movieId") int movieId, String userId, String content, @Param(value = "star") int star) {
		CommentsVo vo = new CommentsVo();
		vo.setMovieId(movieId);;
		vo.setUserId(userId);
		vo.setContent(content);
		vo.setStar(star);
		System.out.println("vo:"+vo);
		int result = commentsService.insert(vo);
		if (result > 0) {
			return true;
		} else {
			return false;
		}
		
	}
	
	@GetMapping("/delete")
	public @ResponseBody boolean delete(@Param(value = "id") int id) {
		int result = commentsService.deleteById(id);
		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}
	@GetMapping("/list")
	public @ResponseBody List<CommentsVo> list(int movieId) {
		System.out.println("listcheck:");
		List<CommentsVo> list = commentsService.findByMovieId(movieId);
		return list;
	}
	
}
