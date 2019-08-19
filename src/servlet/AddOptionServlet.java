package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import dao.MusicDao;
import dao.SubjectDao;
import dao.UserDao;
import dao.VideoDao;

import entity.Music;
import entity.Subject;
import entity.User;
import entity.Video;

public class AddOptionServlet extends HttpServlet {

	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		System.out.println("这里是我的投票页面！！！");
		HttpSession session=request.getSession();
		String name=(String) session.getAttribute("name");
		System.out.println("我的投票页面username："+name);
		User user=new User();
		user.setuName(name);
		UserDao udao=new UserDao();
		udao.findUserByName(user);
		int userStatus=user.getuStatus();
		session.setAttribute("userStatus",userStatus);
		if(userStatus==0){
			request.getRequestDispatcher("AddOption.jsp").forward(request, response);
		}else{
			String type=request.getParameter("stype");
			String sselect=request.getParameter("sselect");
			String description=request.getParameter("sDescription");
			String sfile=request.getParameter("sfile");
			
			String[] descriptions = request.getParameterValues("sDescription");
			
			String[] files = request.getParameterValues("sfile");
			
			String newCurrentPage =request.getParameter("currentPage");
			SubjectDao dao=new SubjectDao();
			int total=dao.getSNum();
			int num=9;
			int currentPage=1;
			System.out.println("总数据条数:"+total);
			int totalPage=total%num>0?total/num+1:total/num;
			
			if(newCurrentPage!=null){
				currentPage=Integer.parseInt(newCurrentPage);
			}
			if(currentPage<1){
				currentPage=1;
			}
			if(currentPage>totalPage){
				currentPage=totalPage;
			}
			int start=(currentPage-1)*num;
			int end=num;
			
			if(sselect.equals("tuwen")){
				request.setAttribute("currentPage", currentPage);
				request.setAttribute("totalPage", totalPage);
				List<Subject> sublist=dao.searchSubjectWithAdd(start,end);
				request.setAttribute("subList", sublist);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}else if(sselect.equals("video")){
				VideoDao dao1=new VideoDao();
				request.setAttribute("currentPage", currentPage);
				request.setAttribute("totalPage", totalPage);
				List<Video> videolist=dao1.searchSubjectWithAdd(start,end);
				request.setAttribute("videoList", videolist);
				request.getRequestDispatcher("videoVote.jsp").forward(request, response);
			}else{
				MusicDao dao2=new MusicDao();
				request.setAttribute("currentPage", currentPage);
				request.setAttribute("totalPage", totalPage);
				List<Music> musiclist=dao2.searchMusicWithAdd(start,end);
				request.setAttribute("musicList", musiclist);
				request.getRequestDispatcher("musicVote.jsp").forward(request, response);
			}
			
		}
		
	
		
		
		
		
		
		
		
		
		
				
	}

}
