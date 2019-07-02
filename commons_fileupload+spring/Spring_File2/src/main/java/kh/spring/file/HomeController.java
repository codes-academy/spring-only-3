package kh.spring.file;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class HomeController {

	@Autowired
	private HttpSession session;

	@RequestMapping("/")
	public String home(Locale locale, Model model) {
		return "home";
	}

	@RequestMapping("upload.do")
	public String uploadProc(String name, MultipartFile image) {
		String resourcePath = 
				session.getServletContext().getRealPath("/resources");
		System.out.println(resourcePath);

//		commons-fileupload : 두 번째 방법
		try {
			FileUtils.writeByteArrayToFile(
					new File(resourcePath+"/"+System.currentTimeMillis()+"_file.png"), 
					image.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}

//                         commons-fileupload : 두 번째 방법
//		try {
//			image.transferTo(
//					new File(resourcePath+"/"+System.currentTimeMillis()+"_file.png"));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}



		
//		String resourcePath = 
//				session.getServletContext().getRealPath("/resources");
//		System.out.println(resourcePath);
//		int maxSize = 10 * 1024 * 1024;
//
//		try {
//			MultipartRequest multi = 
//					new MultipartRequest(request, 
//							resourcePath, 
//							maxSize, 
//							"utf-8", 
//							new DefaultFileRenamePolicy());
//			String name = multi.getParameter("name");
//			File oriFile = multi.getFile("image");
//			FileUtils.moveFile(oriFile, 
//					new File(resourcePath+"/"+System.currentTimeMillis()+"_id_profile.png"));
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
		return "home";
	}
}












