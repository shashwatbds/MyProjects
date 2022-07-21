package com.java.beans;

import java.io.Serializable;

public class Country implements Serializable {
	  
    private static final long serialVersionUID = 1L;
  
    private String name;
    private int code;
    private Continent continent;
  
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Continent getContinent() {
		return continent;
	}

	public void setContinent(Continent continent) {
		this.continent = continent;
	}
}
