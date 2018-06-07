<<<<<<< HEAD
import java.awt.Color;
import java.awt.Graphics;

import com.sun.javafx.geom.Rectangle;

import java.awt.Font;

public class MenuState extends State{
	private Rectangle startButton, scoresButton, exitButton;

	public MenuState(Handler handler) {
		super(handler);
		startButton = new Rectangle(268, 100, 402, 140);
		scoresButton = new Rectangle(268, 350, 402, 140);
		exitButton = new Rectangle(268, 600, 402, 140);
	}

	public void tick() {
		mouseX = handler.getMouseManager().getMouseX();
		mouseY = handler.getMouseManager().getMouseY();
		if(handler.getMouseManager().isLeftPressed())
		{
			System.out.println("Mouse apasat");
			if((mouseX >= startButton.x && mouseX <= startButton.x + startButton.width) && (mouseY >= startButton.y && mouseY <= startButton.y + startButton.height)) {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				State.setState(handler.getGame().getGameMenuState());
			}else if((mouseX >= scoresButton.x && mouseX <= scoresButton.x + scoresButton.width) && (mouseY >= scoresButton.y && mouseY <= scoresButton.y + scoresButton.height)) {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					
				}
				handler.getGame().setScoresState(new ScoresState(handler));
				State.setState(handler.getGame().getScoresState());
			}else if((mouseX >= exitButton.x && mouseX <= exitButton.x + exitButton.width) && (mouseY >= exitButton.y && mouseY <= exitButton.y + exitButton.height)) {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.exit(0);
			}
			
		}
		if(handler.getMouseManager().isLeftPressed())
		{
			System.out.println(handler.getMouseManager().getMouseX() + " " + handler.getMouseManager().getMouseY());
		}
	}

	public void render(Graphics g) {
		int fontSize = 100;
		
		g.setColor(Color.RED);
		g.fillRect((int)startButton.x,(int)startButton.y , startButton.width, startButton.height);
		g.setColor(Color.YELLOW);
		g.fillRect((int)scoresButton.x, (int)scoresButton.y, (int)scoresButton.width, (int)scoresButton.height);
		g.setColor(Color.GREEN);
		g.fillRect((int)exitButton.x, (int)exitButton.y, (int)exitButton.width, (int)exitButton.height);
		
		g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));		     
		g.setColor(Color.BLACK);
		g.drawString("Start", (int)startButton.x + 100, (int)startButton.y + 100);
		
		g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));		     
		g.setColor(Color.BLACK);
		g.drawString("Scores", (int)scoresButton.x + 70, (int)scoresButton.y + 100);
		
		g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));		     
		g.setColor(Color.BLACK);
		g.drawString("Exit", (int)exitButton.x + 120, (int)exitButton.y + 100);
	}
	
}
=======
import java.awt.Color;
import java.awt.Graphics;

import com.sun.javafx.geom.Rectangle;

import java.awt.Font;

public class MenuState extends State{
	private Rectangle startButton, scoresButton, exitButton;

	public MenuState(Handler handler) {
		super(handler);
		startButton = new Rectangle(268, 100, 402, 140);
		scoresButton = new Rectangle(268, 350, 402, 140);
		exitButton = new Rectangle(268, 600, 402, 140);
	}

	public void tick() {
		mouseX = handler.getMouseManager().getMouseX();
		mouseY = handler.getMouseManager().getMouseY();
		if(handler.getMouseManager().isLeftPressed())
		{
			System.out.println("Mouse apasat");
			if((mouseX >= startButton.x && mouseX <= startButton.x + startButton.width) && (mouseY >= startButton.y && mouseY <= startButton.y + startButton.height)) {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				State.setState(handler.getGame().getGameMenuState());
			}else if((mouseX >= scoresButton.x && mouseX <= scoresButton.x + scoresButton.width) && (mouseY >= scoresButton.y && mouseY <= scoresButton.y + scoresButton.height)) {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					
				}
				handler.getGame().setScoresState(new ScoresState(handler));
				State.setState(handler.getGame().getScoresState());
			}else if((mouseX >= exitButton.x && mouseX <= exitButton.x + exitButton.width) && (mouseY >= exitButton.y && mouseY <= exitButton.y + exitButton.height)) {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.exit(0);
			}
			
		}
		if(handler.getMouseManager().isLeftPressed())
		{
			System.out.println(handler.getMouseManager().getMouseX() + " " + handler.getMouseManager().getMouseY());
		}
	}

	public void render(Graphics g) {
		int fontSize = 100;
		
		g.setColor(Color.RED);
		g.fillRect((int)startButton.x,(int)startButton.y , startButton.width, startButton.height);
		g.setColor(Color.YELLOW);
		g.fillRect((int)scoresButton.x, (int)scoresButton.y, (int)scoresButton.width, (int)scoresButton.height);
		g.setColor(Color.GREEN);
		g.fillRect((int)exitButton.x, (int)exitButton.y, (int)exitButton.width, (int)exitButton.height);
		
		g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));		     
		g.setColor(Color.BLACK);
		g.drawString("Start", (int)startButton.x + 100, (int)startButton.y + 100);
		
		g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));		     
		g.setColor(Color.BLACK);
		g.drawString("Scores", (int)scoresButton.x + 70, (int)scoresButton.y + 100);
		
		g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));		     
		g.setColor(Color.BLACK);
		g.drawString("Exit", (int)exitButton.x + 120, (int)exitButton.y + 100);
	}
	
}
>>>>>>> 14557669d7293f081c910e1211d3776f3530645c
