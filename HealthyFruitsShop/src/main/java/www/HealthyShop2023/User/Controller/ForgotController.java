package www.HealthyShop2023.User.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ForgotController {
	@RequestMapping("/forgot.php")
	public String home(Model model) {
		return "user/forgot";
	}
}
