package com.mvc.step1;

public class Pattern {

	public static void main(String[] args) {
		String uri = "/pay/payManager.gym";
		String uri2 = "/dev_web/pay/payManager.gym"; //서버의 경로가 다른 경우가 있을 수 있다.
		String context = "/";
		String context2 = "dev_web/";
		String command = uri.substring(context.length()+1); // 1부터 뒤에가 잘린다.
		int end = command.lastIndexOf(".");
		command = command.substring(0, end);
		String upmu[] = null;
		upmu = command.split("/");
		for(String imsi:upmu) {
			System.out.println(imsi);//pay, payManager
		}
		
	}
	
}
