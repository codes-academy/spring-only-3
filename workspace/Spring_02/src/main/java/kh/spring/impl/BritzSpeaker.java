package kh.spring.impl;

import org.springframework.stereotype.Component;

import kh.spring.interfaces.Speaker;

@Component("bri")
public class BritzSpeaker implements Speaker {

  @Override
  public void volumeUp() {
    System.out.println("ºê¸®Ã÷ : º¼·ý¾÷");
  }

}
