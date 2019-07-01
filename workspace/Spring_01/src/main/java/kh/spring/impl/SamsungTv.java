package kh.spring.impl;

import kh.spring.interfaces.Speaker;
import kh.spring.interfaces.Tv;

public class SamsungTv implements Tv{
	private String model;
	private int price;
	private boolean power;
//	private SonySpeaker speaker = new SonySpeaker(); //�̷��� �ص� ������, ���յ��� ������
//	private SonySpeaker speaker; //�̷��� ������ ���� xml���� �ڵ� �߰�
//	private BritzSpeaker speaker; //britz�� �ٲٱ� - ������, setter�� ���� �� context.xml���� ���� �� �����
	private Speaker speaker; //�������̽��� ����� �������� ���̱�(������, setter�� ����)
	
	public SamsungTv() {
			super();
			System.out.println("�Ｚtv ������");
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
		System.out.println("�Ｚ tv ����" + this + " : " + this.hashCode());
	}
}
