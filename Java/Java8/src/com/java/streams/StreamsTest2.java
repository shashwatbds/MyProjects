package com.java.streams;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.java.beans.Order;
import com.java.beans.Product;

public class StreamsTest2 {

	public static void main(String[] args) {
		List<Order> orders = StreamsData.createData();
		List<Product> products = StreamsData.getProducts();
		test(orders, products);
	}

	private static void test(List<Order> orders, List<Product> products) {

		//1.ObtainList with category Books and price >300
		orders.stream()
		.filter(o -> o.getProducts().stream()
				.allMatch(p-> p.getCategory().equals(StreamsData.BOOKS))
				)
		.flatMap(o-> o.getProducts().stream())
		.filter(p->p.getPrice()>300)
		.peek(System.out::println)
		.collect(Collectors.toList());

		//2. Get list of orders where Product category is baby
		orders.stream()
		.filter(o->o.getProducts().stream()
				.allMatch(p->p.getCategory().equals(StreamsData.BABY)))
		.peek(System.out::println)
		.collect(Collectors.toList());

		//3. Obtain a list of product with category = “Baby” and then apply 10% discount
		orders.stream()
		.filter(o->o.getProducts().stream()
				.allMatch(p->p.getCategory().equals(StreamsData.BABY)))
		.flatMap(o->o.getProducts().stream())
		.map(p-> {
			p.setPrice(p.getPrice()*0.9);
		return p;
		})
		.peek(System.out::println).collect(Collectors.toList());

		//4.Obtain a list of products ordered by customer of tier 3 between 01-Feb-2021 and 01-Apr-2021
		orders.stream()
		.filter(o-> o.getCustomer().getTier()==3)
		.filter(o-> o.getOrderDate().compareTo(LocalDate.of(2021, 01, 01)) > 0)
		.filter(o-> o.getOrderDate().compareTo(LocalDate.of(2021, 01, 31)) < 0)
		.collect(Collectors.toList());

		//5. Get the cheapest products of “Books” category
		System.out.println("5. Get the cheapest products of “Books” category\n");
		orders.stream()
		.flatMap(o->o.getProducts().stream())
		.filter(p->p.getCategory().equals(StreamsData.BOOKS))
		.sorted(Comparator.comparing(Product::getPrice))
		.limit(1)
		.peek(System.out::println)
		.collect(Collectors.toList());

		//6. get two most recently placed orders
		System.out.println("6. get two most recently placed orders\n");
		orders.stream()
		.sorted(Comparator.comparing(Order::getOrderDate).reversed())
		.limit(2)
		.peek(System.out::println)
		.collect(Collectors.toList());
		
		//7. Get a list of orders which were ordered on 11-Mar-2021, log the order records to the console and then return its product list

		//8. Calculate total lump sum of all orders placed in Feb 2021
		System.out.println("8. Calculate total lump sum of all orders placed in Feb 2021\n");
		double sum = orders.stream()
		.filter(o->o.getOrderDate().compareTo(LocalDate.of(2021, 02, 28))>0)
		.filter(o->o.getOrderDate().compareTo(LocalDate.of(2021, 04, 01))<0)
		.flatMap(o->o.getProducts().stream())
		.mapToDouble(p->p.getPrice())
		.peek(System.out::println)
		.sum();
		System.out.println(sum);
		//9. Obtain a data map with order id and order’s product count

	}
}
