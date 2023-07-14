package kh.spring.practice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import kh.spring.dao.MessageDAO;
import kh.spring.dto.MessageDTO;


public class inputProcController implements Controller {

  @Autowired
  private MessageDAO mdao;


  @Override
  public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

    String name = request.getParameter("name");
    String message = request.getParameter("message");


    System.out.println(name + " : " + message);

    ModelAndView mav = new ModelAndView();
//		mav.setViewName("WEB-INF/index.jsp"); //�̷��� �Ǹ� /�� ��������
    //http://localhost/inputProc.do �ּ�â�� �̷��� ��
    //f5 ������ "ã�� �ִ� ���������� ����ڰ� �Է��� ������ ����߽��ϴ�. �ش� �������� ���ư��� ���� �۾��� �ݺ��� �� �ֽ��ϴ�. ����Ͻðڽ��ϱ�?"�� �߸� ��ǲ ������ �ٽ� ��µ�


    try {
      int result = mdao.insert(new MessageDTO(0, name, message));
    } catch (Exception e) {
      e.printStackTrace();
      mav.setViewName("redirect:error.do");
      return mav;
    }


    //�Է��� ���� ������������ �������� �� - �����̷�Ʈ
    //������� ������Ʈ�� ������ �̵��ϱ� ������ ���ΰ�ħ�ϸ� ����ִ� ������Ʈ�� �ٽ� �ѹ� �� �۵���, url�� �� �ٲ�
    //�ּҰ� input.do��, input.do�� ���Ե� �޼��尡 �����Ƿ� ���ΰ�ħ �ϸ� �ٽ� �ѹ� �� �۵��Ǵ� ��
    //���� ��û�� �ٸ� �������� �̾����� ��� - ������
    //���� ��û�� �ٸ� �������� �̾����� �ʴ� ��� - �����̷�Ʈ
    mav.setViewName("redirect:/"); //redirect:(������� url)
    //�����̷�Ʈ �Ҷ��� ���εǾ� �ִ� ������ �� ��� ��
    //���� ������ ���� �ּ�â�� ���ؼ��� ������ �� �ֱ� ������ url������ �� ��� ��

    return mav;
  }
}
