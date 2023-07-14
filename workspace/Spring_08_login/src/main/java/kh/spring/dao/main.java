package kh.spring.dao;

public class main {
  public static void main(String[] args) {

    String[] list = new String[3];
//	for(int i=0; i<4; i++) {
//		String prof = System.currentTimeMillis() + "_" + i;
//		list[i] = "resources/" + prof;
//		System.out.println("resources/" + prof);
//	}
    list[0] = System.currentTimeMillis() + "1";
    list[1] = System.currentTimeMillis() + "2";
    list[2] = System.currentTimeMillis() + "3";
    System.out.println(list[0]);
    System.out.println(list[1]);
    System.out.println(list[2]);
  }
}
