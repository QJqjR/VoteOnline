package Hservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import dao.UserDao;
import entity.User;

public class UpdateUserPass extends HttpServlet {

	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String newCurrentPage =request.getParameter("currentPage");
		
		String userid=request.getParameter("id");
		int id=Integer.parseInt(userid);
		UserDao dao=new UserDao();
		boolean t=dao.updateUserpass(id);
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
		User user=new User();
		user.setuId(id);
		user=dao.findUserpass(user);
		String password=user.getuPass();
		String email=user.getuEmail();
		
		
		if(t){
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("totalPage", totalPage);
			SendEmail(email,password);
			
			List<User> userlist=dao.findUsers();
			request.setAttribute("userList", userlist);
			request.getRequestDispatcher("UserManager.jsp").forward(request, response);
		}
	}
	private void SendEmail(String email,String password ) {
		HtmlEmail send = new HtmlEmail();
		System.out.println("上面来的Email:"+email);
		try {
			send.setHostName("smtp.qq.com");
			send.setSmtpPort(465);// 端口号
			send.setSSLOnConnect(true);// 开启SSL加密
			send.setCharset("utf-8");
			send.addTo(email);// 接收者的QQEamil
			send.setFrom("2414726781@qq.com", "ANGEL");// 第一个参数是发送者的QQEamil  
														// 第二个参数是发送者QQ昵称
			//send.setFrom(email, "ANGEL");
			send.setAuthentication("2414726781@qq.com", "twoszcsymicldjbi"); // 第一个参数是发送者的QQEamil
																				//  
																				// 第二个参数是刚刚获取的授权码
			send.setSubject("小渣渣特给您送上投票信息");// Eamil的标题  第一个参数是我写的判断上下午，删掉即可
			send.setMsg("您已重置密码，现在您的新密码是："+password);// Eamil的内容
			send.send();// 发送
		} catch (EmailException e) {
			e.printStackTrace();
		}
	}

}
