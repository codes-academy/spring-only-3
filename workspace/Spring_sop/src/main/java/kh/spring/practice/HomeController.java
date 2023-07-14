package kh.spring.practice;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@CrossOrigin("http:kh/")
@CrossOrigin("*") //마음대로 가져다 써도 됨
@Controller
public class HomeController {


  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String home(Locale locale, Model model) {
    return "home";
  }

}
