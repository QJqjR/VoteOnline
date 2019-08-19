package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import util.JDBCUtil;
import entity.Music;
import entity.Subject;


public class MusicDao implements MusicInterface {

	public boolean AddMusic(Music music) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean DeleteMusic(Music music) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean FindMusic(Music music) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean UpdateMusic(Music music) {
		// TODO Auto-generated method stub
		return false;
	}
	public int getSNum() {
		int num=0;
		JDBCUtil util=new JDBCUtil();
		String sql="select count(*) from vote_subject_music";
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

	public List<Music> searchMusicByPage(int start, int end) {
		List<Music> muslist=new ArrayList<Music>();
		JDBCUtil util = new JDBCUtil();
		String sql="select * from vote_subject_Music limit ?,?";
		try {
			ResultSet rs=util.executeQuery(sql, start,end);
			Music mus=null;
			while(rs.next()){
				mus=new Music();
				mus.setsId(rs.getInt("VS_ID"));
				mus.setsTitle(rs.getString("VS_TITLE"));
				mus.setsType(rs.getString("VS_TYPE"));
				mus.setsBrowseTotal(rs.getInt("VS_BROWSETOTAL"));
				mus.setsParticipate(rs.getInt("VS_PARTICIPATE"));
				mus.setsVotetotal(rs.getInt("VS_VOTETOTAL"));
				mus.setsImage(rs.getString("VS_IMG"));
				mus.setsMusic(rs.getString("VS_MUSIC"));
				System.out.println("音频路径："+mus.getsMusic());
				muslist.add(mus);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.close();
		}
		muslist.remove(8);
		return muslist;
	}

	public Music FindMusicById(int id) {
		Music mus=null;
		JDBCUtil util=new JDBCUtil();
		String sql="select * from vote_subject_Music where VS_ID=?";
		try {
			ResultSet rs=util.executeQuery(sql, id);
			if(rs.next()){
				mus=new Music();
				mus.setsId(rs.getInt("VS_ID"));
				mus.setsTitle(rs.getString("VS_TITLE"));
				mus.setsType(rs.getString("VS_TYPE"));
				mus.setsBrowseTotal(rs.getInt("VS_BROWSETOTAL"));
				mus.setsParticipate(rs.getInt("VS_PARTICIPATE"));
				mus.setsVotetotal(rs.getInt("VS_VOTETOTAL"));
				mus.setsImage(rs.getString("VS_IMG"));
				mus.setsMusic(rs.getString("VS_MUSIC"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.close();
		}
		return mus;
	}

	public boolean AddTicket(int id, int ticket) {
		boolean result=false;
		JDBCUtil util=new JDBCUtil();
		String sql="update vote_subject_Music set VS_PARTICIPATE=? where VS_ID=?";
		try {
			System.out.println("当前音频ticket的值为："+(ticket+1));
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

	public List<Music> searchMusicWithAdd(int start, int end) {
		List<Music> muslist=new ArrayList<Music>();
		JDBCUtil util = new JDBCUtil();
		String sql="select * from vote_subject_Music limit ?,?";
		try {
			ResultSet rs=util.executeQuery(sql, start,end);
			Music mus=null;
			while(rs.next()){
				mus=new Music();
				mus.setsId(rs.getInt("VS_ID"));
				mus.setsTitle(rs.getString("VS_TITLE"));
				mus.setsType(rs.getString("VS_TYPE"));
				mus.setsBrowseTotal(rs.getInt("VS_BROWSETOTAL"));
				mus.setsParticipate(rs.getInt("VS_PARTICIPATE"));
				mus.setsVotetotal(rs.getInt("VS_VOTETOTAL"));
				mus.setsImage(rs.getString("VS_IMG"));
				mus.setsMusic(rs.getString("VS_MUSIC"));
				System.out.println("音频路径："+mus.getsMusic());
				muslist.add(mus);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.close();
		}
	
		return muslist;
	}

	public List<Music> searchMusicByType(String type) {
		List<Music> muslist=new ArrayList<Music>();
		JDBCUtil util = new JDBCUtil();
		String sql="select * from vote_subject_Music where VS_TYPE = ?";
		try {
			ResultSet rs=util.executeQuery(sql,type);
			Music mus=null;
			while(rs.next()){
				mus=new Music();
				mus.setsId(rs.getInt("VS_ID"));
				mus.setsTitle(rs.getString("VS_TITLE"));
				mus.setsType(rs.getString("VS_TYPE"));
				mus.setsBrowseTotal(rs.getInt("VS_BROWSETOTAL"));
				mus.setsParticipate(rs.getInt("VS_PARTICIPATE"));
				mus.setsVotetotal(rs.getInt("VS_VOTETOTAL"));
				mus.setsImage(rs.getString("VS_IMG"));
				mus.setsMusic(rs.getString("VS_MUSIC"));
				System.out.println("音频路径："+mus.getsMusic());
				muslist.add(mus);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			util.close();
		}
	
		return muslist;
	}
	@Test
	public void test(){
		List<Music> list = searchMusicByType("记忆中的小伙伴");
		System.out.println(list.size());
		
	}

}
