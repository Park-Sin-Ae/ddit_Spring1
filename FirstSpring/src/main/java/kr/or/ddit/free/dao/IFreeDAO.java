package kr.or.ddit.free.dao;

import java.util.List;

import kr.or.ddit.vo.FreeVO;
import kr.or.ddit.vo.PaginationInfoVO;

public interface IFreeDAO {
	public List<FreeVO> selectFreeList(PaginationInfoVO<FreeVO> pagingVo);
	public FreeVO selectFree(int freeNo);
	public int insertFree(FreeVO freeVO);
	public int updateFree(FreeVO freeVO);
	public List<FreeVO> selectFreeList();
	public int deleteFree(int freeNo);
	public void incrementByHit(int freeNo);
	public int selectFreeCount(PaginationInfoVO<FreeVO> pagingVO);
}
