package com.mvc.step3;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.mvc.step3.Board3Logic;
import com.util.MyBatisCommonFactory;

public class Board3Dao {
	Logger logger = Logger.getLogger(Board3Logic.class);
	SqlSessionFactory sqlSessionFactory = null;
	SqlSession sqlSession = null;
	public Board3Dao() {
		sqlSessionFactory = MyBatisCommonFactory.getSqlSessionFactory();//공통코드,1
	}
	public List<Map<String, Object>> boardList() {
		logger.info("boardList 호출 성공");
		List<Map<String, Object>> boardList = null;
		try {
			sqlSession = sqlSessionFactory.openSession();
			boardList = sqlSession.selectList("boardList");// 2 sql섹션이 필욯요하다
			// insert here
			logger.info(boardList);// 매핑되어 있다.
		} catch (Exception e){
			logger.info("Exception : "+e.toString());
		} finally {
			sqlSession.close();// = conclose - i/o와 관련된것은 마지막에는 나눠준다.
		}
		return boardList;
	}

}