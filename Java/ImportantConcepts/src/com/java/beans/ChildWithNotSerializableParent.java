package com.java.beans;

import java.io.Serializable;

public class ChildWithNotSerializableParent extends ParentNotSerializable implements Serializable{

	private static final long serialVersionUID = 1L;

	private String childField1;
	
	public ChildWithNotSerializableParent() {
		System.out.println("Constructor called!!");
	}

	public String getChildField1() {
		return childField1;
	}

	public void setChildField1(String childField1) {
		this.childField1 = childField1;
	}
}
