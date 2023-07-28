package www.HealthyShop2023.DAO;

import org.springframework.data.jpa.repository.JpaRepository;


import www.HealthyShop2023.Model.Orderdetail;

public interface orderDetailDAO extends JpaRepository<Orderdetail , Long>{

}
