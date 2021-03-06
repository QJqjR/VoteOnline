package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SubjectDao;
import entity.Subject;

public class UpdateVoteServlet extends HttpServlet {

	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String newCurrentPage =request.getParameter("currentPage");
		SubjectDao dao=new SubjectDao();
		String type="盗墓笔记最奇特的墓";
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
		List<Subject> sublist=dao.searchSubjectByType(type);
		request.setAttribute("subList", sublist);
		request.getRequestDispatcher("myVote.jsp").forward(request, response);
	}

}
