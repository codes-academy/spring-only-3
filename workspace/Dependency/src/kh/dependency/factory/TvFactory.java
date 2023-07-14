package kh.dependency.factory;

import kh.dependency.interfaces.Tv;
import kh.dependency.items.LgTV;
import kh.dependency.items.SamsungTV;

public class TvFactory {
  public static Tv getInstance(String brand) {
    if (brand.equals("lg")) {
      return new LgTV();
    } else if (brand.equals("samsung")) {
      return new SamsungTV();
    }
    return null;
  }
}
