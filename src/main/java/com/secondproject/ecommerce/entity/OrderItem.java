package com.secondproject.ecommerce.entity;

import java.util.Objects;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;


@Entity
@Table(name = "ORDER_ITEMS")
public class OrderItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "order_id")
	private WebOrder order;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "product_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
    private Product product;
	
	@Column(name = "quantity")
    private Integer quantity;
	
	
	public OrderItem() {}


	public OrderItem(WebOrder order, Product product, Integer quantity) {
		super();
		this.order = order;
		this.product = product;
		this.quantity = quantity;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public WebOrder getOrder() {
		return order;
	}


	public void setOrder(WebOrder order) {
		this.order = order;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
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
		OrderItem other = (OrderItem) obj;
		return Objects.equals(id, other.id);
	}

	
	
}
