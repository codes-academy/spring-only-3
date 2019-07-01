//package kh.spring.aspect;
//
//import java.text.SimpleDateFormat;
//import java.util.Arrays;
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.Signature;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.stereotype.Component;
//
//@Component
//@Aspect //���������μ�, aop�� ������ �ִٴ� ��
//public class LogAdvises {
//	
//	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
//	
//	// return package .. Controller .. Method(�Ű�����)
////	@Before("execution(* *())")
////	@Before("execution(* *(..))") //..=�������� �ְ� �������� �ְ�
////	@Before("execution(* kh.spring.practice.MemberController.log*())") //�޼��� ���� ��, ���� ����, ���� �� �� ��� �������� ���� ����("execution(���ϰ� ǥ����)") // *=��� ��(String ������ �ᵵ ��)
//	//execution(* kh.spring.practice.MemberController.*()) = ���� �ϰ���� �� log ���� ��(log=log�� �����ϴ� �޼���)
////	@Before("execution(* kh.spring.practice.MemberController.log*(String, ..))") //ù��° �Ű������� String, �������� �ְų� ���ų�
////	@Before("execution(* kh.spring.practice.MemberController.*()) || execution(* kh.spring.practice.MemberController.*())")
////	public void pringLog(JoinPoint jp) {
////		System.out.println(jp.getArgs()[0]); //null point exception
////		for(Object o : jp.getArgs()) {
////			System.out.println(o);
////		}
////		System.out.println(sdf.format(System.currentTimeMillis()) + " �� ����");
////	} //��� ��Ʈ�ѷ��� Ư�� ��� ������� ����� �����̽� -> aop ǥ�������� ����
//	
//	
//	//�����̽� �޼���� �������� ���� ȣ��Ǵ� ��
//	//���� ���ϴ� ���ڰ��� �ѱ� ���� ������, �����̽� �޼��� ��ü�� ������ ������ �Ű������� ����
//	//JoinPoint = pointcut before���� ����ɶ� ���� �� �ִ� ������ ��Ƽ� JoinPoint�� �־���
//	
//	
//	@Pointcut("execution(* kh.spring.practice.MemberController.*(..))") 
//	public void memberCut() {
//	}
//	@Pointcut("execution(* kh.spring.practice.MemberController.*())") 
//	public void member2Cut() {
//	}
//	@Before("memberCut() || member2Cut()") //before�� ���ϰ��� �ǹ̰� ���� 
//	public void member(JoinPoint jp) {
//		for(Object o : jp.getArgs()) {
//			System.out.println(o); //MemberController �� ���ڰ��� �־�� ��(�Ű�����)
//		} //�޼��� ���ڰ� //before�� ����Ǹ� ���ڰ��� ������
//		
//		System.out.println("���޵� ���ڰ� : " + Arrays.toString(jp.getArgs()));
//		Signature sign = jp.getSignature(); //�޼��� ���ڰ�
//		
//		StringBuilder sb = new StringBuilder();
//		sb.append(sdf.format(System.currentTimeMillis()) + "�� ");
//		sb.append(sign.getName() + "�޼��� �����");
//		
//		System.out.println(sb.toString()); //Ŭ���� ����
//		
//		System.out.println(jp.getTarget()); //Ÿ��Ŭ����
//		System.out.println(sign.toShortString()); //��� �޼��� �̸� ��������(�޼��� Ǯ ���)
//		
//		//�α��� ������ �˻�
//		//������ before�δ� �޼��带 ������ �� ����
//	}
////	(��� :) 
////	test
////	���޵� ���ڰ� : [test]
////	2019/06/24 12:24:26��login�޼��� �����
////	���޵� ���ڰ� : []
////	2019/06/24 12:24:33��mypage�޼��� �����
////	���޵� ���ڰ� : []
////	2019/06/24 12:24:35��logout�޼��� �����
//
//	//----------------------------------------------------------------------------
//	
//	//around �� before + after
//	
//	
//	//----------------------------------------------------------------------------
//	
////	@Pointcut("execution(* kh.spring.practice.*.log*())") 
////	public void memberCut() {
////		System.out.println(sdf.format(System.currentTimeMillis() + " �� ����"));
////	}
////	@Pointcut("execution(* kh.spring.practice.*.log*())") 
////	public void member2Cut() {
////		System.out.println(sdf.format(System.currentTimeMillis() + " �� ����"));
////	}
////	@Before("memberCut() && member2Cut()") 
////	public void memberCut() {
////		System.out.println(sdf.format(System.currentTimeMillis() + " �� ����"));
////	}
////	@Before("!memberCut()") //memberCut()�� �ƴ� �� 
////	public void memberCut() {
////		System.out.println(sdf.format(System.currentTimeMillis() + " �� ����"));
////	}
//	
//}
