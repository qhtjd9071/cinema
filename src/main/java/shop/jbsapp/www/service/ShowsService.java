package shop.jbsapp.www.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.jbsapp.www.mapper.ShowsMapper;
import shop.jbsapp.www.util.PageUtil;

@Service
@Transactional
public class ShowsService {

	@Autowired
	private ShowsMapper showsMapper;
	
	public int insert(Map<String, Object> map) {
		return showsMapper.insert(map);
	}

	public int deleteById(int id) {
		return showsMapper.deleteById(id);
	}

	public List<Map<String, Object>> showListPaging(PageUtil pageUtil) {
		return showsMapper.showListPaging(pageUtil);
	}

	public int count() {
		return showsMapper.count();
	}

	public int getPriceById(int id) {
		return showsMapper.getPriceById(id);
	}

}
