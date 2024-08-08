package kr.or.ddit.free.web;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.free.service.IFreeService;
import kr.or.ddit.vo.FreeVO;

@Controller
@RequestMapping("/free")
public class FreeModifyController {
	
	@Inject
	private IFreeService service;
	
	@RequestMapping(value="/update.do", method = RequestMethod.GET)
	public String freeUpdateForm(int freeNo, Model model) {
		FreeVO freeVO = service.selectFree(freeNo);
		model.addAttribute("free", freeVO);
		model.addAttribute("status", "u");
		// 수정 이벤트 처리 시, flag 값에 해당하는 'update'의 약자인 'u'를 flag로 설정한다.
		return "free/form";
	}
	
	@RequestMapping(value="/update.do", method = RequestMethod.POST)
	public String freeUpdate(FreeVO freeVO, Model model) {
		String goPage = "";
		ServiceResult result = service.updateFree(freeVO);
		if(result.equals(ServiceResult.OK)) {
			goPage = "redirect:/free/detail.do?freeNo="+freeVO.getFreeNo();
		}else {
			model.addAttribute("status", "u");
			model.addAttribute("free", freeVO);
			goPage = "free/form";
		}
		return goPage;
	}
}
