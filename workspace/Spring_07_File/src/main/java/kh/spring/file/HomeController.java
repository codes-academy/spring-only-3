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
		String resourcesPath = session.getServletContext().getRealPath("/resources"); //resources�ȿ� �־�� �ϴϱ�
		System.out.println(resourcesPath); //���� ���� ��Ʈ
		//package explorer�� ���̴� resources�� �����Ǹ� = D:\SpringOnly\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\Spring_07_File\resources�� ��
		//package explorer���� ����Ǵ� �� �ƴ϶�, resourcesPath�� ����Ǿ� �����
		//������� ���ε� ��� ����
		
		int maxSize = 10 * 1024 * 1024; 
		//������ ����
		
		try {
			//��Ƽ��Ʈ ������Ʈ�� ���׷��̵�(inputstream�� datastream���� ���׷��̵� �ϴ� ��ó��)
			MultipartRequest multi = new MultipartRequest(request, resourcesPath, maxSize, "utf-8", new DefaultFileRenamePolicy()); //����, ���, �ִ�ũ��, ���ڵ����, �ߺ����� ó�� �޼���
			//new DefaultFileRenamePolicy() �� �Ȱ��� �̸��� ������ ��û�Ǹ� _1,2�� ���� _�ڿ� ���ڸ� �ٿ���
			//�̰� ���� ���� ������ ��� ���ε��
			//public String uploadProc(HttpServletRequest request)������ �� ������, ��Ƽ��Ʈ�� ���׷��̵� �� �������� ���� �� ����
			String name = multi.getParameter("name"); //name��Ʈ����Ʈ�� ���� ������ ������
			//Ŀ�ս� ���� ���ε�� �ٸ� �� : ������ ��� ���� �� ���� <-> ��Ƽ���� ������Ʈ : ������ ��� ���� �� ����
			
			//���� ���, ������ ������ ����ٰ� �� �� : ������_�����̸� �̷��� db�� ���ܳ��� �ҷ����⸸ �ϸ� ��(���� �� ������)
			//����ڰ� �ø� �������� �����̸��� ���� ������ �ٲٰų� �״�� ����� ������ �������� ������
			//�ٿ�ε� �ؾ� �� ���� ���� �̸��� �ٲ��� ������ �� �ܿ��� �������� ������ �ٲ㼭 ������ �� ����
			
			//1. �������̶�� ����(�������� �̸��� ������ �ʴ´ٰ� ����)
			File oriFile = multi.getFile("image"); //���⼭ image�� home.jsp������ name="image" //�츮�� �ǵ��� ������� ��Ƽ��Ʈ�� �����ڸ��� ������� ����
//			String fileName = session.getAttribute("id") + "_profile.png"; //�̷������� ����� ��ĥ ���� ����(�������� ������ �������� �ʴ� ��)
//			String fileName = "id_profile.png";
			
//			System.out.println(name);
//			System.out.println("�̸����� : " + oriFile.renameTo(new File("id_profile.png")));
			System.out.println(oriFile.getAbsolutePath()); //�ø� ������ ���
			
//			test2
//			�̸����� : true
//			D:\SpringOnly\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\Spring_07_File\resources\2.PNG
			
			DataInputStream dis = new DataInputStream(new FileInputStream(oriFile));
			byte[] fileContents = new byte[(int)oriFile.length()]; //������ �迭
			dis.readFully(fileContents); //���� ����� �°� ������ �о����
			
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
				byte[] fileContents = new byte[(int)oriFile.length()]; //������ �迭
				dis.readFully(fileContents); //���� ����� �°� ������ �о����
				
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
	//A file handle is inherited by a subprocess of your process //������ ���� �ִ� ���
	//An anti-virus program is scanning.. //����� ������ �˻��ϰ� �ִ� ���
	//An indexer (such as Google Desktop or the ...) //���ۿ��� ������ ���� �ִ� ���
	//=�ݺ��� ������ �ذ� �Ǳ� ������ ���ѹݺ��� ����õ
	
	
	//commons-io ���̺귯���� �߰��ϸ� �ڵ� ���̸� �� ���� �� ����
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
	public String uploadProc4(String name, MultipartFile image) { //�����̳ʿ� MultipartFile ���� �����
		String resourcePath = session.getServletContext().getRealPath("resources");
		System.out.println(resourcePath);
		//...���� �ڵ� ����...
		return "home";
	}
	
	//--------------------------------------------------
	//cor.jar -> ���̺쿡 �߰�
	@RequestMapping("upload5.do")
	public String uploadProc5(HttpServletRequest request) { 
//		String uploadPath = session.getServletContext().getRealPath("/"); // "/"�ϳ��� ������ �����н� Ȩ
		String uploadPath = session.getServletContext().getRealPath("/resources"); //dynamic web ������ request, ������������ session�� �����н��� ����
		//�̹����� ���ε��� ���� �з��� �߿��ϹǷ� Ȩ���� ������ �ϳ� �� ������ ��
		
		int maxSize = 10 * 1024 * 1024;
		System.out.println(uploadPath);
		
		try {
			//�ٸ� ���
//			MultipartRequest multi = new MultipartRequest(request, uploadPath, maxSize, "utf8", new FileRenamePolicy() {
//				@Override
//				public File rename(File arg0) {
//					return null;
//				}
//			});
			
			MultipartRequest multi = new MultipartRequest(request, uploadPath, maxSize, "utf8", new DefaultFileRenamePolicy()); //Ŭ���̾�Ʈ�� ������ ��Ƽ��Ʈ�� �����͸� �ʿ��� ��� ������ ������ �з�, �������ϱ� ����
			//������ ���������� ���ε� �� (�ӽ����� �ƴ�)
			//context.xml�� multipartResolver�� ������ �������� ���� ��
			//������� �����ϸ� ������ ���� �̸����� �����н� ������ ���Ե� ���� Ȯ���� �� ����
			
			//�����̸��� �״�� �� ���̳�, ���ϴ� ��� �ٲ� ���̳�?
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
				
				//�߶󳻱� = move : �̸��� �ٲٸ� �̵��� �� �ִ�
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "home";
	}
	// <img src="d:/...=��ũ ��θ� ���� ����, Ŭ���̾�Ʈ ��ΰ� �ٸ��� ������ �ȵ�" />
	// ��Ʈ��ũ ��ΰ� ���� ��(������ �׸��� �÷� ������ �ִ� �װ�-������ ������ �� = realPath:�ܺο��� �� ���� http://���� ������/)">
	
	//��Ŭ������ ����Ǵ� ���� �̹����� �����, 
	//Ŭ���̾�Ʈ�� �ø� �̹����� ��Ŭ������ resources �ȿ� ���� ���� �ִµ� ����� �� ��
	

	//name, image�� ������ε����� �ޱ�
	@RequestMapping("upload6.do")
//	public String uploadProc6(String name, file) { //cos.jar�� ������ε��� �������� ������ commons-io�� ��
			//file�� �ڷ����� ���� �� ���
//	public String uploadProc6(String name, MultipartFile image) { //commons-io�� ����ϸ� multipartFile�� ���� �� ����
	public String uploadProc6(DTO dto) {
//		System.out.println(name); //null
//		System.out.println(image); //null
		//null���� ������ ���� : bean�� ������ �ʾұ� ���� = context.xml�� multipartResolver �� �����
		
		//multipartResolver�߰��ϸ� ��Ÿ���� ����
		//java.lang.ClassNotFoundException
		
		//pom.xml�� ���̺귯�� �߰�
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
		
		//�ٽ� �����ϸ� ���� ��µ�
//		tt
//		org.springframework.web.multipart.commons.CommonsMultipartFile@69b3f3f7
		
		//DTO���� name, image setter �����
		System.out.println(dto.getName()); //rr
		System.out.println(dto.getImage()); //org.springframework.web.multipart.commons.CommonsMultipartFile@31eef9eb
		
		String uploadPath = session.getServletContext().getRealPath("resources");
		System.out.println(uploadPath);
		try {
//			dto.getImage().transferTo(new File(uploadPath + "/profile_image.png")); //�̸��� �Ȱ��� ������ ���ε��ϸ� �������̵� �Ǿ����
			dto.getImage().transferTo(new File(uploadPath + "/" + System.currentTimeMillis() + "_profile_image.png"));
			//�����̸��� ��ģ�ٸ� ��� ���� ������ ����
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "home";
	}
	
	
	
}
