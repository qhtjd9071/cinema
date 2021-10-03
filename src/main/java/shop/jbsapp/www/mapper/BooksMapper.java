package shop.jbsapp.www.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import shop.jbsapp.www.vo.BooksVo;

@Mapper
public interface BooksMapper {
	
	int insert(BooksVo vo);
	
	int deleteById(int id);
	
	BooksVo findById(int id);

	List<Map<String, Object>> movieList(Map<String, String> map);
	
	List<Map<String, Object>> roomList();
	
	List<Map<String, Object>> roomList(Map<String, Object> map);
	
	int getSeatCountByShowId(int showId);
	
	List<BooksVo> findByShowId(int showId);
	
	int getMovieIdByShowId(int showId);

	String getRating(int movieId);

	int getIdByShowId(int showId);

	int getIdBySeatNumAndShowId(Map<String, Object> params);

}
