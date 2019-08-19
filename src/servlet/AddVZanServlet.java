package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.VideoDao;
import entity.Video;


public class AddVZanServlet extends HttpServlet {

	
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
		
		VideoDao dao=new VideoDao();
		Video vid=new Video();
		Video vid2=new Video();
		vid=dao.FindVideoById(id);
		int aticket=vid.getsParticipate();
		
		boolean addT=dao.AddTicket(id,aticket);
		vid2=dao.FindVideoById(id);
		aticket=vid2.getsParticipate();
		if(addT){
			System.out.println("投票成功！现在的票数为："+aticket);
		}else{
			System.out.println("投票失败");
		}
		request.setAttribute("aticket", aticket);
		request.getRequestDispatcher("VideoAndVote.jsp").forward(request, response);
	}

}
