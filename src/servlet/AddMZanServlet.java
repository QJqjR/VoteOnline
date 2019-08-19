package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MusicDao;
import entity.Music;



public class AddMZanServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		HttpSession session=request.getSession();
		String name=(String) session.getAttribute("name");
		String str=request.getParameter("id");
		
		int id=Integer.parseInt(str);
		
		//System.out.println("该Id为："+id);
		//System.out.println("该用户为："+name);
		
		MusicDao dao=new MusicDao();
		Music mus=new Music();
		Music mus2=new Music();
		mus=dao.FindMusicById(id);
		int aticket=mus.getsParticipate();
		
		boolean addT=dao.AddTicket(id,aticket);
		mus2=dao.FindMusicById(id);
		aticket=mus2.getsParticipate();
		if(addT){
			System.out.println("投票成功！现在的票数为："+aticket);
		}else{
			System.out.println("投票失败");
		}
		request.setAttribute("aticket", aticket);
		request.getRequestDispatcher("MusicAndVote.jsp").forward(request, response);
	}
	}
