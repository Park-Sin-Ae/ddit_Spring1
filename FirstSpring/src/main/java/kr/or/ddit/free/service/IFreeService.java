package kr.or.ddit.free.service;

import java.util.List;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.vo.BoardVO;
import kr.or.ddit.vo.FreeVO;
import kr.or.ddit.vo.PaginationInfoVO;

public interface IFreeService {
	public List<FreeVO> selectFreeList(PaginationInfoVO<FreeVO> pagingVO);
	public List<FreeVO> selectFreeList();
	public int selectFreeCount(PaginationInfoVO<FreeVO> pagingVO);
	public FreeVO selectFree(int freeNo);
	public ServiceResult insertFree(FreeVO freeVO);
	public ServiceResult updateFree(FreeVO freeVO);
	public ServiceResult deleteBoard(int boNo);
}
