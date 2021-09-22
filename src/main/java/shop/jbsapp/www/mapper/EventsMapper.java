package shop.jbsapp.www.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import shop.jbsapp.www.util.PageUtil;
import shop.jbsapp.www.vo.EventsVo;

@Mapper
public interface EventsMapper {

	int insert(EventsVo vo);
	
	int deleteById(int id);
	
	List<EventsVo> findAll();
	
	List<EventsVo> findAllPaging(PageUtil pageUtil);

	EventsVo findById(int id);
	
	int count();
}
