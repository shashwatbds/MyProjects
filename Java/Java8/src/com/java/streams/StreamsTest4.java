package com.java.streams;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.java.beans.Order;
import com.java.beans.Product;

public class StreamsTest4 {

	public static void main(String[] args) {
		List<Order> orders = StreamsData.createData();
		List<Product> products = StreamsData.getProducts();
		test(orders, products);
	}

	private static void test(List<Order> orders, List<Product> products) {

		//1.Obtain Product List with category Books and price >300
		System.out.println("\n1.Obtain Product List with category Books and price >300\n");
		List<Product> prods = orders.stream()
				.flatMap(o-> o.getProducts().stream())
				.filter(p-> p.getCategory().equals(StreamsData.BOOKS))
				.filter(p->p.getPrice()>300)
				.peek(System.out::println)
				.collect(Collectors.toList());

		//2. Get list of orders where Product category is baby
		System.out.println("\n2. Get list of orders where Product category is baby\n");
		orders.stream()
		.filter(o->o.getProducts().stream()
				.allMatch(p->p.getCategory().equals(StreamsData.BABY)))
		.peek(System.out::println)
		.collect(Collectors.toList());

		//3. Obtain a list of product with category = “Baby” and then apply 10% discount
		System.out.println("\n3. Obtain a list of product with category = “Baby” and then apply 10% discount");
		orders.stream()
		.flatMap(o-> o.getProducts().stream())
		.filter(p->p.getCategory().equals(StreamsData.BABY))
		.map( p-> {
			p.setPrice(p.getPrice()*.9);
			return p;
		})
		.peek(System.out::println)
		.collect(Collectors.toList());

		//4.Obtain a list of products ordered by customer of tier 3 between 01-Jan-2021 and 20-Jan-2021
		System.out.println("\n4.Obtain a list of products ordered by customer of tier 3 between 11-Mar-2021 and 01-Apr-2021\n");
		orders.stream()
		.filter(o->o.getCustomer().getTier()==3)
		.filter(o->o.getOrderDate().compareTo(LocalDate.of(2021, 03, 10))>0)
		.filter(o->o.getOrderDate().compareTo(LocalDate.of(2021, 04, 01))<0)
		.peek(System.out::println)
		.collect(Collectors.toList());

		//5. Get the cheapest products of “Books” category
		System.out.println("\n5. Get the cheapest products of “Books” category\n");
		orders.stream()
		.flatMap(o->o.getProducts().stream())
		.filter(p->p.getCategory().equals(StreamsData.BOOKS))
		.sorted(Comparator.comparing(Product::getPrice))
		.peek(System.out::println)
		.limit(1)
		.collect(Collectors.toList());

		//6. get two most recently placed orders
		System.out.println("\n6. get two most recently placed orders\n");
		orders.stream()
		.sorted(Comparator.comparing(Order::getOrderDate).reversed())
		.limit(2)
		.peek(System.out::println)
		.collect(Collectors.toList());

		//7. Get a list of orders which were ordered on 11-Mar-2021, log the order records to the console and then return its product list
		System.out.println("\n7. Get a list of orders which were ordered on 11-Mar-2021, log the order records to the console and then return its product list\n");

		
		
		//8. Calculate total lump sum of all orders placed in Feb 2021
		System.out.println("\n8. Calculate total lump sum of all orders placed in Feb 2021\n");

		//9. Obtain a data map with order id and order’s product count
		System.out.println("\n9. Obtain a data map with order id and order’s product count\n");

	}
}
