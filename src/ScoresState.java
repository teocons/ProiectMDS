import java.awt.Color;
import java.awt.Graphics;

import com.sun.javafx.geom.Rectangle;

import java.awt.Font;

public class ScoresState extends State{
	
	private Rectangle backButton;
	private HighScore highScore;
	private String scores;
	private String[] scoreLine;
	
	public ScoresState(Handler handler) {
		super(handler);
		backButton = new Rectangle(268, 600, 402, 140);
		highScore = handler.getGame().getHighScore();
		highScore.readFile();
		scores = highScore.show();
		scoreLine = scores.split("-");
	}

	@Override
	public void tick() {
		mouseX = handler.getMouseManager().getMouseX();
		mouseY = handler.getMouseManager().getMouseY();
		
		if(handler.getMouseManager().isLeftPressed())
		{
			if((mouseX >= backButton.x && mouseX <= backButton.x + backButton.width) && (mouseY >= backButton.y && mouseY <= backButton.y + backButton.height)) {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				State.setState(handler.getGame().getMenuState());
			}
		}
		
	}

	@Override
	public void render(Graphics g) {
		int fontSize = 100;
		
		g.setColor(Color.GREEN);
		g.fillRect((int)backButton.x, (int)backButton.y, (int)backButton.width, (int)backButton.height);
		
		g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));		     
		g.setColor(Color.BLACK);
		g.drawString("Back", (int)backButton.x + 100, (int)backButton.y + 100);
		
		fontSize = 40;

		
		for(int i = 0; i < 10; ++i) {
			g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));		     
			g.setColor(Color.BLACK);
			g.drawString(scoreLine[i], 100, i * 50 + 100);
		}
	}
}
