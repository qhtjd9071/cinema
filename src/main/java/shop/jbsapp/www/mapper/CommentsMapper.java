package shop.jbsapp.www.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import shop.jbsapp.www.vo.CommentsVo;

@Mapper
public interface CommentsMapper {
	
	int insert(CommentsVo vo);
	
	int deleteById(int id);
	
	double getAvgStarByMovieId(int movieId);
	
	List<CommentsVo> findByMovieId(int movieId);

}
