package com.ariix.java8.lambda.state.change;

/**
 * Finally it is possible to reference a constructor of a class. 
 * You do that by writing the class name followed by ::new, like this:
 * */
public class ConstructorReferrenceLambdaExample {
	
	public static interface Factory {
		String create(char[] val);
	}

	public static void main(String[] args) {
		//Constructor
		Factory factory = String::new;
		String s = factory.create(new char[]{'a','b', 'c','d', 'e'});
		System.out.println(s);
		
		factory = chars -> new String(chars);
		s = factory.create("aaa".toCharArray());
		System.out.println("result:" + s);


		ConstructorReferrenceLambdaExample example = new ConstructorReferrenceLambdaExample();
		example.test();
	}

	private void test() {
		test(this::build);
	}


	public String build(char[] val) {
		return new String(val);
	}


	public void test(Factory factory) {
		String result = factory.create(new char[] {'a'});
		System.out.println(result);
	}

}
