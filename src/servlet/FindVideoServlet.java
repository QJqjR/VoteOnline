package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.VideoDao;
import entity.Video;


public class FindVideoServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String type=request.getParameter("videoFind");
		System.out.println("视频投票主题："+type);
		
		String newCurrentPage=request.getParameter("currentPage");
		VideoDao dao=new VideoDao();
		int total = dao.getSNum();
		int num=9;
		int currentPage=1;
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
		List<Video> videolist=dao.searchVideoByType(type);
		//System.out.println("数组长度："+videolist.size());
		request.setAttribute("videoList", videolist);
		request.getRequestDispatcher("videoVote.jsp").forward(request, response);
		
	}

}
