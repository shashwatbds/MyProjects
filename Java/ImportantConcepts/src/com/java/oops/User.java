package com.java.oops;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class User {

	private final String ID;
	private final String Name;
	private final List<String> emails;

	public User(String id, String name, List<String> emails) {
		this.ID = id;
		this.Name = name;
		this.emails = new ArrayList<>(Collections.unmodifiableList(emails));
		for(String s: emails) {
//			this.emails = new ArrayList<>(Collections.unmodifiableList(emails));
		}
	}

	public String getID() {
		return ID;
	}

	public String getName() {
		return Name;
	}

	public List<String> getEmails() {
		return emails;
	}
	
	public static void main(String[] args) {
		List<String> emails = new ArrayList<>();
		emails.add("email-1");
		emails = Collections.unmodifiableList(emails);
		User user = new User("ID-123", "User Name", Collections.unmodifiableList(emails));
		System.out.println(user.getEmails().size());
		// Print user.getEmails()
		emails.add("email-2");
		System.out.println(user.getEmails().size());
		// Print user.getEmails()
	}
}
