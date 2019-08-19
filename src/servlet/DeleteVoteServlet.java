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

public class DeleteVoteServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String newCurrentPage =request.getParameter("currentPage");
		SubjectDao dao=new SubjectDao();
		String type="记录镜头下最美的时刻";
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
		//boolean t=dao.DeteleSubjectByType(type);
		//System.out.println("测试删除是否成功，我的值是："+t);
		List<Subject> sublist=null;
		request.setAttribute("subList", sublist);
		request.getRequestDispatcher("myVote.jsp").forward(request, response);
		
	}

}
