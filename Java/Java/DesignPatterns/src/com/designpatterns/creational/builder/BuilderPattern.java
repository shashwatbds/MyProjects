package com.designpatterns.creational.builder;

public class BuilderPattern {

	static class Coffee {

		private Coffee(Builder b) {
			this.type = b.type;
			this.sugar = b.sugar;
			this.milk = b.milk;
			this.size = b.size;
		}

		private String type;
		private boolean sugar;
		private boolean milk;
		private String size;

		public static class Builder {
			private String type;
			private boolean sugar;
			private boolean milk;
			private String size;

			public Builder(String type) {
				this.type = type;
			}

			public Builder sugar(boolean sugar) {
				this.sugar = sugar;
				return this;
			}

			public Builder milk(boolean milk) {
				this.milk = milk;
				return this;
			}
			public Builder size(String size) {
				this.size = size;
				return this;
			}
			
			public Coffee build() {
				return new Coffee(this);
			}
		}
		
		@Override
		public String toString() {
			return String.format("Coffee [type=%s, sugar=%s, milk=%s, size=%s]", this.type, this.sugar, this.milk, this.size);
		}
	}
	
	public static void main(String[] args) {
		Coffee c = new BuilderPattern.Coffee.Builder("Mocha").milk(true).size("Large").build();
		System.out.println(c);
	}
}
