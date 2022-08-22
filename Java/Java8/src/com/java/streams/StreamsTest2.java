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

		//1.ObtainList with category Books and price >100
		List<Product> ps = products.stream()
				.filter( p-> (p.getCategory().equals("Books") && p.getPrice() > 500))//intermediate operation
				.collect(Collectors.toList()); // terminary operation
		System.out.println("\nSolution 1:"+ps);

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
				anyMatch( p-> (p.getCategory().equalsIgnoreCase("Baby")))// can not use filter here since we need to have a terminal operation which returns boolean and filter returns a stream.
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
		System.out.println("\nSolution 3:"+bps);	

		//4.Obtain a list of products ordered by customer of tier 3 between 01-Feb-2021 and 01-Apr-2021
		List<Product> ops  = orders.stream().
				filter(o -> (o.getCustomer().getTier()==3)).
				filter(o-> (o.getOrderDate().compareTo(LocalDate.of(2022,01,10)) > 0)).
				filter(o-> (o.getOrderDate().compareTo(LocalDate.of(2022,02,15)) < 0)).
				flatMap(o -> o.getProducts().stream()).
				distinct().
				collect(Collectors.toList());
		System.out.println("\nSolution 4:"+ops);


		//5. Get the cheapest products of “Books” category
		Optional<Product> cb = products.stream().
				filter(p ->  p.getCategory().equalsIgnoreCase("books")).
				min(Comparator.comparing(Product::getPrice));
		System.out.println("\nSolution 5:"+cb);	

		//6. get two most recently placed orders
		List<Order> rps = orders.stream().
				sorted(Comparator.comparing(Order::getOrderDate).reversed()).
				limit(2).
				collect(Collectors.toList());
		System.out.println("\nSolution 6:"+rps);

		//7. Get a list of orders which were ordered on 11-Mar-2021, log the order records to the console and then return its product list
		List<Product> ps1 = orders.stream().
				filter(o -> o.getOrderDate().compareTo(LocalDate.of(2022, 03, 11)) == 0).
				peek(o -> System.out.println(o)).
				flatMap( o -> o.getProducts().stream()).
				collect(Collectors.toList());
		System.out.println("\nSolution 7:"+ps1);

		//8. Calculate total lump sum of all orders placed in Feb 2021
		double sum = orders.stream().
				filter(o-> (o.getOrderDate().compareTo(LocalDate.of(2022,02,01)) > 0)).
				filter(o-> (o.getOrderDate().compareTo(LocalDate.of(2022,04,01)) < 0)).
				peek(o -> System.out.println(o)).
				flatMap(o -> o.getProducts().stream()).
				peek( p-> System.out.println(p)).
				mapToDouble(p -> p.getPrice()).
				sum();
		System.out.println("\nSolution 8:"+sum);

		//9. Obtain a data map with order id and order’s product count
		Map<Integer, Integer> pm = orders.stream().
				collect(Collectors.toMap(o -> o.getId(), o -> o.getProducts().size()));
		System.out.println("\nSolution 9:"+pm);

	}
}
