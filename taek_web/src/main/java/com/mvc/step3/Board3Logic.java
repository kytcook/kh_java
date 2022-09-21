package com.mvc.step3;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.mvc.step2.Board2Dao;

public class Board3Logic {
	Logger logger = Logger.getLogger(Board3Logic.class);
	Board3MDao boardMDao = new Board3MDao();
	Board3SDao boardSDao = new Board3SDao();
	public List<Map<String,Object>> boardDetail(Map<String, Object> pMap){
		logger.info("boardDetail 호출 성공");
		List<Map<String,Object>> boardList = null;
		boardList = boardMDao.boardList(pMap);
		if(boardList!=null && boardList.size()==1) {
			boardMDao.hitCount(pMap);
		}
		return boardList;
	}
	
	public List<Map<String,Object>> boardList(Map<String, Object> pMap){
		logger.info("boardList 호출 성공");
		List<Map<String,Object>> boardList = null;
		boardList = boardMDao.boardList(pMap);
		return boardList;
	}
	
	public int boardInsert(Map<String, Object> pMap) {
		logger.info("boardInsert 호출 성공");
		// board_master_t에 입력 성공시 담기
		int result = 0;
		// board_sub_t에 입력 성공시 담기
		int b_no = 0;
		int b_group = 0;
		// 글번호 채번할 때 - 한번 ( 다오가 호출되는거)
		b_no = boardMDao.getBNo();
		pMap.put("b_no", b_no);
		if(pMap.get("b_group")!=null) {
			b_group = Integer.parseInt(pMap.get("b_group").toString());
		}
		//댓글쓰기
		if(b_group > 0) {
			// 아래 코드는 내 뒤에 댓글이 있을 때만 처리가 된다.
			// 내 뒤에 댓글이 있으면 두번 (다오가 호출되는거)
			boardMDao.bStepUpdate(pMap);
			pMap.put("b_pos", Integer.parseInt(pMap.get("b_pos").toString())+1);
			pMap.put("b_step", Integer.parseInt(pMap.get("b_step").toString())+1);
		}
		//새글쓰기
		else {
			//새글쓰기에서는 댓글쓰기와는 다르게 그룹번호를 새로 채번해야 함
			// 새글일때 그룹번호 채번할 때 세번 ( 다오가 호출되는거)
			b_group = boardMDao.getBGroup();
			pMap.put("b_group", b_group);
			pMap.put("b_pos", 0);
			pMap.put("b_step", 0);
		}
		result = boardMDao.boardMInsert(pMap);   // 새글쓰기와 댓글쓰기 동시
		// 첨부파일이 있는 경우에만 board_sub_t 추가함
		// 첨부파일이 있니?
		if(pMap.get("b_file")!=null && pMap.get("b_file").toString().length()>1) {
			pMap.put("b_no", b_no);
			pMap.put("bs_seq", 1);
			int result2 = boardSDao.boardSInsert(pMap);
			logger.info("result2가 1이면 등록 성공 ===> "+result2);
		}
		// 부모에서 자식으로 내린건 가능함. 그러나 반대는 불가함( 리액트 -> 리덕스 --> NextJS)
		// 전혀 문제가 되지 않음 - static으로 해결함 -> POJO라는 한계로 인해 프레임웍을 이용하여 해결중~
		// 이런점 때문에 Spring, Spring boot를 활용한다.
//		if(( result == 1) && ( result2 == 1)) {
//			Board3MDao.sqlSession.commit();
//		} else {
//			Board3MDao.sqlSession.rollback();
//		}
//		
		return result;
	}
	public int boardUpdate(Map<String, Object> pMap) {
		int result = 0;
		result = boardMDao.boardMUpdate(pMap);
		return result;
	}
	public int boardDelete(Map<String, Object> pMap) {
		int result = 0;
		result = boardMDao.boardMDelete(pMap);
		return result;
	}

}
