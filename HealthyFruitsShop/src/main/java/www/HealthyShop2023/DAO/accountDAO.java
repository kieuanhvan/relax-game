package www.HealthyShop2023.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import www.HealthyShop2023.Model.Account;




public interface accountDAO extends JpaRepository<Account	, Long>{
	public Account findByUsernameAndPassword(String username,String password);
}

