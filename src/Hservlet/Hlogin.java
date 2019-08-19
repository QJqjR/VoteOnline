package Hservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import entity.User;

public class Hlogin extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session=(HttpSession)request.getSession();
		String name=request.getParameter("username");
		String pass=request.getParameter("password");
		
		System.out.println("用户名:"+name);
		System.out.println("密码："+pass);
		//数据库查询操作
		User user=new User();
		user.setuName(name);
		user.setuPass(pass);
		UserDao dao=new UserDao();
		if(dao.findUser(user)){
			Cookie cook=new Cookie("VU_USER_NAME",name);
			Cookie cook1=new Cookie("VU_PASSWORD",pass);
		
			request.getSession().setAttribute("name",name);
			response.sendRedirect("UserManager.jsp");
			}else{
				request.setAttribute("error", "用户名或密码错误！");
				request.getRequestDispatcher("HLogin.jsp").forward(request, response);
			}
	}

}
