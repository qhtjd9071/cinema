package shop.jbsapp.www.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.jbsapp.www.mapper.EventsMapper;
import shop.jbsapp.www.util.PageUtil;
import shop.jbsapp.www.vo.EventsVo;

@Service
@Transactional
public class EventsService {
	
	@Autowired
	private EventsMapper eventsMapper;
	
	public int insert(EventsVo vo) {
		return eventsMapper.insert(vo);
	}

	public int deleteById(int id) {
		return eventsMapper.deleteById(id);
	}

	public List<EventsVo> findAll() {
		return eventsMapper.findAll();
	}
	
	public List<EventsVo> findAllPaging(PageUtil pageUtil) {
		return eventsMapper.findAllPaging(pageUtil);
	}

	public EventsVo findById(int id) {
		return eventsMapper.findById(id);
	}

	public int count() {
		return eventsMapper.count();
	}
}
