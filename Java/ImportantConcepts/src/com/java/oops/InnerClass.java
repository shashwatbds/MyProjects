package com.java.oops;

public class InnerClass {

	private int privateInt;
	protected int protectedInt;
	public int publicInt;
	
	public InnerClass() {

	}

	public class InnerInnerClass {
		private int privateInnerClass;
		protected int protectedInnerClass;
		public int publicInnerClass;
		
		public InnerInnerClass() {
			protectedInt = 2;
			privateInt = 1;
			publicInt = 3;
			privateInnerClass=4;
			protectedInnerClass=5;
			publicInnerClass=6;
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

		InnerClass ic = new InnerClass();
		ic.testMethod();
	}

}
