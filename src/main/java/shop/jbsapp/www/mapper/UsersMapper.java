package shop.jbsapp.www.mapper;

import org.apache.ibatis.annotations.Mapper;

import shop.jbsapp.www.vo.UsersVo;

@Mapper
public interface UsersMapper {

	int insert(UsersVo vo);
	
	int deleteById(String id);
	
	UsersVo findById(String id);

	void updatePwd(UsersVo vo);
}
