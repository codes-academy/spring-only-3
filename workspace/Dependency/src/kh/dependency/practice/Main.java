package kh.dependency.practice;

import kh.dependency.factory.TvFactory;
import kh.dependency.interfaces.Tv;
import kh.dependency.items.LgTV;

public class Main {
  public static void main(String[] args) {
//		SamsungTV tv = new SamsungTV();
//		tv.powerOn();
//		tv.getModel();
//		tv.getPrice();

    //tv�� �ٲ� ���, �� �ڵ带 �����ؾ� ��
//		LgTV tv = new LgTV(); 
//		tv.turnOn();
//		tv.getModel();
//		tv.getPrice(); //�������� ���� �ڵ�

    //1. �������̽� ���
    Tv tv = new LgTV();
    tv.powerOn();

    //2. ���丮���� ���
    Tv tv2 = TvFactory.getInstance("lg");
    tv.powerOn();

    //3. cmd
    Tv tv3 = TvFactory.getInstance(args[0]); //samsung
    //���� : cmd�� ���ľ� �Ѵ�, ���� ���� �迭�� �ٷ� �� ����, �������� ������ ��ƴ�


    //������ : ��������(xml����)�� ���� ������ �� �ν��Ͻ��� ���� ���� ����, �ҽ��ڵ� �ٱ��� ������� ������ �� ���� �������⸸ �ϸ� ��
  }
}
