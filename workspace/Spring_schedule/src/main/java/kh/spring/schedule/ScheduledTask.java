package kh.spring.schedule;

import java.text.SimpleDateFormat;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {
	//특정 시간에 실행되는 메서드
	//특정 상황에 콜 해서 쓰는 게 아니라, 특정 시간에 실행되어야 하기 때문에 리턴값은 무조건 void, 인자값은 받을 수 없음
	
	@Scheduled(fixedDelay=5000)
	public void task1() {
		System.out.println("fixedDelay=5000 / 출력 확인"); //서버를 켜자마자 5초 마다 출력됨
	}
	
	//시간을 표현하는 크론 표현식 //초-분-시-일-월-요일-연도 //연도는 생략이 가능
	//@Scheduled(cron="* * * * * *") //모든 초-분...-요일에 실행하라(1초마다 실행)
	//@Scheduled(cron="30 * * * * *") //30초가 될 때마다
	//@Scheduled(cron="30 5 * * * *") //5분 30초마다x -> 모든 시간에 5분 30초가 될 때마다(2시 5분 30초, 3시 5분 30초)
	//@Scheduled(cron="30 5 3 * * *") //매일 새벽 3시 5분 30초마다
	@Scheduled(cron="50 40 * * * *")
	public void task2() {
		System.out.println("cron=50 40 * * * * / 출력확인");
	}
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
	
	@Scheduled(cron="0 0 0 * * *") //매일 0시
	public void task3() {
		System.out.println("출력확인");
	}

	@Scheduled(cron="30 * * * * *") //매일 0시
	public void task4() {
		System.out.println(sdf.format(System.currentTimeMillis()) + " : cron=30 * * * * * / 출력확인");
	}
	
	//9시 50분 30초 부터 매 7초마다
	@Scheduled(cron="30/7 50 9 * * *")
	public void task5() {
		System.out.println(sdf.format(System.currentTimeMillis()) + " : cron=30/7 50 9 * * * / 출력확인");
	}

	//9시와 10시의 50분 30초 부터 매 7초마다
//	@Scheduled(cron="30/7 50 9,10 * * *")
//	public void task6() {
//		System.out.println(sdf.format(System.currentTimeMillis()) + " : cron=30/7 50 9 * * * / 출력확인");
//	}
	
}
