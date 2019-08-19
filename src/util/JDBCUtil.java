package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtil {
	private final static String DRIVER = "com.mysql.jdbc.Driver";
	private final static String URL = "jdbc:mysql://127.0.0.1:3306/db_justpickyou?useUnicode=true&characterEncoding=utf-8";
	private final static String USER_NAME = "root";
	private final static String USER_PASS = "729395";

	public static Connection conn = null;
	private PreparedStatement stat = null;
	private ResultSet rs = null;

	public JDBCUtil() {
		getConncetion();
	}

	public  void getConncetion() {
		try {
			// 1、加载驱动
			Class.forName(DRIVER);
			// 2、获取数据库链接
			conn = DriverManager.getConnection(URL, USER_NAME, USER_PASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stat != null) {
				stat.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet executeQuery(String sql,Object...params) throws SQLException{
		
		stat=conn.prepareStatement(sql);
		for(int i=0;i<params.length;i++){
			System.out.println(params[i]);
			stat.setObject(i + 1, params[i]);
		}
		
		rs=stat.executeQuery();
		return rs;
	}
	
	public int executeUpdate(String sql,Object...params) throws SQLException{
		int result=0;
		stat=conn.prepareStatement(sql);
		for(int i=0;i<params.length;i++){
			stat.setObject(i+1,params[i]);
		}
		result=stat.executeUpdate();
		return result;
	}
}
