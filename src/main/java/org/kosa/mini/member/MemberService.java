package org.kosa.mini.member;

import java.util.List;

import org.kosa.mini.entity.MemberVO;
import org.kosa.mini.page.PageRequestVO;
import org.kosa.mini.page.PageResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MemberService implements UserDetailsService {
      
	@Autowired
	private MemberMapper memberMapper;
//	@Autowired
//	private PasswordEncoder passwordEncoder;
	
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	public static void main(String [] args) {
		BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
		System.out.println(bcryptPasswordEncoder.encode("1004"));
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("username = {}", username);
		MemberVO resultVO = memberMapper.login(MemberVO.builder().member_id(username).build());
		if (resultVO == null) {
			log.info(username + " 사용자가 존재하지 않습니다");
			throw new UsernameNotFoundException(username + " 사용자가 존재하지 않습니다");
		}
		log.info("resultVO = {}", resultVO);
		//로그인 횟수를 카운트 한다
		memberMapper.loginCountInc(resultVO);
		
		return resultVO;
	}
	
	public int join(MemberVO member) {
		// 비밀번호 암호화
		member.hashPassword(passwordEncoder);
		int result = memberMapper.join(member);
		return result;
	}
	
	public MemberVO myPage(MemberVO member)  {
		MemberVO resultVO = memberMapper.myPage(member);
		log.info(resultVO.toString());
		
		return resultVO;
	}	
	
}