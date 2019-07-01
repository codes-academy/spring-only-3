package kh.spring.file;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Controller
public class HomeController {
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping("/")
	public String home(Locale locale, Model model) {
		
		return "home";
	}
	
	@RequestMapping("upload.do")
	public String uploadProc(HttpServletRequest request) {
		String resourcesPath = session.getServletContext().getRealPath("/resources"); //resources안에 넣어야 하니까
		System.out.println(resourcesPath); //실제 서버 루트
		//package explorer에 보이는 resources가 배포되면 = D:\SpringOnly\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\Spring_07_File\resources가 됨
		//package explorer에서 실행되는 게 아니라, resourcesPath에 복사되어 실행됨
		//여기까지 업로드 경로 잡음
		
		int maxSize = 10 * 1024 * 1024; 
		//사이즈 제한
		
		try {
			//멀티파트 리퀘스트로 업그레이드(inputstream을 datastream으로 업그레이드 하는 것처럼)
			MultipartRequest multi = new MultipartRequest(request, resourcesPath, maxSize, "utf-8", new DefaultFileRenamePolicy()); //파일, 경로, 최대크기, 인코딩방식, 중복파일 처리 메서드
			//new DefaultFileRenamePolicy() 는 똑같은 이름의 파일이 요청되면 _1,2와 같이 _뒤에 숫자를 붙여줌
			//이걸 만든 순간 파일은 즉시 업로드됨
			//public String uploadProc(HttpServletRequest request)에서는 못 꺼내고, 멀티파트로 업그레이드 된 곳에서만 꺼낼 수 있음
			String name = multi.getParameter("name"); //name어트리뷰트를 가진 파일을 꺼내라
			//커먼스 파일 업로드와 다른 점 : 파일을 집어서 꺼낼 수 없음 <-> 멀티파일 리퀘스트 : 파일을 집어서 꺼낼 수 있음
			
			//예를 들어, 프로필 사진을 만든다고 할 때 : 계정명_사진이름 이렇게 db에 남겨놓고 불러오기만 하면 됨(변경 시 덮어씌우고)
			//사용자가 올린 오리지날 파일이름을 서버 측에서 바꾸거나 그대로 남기는 식으로 서버에서 관리함
			//다운로드 해야 할 경우는 파일 이름을 바꾸지 않으나 그 외에는 서버에서 파일을 바꿔서 관리할 수 있음
			
			//1. 프로필이라고 가정(오리지날 이름을 남지기 않는다고 가정)
			File oriFile = multi.getFile("image"); //여기서 image는 home.jsp파일의 name="image" //우리의 의도와 상관없이 멀티파트를 만들자마자 만들어진 파일
//			String fileName = session.getAttribute("id") + "_profile.png"; //이런식으로 만들면 겹칠 일이 없음(스스로의 사진을 수정하지 않는 한)
//			String fileName = "id_profile.png";
			
//			System.out.println(name);
//			System.out.println("이름변경 : " + oriFile.renameTo(new File("id_profile.png")));
			System.out.println(oriFile.getAbsolutePath()); //올린 파일의 경로
			
//			test2
//			이름변경 : true
//			D:\SpringOnly\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\Spring_07_File\resources\2.PNG
			
			DataInputStream dis = new DataInputStream(new FileInputStream(oriFile));
			byte[] fileContents = new byte[(int)oriFile.length()]; //파일의 배열
			dis.readFully(fileContents); //파일 사이즈에 맞게 모조리 읽어들임
			
			DataOutputStream dos = new DataOutputStream(new FileOutputStream(new File(resourcesPath+"id_profile.png")));
			dos.write(fileContents);
			dos.flush();
			dos.close();
			
		}catch(Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "home";
	}
	
	@RequestMapping("upload2.do")
	public String uploadProc2(HttpServletRequest request) {
		String resourcesPath = session.getServletContext().getRealPath("/resources");
		System.out.println(resourcesPath); 
		
		int maxSize = 10 * 1024 * 1024; 
		
		try {
			MultipartRequest multi = new MultipartRequest(request, resourcesPath, maxSize, "utf-8", new DefaultFileRenamePolicy()); 
			String name = multi.getParameter("name"); 
			File oriFile = multi.getFile("image");
			
			System.out.println(name);
			System.out.println(oriFile);
			System.out.println(oriFile.getAbsolutePath()); 

			if(!oriFile.renameTo(new File(resourcesPath + "test.png"))) {
				DataInputStream dis = new DataInputStream(new FileInputStream(oriFile));
				byte[] fileContents = new byte[(int)oriFile.length()]; //파일의 배열
				dis.readFully(fileContents); //파일 사이즈에 맞게 모조리 읽어들임
				
				DataOutputStream dos = new DataOutputStream(new FileOutputStream(new File(resourcesPath+"/id_profile.png")));
				dos.write(fileContents);
				dos.flush();
				dos.close();
//				oriFile.delete();
//				oriFile.deleteOnExit();
				dis.close();
				dos.close();
				boolean delResult = oriFile.delete();
				System.out.println(delResult);
			}
		}catch(Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "home";
	}
	//A file handle is inherited by a subprocess of your process //파일을 쓰고 있는 경우
	//An anti-virus program is scanning.. //백신이 파일을 검사하고 있는 경우
	//An indexer (such as Google Desktop or the ...) //구글에서 파일을 열고 있는 경우
	//=반복문 돌리면 해결 되긴 하지만 무한반복은 비추천
	
	
	//commons-io 라이브러리를 추가하면 코드 길이를 더 줄일 수 있음
	@RequestMapping("upload3.do")
	public String uploadProc3(HttpServletRequest request) {
		String resourcesPath = session.getServletContext().getRealPath("/resources");
		System.out.println(resourcesPath); 
		
		int maxSize = 10 * 1024 * 1024; 
		
		try {
			MultipartRequest multi = new MultipartRequest(request, resourcesPath, maxSize, "utf-8", new DefaultFileRenamePolicy()); 
			String name = multi.getParameter("name"); 
			File oriFile = multi.getFile("image");
			
			System.out.println(name);
			System.out.println(oriFile);
			System.out.println(oriFile.getAbsolutePath()); 

			String profile = System.currentTimeMillis() + "_id_profile.png";
			File f = new File(resourcesPath + "/"  + profile);
//			FileUtils.moveFile(oriFile, new File(resourcesPath + "/" + System.currentTimeMillis() + "_id_profile.png"));
			FileUtils.moveFile(oriFile, f);
			
//			session.setAttribute("img", f);
//			System.out.println(f);
			
			session.setAttribute("img", "\\resources\\" + profile);
			System.out.println("\\resources\\" + profile);
			
		}catch(Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "image";
	}
	
	
	//
	@RequestMapping("upload4.do")
	public String uploadProc4(String name, MultipartFile image) { //컨테이너에 MultipartFile 빈을 만들기
		String resourcePath = session.getServletContext().getRealPath("resources");
		System.out.println(resourcePath);
		//...공유 코드 참조...
		return "home";
	}
	
	//--------------------------------------------------
	//cor.jar -> 메이븐에 추가
	@RequestMapping("upload5.do")
	public String uploadProc5(HttpServletRequest request) { 
//		String uploadPath = session.getServletContext().getRealPath("/"); // "/"하나만 넣으면 리얼패스 홈
		String uploadPath = session.getServletContext().getRealPath("/resources"); //dynamic web 에서는 request, 스프링에서는 session에 리얼패스를 담음
		//이미지를 업로드할 때는 분류가 중요하므로 홈에서 폴더를 하나 더 만들어야 함
		
		int maxSize = 10 * 1024 * 1024;
		System.out.println(uploadPath);
		
		try {
			//다른 방법
//			MultipartRequest multi = new MultipartRequest(request, uploadPath, maxSize, "utf8", new FileRenamePolicy() {
//				@Override
//				public File rename(File arg0) {
//					return null;
//				}
//			});
			
			MultipartRequest multi = new MultipartRequest(request, uploadPath, maxSize, "utf8", new DefaultFileRenamePolicy()); //클라이언트가 보내는 멀티파트형 데이터를 필요한 대로 꺼내서 쓰려고 분류, 컨버팅하기 위함
			//파일이 정상적으로 업로드 됨 (임시파일 아님)
			//context.xml내 multipartResolver가 있으면 에러나니 지울 것
			//여기까지 실행하면 파일이 원본 이름으로 리얼패스 폴더에 삽입된 것을 확인할 수 있음
			
			//파일이름을 그대로 둘 것이냐, 원하는 대로 바꿀 것이냐?
			File file = multi.getFile("image");
			if(!file.renameTo(new File(uploadPath + "/" + System.currentTimeMillis() + "_proFile.png"))) {
				DataInputStream dis = new DataInputStream(new FileInputStream(file));
				byte[] fileContents = new byte[(int)file.length()];
				dis.readFully(fileContents);
				
				DataOutputStream dos = new DataOutputStream(new FileOutputStream(uploadPath + "/" + System.currentTimeMillis() + "_proFile.png"));
				dos.write(fileContents);
				dos.flush();
				dos.close();
				dis.close();
				
				//잘라내기 = move : 이름을 바꾸며 이동할 수 있다
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "home";
	}
	// <img src="d:/...=디스크 경로를 쓰면 서버, 클라이언트 경로가 다르기 때문에 안됨" />
	// 네트워크 경로가 들어가야 함(어차피 그림을 올려 가지고 있는 그곳-서버가 잡혀야 함 = realPath:외부에서 볼 때는 http://서버 아이피/)">
	
	//이클립스가 실행되는 순간 이미지가 복사됨, 
	//클라이언트가 올린 이미지는 이클립스의 resources 안에 넣을 수는 있는데 복사는 안 됨
	

	//name, image를 오토바인딩으로 받기
	@RequestMapping("upload6.do")
//	public String uploadProc6(String name, file) { //cos.jar는 오토바인딩을 제공하지 않으나 commons-io는 됨
			//file의 자료형을 정할 수 없어서
//	public String uploadProc6(String name, MultipartFile image) { //commons-io를 사용하면 multipartFile로 받을 수 있음
	public String uploadProc6(DTO dto) {
//		System.out.println(name); //null
//		System.out.println(image); //null
		//null값이 나오는 이유 : bean을 만들지 않았기 때문 = context.xml에 multipartResolver 빈 만들기
		
		//multipartResolver추가하면 나타나는 에러
		//java.lang.ClassNotFoundException
		
		//pom.xml에 라이브러리 추가
//		<!-- 		apache -->
//		<dependency>
//		    <groupId>commons-fileupload</groupId>
//		    <artifactId>commons-fileupload</artifactId>
//		    <version>1.4</version>
//		</dependency>
//
//		<!-- commons-io -->
//			<!-- https://mvnrepository.com/artifact/commons-io/commons-io -->
//		<dependency>
//		    <groupId>commons-io</groupId>
//		    <artifactId>commons-io</artifactId>
//		    <version>2.6</version>
//		</dependency>
		
		//다시 실행하면 각각 출력됨
//		tt
//		org.springframework.web.multipart.commons.CommonsMultipartFile@69b3f3f7
		
		//DTO만들어서 name, image setter 만들기
		System.out.println(dto.getName()); //rr
		System.out.println(dto.getImage()); //org.springframework.web.multipart.commons.CommonsMultipartFile@31eef9eb
		
		String uploadPath = session.getServletContext().getRealPath("resources");
		System.out.println(uploadPath);
		try {
//			dto.getImage().transferTo(new File(uploadPath + "/profile_image.png")); //이름이 똑같은 파일을 업로드하면 오버라이드 되어버림
			dto.getImage().transferTo(new File(uploadPath + "/" + System.currentTimeMillis() + "_profile_image.png"));
			//파일이름이 겹친다면 어떻게 할지 조건을 제시
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "home";
	}
	
	
	
}
