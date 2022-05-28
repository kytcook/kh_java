package com.day20;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class FileWri {

	public static void main(String[] args) {
		FileWriter fw2 = null;
		try {
			fw2 = new FileWriter("D:\\java_study\\workspace_java\\kh_java\\src\\com\\day20\\log");
			fw2.write(97);
			fw2.write(65);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			
		}
		try {
			fw2.close(); 
		} catch (Exception e2) {

		}
		
	}

}
