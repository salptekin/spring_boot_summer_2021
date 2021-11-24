package rest_api01;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
public class StudentBean01Controller {
	
//	@RequestMapping(method=RequestMethod.GET, path="/getRequest")
//	@ResponseBody //To be able to see the message on the console
//	public String getMethod() {
//		return "Get Request method is executed...";
//	}
	@GetMapping(path="/getRequest")
	public String getMethod1() {
		return "Get Request method is executed...";
	}
	@GetMapping(path="/getObject")
	public StudentBean01 getMethod2() {
		return new StudentBean01("Ali Can", 13, "AC202113");
	}	
	@GetMapping(path="/getParameterized/{school}")
	public StudentBean01 getMethod3(@PathVariable String school) {
		return new StudentBean01("Ali Can", 13, String.format("AC%s202113", school));
	}
	
	@GetMapping(path="/getList")
	public List<StudentBean01> getMethod4() {
		return List.of(
						new StudentBean01("AB", 12, "AB12"),
						new StudentBean01("CD", 13, "CD13"),
						new StudentBean01("EF", 14, "EF14")
				    );
	}	
	@GetMapping//If you do not put any path it works as well
	public String getMethod5() {
		return "Get Request for home page...";
	}

	
	@Autowired//Means you assigned the object(bean) to the std object
	@Qualifier(value="studentBean01")//If you have multiple object in a data type inside the container
	                                 //use @Qualifier(value=<Class name with lowercase initial>) annotation to select a specific object
	StudentInterface std;
	
	@GetMapping(path="/getMessage")
	public String getMethod6() {		
		return std.study();
	}

}
