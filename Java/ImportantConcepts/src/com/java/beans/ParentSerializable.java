package com.java.beans;

import java.io.Serializable;

public class ParentSerializable implements Serializable{

	private static final long serialVersionUID = 1L;

	private String parentField1;

	public ParentSerializable() {
		System.out.println("Constructor called!!");
	}

	public String getParentField1() {
		return parentField1;
	}

	public void setParentField1(String parentField1) {
		this.parentField1 = parentField1;
	}
}
