package com.secondproject.ecommerce.entity;



import java.util.Date;
import java.util.Objects;
import org.hibernate.annotations.CreationTimestamp;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "WEB_ORDERS")
public class WebOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "CUSTOMER_ID")
	private Customer customer;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "ORDER_DATE")
	@CreationTimestamp
	private Date orderDate;
	

	
	public WebOrder() {}

	public WebOrder(Customer customer, String status, Date orderDate) {
		super();
		this.customer = customer;
		this.status = status;
		this.orderDate = orderDate;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WebOrder other = (WebOrder) obj;
		return Objects.equals(id, other.id);
	}

	

	
	
}

	