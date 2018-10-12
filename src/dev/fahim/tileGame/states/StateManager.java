package dev.fahim.tileGame.states;

public class StateManager {

	public static State currentState = null;
	
	public static void setCurrentState(State state)
	{
		currentState = state;
	}
	
	public static State getCurrentState()
	{
		return currentState;
	}
	
}
