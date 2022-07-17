<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.google.gson.*" %>    
<%	
	// 6번 ★ 듣고 말하기
	String mem_tel = request.getParameter("mem_tel");// get방식 : 노출된다. 크기에 제약이 있다(주소창) // post방식은 링크를 할 수 없다. - 즐겨찾기를 할 수 없다. : post는 단위테스트가 불가능하다.
	// 개발단계에서는 get방식, 서버에 올릴때는 post로 바꿔서 올려라
	// '양도' : 업무적인 depth를 키울 수 있다.
	//out.print("주문자 전화번호 :" + mem_tel);		
	List<Map<String,String>> cusList = new ArrayList<>();
    Map<String,String> rMap = new HashMap<>();
    rMap.put("mem_name","김유신");
    rMap.put("mem_addr","서울시 마포구 공덕동");
    rMap.put("mem_tel","0255556666");
    cusList.add(rMap);
    rMap = new HashMap<>();
    rMap.put("mem_name","김춘추");
    rMap.put("mem_addr","서울시 금천구 가산동");
    rMap.put("mem_tel","0277776666");
    cusList.add(rMap);
    rMap = new HashMap<>();
    rMap.put("mem_name","이성계");
    rMap.put("mem_addr","서울시 영등포구 당산동");
    rMap.put("mem_tel","0277778888");
    cusList.add(rMap);
    String address = "";
    // find, 필터,  
    for(int i=0; i<cusList.size(); i++){// 확장자가 jsp, 서버가 tomcat, live서버는 jsp엔진이 없다- jsp안에서는 자바문법 사용. mime타입
    	Map<String,String> rmap = cusList.get(i);
    	if(rmap.get("mem_tel").equals(mem_tel)){// 참조형타입 : mem_tel을 비교해야 하는데 주소번지를 가리키는 값을 비교하고 있다.
    		address = rmap.get("mem_addr");
    	}// 문자열, 스토리텔릥~
    }
    out.print(address);
%>
