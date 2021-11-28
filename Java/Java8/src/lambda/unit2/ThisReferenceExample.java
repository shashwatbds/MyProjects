package lambda.unit2;

public class ThisReferenceExample {

	public static void main(String[] args) {
		ThisReferenceExample thisReferenceExample = new ThisReferenceExample();
		thisReferenceExample.doProcess(10, new Process() {
			@Override
			public void process(int i) {
				System.out.println("Value of i is "+i);
				System.out.println(this);//this will print instance name of inner class, since inner class overrides this reference inside it.
			}
			
			@Override
			public String toString() {
				return "This is the anonymous inner class";
			}
		});
		
		thisReferenceExample.doProcess(10, i -> {
			System.out.println("Value of i is "+i);
//			System.out.println(this);// this will give error since this reference can't be used in a static context. Which means lambda does not override this reference.
		});
	}
	
	public void doProcess(int i, Process p) {
		p.process(i);
	}
}
