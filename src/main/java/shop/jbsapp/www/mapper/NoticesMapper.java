package shop.jbsapp.www.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import shop.jbsapp.www.util.PageUtil;
import shop.jbsapp.www.vo.NoticesVo;

@Mapper
public interface NoticesMapper {

	int insert(NoticesVo vo);
	
	int deleteById(int id);
	
	List<NoticesVo> findAll();
	
	NoticesVo findById(int id);
	
	List<NoticesVo> findAllPaging(PageUtil pageUtil);
	
	int update(NoticesVo vo);
	
	void increaseHit();
	
	int count();
}
