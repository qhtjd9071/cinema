package shop.jbsapp.www.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
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

	public UsersVo findById(String id) {
		return usersMapper.findById(id);
	}
	
	public int deleteById(String id) {
		usersMapper.deleteAuthorityById(id);
		return usersMapper.deleteById(id);
	}

	public UsersVo checkId(String id) {
		return usersMapper.findById(id);
	}

	public boolean checkPwd(String pwd, Authentication authentication) {
		User user = (User) authentication.getPrincipal();
		String userId = user.getUsername();
		UsersVo vo = usersMapper.findById(userId);
		if (encoder.matches(pwd, vo.getPassword())) {
			return true;
		} else {
			return false;
		}
	}

	public void updatePwd(String id, String pwd) {
		UsersVo vo = usersMapper.findById(id);
		String encoded = encoder.encode(pwd);
		vo.setPwd(encoded);
		usersMapper.updatePwd(vo);
	}
}
