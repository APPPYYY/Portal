package com.esspl.first.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonFilter;

@Entity
@Table(name="product")
//@JsonIgnoreProperties(value= {"name","brand"})
@JsonFilter("productfilter")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
	@Length(max = 20,min = 3,message = "please provide a valid name")
	
	@Column(name="name")
private String name;
	@Length(max = 20,min = 3,message = "please provide a valid brand")
	@Column(name="brand")
private String brand;
	@Length(max = 100,min = 10,message = "please provide product description here !!!")
	@Column(name="description")
private String description;
	@Range(min = 100,max = 100000,message = "please give a wowamount")
	@Column(name="unit_price")
private double unitprice;
	@Range(min = 1,max = 200,message = "enter quantity")
	@Column(name="quantity")
private int quantity;
	@Column(name="is_active")
private boolean status;
	@NotNull
	@Column(name="category_id")
private int categoryid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getUnitprice() {
		return unitprice;
	}
	public void setUnitprice(double unitprice) {
		this.unitprice = unitprice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", brand=" + brand + ", description=" + description
				+ ", unitprice=" + unitprice + ", quantity=" + quantity + ", status=" + status + ", categoryid="
				+ categoryid + "]";
	}
	public Product(int id, String name, String brand, String description, double unitprice, int quantity,
			boolean status, int categoryid) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.description = description;
		this.unitprice = unitprice;
		this.quantity = quantity;
		this.status = status;
		this.categoryid = categoryid;
	}
	public Product() {
	
	}

	
	
}
