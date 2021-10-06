package shop.jbsapp.www.service;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.Authentication;
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
		return usersMapper.deleteById(id);
	}

	public UsersVo checkId(String id) {
		return usersMapper.findById(id);
	}

	public boolean checkPwd(String pwd, Authentication authentication) {
		String presentPwd = authentication.getCredentials().toString();
		String encoded = encoder.encode(pwd);
		if (encoder.matches(presentPwd, encoded)) {
			return true;
		} else {
			return false;
		}
	}

	public void updatePwd(String id, String pwd) {
		UsersVo vo = usersMapper.findById(id);
		vo.setPwd(pwd);
		usersMapper.updatePwd(vo);
	}
}
