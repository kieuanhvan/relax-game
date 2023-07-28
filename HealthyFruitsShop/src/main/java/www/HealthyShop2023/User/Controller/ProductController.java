package www.HealthyShop2023.User.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import www.HealthyShop2023.DAO.productDAO;
import www.HealthyShop2023.DTO.ProductDTO;
import www.HealthyShop2023.Model.Product;
import www.HealthyShop2023.Service.ShoppingCartServiceImpl;
import www.HealthyShop2023.Utils.import_fileExcel;
import www.HealthyShop2023.collections.SortByPrice;

@Controller
public class ProductController {
	@Autowired
	ShoppingCartServiceImpl	cart;
		@Autowired
		private productDAO productdao;
		@GetMapping("/products.php")
		public String products(Model model, @RequestParam(required = false)Boolean ascending, @RequestParam(required = false)Boolean decending) { 
			List<Product> list = productdao.findAll();
			if (ascending != null && ascending == true) {
				list.sort(new SortByPrice());
			}else if(decending != null && decending == true) {
				list.sort(new SortByPrice().reversed());
			}
			model.addAttribute("products", list);
			return "user/products";
		}
		@ResponseBody
		@GetMapping("/getproducts.php")
		public List<Product> getproducts( @RequestParam(required = false)Boolean ascending, @RequestParam(required = false)Boolean decending) { 
			List<Product> list = productdao.findAll();
			
			if (ascending != null && ascending == true) {
				list.sort(new SortByPrice());
			}else if(decending != null && decending == true) {
				list.sort(new SortByPrice().reversed());
			}
			
			return list;
		} 
	
		public List<Product> loadProducts()  {
			
			try {
				return import_fileExcel.importByExecl( new FileInputStream(new File("D:\\Java5\\data.xlsx")));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		@ModelAttribute("current_size")
		public Integer shoppingcart() {
			if(cart.getCount() == 0) {
				return 0;
			}
			return cart.getCount();
		}
		
		@ModelAttribute("myCarts")
		public Collection<ProductDTO> getItems(){
			return cart.getItems();
		}
}
