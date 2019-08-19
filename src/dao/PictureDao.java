package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil;
import entity.Picture;

public class PictureDao implements PictureInterface {
	Picture picture=new  Picture();

	public boolean AddPicture(Picture picture) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean DeletePicture(Picture picture) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean FindPicture(Picture picture) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean UpdatePicture(Picture picture) {
		// TODO Auto-generated method stub
		return false;
	}
	public int getSNum() {
		int num=0;
		JDBCUtil util=new JDBCUtil();
		String sql="select count(*) from vote_option_picture";
		try {
			ResultSet rs=util.executeQuery(sql);
			if(rs.next()){
				num=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			util.close();
		}
		return num;
	}

	public List<Picture> searchPictureByPage(int start, int end) {
		List<Picture> piclist=new ArrayList<Picture>();
		JDBCUtil util = new JDBCUtil();
		String sql="select * from vote_option_picture limit ?,?";
		try {
			ResultSet rs=util.executeQuery(sql, start,end);
			Picture pic=null;
			while(rs.next()){
				pic=new Picture();
				pic.setpId(rs.getInt("VOTE_OPTION_ID"));
				pic.setpDescription(rs.getString("VOTE_OPTION_DESCRIPTION"));
				pic.setpImage(rs.getString("VOTE_IMAGE"));
				pic.setpTicket(rs.getInt("VOTE_TICKET"));
				piclist.add(pic);
				//System.out.println("我在这儿呢！");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.close();
		}
	
		return piclist;
	}
	

	public Picture FindPicById(int id){
		Picture pic=null;
		JDBCUtil util=new JDBCUtil();
		String sql="select * from vote_option_picture where VOTE_OPTION_ID=?";
		try {
			ResultSet rs=util.executeQuery(sql, id);
			if(rs.next()){
				pic=new Picture();
				pic.setpId(rs.getInt("VOTE_OPTION_ID"));
				pic.setpDescription(rs.getString("VOTE_OPTION_DESCRIPTION"));
				pic.setpImage(rs.getString("VOTE_IMAGE"));
				pic.setpTicket(rs.getInt("VOTE_TICKET"));
				//piclist.add(pic);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.close();
		}
		return pic;
		
	}
	
	
	public boolean AddTicket(int id,int ticket) {
		boolean result=false;
		JDBCUtil util=new JDBCUtil();
		String sql="update vote_option_picture set VOTE_TICKET=? where VOTE_OPTION_ID=?";
		try {
			System.out.println("当前ticket的值为："+(ticket+1));
			int num=util.executeUpdate(sql,(ticket+1),id);
			if(num>0){
				result=true;
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.close();
		}
		return result;
		}

	
	}
