package kr.or.ddit.notice.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/notice")
public class NoticeRetrieveController {
	
	@RequestMapping(value="/list.do", method = RequestMethod.GET)
	public String noticeList() {
		return "notice/list";
	}
}
