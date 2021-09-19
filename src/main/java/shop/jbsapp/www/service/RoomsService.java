package shop.jbsapp.www.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.jbsapp.www.mapper.RoomsMapper;
import shop.jbsapp.www.util.PageUtil;
import shop.jbsapp.www.vo.RoomsVo;

@Service
@Transactional
public class RoomsService {

	@Autowired
	private RoomsMapper roomsMapper;
	
	public int insert(RoomsVo vo) {
		return roomsMapper.insert(vo);
	}

	public int deleteById(int id) {
		return roomsMapper.deleteById(id);
	}

	public List<RoomsVo> findAll() {
		return roomsMapper.findAll();
	}
	
	public List<RoomsVo> findByLocation(String location) {
		return roomsMapper.findByLocation(location);
	}

	public int count() {
		return roomsMapper.count();
	}

	public List<RoomsVo> findAllPaging(PageUtil pageUtil) {
		return roomsMapper.findAllPaging(pageUtil);
	}

}
