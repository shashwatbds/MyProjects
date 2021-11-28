package pluralsight.IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class IOExample {

	public static void main(String[] args) {
		try(
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(IOExample.class.getResourceAsStream("user.txt")));

				Stream<String> stream = reader.lines();// new method in buffered Reader class which returns a stream.
				){

			stream.filter( line -> line.contains("Shashwat"))
			.findAny()
			.ifPresent(System.out::println);

		}catch(IOException e) {e.printStackTrace();}
		
		Path path = Paths.get("c:", "work","workspace","Java8","src","pluralsight","IO");
		try(Stream<Path> stream = Files.list(path)) {
			stream.filter( p -> p.toFile().isFile()) 
			.forEach(System.out::println);
		}catch (IOException e) {}
	}
	

}
