<<<<<<< HEAD
import java.awt.Graphics;

public abstract class State {
	
	private static State currentState = null;
	protected int mouseX, mouseY;
	
	public static void setState(State state) {
		currentState = state;
	}
	
	public static State getState() {
		return currentState;
	}
	
	//CLASS
	
	protected static Handler handler;
	
	public State(Handler handler1) {
		handler = handler1; 
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
	
}
=======
import java.awt.Graphics;

public abstract class State {
	
	private static State currentState = null;
	protected int mouseX, mouseY;
	
	public static void setState(State state) {
		currentState = state;
	}
	
	public static State getState() {
		return currentState;
	}
	
	//CLASS
	
	protected static Handler handler;
	
	public State(Handler handler1) {
		handler = handler1; 
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
	
}
>>>>>>> 14557669d7293f081c910e1211d3776f3530645c
