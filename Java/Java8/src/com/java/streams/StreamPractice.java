package com.java.streams;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import com.java.beans.Customer;
import com.java.beans.Order;
import com.java.beans.Product;

public class StreamPractice {

	public static void main(String[] args) {
		List<Order> orders = StreamsData.createData();
		List<Product> products = StreamsData.getProducts();
		Map<String, Set<Product>> productSet = StreamsData.getProductSet(products);
		List<Customer> customers = StreamsData.getCustomers();
		
		//1.Obtain List with category Books and price >100
		System.out.println("\n1.ObtainList with category Books and price >300");
		List<Product> expensiveBooks = orders.stream()
				.filter(o-> o.getProducts().stream()
						.allMatch(p->p.getCategory().equalsIgnoreCase(StreamsData.BOOKS)))
				.flatMap(o-> o.getProducts().stream())
				.filter(p-> p.getPrice()>300)
				.collect(Collectors.toList());
		expensiveBooks.forEach(System.out::println);
		
		//2. Get list of orders where Product category is baby
		System.out.println("\n2. Get list of orders where Product category is baby");//Order [id=3, orderDate=2022-03-11, deliveryDate=2022-03-17, status=Delivered]
		orders.stream().
		filter(o -> o.getProducts().stream()
				.allMatch(p->p.getCategory().equalsIgnoreCase(StreamsData.BABY)))
		.flatMap(o-> o.getProducts().stream())
		.peek(System.out::println)
		.collect(Collectors.toList());
		

		//3. Obtain a list of product with category = “Baby” and then apply 10% discount
		System.out.println("\n3. Obtain a list of product with category = “Baby” and then apply 10% discount");
		orders.stream()
		.filter(o->o.getProducts().stream()
				.allMatch(p->p.getCategory().equalsIgnoreCase(StreamsData.BABY)))
		.flatMap(o->o.getProducts().stream())
		.map(p-> {p.setPrice(p.getPrice()*0.9); return p;})
		.peek(System.out::println)
		.collect(Collectors.toList());
		
		//4.Obtain a list of products ordered by customer of tier 3 between 01-Feb-2021 and 01-Apr-2021
		System.out.println("\n4.Obtain a list of products ordered by customer of tier 3, and order date between 01-Feb-2021 and 01-Apr-2021");
		orders.stream()
		.filter(o-> o.getCustomer().getTier()==3)
		.filter(o-> o.getOrderDate().compareTo(LocalDate.of(2021, 01, 01)) > 0)
		.filter(o-> o.getOrderDate().compareTo(LocalDate.of(2021, 01, 31)) < 0)
		.peek(System.out::println)
		.collect(Collectors.toList());

		
		//5. Get the cheapest products of “Books” category
		System.out.println("\n5. Get the cheapest products of “Books” category");
		orders.stream()
		.filter(o->o.getProducts().stream()
				.allMatch(p->p.getCategory().equals(StreamsData.BOOKS)))
		.flatMap(o->o.getProducts().stream())
		.sorted(Comparator.comparing(Product::getPrice).reversed())
		.limit(2)
		.peek(System.out::println)
		.collect(Collectors.toList());
		
		//6. get two most recently placed orders
		System.out.println("\n6. get two most recently placed orders");
		orders.stream()
		.sorted(Comparator.comparing(Order::getOrderDate).reversed())
		.limit(2)
		.peek(System.out::println)
		.collect(Collectors.toList());

		//7. Get a list of orders which were ordered on 11-Mar-2021, log the order records to the console and then return its product list
		System.out.println("\n7. Get a list of orders which were ordered on 11-Mar-2021, log the order records to the console and then return its product list");
		orders.stream()
		.filter(o->o.getOrderDate().equals(LocalDate.of(2021, 11, 11)))
		.peek(System.out::println)
		.flatMap(o->o.getProducts().stream())
		.peek(System.out::println)
		.collect(Collectors.toList());
		
		//8. Calculate total lump sum of all orders placed in Feb 2021
		System.out.println("\n8. Calculate total lump sum of all orders placed in Feb 2021");
		double sum = orders.stream()
		.filter(o->o.getOrderDate().compareTo(LocalDate.of(2021, 02, 28))>0)
		.filter(o->o.getOrderDate().compareTo(LocalDate.of(2021, 04, 01))<0)
		.flatMap(o->o.getProducts().stream())
		.mapToDouble(Product::getPrice)
		.peek(System.out::println)
		.sum();
		System.out.println(sum);

		//9. Obtain a data map with order id and order’s product count
		System.out.println("\n9. Obtain a data map with order id and order’s product count");
		Map<Integer, Integer> map = orders.stream()
		.collect(Collectors.toMap(o -> o.getId(), o-> o.getProducts().size()));
		System.out.println(map.size());
	}

}
