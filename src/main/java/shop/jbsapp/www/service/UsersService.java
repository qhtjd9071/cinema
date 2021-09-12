package shop.jbsapp.www.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.jbsapp.www.mapper.UsersMapper;
import shop.jbsapp.www.vo.UsersVo;

@Service
@Transactional
public class UsersService {

	@Autowired
	private UsersMapper usersMapper;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public int join(UsersVo vo) {
		String pwd = vo.getPwd();
		String encoded = encoder.encode(pwd);
		vo.setPwd(encoded);
		return usersMapper.insert(vo);
	}

	public int deleteById(String id) {
		return usersMapper.deleteById(id);
	}

	public UsersVo checkId(String id) {
		return usersMapper.findById(id);
	}

}
