package shop.jbsapp.www.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.jbsapp.www.mapper.CustomersMapper;
import shop.jbsapp.www.util.PageUtil;
import shop.jbsapp.www.vo.CustomersVo;

@Service
@Transactional
public class CustomersService {

	@Autowired
	private CustomersMapper customersMapper;
	
	public int insert(CustomersVo vo) {
		int boardNum=customersMapper.getMax()+1;
		int id=vo.getId();
		vo.setId(boardNum);
		int ref=vo.getRef();
		int lev=vo.getLev();
		int step=vo.getStep();
		if (id == 0) {
			ref = boardNum;
			vo.setRef(ref);
		} else {
			customersMapper.increaseLevel(vo);
			lev+=1;
			vo.setLev(lev);
			step+=1;
			vo.setStep(step);
		}
		return customersMapper.insert(vo);
	}

	public int deleteById(int id) {
		return customersMapper.deleteById(id);
	}

	public CustomersVo findById(int id) {
		return customersMapper.findById(id);
	}

	public List<CustomersVo> findAllPaging(PageUtil pageUtil) {
		return customersMapper.findAllPaging(pageUtil);
	}

	public int update(CustomersVo vo) {
		return customersMapper.update(vo);
	}

	public int count() {
		return customersMapper.count();
	}

	public int getMax() {
		return customersMapper.getMax();
	}

	public void increaseLevel(CustomersVo vo) {
		customersMapper.increaseLevel(vo);
	}

}
