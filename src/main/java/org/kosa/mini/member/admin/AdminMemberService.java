package org.kosa.mini.member.admin;

import java.util.List;

import org.kosa.mini.entity.MemberVO;
import org.kosa.mini.page.PageRequestVO;
import org.kosa.mini.page.PageResponseVO;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/*
 * MVC 
 * Model : B/L 로직을 구현하는 부분(service + dao)  
 * View  : 출력(jsp) 
 * Controller : model와 view에 대한 제어를 담당 
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class AdminMemberService {
      
	private final AdminMemberMapper adminmemberMapper;
	
	public PageResponseVO<MemberVO> getList(PageRequestVO pageRequestVO) {
    	List<MemberVO> list = adminmemberMapper.getList(pageRequestVO);
        int total = adminmemberMapper.getTotalCount(pageRequestVO);
        
        log.info("list {} ", list);
        log.info("total  = {} ", total);

        return new PageResponseVO<MemberVO>(list, total, pageRequestVO.getSize(), pageRequestVO.getPageNo());
	}
	
	public MemberVO view(MemberVO member)  {
		MemberVO resultVO = adminmemberMapper.view(member);
		log.info(resultVO.toString());
		
		
		return resultVO;
	}
	
	public int delete(MemberVO member)  {
		return adminmemberMapper.delete(member);
	}
	
	public int lock(MemberVO member)  {
		return adminmemberMapper.lock(member);
	}
	
	public int auth(MemberVO member)  {
		return adminmemberMapper.auth(member);
	}
}