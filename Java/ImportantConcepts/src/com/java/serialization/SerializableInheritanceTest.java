package com.java.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import com.java.beans.ChildWithSerializableParent;

public class SerializableInheritanceTest {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		serialize();
		deserialize();
	}

	private static void deserialize() {
		//Deserialise
		try(InputStream fin = new FileInputStream("sercont.txt");
				ObjectInput oin = new ObjectInputStream(fin)){
			System.out.println("De-Serialization process has started, de-serializing country object...");
			ChildWithSerializableParent country = (ChildWithSerializableParent) oin.readObject();//Constructor is not called during de-serialisation process.
			System.out.println(country.getChildField1() + country.getParentField1());
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void serialize() {
		//Serialise
		ChildWithSerializableParent c1 = new ChildWithSerializableParent();
		c1.setChildField1("Child");
		c1.setParentField1("Parent");
		try(OutputStream fout = new FileOutputStream("sercont.txt"); 
				ObjectOutput oout = new ObjectOutputStream(fout)) {

			System.out.println("Serialization process has started, serializing country object...");
			oout.writeObject(c1);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
