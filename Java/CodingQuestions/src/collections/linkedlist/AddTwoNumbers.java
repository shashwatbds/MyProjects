package collections.linkedlist;

public class AddTwoNumbers {

	public static void main(String[] args) {

		Node head1 = new Node("2");
		Node n11 = new Node("4");head1.setNext(n11);
		Node n12 = new Node("3");n11.setNext(n12);

		Node head2 = new Node("5");
		Node n21 = new Node("6");head2.setNext(n21);
		Node n22 = new Node("4");n21.setNext(n22);


		addTwoNumbers(head1, head2);//342+465=807


		head1 = new Node("9");
		n11 = new Node("9");head1.setNext(n11);
		n12 = new Node("9");n11.setNext(n12);

		head2 = new Node("9");
		n21 = new Node("9");head2.setNext(n21);

		addTwoNumbers(head1, head2); //999+99=1098

	}

	public static Node addTwoNumbers(Node head1, Node head2) {

		int carry = 0;
		int sum = Integer.parseInt(head1.getData())+Integer.parseInt(head2.getData()) + carry;

		if(sum>=10) {
			carry=sum/10;
			sum = sum%10;
		} 
		Node result = new Node(String.valueOf(sum));

		Node currentN1 = head1;
		Node currentN2 = head2;
		Node resultNext = result;
		while(currentN1.hasNext() || currentN2.hasNext()) { 
			//If both List are not of same length then adjust length by adding 0
			Node n1 = currentN1.hasNext() ? currentN1.getNext() : new Node("0");
			Node n2 = currentN2.hasNext() ? currentN2.getNext() : new Node("0");

			int sum1 = Integer.parseInt(n1.getData())+Integer.parseInt(n2.getData()) + carry;
			if(sum1>=10) {
				carry=sum1/10;
				sum1 = sum1%10;
			} else {
				carry=0;
			}

			Node next = new Node(String.valueOf(sum1));
			resultNext.setNext(next);
			currentN1=n1;
			currentN2 = n2;
			resultNext = next;

		}

		if(carry!=0) {
			Node lastNode = new Node(String.valueOf(carry));
			resultNext.setNext(lastNode);
		}

		return result;
	}
}
