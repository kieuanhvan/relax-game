package www.HealthyShop2023.User.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import www.HealthyShop2023.Model.Account;
import www.HealthyShop2023.Service.ShoppingCartServiceImpl;
@Controller
public class RegisterController {
	@Autowired
	ShoppingCartServiceImpl	cart;
	@GetMapping("/register.php")
	public String register_display(Model model) {
		 model.addAttribute("register", new Account());
		return "user/register";
	}
	@PostMapping("/register.php")
	public String register(Model model,@ModelAttribute("register") @Validated Account acc,Errors errors) {
		if (errors.hasErrors()) {
			model.addAttribute("mess", "Vui long sua cac looi sau");
		}else {
			model.addAttribute("mess", "chuc mung bn da nhap dungs");
		}
		
		return "user/register";
	}
	@ModelAttribute("current_size")
	public Integer shoppingcart() {
		if(cart.getCount() == 0) {
			return 0;
		}
		return cart.getCount();
	}
}
