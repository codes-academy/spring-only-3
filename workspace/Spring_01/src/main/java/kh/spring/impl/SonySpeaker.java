package kh.spring.impl;

import kh.spring.interfaces.Speaker;

public class SonySpeaker implements Speaker {
  public void volumeUp() {
    System.out.println("소니 스피커 : 볼륨업");
  }
}
