package easy.collections;

public class QueueUsingArray {

	private int head, tail, length = 0;
	private static final int DEFAULT_CAPACITY = 200;
	int[] arr = new int[DEFAULT_CAPACITY]; 

	public void push(int i){
		arr[length] = i;
		length+=1;
		tail = length-1;
	}

	public int pop(){
		if(length ==0) {
			return -1;
		}
		int rem = arr[head];
		for(int i=0; i<size();i++) {
			arr[i] = arr[i+1];
		}
		arr[tail] = 0;
		System.out.println(rem);
		return rem;
	}

	public int size() {
		return length;
	}

	public void printQueue() {
		for(int i=0; i<length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void main(String[] args) {
		QueueUsingArray queue = new QueueUsingArray();
		queue.printQueue();
		queue.push(1);
		queue.push(2);
		queue.push(3);
		queue.push(4);
		queue.push(5);
		queue.push(6);
		queue.push(7);
		queue.push(8);
		queue.push(9);queue.push(10);
		queue.printQueue();
		queue.pop();
		queue.pop();
		queue.pop();
		queue.pop();
		queue.pop();
		queue.pop();
		queue.pop();
		queue.pop();
		queue.pop();
		queue.pop();
		queue.printQueue();
	}

}
