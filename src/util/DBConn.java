package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
	// DB ���� ����
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String USERNAME = "momo";
	private static final String PASSWORD = "admin2019";

	// DB ���� ��ü
	private static Connection conn = null; //���ᰴü
	
	// private ������
	private DBConn() { }
	
	// Connection ��ü ��ȯ - Singleton Pattern
	public static Connection getConnection() {

		// DB ������ �ȵǾ����� ���� ����
		if( conn == null ) {
			try {
				Class.forName(DRIVER); //����̹��ε�
				
				// DB ���ᰴü ����
				conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return conn; // DB ���ᰴü ��ȯ
	}
	
}












