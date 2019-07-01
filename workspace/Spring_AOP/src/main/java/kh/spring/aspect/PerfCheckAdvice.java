package kh.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerfCheckAdvice {
	//"executtion(* kh.spring.practice.MemberController.*(..))" <- �̰� ����Ʈ��
	@Around("execution(* kh.spring.practice.MemberController.*(..))")
	public Object perfCheck(ProceedingJoinPoint pjp) {
		long startTime = System.currentTimeMillis();
		
		Object retVal = null;
		try {
			retVal = pjp.proceed(); //view, model���ϰ��� -> ���� �𸣱� ������ ���ϰ��� ������Ʈ�� ����
			//pointcut �޼��尡 ����Ǵ� ����(���� ������ �� ����) //�̰� �������� ���� before, �Ʒ��� after
			//���� �� ���� ������ throwable�� ��
		} catch (Throwable e) {
			e.printStackTrace();
		} 
		
		long endTime = System.currentTimeMillis();
		System.out.println((endTime - startTime) / 1000.0 + "�ʰ� ����");
		
		return retVal; //pointCut �� �տ��� �� ��, �ڿ��� �� �� ����ë�� ������
	}
	//�ڽ��� ����� pointcut �޼��忡 ������ �� �� ����(������ ���� �ʰų�, �ٸ��� ��ȭ�� �ְų�) <-> before�� ���� �� ��
	
	// [���]
//	0.019�ʰ� ����
//	0.0�ʰ� ����
//	0.0�ʰ� ����
}
