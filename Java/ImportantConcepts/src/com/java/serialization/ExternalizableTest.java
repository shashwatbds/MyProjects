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

import com.java.beans.Student;

public class ExternalizableTest {

	public static void main(String[] args) {
		//Serialise
		Student student = new Student();
		student.setAge(34);
		student.setName("Shashwat");
		// Step 1: Open a file output stream to create a file object on disk.
		// This file object will be used to write the serialised bytes of an object

		// Step 2: Create a ObjectOutputStream, this class takes a files stream.
		// This class is responsible for converting the Object of any type into
		// a byte stream
		try(OutputStream fout = new FileOutputStream("ext.txt"); 
				ObjectOutput oout = new ObjectOutputStream(fout)) {

			System.out.println("Serialization process has started, serializing person object...");
			// Step 3: ObjectOutputStream.writeObject method takes an Object and 
			// converts it into a ByteStream. Then it writes the Byte stream into
			// the file using the File stream that we created in step 1.
			student.writeExternal(oout);
		} catch(IOException e) {
			e.printStackTrace();
		}

		//Deserialise
		// Step 1: Create a file input stream to read the serialised content
		// of person class from the file
		// Step 2: Create an object stream from the file stream. So that the content
		// of the file is converted to the person Object instance
		try(InputStream fin = new FileInputStream("ext.txt");
				ObjectInput oin = new ObjectInputStream(fin)){
			System.out.println("De-Serialization process has started, de-serializing person object...");
			// Step 3: Read the content of the stream and convert it into object
			Student s = new Student();
			s.readExternal(oin);//Constructor is called during de-serialisation process.
			System.out.println(s.getName());
			System.out.println(s.getAge());
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
