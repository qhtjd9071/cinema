package shop.jbsapp.www.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.jbsapp.www.mapper.MypageMapper;
import shop.jbsapp.www.util.GetSeatNum;
import shop.jbsapp.www.vo.CustomersVo;

@Service
@Transactional
public class MypageService{

	@Autowired
	private MypageMapper mypageMapper;
	
	public List<Map<String, Object>> myBook(String userId) {
		List<Map<String, Object>> list = mypageMapper.myBook(userId);
		for(Map<String, Object> map : list) {
			String seatNum = (String)map.get("SEATNUM");
			String newSeatNum = GetSeatNum.getSeatNumList(seatNum);
			map.put("SEATNUM", newSeatNum);
		}
		return list;
	}

	public int countByUserId(String userId) {
		return mypageMapper.countByUserId(userId);
	}

	public List<CustomersVo> inquiryList(Map<String, Object> map) {
		return mypageMapper.inquiryList(map);
	}

}
