package com.test.java.MavenPractice;

import java.io.IOException;

import org.junit.Test;

public class ReadFileTest {

	@Test
	public void readFileTest() {
		ReadFile rf = new ReadFile();
		try {
			rf.readFile("Temp.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
