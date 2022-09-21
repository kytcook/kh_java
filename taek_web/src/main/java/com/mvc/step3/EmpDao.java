package com.mvc.step3;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.util.MyBatisCommonFactory;
// POJO에서는 AOP의 지원이 없으므로 정규식을 이용해서 코드 삽입이 불가하다.
// 관여하기도 불가한 상태
public class EmpDao {
	Logger logger = Logger.getLogger(EmpDao.class);
	SqlSessionFactory sqlSessionFactory = null;
	static SqlSession sqlSession = null;
	
	public EmpDao() {
		sqlSessionFactory = MyBatisCommonFactory.getSqlSessionFactory();
	}
	// spring에서 제공하는 SQLException대신 사용하는 클래스
	// 예외가 발생했을 때, 여기서 직접 처리하지 않고 나를 호출한 곳에서 처리해주세요~
	public int empInsert(Map<String, Object> emap) {
		logger.info(emap);
		int result = 0;
		try {
//			con.setAutoCommit(false);
			sqlSession = sqlSessionFactory.openSession();
			result = sqlSession.update("empInsert", emap);
			logger.info("result : " + result);
		} catch (Exception e) {
			logger.info("Exception : " + e.toString());
		}
		return result;
	}
	
}
