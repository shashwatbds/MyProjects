package medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FindFarthestPoint {

	public static void main(String[] args) {

		int[] source = {0,0};
		List<Point> points = new ArrayList<>();
		points.add(new Point(2,3));points.add(new Point(2,0)); points.add(new Point(-1,0));points.add(new Point(-1,0));
		points.add(new Point(0,2));points.add(new Point(-2,0));
		
		points.forEach(System.out::println);
		System.out.println("\n");
		findFartherPoint(source, points ,3);
	}

	private static void findFartherPoint(int[] source, List<Point> points, int i) {
		
		List<Point> sortedPoints = points.stream()
				.sorted(Comparator.comparing(Point::getDistanceFromZero).reversed())
				.peek(System.out::println)
				.limit(i)
				.collect(Collectors.toList());
		System.out.println("\n");
		System.out.println(sortedPoints.get(i-1));
	}

}
