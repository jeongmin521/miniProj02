package org.kosa.mini.member.admin;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.kosa.mini.entity.MemberVO;
import org.kosa.mini.page.PageRequestVO;

@Mapper
public interface AdminMemberMapper {

	MemberVO login(MemberVO boardVO);
	
	//회원 정보 불러오기
	List<MemberVO> getList(PageRequestVO pageRequestVO);
	int getTotalCount(PageRequestVO pageRequestVO);
	MemberVO view(MemberVO memberVO);
}
