package shop.jbsapp.www.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import shop.jbsapp.www.service.BooksService;
import shop.jbsapp.www.service.MoviesService;
import shop.jbsapp.www.service.RoomsService;
import shop.jbsapp.www.util.GetSeatNum;
import shop.jbsapp.www.vo.BooksVo;
import shop.jbsapp.www.vo.MoviesVo;
import shop.jbsapp.www.vo.RoomsVo;

@Controller
@RequestMapping(value = "/book")
public class BookController{
	
	@Autowired
	private BooksService bookService;
	
	@Autowired
	private RoomsService roomsService;
	
	@Autowired
	private MoviesService moviesService;
	
	private static final Logger logger = LoggerFactory.getLogger(BookController.class);
	
	
	@GetMapping("/main")
	public ModelAndView bookForm() {
		List<RoomsVo> list = roomsService.findAll();
		ModelAndView mv = new ModelAndView("book/booking");
		mv.addObject("list", list);
		return mv;
	}
	
	@GetMapping("/countPeople")
	public ModelAndView countForm(@Param(value = "showId") int showId) {
		List<BooksVo> list = bookService.findByShowId(showId);
		List<String> strList = new ArrayList<String>();
		for(BooksVo vo : list) {
			strList = GetSeatNum.getSeatNumList(strList, vo.getSeatNum());
		}
		System.out.println("test:"+list.toString());
		System.out.println("test:"+strList.toString());
		int movieId = bookService.getMovieIdByShowId(showId);
		ModelAndView mv = new ModelAndView("book/countSelection");
		mv.addObject("list", strList);
		mv.addObject("count", bookService.getSeatCountByShowId(showId));
		mv.addObject("showId", showId);
		mv.addObject("movieId", movieId);
		mv.addObject("rating", bookService.getRating(movieId));
		return mv;
	}
	
	@PostMapping("/selection")
	public ModelAndView bookPage(@Param(value = "adultCount") int adultCount, @Param(value = "teenCount") int teenCount, int showId) {
		List<BooksVo> list = bookService.findByShowId(showId);
		List<String> strList = new ArrayList<String>();
		for(BooksVo vo : list) {
			strList = GetSeatNum.getSeatNumList(strList, vo.getSeatNum());
		}
		
		int movieId = bookService.getMovieIdByShowId(showId);
		MoviesVo vo = moviesService.findById(movieId);
		ModelAndView mv = new ModelAndView("book/bookPage");
		mv.addObject("list", strList);
		mv.addObject("count", bookService.getSeatCountByShowId(showId));
		mv.addObject("showId", showId);
		// price 테이블 위치 바꿔야함
		mv.addObject("price", 10000);
		mv.addObject("movieTitle", vo.getTitle());
		mv.addObject("adultCount", adultCount);
		mv.addObject("teenCount", teenCount);
		mv.addObject("totalCount", adultCount + teenCount);
		return mv;
	}
	
	@PostMapping("/theater")
	public @ResponseBody List<RoomsVo> theaterList(String location) {
		List<RoomsVo> list = roomsService.findByLocation(location);
		return list;
	}
	
	@PostMapping("/movieList")
	public @ResponseBody List<Map<String, Object>> movieList(String theaterName, String sort) {
		Map<String, String> map = new HashMap<>();
		map.put("theaterName", theaterName);
		map.put("sort", sort);
		List<Map<String, Object>> list = bookService.movieList(map);
		return list;
	}
	
	@GetMapping("/cancel")
	public String cancel(@Param(value = "bookId") int bookId) {
		int result = bookService.cancel(bookId);
		if (result > 0) {
			return "redirect:/mypage/payList";
		} else {
			return "/fail/fail";
		}
	}
}