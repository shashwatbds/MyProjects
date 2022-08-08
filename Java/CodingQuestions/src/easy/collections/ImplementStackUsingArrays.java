package easy.collections;

public class ImplementStackUsingArrays {

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
		int rem = arr[tail];
		arr[tail] = 0;
		tail -=1;
		length-=1;
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
		ImplementStackUsingArrays stack = new ImplementStackUsingArrays();
		stack.printQueue();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		stack.push(7);
		stack.push(8);
		stack.push(9);stack.push(10);
		stack.printQueue();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.printQueue();
	}

}
