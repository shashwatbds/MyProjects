package com.java.operators;

public class EllipsesOperator {

	public static void main(String[] args) {

		parseInput("2","1 0");

		parseInput("4","1 0","3 1","3 2");

		parseInput("4","1 0","2 0","3 2 1");
	}

	private static void parseInput(String... input) {

		int numCourses = Integer.parseInt(input[0]);
		int[][] pre = new int[input.length-1][2];
		for(int i=1; i<input.length; i++) {
			int arrIndex = 0;
			String[] dependencies = input[i].split(" ");
			int[] temp = new int[dependencies.length];
			for(String dependency: dependencies) {
				temp[arrIndex] = Integer.parseInt(dependency);
				arrIndex++;
			}
			pre[i-1] = temp;
		}
		System.out.println(input);
		System.out.println("\n\n");
	}
}
