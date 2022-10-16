package medium.queue;

import java.util.Stack;

public class QueueUsingStack {
	
	class Queue {
		
		Stack<Integer> s1 = new Stack<>();
		Stack<Integer> s2 = new Stack<>();
		
		public void enQueue(int x) {
			
			while(!s1.isEmpty()) {
				s2.push(s1.pop());
			}
			
			s1.push(x);
			
			while(!s2.isEmpty()) {
				s1.push(s2.pop());
			}
		}
		
		public int deQueue() {
			
			if(s1.isEmpty()) {
				System.out.println("Queue is empty");
				System.exit(0);
			}
			
			int x = s1.peek();
			s1.pop();
			return x;
		}
	}
	
	public static void main(String[] args) {
		QueueUsingStack obj = new QueueUsingStack();
		Queue q = obj.new Queue();
	    q.enQueue(1);
	    q.enQueue(2);
	    q.enQueue(3);
	 
	    System.out.println(q.deQueue());
	    System.out.println(q.deQueue());
	    System.out.println(q.deQueue());
	}

}
