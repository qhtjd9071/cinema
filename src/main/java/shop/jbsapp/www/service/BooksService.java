package shop.jbsapp.www.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.jbsapp.www.mapper.BooksMapper;
import shop.jbsapp.www.mapper.PaysMapper;
import shop.jbsapp.www.vo.BooksVo;

@Service
@Transactional
public class BooksService {

	@Autowired
	private BooksMapper booksMapper;
	
	@Autowired
	private PaysMapper paysMapper;
	
	public int insert(BooksVo vo) {
		return booksMapper.insert(vo);
	}

	public int deleteById(int id) {
		return booksMapper.deleteById(id);
	}

	public List<Map<String, Object>> movieList(Map<String, String> map) {
		return booksMapper.movieList(map);
	}

	public List<Map<String, Object>> roomList(Map<String, Object> map) {
		return booksMapper.roomList(map);
	}

	public int getSeatCountByShowId(int showId) {
		return booksMapper.getSeatCountByShowId(showId);
	}

	public List<BooksVo> findByShowId(int showId) {
		return booksMapper.findByShowId(showId);
	}

	public int getMovieIdByShowId(int showId) {
		return booksMapper.getMovieIdByShowId(showId);
	}

	public String getRating(int movieId) {
		return booksMapper.getRating(movieId);
	}

	public int getIdByShowId(int showId) {
		return booksMapper.getIdByShowId(showId);
	}

	public Integer getIdBySeatNumAndShowId(Map<String, Object> params) {
		return booksMapper.getIdBySeatNumAndShowId(params);
	}

	public int cancel(int bookId) {
		try {
			paysMapper.deleteByBookId(bookId);
			booksMapper.deleteById(bookId);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}


}
