package medium.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class StackWrapper {

	private Stack<Integer> stack = new Stack<Integer>();
	private List<Integer> sorted = new ArrayList<>();
	
	public void push(int num) {
		stack.push(num);
		sorted.add(num);
	}
	
	public int pop() {
		int i = stack.pop();
		sorted.remove(i);
		return i;
	}
	
	public int getMin() {
		Collections.sort(sorted);
		return sorted.get(0);
	}
	
}
