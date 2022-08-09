package com.mvc.step3;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.util.MyBatisCommonFactory;

public class Board3SDao {
	Logger logger = Logger.getLogger(Board3Logic.class);
	SqlSessionFactory sqlSessionFactory = null;
	SqlSession sqlSession = null;
	public Board3SDao() {
		sqlSessionFactory = MyBatisCommonFactory.getSqlSessionFactory();//공통코드,1
	}
}
