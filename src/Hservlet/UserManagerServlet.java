package Hservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import entity.User;

public class UserManagerServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String newCurrentPage =request.getParameter("currentPage");
		UserDao dao=new UserDao();
		
		int num=10;
		int total=dao.getUserNum();
		//System.out.println("总页数："+total);
		int totalPage=total%num>0?total/num+1:total/num;
		int currentPage=1;
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
		System.out.println("总页数currentPage:"+currentPage);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("totalPage", totalPage);
		
		List<User> userlist=dao.findUsers();
		request.setAttribute("userList", userlist);
		request.getRequestDispatcher("UserManager.jsp").forward(request, response);
			
	}

}
