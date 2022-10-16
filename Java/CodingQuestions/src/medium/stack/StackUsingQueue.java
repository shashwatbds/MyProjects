package medium.stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

	public class Stack {

		Queue<Integer> q1 = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();

		int size = 0;
		
		public Stack() {};

		public void push(int x) {

			q2.add(x);

			while(!q1.isEmpty()) {
				q2.add(q1.peek());
				q1.remove();
			}

			Queue<Integer> temp = q1;
			q1=q2;
			q2=temp;
		}

		public int pop() {

			int removed = 0;
			if(!q1.isEmpty()) {
				removed = q1.remove();
			}
			return removed;
		}

		public int top() {
			if(q1.isEmpty()) {
				return -1;
			}
			return q1.peek();
		}

		public int size() {
			return q1.size();
		}
	}

	public static void main(String[] args) {
		StackUsingQueue obj = new StackUsingQueue();
		Stack s = obj.new Stack();
		s.push(1);
		s.push(2);
		s.push(3);
		
		System.out.println("current size: " + s.size());
        System.out.println(s.top());
        s.pop();
        System.out.println(s.top());
        s.pop();
        System.out.println(s.top());
 
        System.out.println("current size: " + s.size());
	}
}
