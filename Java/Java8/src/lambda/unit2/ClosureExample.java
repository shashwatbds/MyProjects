package lambda.unit2;

public class ClosureExample {

	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		doProcess(a, new Process() {
			@Override
			public void process(int i) {
				System.out.println(i+b);// b variable will actually be read at line 19. Line 19 is inside method doProcess and it does not have 
				// any variable called b still it's accessible but it is assumed as final, which means since value of b is passed around
				// and compiler remembers it during execution of process method inside doProcess(). if we try to change value of b then compiler will show error.
			}
		});
	}
	
	public static void doProcess(int i, Process p) {
		p.process(i);
	}
}


interface Process{
	void process(int i);
}