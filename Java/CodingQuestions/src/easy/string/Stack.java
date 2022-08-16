package easy.string;

public class Stack {

	int len=0, head, tail;
	char[] arr;

	public Stack(int len) {
		arr = new char[len];
	}

	public void push(char c) {
		arr[len] = c;
		len+=1;
		tail=len-1; 
	}

	public char pop() {
		char item = arr[this.len-1];
		arr[this.len-1] = 'X';
		len -=1;
		tail-=1;
		return item;
	}
	
	public int size() {
		return this.len;
	}
}
