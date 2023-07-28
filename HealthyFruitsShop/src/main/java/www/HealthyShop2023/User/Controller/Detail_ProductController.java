package www.HealthyShop2023.User.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import www.HealthyShop2023.Service.ShoppingCartServiceImpl;

@Controller
public class Detail_ProductController {
	@Autowired
	ShoppingCartServiceImpl	cart;
@RequestMapping("/detailProduct.php")
public String detailProduct(Model model) {
	return "user/detail_Product";
}
@ModelAttribute("current_size")
public Integer shoppingcart() {
	if(cart.getCount() == 0) {
		return 0;
	}
	return cart.getCount();
}
}
