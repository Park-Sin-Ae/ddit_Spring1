package kr.or.ddit.free.web;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.free.service.IFreeService;
import kr.or.ddit.vo.FreeVO;

@Controller
@RequestMapping("/free")
public class FreeInsertController {

	@Inject
	private IFreeService service;
	
	@RequestMapping(value="/form.do", method = RequestMethod.GET)
	public String freeForm() {
		return "free/form";
	}
	
	@RequestMapping(value="/insert.do", method = RequestMethod.POST)
	public String insertFree(FreeVO freeVO, Model model) {
		Map<String, String> errors = new HashMap<String, String>();
		String goPage = "";
		
		if(StringUtils.isBlank(freeVO.getFreeTitle())) {
			errors.put("freeTitle", "제목을 입력해주세요!");
		}
		if(StringUtils.isBlank(freeVO.getFreeContent())) {
			errors.put("freeContent", "내용을 입력해주세요!");
		}
		
		if(errors.size() > 0) {
			model.addAttribute("errors", errors);
			model.addAttribute("free", freeVO);
			goPage = "free/form";
		}else {
			freeVO.setFreeWriter("a001");
			ServiceResult result = service.insertFree(freeVO);
			if(result.equals(ServiceResult.OK)) {
				goPage = "redirect:/free/detail.do?freeNo="+freeVO.getFreeNo();
			}else {
				model.addAttribute("free", freeVO);
				goPage = "free/form";
			}
		}
		return goPage;
	}
	
	   @RequestMapping(value="/delete.do", method= RequestMethod.POST)
	   public String deleteFree(int freeNo, Model model) {
	      String goPage ="";
	      ServiceResult result = service.deleteBoard(freeNo);
	      if(result.equals(ServiceResult.OK)) {
	         goPage = "redirect:/free/list.do";
	      }else {
	         goPage = "redirect:/free/detail.do?freeNo="+freeNo;
	      }
	      return goPage;
	   }
}
