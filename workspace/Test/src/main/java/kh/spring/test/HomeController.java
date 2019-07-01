package kh.spring.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

@Controller
public class HomeController {

	@Autowired
	private MyUtil util;

	@RequestMapping("/")
	public String home() {
		
		return "home";
	}
	
	@ResponseBody
	@RequestMapping("asJson")
	public String inputProc(String data1, String data2) {
	JsonObject obj = new JsonObject();
	obj.addProperty("data1", data1);
	obj.addProperty("data2", data2);
	return new Gson().toJson(obj);
	}
	
}
