package kr.or.ddit.book.dao;

import java.util.List;
import java.util.Map;

public interface IBookDAO {
	int insertBook(Map<String, Object> map);
	int insertBook2(Map<String, Object> map);
	Map<String, Object> selectBook(Map<String, Object> map);
	int updateBook(Map<String, Object> map);
	int deleteBook(Map<String, Object> map);
	List<Map<String, Object>> selectBookList(Map<String, Object> map);
}
