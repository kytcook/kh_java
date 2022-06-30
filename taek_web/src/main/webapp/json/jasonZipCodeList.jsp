<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.util.DBConnectionMgr, java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement, java.sql.ResultSet" %>
<%@ page import="java.util.List, java.util.ArrayList" %>
<%@ page import="java.util.Map, java.util.HashMap" %>
<%@ page import="com.google.gson.Gson" %>
<%
   // 스크립틀릿
   // get 방식으로 url 전송한다. (get은 파라미터를 사용하여 단위테스트가 가능하다.)
   String dong = request.getParameter("dong"); // 사용자가 입력한 동 정보를 가져오기
   
   // 50000건의 데이터를 다 불러올 수 없기 때문에 default 값을 설정해준다.
   if(request.getParameter("dong") == null){
      dong = "역삼";
   } else {
      dong = request.getParameter("dong");
   }

      Connection          con    = null;
      PreparedStatement    pstmt    = null;
      ResultSet          rs       = null;
      DBConnectionMgr    dbMgr    = new DBConnectionMgr();
      
      List<Map<String,Object>> zipList = null;
      
      StringBuilder sql = new StringBuilder();
      sql.append("SELECT                         ");
      sql.append("       address, zipcode        ");
      sql.append("  FROM zipcode_t               ");
      sql.append(" WHERE dong LIKE '%'||?||'%'   ");
      
      try {
         con = dbMgr.getConnection();
         pstmt = con.prepareStatement(sql.toString());
         pstmt.setString(1, dong);
         rs = pstmt.executeQuery();
         
         zipList = new ArrayList<>();
         Map<String,Object> rmap = null;
         
         while(rs.next()) {
            rmap = new HashMap<>();
            rmap.put("address", rs.getString("address"));
            rmap.put("zipcode", rs.getString("zipcode"));
            //rmap.put("zipcode", rs.getString(2));
            zipList.add(rmap);
         }
         
         Gson g = new Gson();
         String imsi = g.toJson(zipList);
         out.print(imsi);
      } catch (Exception e) {
         out.println("Exception : " + e.toString());
      }
%>