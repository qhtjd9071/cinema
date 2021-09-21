package shop.jbsapp.www.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.jbsapp.www.mapper.NoticesMapper;
import shop.jbsapp.www.util.PageUtil;
import shop.jbsapp.www.vo.NoticesVo;

@Service
@Transactional
public class NoticesService {

	private static Logger logger = LoggerFactory.getLogger(NoticesService.class);
	
	@Autowired
	private NoticesMapper noticesMapper;
	
	public int insert(NoticesVo vo) {
		return noticesMapper.insert(vo);
	}

	public int deleteById(int id) {
		return noticesMapper.deleteById(id);
	}

	public NoticesVo findById(int id) {
		noticesMapper.increaseHit();
		return noticesMapper.findById(id);
	}

	public int update(NoticesVo vo) {
		logger.info("check");
		int result = noticesMapper.update(vo);
		System.out.println(result);
		return result;
	}

	public int count() {
		return noticesMapper.count();
	}

	public List<NoticesVo> findAllPaging(PageUtil pageUtil) {
		return noticesMapper.findAllPaging(pageUtil);
	}

}
