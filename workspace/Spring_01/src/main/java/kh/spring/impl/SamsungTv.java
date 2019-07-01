package kh.spring.impl;

import kh.spring.interfaces.Speaker;
import kh.spring.interfaces.Tv;

public class SamsungTv implements Tv{
	private String model;
	private int price;
	private boolean power;
//	private SonySpeaker speaker = new SonySpeaker(); //이렇게 해도 되지만, 결합도가 높아짐
//	private SonySpeaker speaker; //이렇게 선언한 다음 xml에서 코드 추가
//	private BritzSpeaker speaker; //britz로 바꾸기 - 생성자, setter도 수정 후 context.xml에서 빈을 더 만들기
	private Speaker speaker; //인터페이스를 만들어 의존성을 줄이기(생성자, setter는 수정)
	
	public SamsungTv() {
			super();
			System.out.println("삼성tv 생성됨");
		}
	public SamsungTv(String model, int price, boolean power, Speaker speaker) {
			super();
			this.model = model;
			this.price = price;
			this.power = power;
			this.speaker = speaker;
		}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public boolean isPower() {
		return power;
	}
	public void setPower(boolean power) {
		this.power = power;
	}
	public Speaker getSpeaker() {
		return speaker;
	}
	public void setSpeaker(BritzSpeaker speaker) {
		this.speaker = speaker;
	}
	
	//	public SamsungTv(String model, int price, boolean power) {
//		super();
//		this.model = model;
//		this.price = price;
//		this.power = power;
//	}
//	public SamsungTv() {
//		super();
//	}
//	public String getModel() {
//		return model;
//	}
//	public void setModel(String model) {
//		this.model = model;
//	}
//	public int getPrice() {
//		return price;
//	}
//	public void setPrice(int price) {
//		this.price = price;
//	}
//	public boolean isPower() {
//		return power;
//	}
//	public void setPower(boolean power) {
//		this.power = power;
//	}
	
	@Override
	public void powerOn() {	
		System.out.println("삼성 tv 켜짐" + this + " : " + this.hashCode());
	}
}
