package com.springboot.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GenericEntity {

	@Id
	private Long id;
	private String val;
	
	public GenericEntity(Long id, String val) {
		super();
		this.id = id;
		this.val = val;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getVal() {
		return val;
	}
	public void setVal(String val) {
		this.val = val;
	}
	
	
}
