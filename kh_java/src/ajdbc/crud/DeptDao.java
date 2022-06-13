package ajdbc.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.JOptionPane;

import jdbc.oracle.DBConnectionMgr;
import oracle.DeptVO;

public class DeptDao {
	// 선언부c
	DeptView deptView = null;
	//////////////////// DB연동 ///////////////////////
	// 오라클 서버와 연동하기 위한 서버들 드라이버 클래스
	DBConnectionMgr 	dbMgr 	= new DBConnectionMgr();
	Connection 			con 	= null;// 물리적으로 떨어진 오라클 서버와 연결통로
	PreparedStatement 	pstmt 	= null;// DML구문 전달하고 오라클에게 요청
	ResultSet 			rs 		= null;// 조회경우 커서를 조작 필요
	//////////////////// DB연동 ///////////////////////
	// 디폴트 생성자는 생성자가 하나도 없을 경우에만 제공됨
	// 파라미터를 갖는 생성자가 하나라도 있으면 디폴트 생성자도 제공안됨
	public DeptDao() {}
	public DeptDao(DeptView deptView) {
		this.deptView = deptView;
		
	}
	/**************************************************
	 * 부서 등록 구현
	 * VO(Value Object) - 오라클 타입과 자바타입비교 - 컬럼명과 VO전변과 Map의 키값은 반드시 일치해야 한다.
	 * @param pdVO - 사용자가 입력한 부서번호, 부서명, 지역을 받는다. - 복합데이터 클래스
	 * @return int - 1: 등록성공 0:등록실패 
	 * INSERT INTO dept(deptno, dname, loc)
	          VALUES(71,'개발1팀','서귀포'); - 내가 설계한 것과 DB의 값이 잘 일치하는지 확인하기 위해 복사붙여둔다
	 **************************************************/
	public int deptInsert(DeptVO pdVO) {
		System.out.println("deptInsert 호출 성공");
		int result = 0;
		
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO dept(deptno, dname, loc) VALUES(?,?,?)");
		// 물리적으로 떨어져 있는 오라클 서버와 통신
		// 반드시 예외처리를 해야한다.
		// 사용한 자원 반납 처리 - 명시적으로 한다.
		// 생성된 역순으로 반납한다. 문을 열고 들어온 순서대로 다시 닫으면서 나간다.
		// 왜 생성한 역순인가? - 의존관계에 있다. Connection, PreparedStatement, ResultSet - 자바성능 튜닝 가이드
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			// 중간에 어떤 코드가 끼어들더라도, 코드에 대한 변경을 최소하한다.
			// 동적쿼리를 처리하는 PreparedStatment에서 ? 자리에 필요한 파라미터를 적용하는데
			// 테이블 설계가 바뀌거나 컬럼이 추가되는 경우를 예측하여 최소한의 코드 변경이 되도록 변수를 사용해 본다.
			// ? 자리는 1부터이므로 ++i 로 시작한다.
			// 만일 1로 초기화 했다면 i++로 하면 될 것이다.
			int i = 0; 
			pstmt.setInt(++i, pdVO.getDeptno());
			pstmt.setString(++i, pdVO.getDname());
			pstmt.setString(++i, pdVO.getLoc());
			// selecet인 경우 커서를 리턴받고, insert, update, delete 인 경우는 int리턴 받음
			result = pstmt.executeUpdate(); // 성공됐을 때 리턴값이 int
			// 오라클 서버에서 입력 처리를 성공했을 때 1을 돌려 받는다.
			if (result == 1) {
				deptSelectAll();
				// 입력 성공 후에 화면에 대한 초기화 - 사용자의 편의성 제공
				deptView.setDeptno(0);
				deptView.setDname("");
				deptView.setLoc("");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnectionMgr.freeConnection(pstmt, con); // 자원반납하는 부분도 따로 빼둠?
		}
		return result;
	}

	/**************************************************
	 * 부서 수정 구현
	 * 
	 * @param pdVO - 사용자가 수정한 부서번호, 부서명, 지역을 받는다. - 복합데이터 클래스
	 * @return int - 1: 등록성공 0:등록실패 
	 * UPDATE dept SET dname = '개발2팀' ,loc = '거제도'    
	    WHERE deptno = 71;
	 **************************************************/
	public int deptUpdate(DeptVO pdVO) {
		System.out.println("deptUpdate 호출 성공");
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE dept          ");
		sql.append("   SET dname = ?,    ");
		sql.append("		loc =  ?      ");
		sql.append(" WHERE deptno = 71;  ");
		int result = 0;
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			int i = 1;
			pstmt.setString(i++, pdVO.getDname());
			pstmt.setString(i++, pdVO.getLoc());
			pstmt.setInt(i++, pdVO.getDeptno());
			result = pstmt.executeUpdate();
			if (result == 1) {
				JOptionPane.showMessageDialog(deptView, "데이터가 수정되었습니다.", "Info", JOptionPane.INFORMATION_MESSAGE);
				deptSelectAll(); // 새로고침 처리 메소드 호출하기 - 메소드 재사용성 - 반복되는 코드를 줄여 준다.
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnectionMgr.freeConnection(pstmt, con);
		}
		
		return result;
	}

	/**************************************************
	 * 부서 삭제 구현
	 * 
	 * @param deptno(int) - 사용자가 선택한 부서번호
	 * @return int - 1: 등록성공 0:등록실패 DELETE FROM dept WHERE deptno = 71
	 **************************************************/
	public int deptDelete(int deptno) { // pk를 받는다.
		System.out.println("deptUpdate 호출 성공" + deptno);
		int result = 0;
		
		StringBuilder sql = new StringBuilder();
		sql.append(" DELETE FROM dept WHERE deptno = ?");
		
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, deptno); // 하나라서 상수 1로 처리한다.
			result = pstmt.executeUpdate();
			if (result == 1) {
				JOptionPane.showMessageDialog(deptView, "데이터가 삭제되었습니다.", "Info", JOptionPane.INFORMATION_MESSAGE);
				// 삭제된 후에 화면 갱신처리하기 - 동기화 처리 진행됨
				// 입력, 수정, 삭제에서 반복적으로 호출 될 수 있다. - 메소드로 코드를 줄여준다.
				// List<VO>, List<Map> 맵에 대한 이해
				deptSelectAll(); // 새로고침 처리 메소드 호출하기 - 메소드 재사용성 - 반복되는 코드를 줄여 준다.
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnectionMgr.freeConnection(pstmt, con);
		}
		return result;
	}

	/****************************************
	 * 부서 목록 전체 조회 구현(새로고침시 재사용 위해서)
	 * @return List<Map<String,Object>> 
	 * SELECT deptno, dname, loc 
	  	 FROM dept
	 *****************************************/
	public List<Map<String, Object>> deptSelectAll() {
		System.out.println("deptSelectAll 호출 성공");
//		List<Map<String,Object>> deptList = null;
		List<Map<String, Object>> deptList	 = new ArrayList<>();
		StringBuilder 			  sql		 = new StringBuilder();
		sql.append("SELECT deptno, dname, loc FROM dept"); // 전체를 줘야해서 where절이 없는 상태이다.
		try {
			con		= dbMgr.getConnection();
			pstmt 	= con.prepareStatement(sql.toString());
			rs 		= pstmt.executeQuery();
			Map<String, Object> rmap = null;
			
			while (rs.next()) {
				rmap = new HashMap<>();// 같은 이름의 변ㅅ누이지만 서로 다른 주소번지를 갖는다.
				rmap.put("deptno", rs.getInt("deptno"));
				rmap.put("dname", rs.getString("dname"));
				rmap.put("loc", rs.getString("loc"));
				deptList.add(rmap);// 순서가 정해진다. 기본정렬은 오라클에서 하는 것이 빠르다. - 자바에서는 View를 보는정도로 구상
			}
			
//			System.out.println(deptList);// 단위테스트때문에 달아둔 것이므로 없애도 된다.
			// 기존에 조회된 결과 즉 목록을 삭제하기
			// 자료구조가 존재하는지
			while (deptView.dtm.getRowCount() > 0) {// 여러번 조회를 누르더라도 뒤에 내용이 삭제되므로 검색된 로우의 수만큼 출력시킨다.
				deptView.dtm.removeRow(0);// 파라미터에 0을 주어서 테이블의 인덱스가 바뀌는 문제를 해결함.
			}
			// Iterator는 자료구조가 갖고 있는 정보의 유무를 체크하는데 필요한 메소드를 제공하고 있다.
			Iterator<Map<String, Object>> iter = deptList.iterator();// 컬렉션프레임워크안에 유틸패키지를 지원하는 클래스 iterator
			Object keys[] = null;
			while (iter.hasNext()) {
				Map<String, Object> data = iter.next();
				keys = data.keySet().toArray();
				Vector<Object> oneRow = new Vector<>();
				oneRow.add(data.get(keys[2]));// 키값이 랜덤. 순서는 확인할 수 없다.
				oneRow.add(data.get(keys[1]));// 키값이 랜덤. 순서는 확인할 수 없다.
				oneRow.add(data.get(keys[0]));// 키값이 랜덤. 순서는 확인할 수 없다.
				// 데이터 셋인 DefaultTableModel에 조회 결과 담기. - 반복처리함 => 10, 20, 30, 40
				deptView.dtm.addRow(oneRow);
//				System.out.println(keys[2]);
//				System.out.println(keys[1]);
//				System.out.println(keys[0]);
			}
		} catch (Exception e) {
			e.printStackTrace();// 스택영역에 쌓여있는 에러 메시지를 순차적으로 출력해주는 메소드
		} finally {
			DBConnectionMgr.freeConnection(rs, pstmt, con);
		}
		return deptList;
	}

	/****************************************
	 * 부서 상세 조회 구현(새로고침시 재사용 위해서)
	 * 
	 * @param deptno(int)
	 * @return DeptVO 
	 * SELECT deptno, dname, loc FROM dept
	    WHERE deptno = ?
	 *****************************************/
	public DeptVO deptSelectDetail(int deptno) {
		System.out.println("deptSelectDetail 호출 성공");
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT deptno, dname, loc FROM dept  ");
		sql.append(" WHERE deptno = ?                  	  ");                          
		DeptVO rdVO = null;
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				rdVO = new DeptVO();
				rdVO.setDeptno(rs.getInt("deptno"));
				rdVO.setDname(rs.getString("dname"));
				rdVO.setLoc(rs.getString("loc"));
			}
			if(rdVO !=null) {
				deptView.setDeptno(rdVO.getDeptno());
				deptView.setDname(rdVO.getDname());
				deptView.setLoc(rdVO.getLoc());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnectionMgr.freeConnection(rs, pstmt, con);
		}
		return rdVO;
	}
}
