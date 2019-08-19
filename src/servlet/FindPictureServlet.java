package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PictureDao;
import dao.SubjectDao;
import entity.Picture;
import entity.Subject;

public class FindPictureServlet extends HttpServlet {

	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//HttpSession session=request.getSession();
		//String type=(String) session.getAttribute("findPicture");
		String type=request.getParameter("findPicture");
		System.out.println("图片投票主题："+type);
		
		String newCurrentPage =request.getParameter("currentPage");
		SubjectDao dao=new SubjectDao();
		int total=dao.getSNum();
		int num=9;
		int currentPage=1;
		//System.out.println("总数据条数:"+total);
		
		//分页
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
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
