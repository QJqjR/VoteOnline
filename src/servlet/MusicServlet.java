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
import entity.Music;

public class MusicServlet extends HttpServlet {

	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session=request.getSession();
		String name=(String) session.getAttribute("name");
		System.out.println("音乐投票页面的用户："+name);
		String newCurrentPage =request.getParameter("currentPage");
		MusicDao dao=new MusicDao();
		int total=dao.getSNum();
		int num=9;
		int currentPage=1;
		//System.out.println("视频数据总条数:"+total);
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
		
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("totalPage", totalPage);
		List<Music> musiclist=dao.searchMusicByPage(start,end);
		request.setAttribute("musicList", musiclist);
		request.getRequestDispatcher("musicVote.jsp").forward(request, response);
	}

}
