package kr.or.ddit.board.web;

import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.vo.BoardVO;
import kr.or.ddit.vo.PaginationInfoVO;

@Controller
@RequestMapping("/board")
public class BoardRetrieveController {
	
	@Inject
	private IBoardService service;
	
	@RequestMapping(value="/list.do")
	public String boardList(
			@RequestParam(name="page", required = false, defaultValue = "1") int currentPage,
			@RequestParam(required = false, defaultValue = "title") String searchType,
			@RequestParam(required = false) String searchWord, 
			Model model) {
		// [방법 1] 일반적인 목록 조회
//		List<BoardVO> boardList = service.selectBoardList();
//		model.addAttribute("boardList", boardList);
		
		// [방법 2] 페이징 및 검색이 적용된 목록 조회
		PaginationInfoVO<BoardVO> pagingVO = new PaginationInfoVO<BoardVO>();
		
		// 검색을 진행했을 때
		// searchWord라는 녀석이 있으면 검색한거, 없으면 겁색 안함
		if(StringUtils.isNotBlank(searchWord)) {
			pagingVO.setSearchType(searchType);
			pagingVO.setSearchWord(searchWord);
			model.addAttribute("searchType", searchType);
			model.addAttribute("searchWord", searchWord);
		}
		
		pagingVO.setCurrentPage(currentPage);
		
		// 목록 총 게시글 수 가져오기
		int totalRecord = service.selectBoardCount(pagingVO);
		pagingVO.setTotalRecord(totalRecord);
		
		// 현재 페이지에 해당하는 screenSize 만큼의 게시글 정보를 얻어온다.
		List<BoardVO> dataList = service.selectBoardList(pagingVO);
		pagingVO.setDataList(dataList);
		
		model.addAttribute("pagingVO", pagingVO);
		
		return "board/list";
	}
	
	
	@RequestMapping(value="/detail.do", method = RequestMethod.GET)
	public String boardDetail(int boNo, Model model) {
		BoardVO boardVO = service.selectBoard(boNo);
		model.addAttribute("board", boardVO);
		return "board/view";
	}
}
