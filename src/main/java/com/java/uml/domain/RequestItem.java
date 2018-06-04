package com.java.uml.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class RequestItem implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@EmbeddedId
	private RequestItemPK id = new RequestItemPK();
	
	private Double discount, price;
	private Integer amount;
	
	public RequestItem() {
		
	}

	public RequestItem(Request request, Product product, Double discount, Double price, Integer amount) {
		super();
		id.setProduct(product);
		id.setRequest(request);
		this.discount = discount;
		this.price = price;
		this.amount = amount;
	}

	@JsonIgnore
	public Request getRequest() {
		return id.getRequest();
	}
	
	public Product getProduct() {
		return id.getProduct();
	}
	
	public RequestItemPK getId() {
		return id;
	}

	public void setId(RequestItemPK id) {
		this.id = id;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RequestItem other = (RequestItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
