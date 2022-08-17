package com.test.java.MavenPractice;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

public class ReadFile {

	public void readFile(String path) throws IOException {
		InputStream is = getClass().getResourceAsStream("/"+path);
		String content = IOUtils.toString(is);
		System.out.println(content);
	}
}
