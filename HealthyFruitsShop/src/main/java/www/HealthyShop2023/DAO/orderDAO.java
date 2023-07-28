package www.HealthyShop2023.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import www.HealthyShop2023.Model.Order;

public interface orderDAO extends JpaRepository<Order , Long>{

}
