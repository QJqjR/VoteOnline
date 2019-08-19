package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import util.JDBCUtil;
import entity.Subject;

public class SubjectDao implements SubjectInterface{

	public boolean AddSubject(Subject subject) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean DeteleSubject(Subject subject) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean FindSubject(Subject subject) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean UpdateSubject(Subject subject) {
		// TODO Auto-generated method stub
		return false;
	}

	public int getSNum() {
		int num=0;
		JDBCUtil util=new JDBCUtil();
		String sql="select count(*) from vote_subject";
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

	public List<Subject> searchSubjectByPage(int start, int end) {
		List<Subject> sublist=new ArrayList<Subject>();
		JDBCUtil util = new JDBCUtil();
		String sql="select * from vote_subject limit ?,?";
		try {
			ResultSet rs=util.executeQuery(sql, start,end);
			Subject sub=null;
			while(rs.next()){
				sub=new Subject();
				sub.setsId(rs.getInt("VS_ID"));
				sub.setsTitle(rs.getString("VS_TITLE"));
				sub.setsType(rs.getString("TYPE"));
				sub.setsBrowseTotal(rs.getInt("VS_BROWSETOTAL"));
				sub.setsParticipate(rs.getInt("VS_PARTICIPATE"));
				sub.setsVotetotal(rs.getInt("VS_VOTETOTAL"));
				sub.setsImage(rs.getString("VS_IMG"));
				//System.out.println("图片地址："+sub.getsImage());
				sublist.add(sub);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.close();
		}
		sublist.remove(8);
		return sublist;
	}
	public List<Subject> searchSubjectWithAdd(int start, int end) {
		List<Subject> sublist=new ArrayList<Subject>();
		JDBCUtil util = new JDBCUtil();
		String sql="select * from vote_subject limit ?,?";
		try {
			ResultSet rs=util.executeQuery(sql, start,end);
			Subject sub=null;
			while(rs.next()){
				sub=new Subject();
				sub.setsId(rs.getInt("VS_ID"));
				sub.setsTitle(rs.getString("VS_TITLE"));
				sub.setsType(rs.getString("TYPE"));
				sub.setsBrowseTotal(rs.getInt("VS_BROWSETOTAL"));
				sub.setsParticipate(rs.getInt("VS_PARTICIPATE"));
				sub.setsVotetotal(rs.getInt("VS_VOTETOTAL"));
				sub.setsImage(rs.getString("VS_IMG"));
				//System.out.println("图片地址："+sub.getsImage());
				sublist.add(sub);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.close();
		}
		return sublist;
	}

	
	public List<Subject> searchSubjectByType(String type) {
		List<Subject> sublist=new ArrayList<Subject>();
		JDBCUtil util = new JDBCUtil();
		System.out.println("我是前面页面来的type:"+type);		
		String sql="select * from vote_subject as vs where type = ?";	
		try { 
			ResultSet rs=util.executeQuery(sql, type);
			
			System.out.println("嗨，你看见我了吗？我是图片，我在这呢,hello……");
			while(rs.next()){
				Subject  sub=new Subject();
				sub.setsId(rs.getInt("VS_ID"));
				sub.setsTitle(rs.getString("VS_TITLE"));
				sub.setsType(rs.getString("TYPE"));
				sub.setsBrowseTotal(rs.getInt("VS_BROWSETOTAL"));
				sub.setsParticipate(rs.getInt("VS_PARTICIPATE"));
				sub.setsVotetotal(rs.getInt("VS_VOTETOTAL"));
				sub.setsImage(rs.getString("VS_IMG"));
				System.out.println("嗨，你看见我了吗？我是图片，我在这呢："+sub.getsImage());
				sublist.add(sub);
			}
		} catch (SQLException e) {         
			e.printStackTrace();
		}finally{
			util.close();
		}
		System.out.println("数组长度："+sublist.size());
		return sublist;
	}
	
	@Test
	public void test(){
		List<Subject> list = searchSubjectByType("记忆中的小伙伴");
		System.out.println(list.size());
		
	}
}
