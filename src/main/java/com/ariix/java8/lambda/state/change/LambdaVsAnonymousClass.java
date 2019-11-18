package com.ariix.java8.lambda.state.change;

/**
 * 
 * Notice how the anonymous MyEventConsumer implementation now has a field named eventCount.
 * A lambda expression cannot have such fields. A lambda expression is thus said to be stateless.
 * 
 * */
public class LambdaVsAnonymousClass {
	public static interface MyEventConsumer {
		public void consume(Object event);
	}

	public static void main(String[] args) {
		MyEventConsumer consumer = new MyEventConsumer() {
			private int count;
			@Override
			public void consume(Object event) {
				count++;
				System.out.println(event.toString() + " consumed");
				System.out.println("already consume: " + count + " events");
			}
		};
		consumer.consume(new Object());
		consumer.consume(new Object());
		
		
		
		MyEventConsumer lambdaConsumer = (event) -> {
			System.out.println(event.toString() + " consumed");
		};
		
		lambdaConsumer.consume(new Object());
		
	}

}
