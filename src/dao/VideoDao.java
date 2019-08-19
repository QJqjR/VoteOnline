package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import util.JDBCUtil;
import entity.Subject;
import entity.Video;

public class VideoDao  implements VideoInterface{

	public boolean AddVideo(Video video) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean DeleteVideo(Video video) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean FindVideo(Video video) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean UpdateVideo(Video video) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public int getSNum() {
		int num=0;
		JDBCUtil util=new JDBCUtil();
		String sql="select count(*) from vote_subject_video";
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

	public List<Video> searchVideoByPage(int start, int end) {
		List<Video> videolist=new ArrayList<Video>();
		JDBCUtil util = new JDBCUtil();
		String sql="select * from vote_subject_video limit ?,?";
		try {
			ResultSet rs=util.executeQuery(sql, start,end);
			Video video=null;
			while(rs.next()){
				video=new Video();
				video.setsId(rs.getInt("VS_ID"));
				video.setsTitle(rs.getString("VS_TITLE"));
				video.setsType(rs.getString("VS_TYPE"));
				video.setsBrowseTotal(rs.getInt("VS_BROWSETOTAL"));
				video.setsParticipate(rs.getInt("VS_PARTICIPATE"));
				video.setsVotetotal(rs.getInt("VS_VOTETOTAL"));
				video.setsImage(rs.getString("VS_IMG"));
				video.setsVideo(rs.getString("VS_VIDEO"));
				//System.out.println("视频路径："+video.getsVideo());
				videolist.add(video);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.close();
		}
		videolist.remove(8);
		return videolist;
	}

	public Video FindVideoById(int id) {
		Video vid=null;
		JDBCUtil util=new JDBCUtil();
		String sql="select * from vote_subject_video where VS_ID=?";
		try {
			ResultSet rs=util.executeQuery(sql, id);
			if(rs.next()){
				vid=new Video();
				vid.setsId(rs.getInt("VS_ID"));
				vid.setsTitle(rs.getString("VS_TITLE"));
				vid.setsType(rs.getString("VS_TYPE"));
				vid.setsBrowseTotal(rs.getInt("VS_BROWSETOTAL"));
				vid.setsParticipate(rs.getInt("VS_PARTICIPATE"));
				vid.setsVotetotal(rs.getInt("VS_VOTETOTAL"));
				vid.setsImage(rs.getString("VS_IMG"));
				vid.setsVideo(rs.getString("VS_VIDEO"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.close();
		}
		return vid;
	}

	public boolean AddTicket(int id, int ticket) {
		boolean result=false;
		JDBCUtil util=new JDBCUtil();
		String sql="update vote_subject_video set VS_PARTICIPATE=? where VS_ID=?";
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

	public List<Video> searchSubjectWithAdd(int start, int end) {
		List<Video> videolist=new ArrayList<Video>();
		JDBCUtil util = new JDBCUtil();
		String sql="select * from vote_subject_video limit ?,?";
		try {
			ResultSet rs=util.executeQuery(sql, start,end);
			Video video=null;
			while(rs.next()){
				video=new Video();
				video.setsId(rs.getInt("VS_ID"));
				video.setsTitle(rs.getString("VS_TITLE"));
				video.setsType(rs.getString("VS_TYPE"));
				video.setsBrowseTotal(rs.getInt("VS_BROWSETOTAL"));
				video.setsParticipate(rs.getInt("VS_PARTICIPATE"));
				video.setsVotetotal(rs.getInt("VS_VOTETOTAL"));
				video.setsImage(rs.getString("VS_IMG"));
				video.setsVideo(rs.getString("VS_VIDEO"));
				//System.out.println("视频路径："+video.getsVideo());
				videolist.add(video);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.close();
		}

		return videolist;
	}

	public List<Video> searchVideoByType(String type) {
		List<Video> vidlist = new ArrayList<Video>();
		JDBCUtil util = new JDBCUtil();
		String sql= "select * from vote_subject_video where VS_TYPE = ?";
		try {
			ResultSet rs=util.executeQuery(sql, type);
			while(rs.next()){
				Video video = new Video();
				video.setsId(rs.getInt("VS_ID"));
				video.setsTitle(rs.getString("VS_TITLE"));
				video.setsType(rs.getString("VS_TYPE"));
				video.setsBrowseTotal(rs.getInt("VS_BROWSETOTAL"));
				video.setsParticipate(rs.getInt("VS_PARTICIPATE"));
				video.setsVotetotal(rs.getInt("VS_VOTETOTAL"));
				video.setsImage(rs.getString("VS_IMG"));
				video.setsVideo(rs.getString("VS_VIDEO"));
				System.out.println("视频路径："+video.getsVideo());
				vidlist.add(video);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return vidlist;
	}
	@Test 
	public void test(){
		List<Video> list=searchVideoByType("记忆中的小伙伴");
		System.out.println(list.size());
	}
}
