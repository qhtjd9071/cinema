package shop.jbsapp.www.controller;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.security.Principal;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class BaseController {

	@Autowired
	private ServletContext context;
	
	@GetMapping("/")
	public String home(@AuthenticationPrincipal Principal principal) {
		if (principal != null) {
			String authority = principal.getName();
			if(authority != null && authority.equals("admin")) {
				return "admin/main";
		}
		}
		return "layout/main";
	}
	
	@PostMapping("/fileUpload/{cmd}")
	@ResponseBody
	public String fileUpload(MultipartFile file, @PathVariable String cmd) {
		String path = null;

		if (cmd.equals("eventMain")) {
			path=context.getRealPath("/resources/upload/event/main");
		} else if (cmd.equals("eventDetail")) {
			path=context.getRealPath("/resources/upload/event/detail");
		} else if (cmd.equals("movie")) {
			path=context.getRealPath("/resources/upload/movie");
		}
		String orgfilename=file.getOriginalFilename();
		String savefilename=UUID.randomUUID()+"_"+orgfilename;
		try {
			InputStream is=file.getInputStream();
			FileOutputStream fos=new FileOutputStream(path+"\\"+savefilename);
			FileCopyUtils.copy(is, fos);
			is.close();
			fos.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return savefilename;
	}
}
