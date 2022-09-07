package youtube.streams;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.java.beans.Address;
import com.java.beans.Customer;

public class TryWithResources {

	public static void main(String[] args) {

		Customer c = new Customer(1, "Shashwat", 1);
		c.setAddress(new Address("London","Surrey"));
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
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//1. Customer must be Serializable.
	}

}
