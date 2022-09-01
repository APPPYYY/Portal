package com.esspl.first.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
 private int cid;
	@Column(name="name")
 private String cname;
	@Column(name="description")
 private String cdescription;
	@Column(name="is_active")
 private boolean cstatus;
	
	
	
public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}
public String getCdescription() {
	return cdescription;
}
public void setCdescription(String cdescription) {
	this.cdescription = cdescription;
}
public boolean isCstatus() {
	return cstatus;
}
public void setCstatus(boolean cstatus) {
	this.cstatus = cstatus;
}
@Override
public String toString() {
	return "Category [cid=" + cid + ", cname=" + cname + ", cdescription=" + cdescription + ", cstatus=" + cstatus
			+ "]";
}
public Category(int cid, String cname, String cdescription, boolean cstatus) {
	super();
	this.cid = cid;
	this.cname = cname;
	this.cdescription = cdescription;
	this.cstatus = cstatus;
}
public Category() {
	
}
 
}
