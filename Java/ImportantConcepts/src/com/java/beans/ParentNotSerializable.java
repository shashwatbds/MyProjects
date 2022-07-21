package com.java.beans;

public class ParentNotSerializable {

	private String parentField1;

	public ParentNotSerializable() {
		System.out.println("Constructor called!!");
	}

	public String getParentField1() {
		return parentField1;
	}

	public void setParentField1(String parentField1) {
		this.parentField1 = parentField1;
	}
	
}
