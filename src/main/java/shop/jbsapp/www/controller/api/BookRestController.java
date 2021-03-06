package shop.jbsapp.www.controller.api;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import shop.jbsapp.www.service.BooksService;
import shop.jbsapp.www.util.GetSeatNum;
import shop.jbsapp.www.vo.BooksVo;

@RestController
@RequestMapping("/api/book")
public class BookRestController {
	
	@Autowired
	private BooksService booksService;
	
	@PostMapping("/book")
	public int book(@RequestBody Map<String, Object> params, Principal principal) {
		BooksVo vo = new BooksVo();
		int price = (int) params.get("price");
		String seatNum = ((String) params.get("seatNum")).toString();
		int showId = (int) params.get("showId");
		vo.setPrice(price);
		vo.setSeatNum(seatNum);
		vo.setShowId(showId);
		vo.setUserId(principal.getName());
		Integer checkSeat = booksService.getIdBySeatNumAndShowId(params);
		if (checkSeat != null) {
			return -1;
		} else {
			booksService.insert(vo);
			return booksService.getIdBySeatNumAndShowId(params);
		}
 	}
	
	@GetMapping("/showList")
	public List<Map<String, Object>> showList(String begintime, String movieTitle, String theaterName) {
		String[] tmp = begintime.split("/");
		
		String beginTime = tmp[0] + "/" + tmp[1] + "/";
		
		if (tmp[2].length() == 1) {
			beginTime +=  "0" + tmp[2];
		} else {
			beginTime += tmp[2];
		}
		
		Map<String, Object> map = new HashMap<>();

		map.put("beginTime", beginTime);
		map.put("title", movieTitle);
		map.put("theaterName", theaterName);
		
		List<Map<String, Object>> result = booksService.roomList(map);
		return result;
	}
	
	@PostMapping("/timeList")
	public List<Map<String, Object>> timeList(String begintime, String movieTitle, String theaterName, @Param(value = "roomNum") int roomNum) {
		String[] tmp = begintime.split("/");
		
		String beginTime = tmp[0] + "/" + tmp[1] + "/";
		
		if (tmp[2].length() == 1) {
			beginTime +=  "0" + tmp[2];
		} else {
			beginTime += tmp[2];
		}
		Map<String, Object> map = new HashMap<>();
		map.put("beginTime", beginTime);
		map.put("title", movieTitle);
		map.put("theaterName", theaterName);
		map.put("roomNum", roomNum);
		
		List<Map<String, Object>> result = booksService.roomList(map);
		return result;
	}
}
