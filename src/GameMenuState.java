import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.sun.javafx.geom.Rectangle;

public class GameMenuState extends State{
	private Rectangle veryEasyButton, easyButton, mediumButton, hardButton, veryHardButton, backButton;
	private Game game;

	public GameMenuState(Handler handler) {
		super(handler);
		veryEasyButton = new Rectangle(268, 80, 400, 60);
		easyButton = new Rectangle(268, 180, 400, 60);
		mediumButton = new Rectangle(268, 280, 400, 60);
		hardButton = new Rectangle(268, 380, 400, 60);
		veryHardButton = new Rectangle(268, 480, 400, 60);
		backButton = new Rectangle(268, 600, 402, 140);
		
	}

	@Override
	public void tick() {
		mouseX = handler.getMouseManager().getMouseX();
		mouseY = handler.getMouseManager().getMouseY();
		if(handler.getMouseManager().isLeftPressed())
		{
			if((mouseX >= veryEasyButton.x && mouseX <= veryEasyButton.x + veryEasyButton.width) && (mouseY >= veryEasyButton.y && mouseY <= veryEasyButton.y + veryEasyButton.height)) {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				game = handler.getGame();
				game.setGameState(new GameState(handler, 0));
				handler.setGame(game);
				State.setState(handler.getGame().getGameState());
			}else if((mouseX >= easyButton.x && mouseX <= easyButton.x + easyButton.width) && (mouseY >= easyButton.y && mouseY <= easyButton.y + easyButton.height)) {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				game = handler.getGame();
				game.setGameState(new GameState(handler, 1));
				handler.setGame(game);
				State.setState(handler.getGame().getGameState());
			}else if((mouseX >= mediumButton.x && mouseX <= mediumButton.x + mediumButton.width) && (mouseY >= mediumButton.y && mouseY <= mediumButton.y + mediumButton.height)) {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				game = handler.getGame();
				game.setGameState(new GameState(handler, 1));
				handler.setGame(game);
				State.setState(handler.getGame().getGameState());
			}else if((mouseX >= hardButton.x && mouseX <= hardButton.x + hardButton.width) && (mouseY >= hardButton.y && mouseY <= hardButton.y + hardButton.height)) {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				game = handler.getGame();
				game.setGameState(new GameState(handler, 1));
				handler.setGame(game);
				State.setState(handler.getGame().getGameState());
			}else if((mouseX >= veryHardButton.x && mouseX <= veryHardButton.x + veryHardButton.width) && (mouseY >= veryHardButton.y && mouseY <= veryHardButton.y + veryHardButton.height)) {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				game = handler.getGame();
				game.setGameState(new GameState(handler, 1));
				handler.setGame(game);
				State.setState(handler.getGame().getGameState());
			}else if((mouseX >= backButton.x && mouseX <= backButton.x + backButton.width) && (mouseY >= backButton.y && mouseY <= backButton.y + backButton.height)) {
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
		int fontSize = 50;
		
		g.setColor(Color.GREEN);
		g.fillRect((int)easyButton.x,(int)veryEasyButton.y , veryEasyButton.width, veryEasyButton.height);
		g.setColor(Color.GREEN);
		g.fillRect((int)easyButton.x,(int)easyButton.y , easyButton.width, easyButton.height);
		g.setColor(Color.YELLOW);
		g.fillRect((int)mediumButton.x, (int)mediumButton.y, (int)mediumButton.width, (int)mediumButton.height);
		g.setColor(Color.RED);
		g.fillRect((int)hardButton.x, (int)hardButton.y, (int)hardButton.width, (int)hardButton.height);
		g.setColor(Color.RED);
		g.fillRect((int)veryHardButton.x, (int)veryHardButton.y, (int)veryHardButton.width, (int)veryHardButton.height);
		g.setColor(Color.GREEN);
		g.fillRect((int)backButton.x, (int)backButton.y, (int)backButton.width, (int)backButton.height);
		
		g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));		     
		g.setColor(Color.BLACK);
		g.drawString("Easy", (int)easyButton.x + 150, (int)easyButton.y + 45);
		
		g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));		     
		g.setColor(Color.BLACK);
		g.drawString("Very Easy", (int)veryEasyButton.x + 100, (int)veryEasyButton.y + 45);
		
		g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));		     
		g.setColor(Color.BLACK);
		g.drawString("Medium", (int)mediumButton.x + 120, (int)mediumButton.y + 45);

		g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));		     
		g.setColor(Color.BLACK);
		g.drawString("Hard", (int)hardButton.x + 150, (int)hardButton.y + 45);
		
		g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));		     
		g.setColor(Color.BLACK);
		g.drawString("Very Hard", (int)veryHardButton.x + 100, (int)veryHardButton.y + 45);
		
			     
		
		fontSize = 100;
		
		g.setColor(Color.BLACK);
		g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));	
		g.drawString("Back", (int)backButton.x + 110, (int)backButton.y + 100);
		
		
	}
	
}
