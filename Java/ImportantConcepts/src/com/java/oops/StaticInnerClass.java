package com.java.oops;

public class StaticInnerClass {

	private int privateInt;
	protected int protectedInt;
	public int publicInt;
	
	public StaticInnerClass() {

	}

	public static class InnerInnerClass {
		private int privateInnerClass;
		protected int protectedInnerClass;
		public int publicInnerClass;
		
		public InnerInnerClass() {
//			protectedInt = 2; Can't access non static variables in static context.
//			privateInt = 1;
//			publicInt = 3;
			privateInnerClass=4;
			protectedInnerClass=5;
			publicInnerClass=6;
			
			StaticInnerClass sic = new StaticInnerClass();
			sic.privateInt = 2;
			sic.protectedInt = 3;
			sic.publicInt = 4;
		}
	}
	
	public void testMethod() {
		
		class A {
			private String s="A";
			public String getA() {
				return s;
			}
		}
		
		{
			class B {
				private String s="B";
				public String getB() {
					return s;
				}
			}
			
			B b = new B();
			System.out.println(b.getB());
		}
		
		A a = new A();
		System.out.println(a.getA());
	}
	
	public static void main(String[] args) {

	}

}
