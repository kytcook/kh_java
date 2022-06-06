package ex10;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ex10.DBConnection;

public class ChatDAO {
	Connection con = DBConnection.getConnection();
	
	// 회원가입
	public int signUp(String id,String password,String nickName) {
		int count = 0;
		
		try {
			String sql = "INSERT INTO CHATMEMBER VALUES (?,?,?)";
			if (idCheck(id) == false) {
				System.out.println("존재하는 아이디입니다.");
				count = 2;
			}else {
				PreparedStatement pst = con.prepareStatement(sql);
				pst.setString(1, id);
				pst.setString(2, password);
				pst.setString(3, nickName);
				pst.executeUpdate();
				DBConnection.freeConnection(pst,con);
				count = 1;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return count;
	}
	
	// 중복검사 (불리언값 리턴)
	// 중복인 경우 : false
	// 중복이 아닌경우 : true
	public boolean idCheck(String id) {
		boolean idcheck = true;
		try {
			String sql = "SELECT * FROM CHATMEMBER WHERE ID = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, id);
			ResultSet rs = pst.executeQuery();
	
			if(rs.next()) {
				if (rs.getString("ID").equals(id)) {
					idcheck = false;
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		} 
		return idcheck;
	}
	
	// 로그인기능 (정수값 리턴)
	// 성공시 1 , 비번 실패시 2, 아이디가 없을시 3
	public String[] idLogin(String id, String pwd) {
		String[] List = new String[2];
		try {
			String sql = "SELECT * FROM CHATMEMBER WHERE ID = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, id);
			ResultSet rs = pst.executeQuery();	
			if(rs.next()) {
				if(!rs.getString("PWD").equals(pwd)){
					List[0] = "2";
				}else{
					List[0] = "1";
					List[1] = rs.getString("NAME");
				}
			} else {
				List[0] = "3";
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return List;
	}
	
	// 전체 멤버 조회
	public List<MemberVO> selectAll() {
		List<MemberVO> List = new ArrayList<>();
		
		try {
			String sql = "SELECT * FROM CHATMEMBER";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				String id = rs.getString("ID");
				String pwd = rs.getString("PWD");
				String name = rs.getString("NAME");
				
				MemberVO data = new MemberVO(id,pwd,name);
				List.add(data);
			}
			
			
			DBConnection.freeConnection(rs,pst,con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return List;
	}
	
	
	public static void main(String[] args) {
		ChatDAO dao = new ChatDAO();
		List<MemberVO> List;
		List = dao.selectAll();
		for (int i=0; i<List.size(); i++) {
			System.out.println(List.get(i).getID());
			System.out.println(List.get(i).getPWD());
			System.out.println(List.get(i).getNAME());
			System.out.println("----------------");
		}
//		System.out.println(dao.idLogin("test3", "12354"));		
//		dao.signUp("test3","1234","comedown3");
//		dao.selectAll();
		dao.signUp("test1234","1234","comedown");
		
	}
	
}
