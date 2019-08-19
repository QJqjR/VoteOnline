package servlet;

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

public class RegisterServlet extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String name = request.getParameter("username");
		String pass = request.getParameter("password");
		String rpass = request.getParameter("repassword");
		String email = request.getParameter("useremail");
		//System.out.println("name:"+name);
		//System.out.println("pass:"+pass);
		
		User user=new User();
		user.setuName(name);
		user.setuPass(pass);
		user.setuEmail(email);
		
		HttpSession session = request.getSession();
		ServletContext sc = session.getServletContext();
		
		UserDao userdao = new UserDao();
		List<User> list = new ArrayList<User>();
		
		boolean flag=true;
		list = userdao.findUsers();
		for(User u:list) {
			if(name.equals(u.getuName())) {
				flag=false;
				break;
			}
		}
		if(flag){
			UserDao ud = new UserDao();
			boolean f = ud.addUser(user);
			if (f) {
				request.setAttribute("msg", "注册成功！");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}else{
			request.setAttribute("msg", "用户名已存在，请重新输入！");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
	}
}
