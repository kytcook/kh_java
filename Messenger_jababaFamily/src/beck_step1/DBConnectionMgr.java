<<<<<<< HEAD:Messenger_jababaFamily/src/beck_step1/DBConnectionMgr.java
package beck_step1;
=======
package step1;
>>>>>>> 6cf0eee2f717fef32aeab610ec5ac1a94da8b5d7:Messenger_jababaFamily/src/step1/DBConnectionMgr.java

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionMgr {
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521:orcl11";
		Connection con = null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("192.168.1.86", "scott", "tiger");
		}catch(Exception e){
			System.out.println("Exception=["+ e +"]");
		}  
		return con;
	}
}
