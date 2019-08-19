package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil;
import entity.User;

public class UserDao implements UserInterface{

	public boolean findUser(User user) {
			boolean result=false;
			JDBCUtil util =new JDBCUtil();
			String sql="select *from vote_user where VU_USER_NAME=? and VU_PASSWORD=?";
			ResultSet rs;
			try {
				rs=util.executeQuery(sql,user.getuName(),user.getuPass());
				if(rs.next()){
			    	result=true;
			    }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				util.close();
			}
			return result;
		}
	public User findUserByName(User user) {
		JDBCUtil util =new JDBCUtil();
		String sql="select *from vote_user where VU_USER_NAME=? ";
		ResultSet rs;
		try {
			rs=util.executeQuery(sql,user.getuName());
			while(rs.next()){
				user.setuId(rs.getInt("VU_USER_ID"));
				user.setuName(rs.getString("VU_USER_NAME"));
				user.setuPass(rs.getString("VU_PASSWORD"));
				user.setuStatus(rs.getInt("VU_STATUS"));
				user.setuEmail(rs.getString("VU_EMAIL"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.close();
		}
		return user;
	}
	

	public boolean addUser(User user) {
		boolean result=false;
		JDBCUtil util=new JDBCUtil();
		String sql="insert into vote_user (VU_USER_NAME,VU_PASSWORD,VU_EMAIL,VU_STATUS) values(?,?,?,?)";
		ResultSet rs;
		try {
			util.executeUpdate(sql,user.getuName(),user.getuPass(),user.getuEmail(),0);
			result=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.close();
		}
		return result;
	}


	public List<User> findUsers() {
		
			List<User> userlist=new ArrayList<User>();
			JDBCUtil util=new JDBCUtil();
			String sql="select *from vote_user";
			ResultSet rs;
			try {
				rs=util.executeQuery(sql);
				User user=null;
				while(rs.next()){
					user=new User();
					user.setuId(rs.getInt("VU_USER_ID"));
					user.setuName(rs.getString("VU_USER_NAME"));
					user.setuPass(rs.getString("VU_PASSWORD"));
					user.setuStatus(rs.getInt("VU_STATUS"));
					user.setuEmail(rs.getString("VU_EMAIL"));
					userlist.add(user);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				util.close();
			}
			return userlist;
		}
	public User findUserEmail(User user) {
		JDBCUtil util=new JDBCUtil();
		String sql="select * from vote_user where VU_USER_NAME=?";
		ResultSet rs;
		try {
			rs=util.executeQuery(sql, user.getuName());
			while(rs.next()){
				user.setuId(rs.getInt("VU_USER_ID"));
				user.setuName(rs.getString("VU_USER_NAME"));
				user.setuPass(rs.getString("VU_PASSWORD"));
				user.setuStatus(rs.getInt("VU_STATUS"));
				user.setuEmail(rs.getString("VU_EMAIL"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}

	public int getUserNum() {
		int num=0;
		JDBCUtil util=new JDBCUtil();
		String sql="select count(*) from vote_user";
		try {
			ResultSet rs=util.executeQuery(sql);
			if(rs.next()){
				num=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.close();
		}
		return num;
	}


	public boolean updateUser(int id) {
		boolean result=false;
		JDBCUtil util=new JDBCUtil();
		String sql="update vote_user set VU_STATUS=? where VU_USER_ID=?";
		try {
			int num=util.executeUpdate(sql, 1,id);
			if(num>0){
				result=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.close();
		}
		return result;
	}


	public boolean updateUserpass(int id) {
		boolean result=false;
		JDBCUtil util=new JDBCUtil();
		String sql="update vote_user set VU_PASSWORD=? where VU_USER_ID=?";
		try {
			int num=util.executeUpdate(sql, "123456",id);
			if(num>0){
				result=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.close();
		}
		return result;
	}


	public User findUserpass(User user) {
		JDBCUtil util =new JDBCUtil();
		String sql="select *from vote_user where VU_USER_ID=?";
		ResultSet rs;
		try {
			rs=util.executeQuery(sql, user.getuId());
			while(rs.next()){
				user.setuId(rs.getInt("VU_USER_ID"));
				user.setuName(rs.getString("VU_USER_NAME"));
				user.setuPass(rs.getString("VU_PASSWORD"));
				user.setuStatus(rs.getInt("VU_STATUS"));
				user.setuEmail(rs.getString("VU_EMAIL"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}
}


