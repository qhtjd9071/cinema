package admin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/fileup1")
public class FileuploadController1 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String saveDir=getServletContext().getRealPath("/upload/event");
		System.out.println(saveDir);
		MultipartRequest mr=new MultipartRequest(request,
				saveDir,
				1024*1024*5,
				"utf-8",
				new DefaultFileRenamePolicy()
		);
		String orgFileName=mr.getFilesystemName("upload_file1");
		String saveFileName=mr.getFilesystemName("upload_file1");
		
		JSONObject json=new JSONObject();
		json.put("orgFileName", orgFileName);
		json.put("saveFileName", saveFileName);
		PrintWriter pw=response.getWriter();
		pw.print(json);
	}
}
