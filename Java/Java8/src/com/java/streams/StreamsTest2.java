package com.java.streams;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.java.beans.Customer;
import com.java.beans.Order;
import com.java.beans.Product;

public class StreamsTest2 {

	public static void main(String[] args) {
		createData();
	}

	private static void createData() {
		Product p1 = new Product("Product1", "Sports", 2000);
		Product p2 = new Product("Product2", "Sports", 5000);
		Product p3 = new Product("Product3", "Baby", 3000);
		Product p4 = new Product("Product4", "Baby", 25000);
		Product p5 = new Product("Product5", "Beauty", 500);
		Product p6 = new Product("Product6", "Baby", 1000);
		Product p7 = new Product("Product7", "Beauty", 2000);
		Product p8 = new Product("Product8", "Books", 1199);
		Product p9 = new Product("Product9", "Books", 599);
		Product p10 = new Product("Product10", "Books", 299);
		List<Product> products = new ArrayList<Product>();
		products.add(p1);products.add(p2);products.add(p3);products.add(p4);products.add(p5);
		products.add(p6);products.add(p7);products.add(p8);products.add(p9);products.add(p10);

		Customer c1 = new Customer(1, "Customer1", 1);
		Customer c2 = new Customer(2, "Customer2", 1);
		Customer c3 = new Customer(3, "Customer3", 2);
		Customer c4 = new Customer(4, "Customer4", 3);

		Set<Product> books = new HashSet<Product>();
		books.add(p10);
		books.add(p9);
		books.add(p8);

		Set<Product> babyP = new HashSet<Product>();
		babyP.add(p6);
		babyP.add(p4);
		babyP.add(p3);

		Set<Product> sportsP = new HashSet<Product>();
		sportsP.add(p1);
		sportsP.add(p2);

		Set<Product> beautyP = new HashSet<Product>();
		beautyP.add(p5);
		beautyP.add(p7);

		Order o1 = new Order(1, LocalDate.of(2021,11,11), LocalDate.of(2021,11,17), "Delivered", c2, beautyP);
		Order o2 = new Order(2, LocalDate.of(2022,01,11), LocalDate.of(2022,01,17), "Delivered", c4, books);
		Order o3 = new Order(3, LocalDate.of(2022,03,11), LocalDate.of(2022,03,17), "Delivered", c3, babyP);
		Order o4 = new Order(4, LocalDate.of(2022,04,11), LocalDate.of(2022,04,17), "Delivered", c1, sportsP);
		List<Order> orders = new ArrayList<>();
		orders.add(o1);orders.add(o2);
		orders.add(o3);orders.add(o4);


		//1.ObtainList with category Books and price >100
		List<Product> ps = products.stream().
				filter( p-> (p.getCategory().equals("Books") && p.getPrice() > 500)). //intermediate operation
				collect(Collectors.toList()); // terminary operation
		System.out.println(ps);

		//2. Get list of orders where Product category is baby
		//		List<Order> os = orders.stream().
		//		filter( o -> {
		//			for(Product p : o.getProducts()) {
		//				if(p.getCategory().equalsIgnoreCase("Baby"))
		//					return true;
		//				
		//				break;
		//			}
		//			return false;
		//		}).collect(Collectors.toList());
		List<Order> os = orders.stream().
				filter( o -> 
				o.getProducts().stream().
				anyMatch( p-> (p.getCategory().equalsIgnoreCase("Baby")))
						).collect(Collectors.toList());
		os.forEach(System.out::println);

		//3. Obtain a list of product with category = “Baby” and then apply 10% discount
		List<Product> bps = products.stream().
				filter(p -> p.getCategory().equalsIgnoreCase("Baby")).
				map(p -> {
					p.setPrice(p.getPrice()*0.9);
					return p;
				}).
				collect(Collectors.toList());
		System.out.println(bps);	

		//4.Obtain a list of products ordered by customer of tier 2 between 01-Feb-2021 and 01-Apr-2021
		List<Product> ops  = orders.stream().
				filter(o -> (o.getCustomer().getTier()==3)).
				filter(o-> (o.getOrderDate().compareTo(LocalDate.of(2022,01,10)) > 0)).
				filter(o-> (o.getOrderDate().compareTo(LocalDate.of(2022,02,15)) < 0)).
				flatMap(o -> o.getProducts().stream()).
				distinct().
				collect(Collectors.toList());
		System.out.println(ops);


		//5. Get the cheapest products of “Books” category
		Optional<Product> cb = products.stream().
				filter(p ->  p.getCategory().equalsIgnoreCase("books")).
				min(Comparator.comparing(Product::getPrice));
		System.out.println(cb);	
		
		//6. get two most recently placed orders
		List<Order> rps = orders.stream().
				sorted(Comparator.comparing(Order::getOrderDate).reversed()).
				limit(2).
				collect(Collectors.toList());
		System.out.println(rps);
		
		//7. Get a list of orders which were ordered on 15-Mar-2021, log the order records to the console and then return its product list
	}
}
