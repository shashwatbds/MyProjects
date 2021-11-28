package pluralsight.datetime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class DateTimeExample {

	public static void main(String[] args) {
		List<User> users = new ArrayList<>();
		try(
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(DateTimeExample.class.getResourceAsStream("user.txt")));

				Stream<String> stream = reader.lines();// new method in buffered Reader class which returns a stream.
				){

			stream.map( line -> { 
				String[] arr = line.split(",");
				int year = Integer.parseInt(arr[1].trim());
				int month = Integer.parseInt(arr[2].trim());
				int date = Integer.parseInt(arr[3].trim());
				User user = new User(arr[0].trim(), LocalDate.of(year, Month.of(month), date));
				users.add(user);
				return user;
			})
			.forEach(System.out::println);

		}catch(IOException e) {e.printStackTrace();}

		LocalDate now = LocalDate.now();
		
		users.stream()
		.forEach(u -> {
			Period p = u.getDob().until(now);
			System.out.println(u.getName()+" was born "+p.getYears()+" years, "+p.getMonths()+" months and "+p.getDays()+" days ago.");
			});
	}

}
