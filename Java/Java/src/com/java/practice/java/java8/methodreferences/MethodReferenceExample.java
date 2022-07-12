package com.java.practice.java.java8.methodreferences;

import java.util.ArrayList;
import java.util.List;

/**
 * Uses function as a parameter to invoke a method.
 * */
public class MethodReferenceExample {

	//ContainingClass::methodName
	public static void main(String[] args) {
		List<User> userList = new ArrayList<User>();
		for(int i =25; i<30;i++) {
			User user = new User("Name"+i,i);
			userList.add(user);
		}
		//userList.stream().forEach(User::userInfo);
		userList.stream().forEach(User::introduceYourself);
	}

}
