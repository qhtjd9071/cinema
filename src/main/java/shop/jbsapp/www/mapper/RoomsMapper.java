package shop.jbsapp.www.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import shop.jbsapp.www.util.PageUtil;
import shop.jbsapp.www.vo.RoomsVo;

@Mapper
public interface RoomsMapper {

	int insert(RoomsVo vo);
	
	int deleteById(int id);
	
	List<RoomsVo> findAll();

	List<RoomsVo> findByLocation(String location);
	
	List<RoomsVo> findAllPaging(PageUtil pageUtil);
	
	int count();
}
