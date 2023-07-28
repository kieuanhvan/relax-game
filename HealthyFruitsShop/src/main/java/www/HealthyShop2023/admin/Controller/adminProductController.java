package www.HealthyShop2023.admin.Controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import www.HealthyShop2023.DAO.categoriesDAO;
import www.HealthyShop2023.DAO.productDAO;
import www.HealthyShop2023.Model.Category;
import www.HealthyShop2023.Model.Product;

@Controller
public class adminProductController {
	@Autowired
	private productDAO productdao;
	@Autowired
	public categoriesDAO categorydao;
	
	
	@GetMapping("/admin/products-manager")
	@Cacheable("product")
	public String displayManagerProduct(Model model) {
		model.addAttribute("products", productdao.findAll());
		model.addAttribute("product",  new Product());
		return "admin/product-manager";
	}
	
	@GetMapping("/admin/product/edit/{x}")
	@Cacheable("findProduct")
	public String productEdit(Model model , @PathVariable("x") Long id) {
		model.addAttribute("product", productdao.findById(id));
		model.addAttribute("products", productdao.findAll());
		return "admin/product-manager";
	}
	
	@PostMapping("/admin/product/add")
	public String addNewElement(@ModelAttribute("product") Product product) {
		productdao.save(product);
		return "redirect:/admin/products-manager";
	}
	@Cacheable("categories")
	@ModelAttribute("categories")
	public List<Category> showCate(){
		return categorydao.findAll();
	}
	
	
	@GetMapping("/admin/product/delete/{x}")
	@Cacheable("findProduct")
	public String productDelete(Model model , @PathVariable("x") Long id) {
		Product product=new Product();
		product.setId(id);
		productdao.delete(product);
		return "redirect:/admin/products-manager";
	}
	
	@PostMapping("/admin/product/update")
	public String productUpdate(@ModelAttribute("product") Product product) {
		product.setCreatedate(new Date());
		productdao.save(product);
		return "redirect:/admin/product/edit/"+product.getId();
	}
	
}
