package com.mvc.step3;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

public class EmpLogic {
	Logger logger = Logger.getLogger(EmpLogic.class);
	// 생성자가 아닌 선언부에 인스턴스화를 하는 부분에 대해서 생각해본다.
	private DeptDao deptDao = new DeptDao();
	private EmpDao empDao = new EmpDao();
	//@Transactional(propagation = propagation.REQUIRES_NEW, rollbackFor= {DataAccessExxception.class})
//	public int doEmp() {// 한번에 커밋하시오..
//	public int goEmp() {// 건건이 커밋해라...
	public int cudEmp() {// 건건이 커밋해라...
		logger.info("doEmp 호출");
		int empResult = 0;
		int deptResult = 0;
		Map<String,Object> emap = new HashMap<>();
		emap.put("empno", 9005);
		emap.put("ename", "김유신");
		emap.put("deptno", 89);
		// 이곳에서 try..catch 할 필요가 있나??
//		try {
			Map<String,Object> dmap = new HashMap<>();
			dmap.put("deptno", 89);
			dmap.put("dname", "개발부");
			dmap.put("loc", "부산");
			deptResult = deptDao.deptInsert(dmap);
			empResult = empDao.empInsert(emap);
			if(deptResult == 1 && empResult == 1) {
				EmpDao.sqlSession.commit();
			} else {
				EmpDao.sqlSession.rollback();
			}
//		} catch (Exception de) {
//			throw de;// 스프링에서 aop를 이용하고 pointcut 하기위한 이슈
//		}
		return 0;
	}
}
