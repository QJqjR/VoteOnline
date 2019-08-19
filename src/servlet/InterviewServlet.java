package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import dao.UserDao;

import entity.User;

public class InterviewServlet extends HttpServlet {

	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		HttpSession session=request.getSession();
		String newCurrentPage =request.getParameter("currentPage");
		
		String name=(String) session.getAttribute("name");
		System.out.println("邮件通知用户："+name);
		User user=new User();
		user.setuName(name);
		UserDao dao=new UserDao();
		user=dao.findUserEmail(user);
		//SendEmail(user.getuEmail(),user.getuName());
		String email=user.getuEmail();
		System.out.println("从数据库里出来的email:"+email);
		//SendEmail(user.getuEmail());
		//SendEmail("2414726781@qq.com");
		SendEmail(email);
		request.getRequestDispatcher("myVote.jsp").forward(request, response);

		
	}
	private void SendEmail(String email) {
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
			send.setMsg("你发布的投票信息:盗墓笔记最奇特的墓"+"\n" + "访问人数：0"+"\n"+"参与人数：0"+
			"\n"+"累计投票数：0票"+"\n"+"最高得票数：0票"+"\n"+"西沙海底墓：0票"+"\n"+"秦岭神树：0票"+"\n"+"云顶天宫：0票");// Eamil的内容
			send.send();// 发送
		} catch (EmailException e) {
			e.printStackTrace();
		}
	}

}
