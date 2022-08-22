package com.java.streams;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.java.beans.Customer;
import com.java.beans.Order;
import com.java.beans.Product;

public abstract class StreamsData {

	public static final String BOOKS = "books";
	public static final String BEAUTY = "beauty";
	public static final String BABY = "baby";
	public static final String SPORTS = "sports";
	
	public static final String DELIVERED = "Delivered";
	
	public static List<Order> createData() {
		
		List<Product> products = getProducts();
		Map<String, Set<Product>> productsMap = getProductSet(products);
		List<Customer> customers = getCustomers();

		Order o1 = new Order(1, LocalDate.of(2021,11,11), LocalDate.of(2021,11,17), DELIVERED, customers.get(1), productsMap.get(BEAUTY));
		Order o2 = new Order(2, LocalDate.of(2021,01,11), LocalDate.of(2021,01,17), DELIVERED, customers.get(3), productsMap.get(BOOKS));
		Order o3 = new Order(3, LocalDate.of(2021,03,11), LocalDate.of(2021,03,17), DELIVERED, customers.get(2), productsMap.get(BABY));
		Order o4 = new Order(4, LocalDate.of(2021,04,11), LocalDate.of(2021,04,17), DELIVERED, customers.get(0), productsMap.get(SPORTS));
		
		List<Order> orders = new ArrayList<>();
		orders.add(o1);orders.add(o2);
		orders.add(o3);orders.add(o4);
		
		return orders;
	}
	
	public static List<Customer> getCustomers() {
		Customer c1 = new Customer(1, "Customer1", 1);
		Customer c2 = new Customer(2, "Customer2", 1);
		Customer c3 = new Customer(3, "Customer3", 2);
		Customer c4 = new Customer(4, "Customer4", 3);
		List<Customer> customers = new ArrayList<Customer>();
		customers.add(c1);customers.add(c2);customers.add(c3);customers.add(c4);
		return customers;
	}

	public static List<Product> getProducts(){
		Product p1 = new Product("Product0", SPORTS, 2000);
		Product p2 = new Product("Product1", SPORTS, 5000);
		Product p3 = new Product("Product2", BABY, 3000);
		Product p4 = new Product("Product3", BABY, 25000);
		Product p5 = new Product("Product4", BEAUTY, 500);
		Product p6 = new Product("Product5", BABY, 1000);
		Product p7 = new Product("Product6", BEAUTY, 2000);
		Product p8 = new Product("Product7", BOOKS, 1199);
		Product p9 = new Product("Product8", BOOKS, 599);
		Product p10 = new Product("Product9", BOOKS, 299);
		List<Product> products = new ArrayList<Product>();
		products.add(p1);products.add(p2);products.add(p3);products.add(p4);products.add(p5);
		products.add(p6);products.add(p7);products.add(p8);products.add(p9);products.add(p10);
		return products;
	}
	
	public static Map<String, Set<Product>> getProductSet(List<Product> products) {
		
		Set<Product> books = new HashSet<Product>();
		books.add(products.get(9));
		books.add(products.get(8));
		books.add(products.get(7));

		Set<Product> babyP = new HashSet<Product>();
		babyP.add(products.get(5));
		babyP.add(products.get(3));
		babyP.add(products.get(2));

		Set<Product> sportsP = new HashSet<Product>();
		sportsP.add(products.get(0));
		sportsP.add(products.get(1));

		Set<Product> beautyP = new HashSet<Product>();
		beautyP.add(products.get(4));
		beautyP.add(products.get(6));
		
		Map<String, Set<Product>> productsMap = new HashMap<>();
		productsMap.put(BEAUTY, beautyP);
		productsMap.put(BABY, babyP);
		productsMap.put(SPORTS, sportsP);
		productsMap.put(BOOKS, books);
		
		return productsMap;

	}
}
