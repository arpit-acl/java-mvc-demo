package mongo.crud.demo.components.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import mongo.crud.demo.components.user.User;
import mongo.crud.demo.utils.ResponseHelper;

@Controller
@RequestMapping(value = "/auth")
public class AuthController {

	@Autowired
	AuthServiceImpl authService;
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login_view() {
		authService.isUserExist("arpit.patel@acldigital.com");
//		System.out.println("view call");
//		ModelAndView model = new ModelAndView("login");
		return "login";
	}
	
	@RequestMapping(value = "/singup", method = RequestMethod.GET)	
	public String signup_view() {
		return "signup";
	}
	
	@PostMapping(value = "/register")
	public @ResponseBody ResponseEntity<Object> singup(@RequestBody AuthDto ob) {
		User isExist = authService.isUserExist(ob.email);
		if (isExist != null) {
			return new ResponseHelper(false, null, "USER_EXIST", "en" ).badRequest();
		} else {
			System.out.println(ob.password);
			User nUser = new User(ob.email, ob.name);
			nUser.setPassword(ob.password); 
			authService.register(nUser);
			return new ResponseHelper(true, nUser, "USER_REGISTERED", "en" ).ok();
		}
	}
	
	@PostMapping(value = "/login")
	public @ResponseBody ResponseHelper login(@RequestBody AuthDto ob) {
		return null;
			
	}
	
}
