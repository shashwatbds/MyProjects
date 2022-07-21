package com.java.io;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyLoaderTest {

	public static void main(String[] args) throws IOException {
		PropertyLoaderTest obj = new PropertyLoaderTest();
		final Properties properties = new Properties();
		try(final InputStream stream = obj.getClass().getResourceAsStream("../../../config.properties")){ //we are in com -> java -> io hence 3 folders we need to get out of.
			properties.load(stream);
		}
		System.out.println(properties);
	}
}
