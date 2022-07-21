package com.java.beans;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Student implements Externalizable {

	//The serialisation at runtime associates with each serialisation class a version number, called a serialVersionUID, 
	//which is used during de-serialisation to verify that the sender and receiver of a serialisation object have loaded classes 
	//for that object that are compatible with respect to serialisation. 
	private static final long serialVersionUID = 1L;

	private String name;
	private int age;
	
	public Student() {
		System.out.println("Contructor called!!");
	}
	
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeUTF(name);
		out.writeInt(age);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		this.name = in.readUTF(); //If you directly add to the setter then it wont set.
		this.age = in.readInt(); 
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
}
