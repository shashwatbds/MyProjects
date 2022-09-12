package com.java.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.java.beans.Address;
import com.java.beans.Customer;

public class SerializationWithCollection {

	public static void main(String[] args) {
		Customer c = new Customer(1, "Shashwat", 1);
		c.setAddress(new Address("London","Surrey"));
		List<String> names = new ArrayList<String>();
		names.add("Shash");names.add("Shash1");names.add("Shash2");
		c.setNames(names);
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Customer.txt"))){
			oos.writeObject(c);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Customer.txt"))) {
			Customer cs = (Customer) ois.readObject();
			System.out.println(cs.getName());
			cs.getNames().forEach(System.out::println);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
