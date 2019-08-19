package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PictureDao;
import entity.Picture;

public class AddZanServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		HttpSession session=request.getSession();
		String name=(String) session.getAttribute("name");
		String str=request.getParameter("id");
		
		int id=Integer.parseInt(str);
		
		//System.out.println("该Id为："+id);
		
		PictureDao dao=new PictureDao();
		Picture pic=new Picture();
		Picture pic2=new Picture();
		pic=dao.FindPicById(id);
		int aticket=pic.getpTicket();
	
		
		boolean addT=dao.AddTicket(id,aticket);
		pic2=dao.FindPicById(id);
		aticket=pic2.getpTicket();
		if(addT){
			System.out.println("投票成功！现在的票数为："+aticket);
		}else{
			System.out.println("投票失败");
		}
		request.setAttribute("aticket", aticket);
		request.getRequestDispatcher("PicAndVote.jsp").forward(request, response);
		
		
	}

}
