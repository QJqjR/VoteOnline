package servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UpPservlet extends HttpServlet {
	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		 
		//创建工厂对象
		  DiskFileItemFactory factory=new DiskFileItemFactory();
		   File  f=new File("E:/target");
		    if(!f.exists()){
		    	f.mkdirs();
		    }
		    
		    factory.setRepository(f);
		    ServletFileUpload fileupload=new ServletFileUpload(factory);
		        fileupload.setHeaderEncoding("utf-8");
		        PrintWriter out=response.getWriter();
		       try {
				List<FileItem> fileItems=fileupload.parseRequest(request);
				 for(FileItem fileItem:fileItems){
					 
					 if(fileItem.isFormField()){
						  String name=fileItem.getFieldName();
						  String value=fileItem.getString("utf-8");
						  out.println("上传作者："+value+"**************");
					 }else{
						 String fileName=fileItem.getName();
						fileName=fileName.substring(fileName.lastIndexOf("/")+1);
						fileName=fileName=UUID.randomUUID()+"_"+fileName;
						String filepath="/upload/";
						 filepath=getServletContext().getRealPath(filepath+fileName);
						 System.out.println(filepath+"%%%%%%%%%%");
						 File file=new File(filepath);
						 OutputStream op=new FileOutputStream(file);
						  InputStream in=fileItem.getInputStream();
						  byte[] buffer=new byte[1024];
						  int len=-1;
						  while((len=in.read(buffer))!=-1){
							  op.write(buffer,0,len);
						  }
						  op.close();
						  in.close();
						  fileItem.delete();
					 }	 
				 }
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		    
	}


}
