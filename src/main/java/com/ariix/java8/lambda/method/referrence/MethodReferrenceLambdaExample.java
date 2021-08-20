package com.ariix.java8.lambda.method.referrence;

public class MethodReferrenceLambdaExample {

	public static void main(String[] args) {
		MyPrinter canPrinter = (s) -> System.out.println(s);
		canPrinter.print("test");
		
		canPrinter = System.out::println;
		canPrinter.print("aa");
		
		MyPrinter errorPrinter = System.err::println;
		errorPrinter.print("testaaaaaaaaaaa");
		
		//Static method referrence
		errorPrinter = FormattedPrinter::print;
		errorPrinter.print("testing......");
		
		//Instance method referrence
		errorPrinter = new FormattedPrinter()::println;
		errorPrinter.print("testing......");



		computeAndPrint(8, 9, canPrinter);

	}

	public static void computeAndPrint(int a, int b, MyPrinter printer) {
		int sum = a + b;
		printer.print(String.valueOf(sum));
	}
	
	public static class FormattedPrinter{
		public static void print(String something) {
			Long start = System.currentTimeMillis();
			System.out.println("start print");
			System.out.println(something);
			System.out.println("end print");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Long end = System.currentTimeMillis();
			System.out.println("spend time: " + (end-start));
		}
		
		public void println(String something) {
			Long start = System.currentTimeMillis();
			System.out.println("start print");
			System.out.println(something);
			System.out.println("end print");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Long end = System.currentTimeMillis();
			System.out.println("spend time: " + (end-start));
		}
		
	}

}
