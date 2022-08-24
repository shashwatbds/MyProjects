package com.designpatterns.behavioral.observer;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class PCLNewsAgency {

	private String news;
	
	private PropertyChangeSupport support;
	
	public PCLNewsAgency() {
		support = new PropertyChangeSupport(this);
	}
	
	public void addPropertyChangeListener(PropertyChangeListener pcl) {
		support.addPropertyChangeListener(pcl);
	}
	
	public void removePropertyChangeListener(PropertyChangeListener pcl) {
		support.removePropertyChangeListener(pcl);
	}

	public String getNews() {
		return news;
	}

	public void setNews(String news) {
		support.fireIndexedPropertyChange("news", 0,  this.news, news);
		this.news = news;
	}
	
	
}
