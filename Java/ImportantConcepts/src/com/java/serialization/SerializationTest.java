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

import com.java.beans.Person;

public class SerializationTest {

	public static void main(String[] args) {

		serialize();
		deserialize();

	}

	private static void deserialize() {
		//Deserialise
		// Step 1: Create a file input stream to read the serialised content
				// of person class from the file
		// Step 2: Create an object stream from the file stream. So that the content
				// of the file is converted to the person Object instance
		try(InputStream fin = new FileInputStream("ser.txt");
				ObjectInput oin = new ObjectInputStream(fin)){
			System.out.println("De-Serialization process has started, de-serializing person object...");
			// Step 3: Read the content of the stream and convert it into object
			Person p = (Person) oin.readObject();//Constructor is not called during de-serialisation process.
			System.out.println(p.getName());
			System.out.println(p.getAge());
			System.out.println(p.getWeight());// Since weight is transient, default 0 is returned. Due to transient weight property was not serialised at all. Same behaviour with static properties.
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void serialize() {
		//Serialise
		Person person = new Person("Shashwat",34, 90);
		// Step 1: Open a file output stream to create a file object on disk.
		// This file object will be used to write the serialised bytes of an object
		
		// Step 2: Create a ObjectOutputStream, this class takes a files stream.
		// This class is responsible for converting the Object of any type into
		// a byte stream
		try(OutputStream fout = new FileOutputStream("ser.txt"); 
				ObjectOutput oout = new ObjectOutputStream(fout)) {

			System.out.println("Serialization process has started, serializing person object...");
			// Step 3: ObjectOutputStream.writeObject method takes an Object and 
			// converts it into a ByteStream. Then it writes the Byte stream into
			// the file using the File stream that we created in step 1.
			oout.writeObject(person);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
