package com.springboot.demo.entity;

public class GenericEntity {

	private Long id;
	private String value;
	
	public GenericEntity(Long id, String value) {
		super();
		this.id = id;
		this.value = value;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	
}
