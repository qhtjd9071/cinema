package shop.jbsapp.www.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import shop.jbsapp.www.util.PageUtil;
import shop.jbsapp.www.vo.CustomersVo;

@Mapper
public interface CustomersMapper {

	int insert(CustomersVo vo);
	
	int deleteById(int id);
	
	CustomersVo findById(int id);
	
	List<CustomersVo> findAllPaging(PageUtil pageUtil);
	
	int update(CustomersVo vo);
	
	int count();
	
	int getMax();
	
	void increaseLevel(CustomersVo vo);
	
}
