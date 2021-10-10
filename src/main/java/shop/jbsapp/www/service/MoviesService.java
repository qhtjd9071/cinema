package shop.jbsapp.www.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.jbsapp.www.mapper.CommentsMapper;
import shop.jbsapp.www.mapper.MoviesMapper;
import shop.jbsapp.www.util.PageUtil;
import shop.jbsapp.www.vo.MoviesVo;

@Service
@Transactional
public class MoviesService {

	@Autowired
	private MoviesMapper moviesMapper;
	
	@Autowired
	private CommentsMapper commentsMapper;
	
	public int insert(MoviesVo vo) {
		return moviesMapper.insert(vo);
	}

	public int deleteById(int id) {
		return moviesMapper.deleteById(id);
	}

	public List<MoviesVo> findAll() {
		return moviesMapper.findAll();
	}

	public MoviesVo findById(int id) {
		return moviesMapper.findById(id);
	}
	
	public int count() {
		return moviesMapper.count();
	}

	public List<MoviesVo> findAllPaging(PageUtil pageUtil) {
		return moviesMapper.findAllPaging(pageUtil);
	}

	public Map<String, Object> detailById(int id) {
		Map<String, Object> map = new HashMap<>();
		map.put("vo", moviesMapper.findById(id));
		map.put("grade", commentsMapper.getAvgStarByMovieId(id));
		return map;
	}

}
