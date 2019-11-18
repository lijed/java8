package com.ariix.java8.lambda.state.change;

import java.util.ArrayList;
import java.util.List;

public class StateOwner {
	private State privousState;
	private State currentState;
	public State getPrivousState() {
		return privousState;
	}

	public void setPrivousState(State privousState) {
		this.privousState = privousState;
	}

	public State getCurrentState() {
		return currentState;
	}

	public void setCurrentState(State currentState) {
		if (this.currentState != null) {
			this.privousState = this.currentState;
		}
		this.currentState = currentState;
	}

	private List<StateChangeListener> listeners = new ArrayList<StateChangeListener>();
	
	public void addStateListener(StateChangeListener listener) {
		listeners.add(listener);
	}
	
	public void notifyStateListener() {
		if (listeners != null) {
			for (StateChangeListener listener : listeners) {
				listener.onStateChange(privousState, currentState);
			}
		}
	}
	
	public static void main(String[] args) {
		StateOwner owner = new StateOwner();
		owner.setPrivousState(new State("Start"));
		owner.setCurrentState(new State("Running"));
		
		//Java 7 anonymous class
		owner.addStateListener(new StateChangeListener() {
			@Override
			public void onStateChange(State oldState, State newState) {
				
				//Do something with the old and new state
				System.out.println(oldState.getName() + " to "  + newState.getName());	
			} 
		});
		
		owner.addStateListener((oldState, newState) -> System.out.print("From " + oldState.getName() + " to" + newState.getName()));
		owner.notifyStateListener();
		StateChangeListener stopStateChangeListener = (oldState, newState) -> {
			if ("stop".equalsIgnoreCase(newState.getName())) {
				System.out.println("system is stoped");
			} else {
				System.out.println("system is runningss");
			}
		};
		
		owner.addStateListener(stopStateChangeListener);
		
		owner.setCurrentState(new State("stop"));
		owner.notifyStateListener();
		
	}
}
