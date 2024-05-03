package org.kosa.mini.member;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.validation.Valid;

import org.kosa.mini.code.CodeService;
import org.kosa.mini.entity.BoardVO;
import org.kosa.mini.entity.MemberVO;
import org.kosa.mini.page.PageRequestVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

	private final MemberService memberService;

	@GetMapping("/joinForm")
	public String joinForm() {
		return "member/joinForm";
	}

	@PostMapping("/join")
	@ResponseBody
	public Map<String, Object> join(@RequestBody MemberVO memberVO) {
		Map<String, Object> result = new HashMap<>();

		int updated = memberService.join(memberVO);
		if (updated == 1) { // 성공
			result.put("status", 0);
		} else {
			result.put("status", -99);
			result.put("statusMessage", "회원가입 실패하였습니다");
		}
		return result;
	}

}
