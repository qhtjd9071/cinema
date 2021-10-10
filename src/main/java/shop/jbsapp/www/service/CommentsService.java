package shop.jbsapp.www.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.jbsapp.www.mapper.CommentsMapper;
import shop.jbsapp.www.vo.CommentsVo;

@Service
@Transactional
public class CommentsService {

	@Autowired
	private CommentsMapper commentsMapper;
	
	public int insert(CommentsVo vo) {
		return commentsMapper.insert(vo);
	}

	public int deleteById(int id) {
		return commentsMapper.deleteById(id);
	}

	public double getAvgStarByMovieId(int movieId) {
		return commentsMapper.getAvgStarByMovieId(movieId);
	}

	public List<CommentsVo> findByMovieId(int movieId) {
		return commentsMapper.findByMovieId(movieId);
	}

}
