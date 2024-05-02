package org.kosa.mini.member;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.kosa.mini.entity.MemberVO;
import org.kosa.mini.page.PageRequestVO;

@Mapper
public interface MemberMapper {

	MemberVO login(MemberVO boardVO);
	//마지막 로그인 시간 변경 
	int updateMemberLastLogin(String email);
	//로그인시 비밀 번호 틀린 회수를 1 증가 함
	void loginCountInc(MemberVO member);
	//로그인 성공이 비밀 번호 틀린 회수를 초기화 함  
	void loginCountClear(String email);
	//회원가입
	int join(MemberVO member);
	//회원 정보 불러오기
	List<MemberVO> getList(PageRequestVO pageRequestVO);
	int getTotalCount(PageRequestVO pageRequestVO);
}