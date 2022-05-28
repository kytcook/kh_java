package network.step1;

import java.net.*; 
public class InetAddressEx { 
	public static void main(String[] args) 
			throws UnknownHostException { 
		InetAddress iaddr = 
				InetAddress.getLocalHost(); 
		System.out.printf("호스트 이름 : %s %n" , 
				iaddr.getHostName()); 
		System.out.printf("호스트 IP 주소 : %s %n" , 
				iaddr.getHostAddress()); 
		iaddr = InetAddress.getByName("www.google.com"); // 도메인을 써주게 되면 도메인 주소를 가지고, inetaddress가 만들어진다. 그걸 통해 호스트 이름 ip주소를 출력?
//		iaddr = InetAddress.getByName("www.google23412.com"); // 문법상으로는 오류가 없지만, 실행할 때 오루가 발생한다. UnknownHostException
		System.out.printf("호스트 이름 : %s %n" , 
				iaddr.getHostName()); 
		System.out.printf("호스트 IP 주소 : %s %n" , 
				iaddr.getHostAddress()); 
		InetAddress sw[] = 
				InetAddress.getAllByName("www.daum.net"); 
		for (InetAddress temp_sw : sw) { 
			System.out.printf("호스트 이름 : %s , " , 
					temp_sw.getHostName()); 
			System.out.printf("호스트 IP 주소 : %s %n" , 
					temp_sw.getHostAddress()); 
		} 
	} 
} 

