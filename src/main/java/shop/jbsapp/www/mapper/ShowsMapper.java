package shop.jbsapp.www.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import shop.jbsapp.www.util.PageUtil;

@Mapper
public interface ShowsMapper {

	int insert(Map<String, Object> map);
	
	int deleteById(int id);
	
	List<Map<String, Object>> showListPaging(PageUtil pageUtil);
	
	int count();

	int getPriceById(int id);
}
