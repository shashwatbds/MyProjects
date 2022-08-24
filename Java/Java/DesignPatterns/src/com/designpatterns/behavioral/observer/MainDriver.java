package com.designpatterns.behavioral.observer;

public class MainDriver {

	public static void main(String[] args) {
		PCLNewsAgency observable = new PCLNewsAgency();
		PCLNewsChannel observer = new PCLNewsChannel();
		
		observable.addPropertyChangeListener(observer);
		observable.setNews("News");
		
		System.out.println(observer.getNews());
	}

}
