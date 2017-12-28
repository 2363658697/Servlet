package up_download;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadServlet extends HttpServlet {
	static String SAVE_DIR = "E:/test";
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		
		
		String fileName="W3School¿Îœﬂ ÷≤·(2014.3.24).chm";
		
		String destPath=SAVE_DIR+"/"+fileName;
		
		response.setHeader("Location",URLEncoder.encode(fileName, "UTF-8"));
		response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, "UTF-8"));
		
		
		OutputStream os=response.getOutputStream();
		
		FileInputStream fis=new FileInputStream(destPath);
		byte[] bs=new byte[1024];
		int write=-1;
		while((write=fis.read(bs))!=-1){
			os.write(bs, 0, write);
		}
		
		os.close();
		fis.close();
		
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
