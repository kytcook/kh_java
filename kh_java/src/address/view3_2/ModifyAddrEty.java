package address.view3_2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModifyAddrEty {
	DBConnectionMgr 	dbMgr 	= new DBConnectionMgr();
	Connection 			con 	= null;
	PreparedStatement 	pstmt 	= null;
	public AddressVO modify(AddressVO vo) {
		System.out.println("ModifyAddrEty modify 호출 성공");
		StringBuilder sql = new StringBuilder();
		AddressVO rVO = new AddressVO();
		sql.append("UPDATE mkaddrtb                     ");
		sql.append("   SET name    = ?                 	");
		sql.append("      ,address = ?					");
		sql.append("      ,gender  = ?                  ");
		sql.append(" WHERE id = 10;                     ");
		int id = vo.getId();
		int result =0;
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getAddress());
			pstmt.setString(3, vo.getGender());
			pstmt.setInt(4, vo.getId());
			result = pstmt.executeUpdate();
			rVO.setResult(result);
		} catch (SQLException se) {
			System.out.println("[[query]]"+sql.toString());
		} catch (Exception e) {
			e.printStackTrace();// 에러 스택에 쌓여 있는 로그 정보 출력해줌.라인번호도 같이
		} finally {
			// DB연동에서 사용한 자원 반납하기 - 노출 가능, 위변조
			dbMgr.freeConnection(pstmt, con);
		}
		return rVO;
	}//////////////////END OF MODIFY

}
