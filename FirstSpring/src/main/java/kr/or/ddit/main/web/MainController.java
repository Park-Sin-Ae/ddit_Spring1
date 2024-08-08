package kr.or.ddit.main.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	
	@RequestMapping(value={"/", "main.do"}, method = RequestMethod.GET)
	public String main() {
		// 'localhost' 라고 주소창에 입력했을 때, main.jsp가 응답 화면으로 나갈 수 있도록
		// 완성해주세요.
		return "main";
	}
}
