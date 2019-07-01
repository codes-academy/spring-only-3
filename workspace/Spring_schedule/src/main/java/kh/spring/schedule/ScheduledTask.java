package kh.spring.schedule;

import java.text.SimpleDateFormat;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {
	//Ư�� �ð��� ����Ǵ� �޼���
	//Ư�� ��Ȳ�� �� �ؼ� ���� �� �ƴ϶�, Ư�� �ð��� ����Ǿ�� �ϱ� ������ ���ϰ��� ������ void, ���ڰ��� ���� �� ����
	
	@Scheduled(fixedDelay=5000)
	public void task1() {
		System.out.println("fixedDelay=5000 / ��� Ȯ��"); //������ ���ڸ��� 5�� ���� ��µ�
	}
	
	//�ð��� ǥ���ϴ� ũ�� ǥ���� //��-��-��-��-��-����-���� //������ ������ ����
	//@Scheduled(cron="* * * * * *") //��� ��-��...-���Ͽ� �����϶�(1�ʸ��� ����)
	//@Scheduled(cron="30 * * * * *") //30�ʰ� �� ������
	//@Scheduled(cron="30 5 * * * *") //5�� 30�ʸ���x -> ��� �ð��� 5�� 30�ʰ� �� ������(2�� 5�� 30��, 3�� 5�� 30��)
	//@Scheduled(cron="30 5 3 * * *") //���� ���� 3�� 5�� 30�ʸ���
	@Scheduled(cron="50 40 * * * *")
	public void task2() {
		System.out.println("cron=50 40 * * * * / ���Ȯ��");
	}
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
	
	@Scheduled(cron="0 0 0 * * *") //���� 0��
	public void task3() {
		System.out.println("���Ȯ��");
	}

	@Scheduled(cron="30 * * * * *") //���� 0��
	public void task4() {
		System.out.println(sdf.format(System.currentTimeMillis()) + " : cron=30 * * * * * / ���Ȯ��");
	}
	
	//9�� 50�� 30�� ���� �� 7�ʸ���
	@Scheduled(cron="30/7 50 9 * * *")
	public void task5() {
		System.out.println(sdf.format(System.currentTimeMillis()) + " : cron=30/7 50 9 * * * / ���Ȯ��");
	}

	//9�ÿ� 10���� 50�� 30�� ���� �� 7�ʸ���
//	@Scheduled(cron="30/7 50 9,10 * * *")
//	public void task6() {
//		System.out.println(sdf.format(System.currentTimeMillis()) + " : cron=30/7 50 9 * * * / ���Ȯ��");
//	}
	
}
