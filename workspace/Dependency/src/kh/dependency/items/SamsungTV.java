package kh.dependency.items;

import kh.dependency.interfaces.Tv;

public class SamsungTV implements Tv{
	private String model;
	private int price;
	private boolean power;
	
	public void powerOn() {
		this.power = true;
	}
	public void powerOff() {
		this.power = false;
	}
	
	public SamsungTV(String model, int price, boolean power) {
		super();
		this.model = model;
		this.price = price;
		this.power = power;
	}
	public SamsungTV() {
		super();
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
}
