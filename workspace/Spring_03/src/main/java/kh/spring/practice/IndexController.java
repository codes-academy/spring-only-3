package kh.spring.practice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class IndexController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// '/'�� ģ ����� ���ϴ� �� : ù �������� ������ �� (or �� ���̵�, ���������� �޾Ƽ� ȭ�鿡 �ѷ��ش�?)
		//���� ����� ��û�� ó���� ��� ��
		// dispatcher / sendredirect...
		//dao�۾��� �� �� ���� ������ �����ֱ⸸ �ϸ� ��
		
		//Ư������ ���ϰ��� ModelAndView �ڷ����̶�� ��
		//do get, post������ "���� ����"�� ���̳�, 
		//�������� ��û�� ������ ��Ʈ�ѷ��� ��� �޾Ƽ� �� ������� ������ ��, ds�� �߽����� �Դٰ��ٸ� �ݺ��ϰ� �����Ƿ� �ܹ��� �������̳� �����̷�Ʈ�� �� �� ����
		//��, ModelAndView�� ����ó�� ���� �� �ִ� ������� ������ ��� ��
		
		//����ó��
		ModelAndView mav = new ModelAndView();
				//���� �� ���̳� : �� ������
				//� ������ ������ �� ���̳� : 
		mav.setViewName("WEB-INF/index.jsp"); // ""�� ��η� �����ڴ�
		
//		return null;
		return mav;
		//������ ������, �����̷�Ʈ��� ���� ��� �˱�?
		//���� �� ����� ��������
		//�� �������� index.jsp�� ����� �����ϸ� 404�� ��
		
		//*�����̷�Ʈ : Ŭ���̾�Ʈ���� ������ ����, url�� Ÿ�� ������ ����̱� ������ �� ����
	}

}
