package kh.dependency.items;

import kh.dependency.interfaces.Tv;

public class LgTV implements Tv {
  private String model;
  private int price;
  private boolean power;

  //	public void turnOn() {
//		this.power = true;
//	}
  @Override
  public void powerOn() {

  }

  public void turnOff() {
    this.power = false;
  }

  public LgTV(String model, int price, boolean power) {
    super();
    this.model = model;
    this.price = price;
    this.power = power;
  }

  public LgTV() {
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
