package org.kosa.mini.member.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.validation.Valid;

import org.kosa.mini.code.CodeService;
import org.kosa.mini.entity.MemberVO;
import org.kosa.mini.page.PageRequestVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

}