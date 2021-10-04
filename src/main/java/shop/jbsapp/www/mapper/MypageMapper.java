package shop.jbsapp.www.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import shop.jbsapp.www.vo.CustomersVo;

@Mapper
public interface MypageMapper {

	List<Map<String, Object>> myBook(String userId);
	
	int countByUserId(String userId);
	
	List<CustomersVo> inquiryList(Map<String, Object> map);
	
}