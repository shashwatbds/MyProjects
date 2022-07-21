package com.java.serialization;

import java.io.*;

public class SerializableSingleton implements Serializable{

	private static final long serialVersionUID = 1L;

	private SerializableSingleton() {}

	private static final SerializableSingleton INSTANCE = new SerializableSingleton();

	public static SerializableSingleton getInstance() {
		return INSTANCE;
	}

	/**
	 * Method ensures that we don't break singleton pattern during DeSerialization process- method must not be called other than DeSerialization time.
	 */
	private Object readResolve() throws ObjectStreamException {
		System.out.println("in readResolve()");
		return INSTANCE;
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		System.out.println("Are objects same before serialization : "+ (getInstance() == getInstance()) );

		OutputStream fout = new FileOutputStream("ser.txt");
		ObjectOutput oout = new ObjectOutputStream(fout);
		System.out.println("Serialization process has started...");
		oout.writeObject(getInstance());
		fout.close();
		oout.close();
		System.out.println("Object Serialization completed.");

		//DeSerialization process >>>>>>>.
		InputStream fin=new FileInputStream("ser.txt");
		ObjectInput oin=new ObjectInputStream(fin);
		System.out.println("\nDeSerialization process has started...");
		SerializableSingleton deSerializedObj = (SerializableSingleton)oin.readObject();
		fin.close();
		oin.close();
		System.out.println("Object DeSerialization completed.");
		System.out.println("Are objects same after serialization : "+ (deSerializedObj == getInstance()) );
	}
}
