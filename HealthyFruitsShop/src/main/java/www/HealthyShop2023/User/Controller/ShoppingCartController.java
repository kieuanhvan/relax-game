package www.HealthyShop2023.User.Controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import www.HealthyShop2023.DAO.CartSessionDAO;
import www.HealthyShop2023.DTO.ProductDTO;
import www.HealthyShop2023.Model.Account;
import www.HealthyShop2023.Model.CartSession;
import www.HealthyShop2023.Service.ShoppingCartServiceImpl;
import www.HealthyShop2023.Service.sessionServices;
import www.HealthyShop2023.Utils.ManagerUser;




@Controller
public class ShoppingCartController {
	@Autowired
	 ShoppingCartServiceImpl	cart;
	@Autowired
	 sessionServices sessionservice;
	
	@Autowired
	CartSessionDAO cartSSDao;
	@RequestMapping("/cart/view")
	public String view(Model model) {
		
		
		return "user/viewcart";
	}

	@RequestMapping("/cart/add/{id}")
	public String add(@PathVariable("id") Long id) {
		Account acc = ManagerUser.checklogin(sessionservice);
		if (acc != null) {
			cart.add(id, acc.getId());
			
		}
		
		return "redirect:/products.php"; // hiển thị giỏ hàng
	}
	
	@ModelAttribute("myCarts")
	public Collection<ProductDTO> getItems(){
		return cart.getItems();
	}

	@RequestMapping("/cart/remove/{id}")
	public String remove(@PathVariable("id") Long id) {
		cart.remove(id);
		return "redirect:/cart/view";
	}

	@GetMapping("/cart/update/{id}/{qty}")
	public String update(@PathVariable("id") Long id, @PathVariable("qty") Integer qty) {

		Account acc = ManagerUser.checklogin(sessionservice);
		if (acc != null) {
			cart.update(id,qty);
		}
		
		
		return "redirect:/cart/view";
	}

	@RequestMapping("/cart/clear")
	public String clear() {
		cart.clear();
		return "redirect:/cart/view";
	}
	@ModelAttribute("current_size")
	public Integer shoppingcart() {
		if(cart.getCount() == 0) {
			return 0;
		}
		return cart.getCount();
	}

}
