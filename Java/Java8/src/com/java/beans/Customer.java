package com.java.beans;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

public class Customer implements Serializable{

	// This serialVersionUID field is necessary for Serializable as well as Externalizable to provide version control,
    // Compiler will provide this field if we do not provide it which might change if we modify the class structure of our class, 
	// and we will get ClassCastException,
    // If we provide value to this field and do not change it, serialization-deserialization will not fail 
	// if we change our class structure.

	private static final long serialVersionUID = 3054369136658567203L;
	private Integer id;
	private String name;
	private Integer tier;
	private Address address;//If this class is not serializable we get NotSerializableException
	private List<String> names;
	
	public Customer(Integer id, String name, Integer tier) {
		super();
		this.id = id;
		this.name = name;
		this.tier = tier;
//		System.out.println("Constructor Called");
	}
	
	public Customer() {
//		System.out.println("Constructor Called");
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getTier() {
		return tier;
	}
	public void setTier(Integer tier) {
		this.tier = tier;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", tier=" + tier + "]";
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
//	private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
//		ois.readObject();
//	}
	
	private void writeObject(ObjectOutputStream oos) throws IOException {
		oos.defaultWriteObject();
	}
	public List<String> getNames() {
		return names;
	}
	public void setNames(List<String> names) {
		this.names = names;
	}
}
