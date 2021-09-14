package shop.jbsapp.www.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import shop.jbsapp.www.util.PageUtil;
import shop.jbsapp.www.vo.MoviesVo;

@Mapper
public interface MoviesMapper {

	int insert(MoviesVo vo);
	
	int deleteById(int id);
	
	List<MoviesVo> findAll();
	
	MoviesVo findById(int id);
	
	int count();
	
	List<MoviesVo> findAllPaging(PageUtil pageUtil);
	
}
