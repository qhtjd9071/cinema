package shop.jbsapp.www.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import shop.jbsapp.www.vo.PaysVo;

@Mapper
public interface PaysMapper {

	int insert(PaysVo vo);
	
	int update(PaysVo vo);
	
	int deleteByBookId(int bookId);
	
	PaysVo findByBookId(int bookId);
	
	List<PaysVo> findAll();
}
