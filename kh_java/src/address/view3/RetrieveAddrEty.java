package address.view3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
// 이 클래스가 select역할을 담당한다.
public class RetrieveAddrEty {
	// 여기서는 이른 인스턴스화 <> (게으른 인스턴스화 : 효과적이다 - 필요할 때 인스턴스화 한다.)
	DBConnectionMgr 	dbMgr	= new DBConnectionMgr();
	Connection			con 	= null;	
	PreparedStatement 	pstmt 	= null;	 
	ResultSet 			rs 		= null; // 커서
	/***************************************************************************
	 * 회원정보 중 상세보기 구현 - 1건 조회
	 * SELECT id, name, address, DECODE(gender,'1','남','여') as "성별"
            , relationship, comments, registedate, birthday
         FROM mkaddrtb
        WHERE id = 5
	 * @param vo : 사용자가 선택한 값
	 * @return AddressVO : 조회 결과 1건을 담음
	 **************************************************************************/
	public AddressVO[] retrieve() {
		System.out.println("RetrieveAddrEty retrieve() 호출 성공");
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT id, name, address, telephone, gender      ");
	    sql.append("  ,relationship, birthday, comments, registedate ");
	    sql.append("  FROM mkaddrtb                                  ");//블록안에는 절대 세미콜론 찍지마셈~
	    AddressVO[] vos = null;// 바깥 스코프에 둬야한다.
	    try {
			con		= dbMgr.getConnection();
			pstmt 	= con.prepareStatement(sql.toString());
			rs 		= pstmt.executeQuery();
			Vector<AddressVO> v = new Vector<>();
			AddressVO rVO = null;
			while(rs.next()) {
				rVO = new AddressVO(rs.getString("name")
								   ,rs.getString("address")
								   ,rs.getString("telephone")
								   ,rs.getString("gender")
								   ,rs.getString("relationship")
								   ,rs.getString("birthday")
								   ,rs.getString("comments")
								   ,rs.getString("registedate")
								   ,rs.getInt("id")
								   );
				v.add(rVO); //v.size() -> 배열의 크기 결정해야 함
			}/////////////////end of while
			vos = new AddressVO[v.size()];
			v.copyInto(vos);
		} catch (SQLException se) {
			System.out.println("[[query]]"+sql.toString());
		} catch (Exception e) {
			e.printStackTrace();// 에러 스택에 쌓여 있는 로그 정보 출력해줌. 라인번호도 같이
		} finally {
			// DB연동에서 사용한 자원 반납하기
			dbMgr.freeConnection(rs, pstmt, con);
		}
	    return vos;
	}
}
//	/***************************************************************************
//	 * 회원 목록 보기 구현 - n건 조회
//	 * SELECT id, name, address, DECODE(gender,'1','남','여') as "성별"
//            , relationship, comments, registedate, birthday
//         FROM mkaddrtb
//	 * @param vo : 사용자가 선택한 값
//	 * @return AddressVO : 조회 결과 1건을 담음
//	 **************************************************************************/
//	public AddressVO[] retrieve() {
//		System.out.println("RetrieveAddrEty retrieve() 호출 성공");		
//		
//		AddressVO[] vos = null;
//		return vos;
//	}
//}

/*
ID,NAME,ADDRESS,TELEPHONE,GENDER,RELATIONSHIP,BIRTHDAY,COMMENTS,REGISTEDATE
3,나초보,서울시 마포구 공덕동,025556968,2,2,19801215,주연테크,REGISTEDATE
1,홍길동,서울시 영등포구 당산동,111,1,동창,19901010,222,20081117
2,이순신,서울시 서초구 양재동,222,2,회사동료,19901110,333,20100113
4,강감찬,경기도 광명시,11,1,동창,19801120,테스트합니다.,2011-03-20
9,나초조,4455,44455,1,44555,19800702,자영업,20110320
7,223,223,223,2,223,223,223,20190609
10,조조,경기도 화성시,44455,1,44555,19800702,자영업,20110320
*/