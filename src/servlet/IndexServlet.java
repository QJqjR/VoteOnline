package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SubjectDao;
import dao.UserDao;
import entity.Subject;
import entity.User;

public class IndexServlet extends HttpServlet {

		public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			HttpSession session=request.getSession();
			String name=(String) session.getAttribute("name");
			System.out.println("主页username:"+name);
			User user=new User();
			user.setuName(name);
			UserDao udao=new UserDao();
			user=udao.findUserByName(user);
			int userStatus=user.getuStatus();
			System.out.println("主页用户的状态："+userStatus);
			
			String newCurrentPage =request.getParameter("currentPage");
			SubjectDao dao=new SubjectDao();
			int total=dao.getSNum();
			int num=9;
			int currentPage=1;
			//System.out.println("总数据条数:"+total);
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
			session.setAttribute("userStatus", userStatus);
			
			List<Subject> sublist=dao.searchSubjectByPage(start,end);
			request.setAttribute("subList", sublist);
			request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
