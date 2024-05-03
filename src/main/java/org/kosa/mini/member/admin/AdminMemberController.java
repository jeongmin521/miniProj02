package org.kosa.mini.member.admin;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.validation.Valid;

import org.kosa.mini.code.CodeService;
import org.kosa.mini.entity.MemberVO;
import org.kosa.mini.page.PageRequestVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminMemberController {

	private final AdminMemberService adminmemberService;
	private final CodeService codeService;
	
	
	@RequestMapping("/list")
	public String list(@Valid PageRequestVO pageRequestVO, BindingResult bindingResult, Model model) throws ServletException, IOException {
		log.info("회원목록");
		
		log.info(pageRequestVO.toString());

        if(bindingResult.hasErrors()){
        	pageRequestVO = PageRequestVO.builder().build();
        }
		model.addAttribute("pageResponseVO", adminmemberService.getList(pageRequestVO));
		model.addAttribute("sizes", codeService.getList());
		
		return "admin/list";
	}
	
	@GetMapping("/view")
	public String view(MemberVO member, Model model) throws ServletException, IOException {
		log.info("상세보기");
		
		model.addAttribute("member", adminmemberService.view(member));
		
		return "admin/view";
	}
	
	@RequestMapping("delete")
	@ResponseBody
	public Map<String, Object> delete(@RequestBody MemberVO member) throws ServletException, IOException {
		log.info("삭제 -> {}", member);
		int updated = adminmemberService.delete(member);
		
		Map<String, Object> map = new HashMap<>();
		if (updated == 1) { //성공
			map.put("status", 0);
		} else {
			map.put("status", -99);
			map.put("statusMessage", "회원 정보 삭제 실패");
		}
		
		return map;
	}
	
	@RequestMapping("lock")
	@ResponseBody
	public Map<String, Object> lock(@RequestBody MemberVO member) throws ServletException, IOException {
		log.info("잠금/해제 -> {}", member);
		int updated = adminmemberService.lock(member);
		
		Map<String, Object> map = new HashMap<>();
		if (updated == 1) { //성공
			map.put("status", 0);
		} else {
			map.put("status", -99);
			map.put("statusMessage", "회원 계정 잠금/해제 처리 실패");
		}
		
		return map;
	}
	
	@RequestMapping("auth")
	@ResponseBody
	public Map<String, Object> auth(@RequestBody MemberVO member) throws ServletException, IOException {
		log.info("권한 변경 -> {}", member);
		int updated = adminmemberService.auth(member);
		
		Map<String, Object> map = new HashMap<>();
		if (updated == 1) { //성공
			map.put("status", 0);
		} else {
			map.put("status", -99);
			map.put("statusMessage", "권한 변경 처리 실패");
		}
		return map;
	}

}