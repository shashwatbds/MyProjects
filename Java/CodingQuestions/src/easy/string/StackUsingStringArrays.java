package easy.string;

public class StackUsingStringArrays {

	private int head,tail,length;
	private static final int DEFAULT_CAPACITY = 200;
	char[] arr = new char[DEFAULT_CAPACITY]; 

	public void push(char i){
		arr[length] = i;
		length+=1;
		tail = length-1;
	}

	public char pop(){
		if(length ==0) {
			return '0';
		}
		char rem = arr[tail];
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
		StackUsingStringArrays stack = new StackUsingStringArrays();
		stack.printQueue();
		stack.push('1');
		stack.push('2');
		stack.push('3');
		stack.push('4');
		stack.push('5');
		stack.push('6');
		stack.push('7');
		stack.push('8');
		stack.push('9');
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
		stack.printQueue();
	}

}
