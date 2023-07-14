package kh.spring.impl;

import kh.spring.interfaces.Tv;

public class LgTv implements Tv {
  private String model;
  private int price;
  private boolean power;

  public LgTv() {
    super();
  }

  public LgTv(String model, int price, boolean power) {
    super();
    this.model = model;
    this.price = price;
    this.power = power;
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

  @Override
  public void powerOn() {
  }
}
