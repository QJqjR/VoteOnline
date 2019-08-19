package servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ValidateServlet extends HttpServlet {


	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//创建图片
		BufferedImage image=new BufferedImage(100, 30,BufferedImage.TYPE_INT_RGB);
		//获取画笔
		Graphics g=image.getGraphics();
		  Random r=new Random();
		  //设置背景颜色
		 g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
	      g.fillRect(0,0, 100, 30);
	      String number=getNumber(4);
	      HttpSession session=request.getSession();
	      session.setAttribute("code", number);
	      g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
	      g.setFont(new Font("",Font.BOLD+Font.ITALIC,25));
	       g.drawString(number, 5,20);
	       for(int i=0;i<4;i++){
	    	   g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
	    	   g.drawLine(r.nextInt(100), r.nextInt(30), r.nextInt(100), r.nextInt(30));
	       }
	       response.setContentType("image/jpeg");
	       OutputStream out=response.getOutputStream();
	       ImageIO.write(image,"jpeg", out);
	       out.close();
	}
	   public  String getNumber(int n){
		    String str="1234567890qwertyuioplkjhgfdsazxcvbnm";
		       Random r=new Random();
		       String ss="";
		       for(int i=0;i<n;i++){
		    	 char c=str.charAt(r.nextInt(str.length()));
		    	 ss=ss+c;
		       }
		   return ss;
	   }
	}

