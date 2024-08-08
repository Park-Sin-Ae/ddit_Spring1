package kr.or.ddit.free.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.free.dao.IFreeDAO;
import kr.or.ddit.vo.FreeVO;
import kr.or.ddit.vo.PaginationInfoVO;

@Service
public class FreeServiceImpl implements IFreeService {
	
	@Inject
	private IFreeDAO dao;
	
	@Override
	public List<FreeVO> selectFreeList(PaginationInfoVO<FreeVO> pagingVO) {
		return dao.selectFreeList(pagingVO);
	}

	@Override
	public int selectFreeCount(PaginationInfoVO<FreeVO> pagingVO) {
		return dao.selectFreeCount(pagingVO);
	}

	@Override
	public FreeVO selectFree(int freeNo) {
	    dao.incrementByHit(freeNo); 
		return dao.selectFree(freeNo);
	}

	@Override
	public ServiceResult insertFree(FreeVO freeVO) {
		ServiceResult result = null;
		int status = dao.insertFree(freeVO);
		
		if(status > 0) {
			result = ServiceResult.OK;
		}else {
			result = ServiceResult.FAILED;
		}
		return result;
	}

	@Override
	public ServiceResult updateFree(FreeVO freeVO) {
		ServiceResult result = null;
		int status = dao.updateFree(freeVO);
		if(status > 0) {
			result = ServiceResult.OK;
		}else {
			result = ServiceResult.FAILED;
		}
		return result;
	}

	@Override
	public List<FreeVO> selectFreeList() {
		return dao.selectFreeList();
	}

	@Override
	public ServiceResult deleteBoard(int freeNo) {
		ServiceResult result = null;
	      int status = dao.deleteFree(freeNo);
	      if(status > 0) {   //수정 성공
	         result = ServiceResult.OK;
	      }else {
	         result = ServiceResult.FAILED;
	      }
	      return result;
	}
}
