package www.HealthyShop2023.Model;

import java.io.Serializable;

import jakarta.annotation.Generated;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.LastModifiedDate;


/**
 * The persistent class for the products database table.
 * 
 */
@Getter @Setter
@Entity
@Table(name="products")
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Long id;

	private Boolean available;

	@Temporal(TemporalType.DATE)
	 @CreationTimestamp
	 @LastModifiedDate
	private Date createdate;

	private String image;

	private String name;

	private Double price;
	
	private String description;

	//bi-directional many-to-one association to Orderdetail
	@OneToMany(mappedBy="product")
	private List<Orderdetail> orderdetails;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="categoryid")
	private Category category;


}