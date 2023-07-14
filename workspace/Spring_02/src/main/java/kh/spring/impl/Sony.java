package kh.spring.impl;

import org.springframework.stereotype.Component;

import kh.spring.interfaces.Speaker;

@Component("sony")
public class Sony implements Speaker {

  @Override
  public void volumeUp() {
    System.out.println("¼Ò´Ï : º¼·ý ¾÷");
  }

}
