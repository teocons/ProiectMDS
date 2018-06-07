import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.sun.javafx.geom.Rectangle;

public class GameState extends State{
	
	private Player player;
	private World world;
	private Rectangle menuButton;
	private int score = 0;
	private int difficulty = 0;
	
	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}



	GameState(Handler handler, int difficulty) {
		super(handler);
		this.difficulty = difficulty;
		world = new World(handler, difficulty);
		handler.setWorld(world);
		player = new Player(handler, 65, 65);
		menuButton = new Rectangle(1, 7, 90, 60);
		
	}
	 
	public void tick(){
		score += 1;
		world.tick();
		player.tick();
		mouseX = handler.getMouseManager().getMouseX();
		mouseY = handler.getMouseManager().getMouseY();
		if(handler.getMouseManager().isLeftPressed()) {
			if((mouseX >= menuButton.x && mouseX <= menuButton.x + menuButton.width) &&
			   (mouseY >= menuButton.y && mouseY <= menuButton.y + menuButton.width)) {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				State.setState(handler.getGame().getMenuState());
				player = new Player(handler, 65, 65);
			}
		}
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void render(Graphics g) {
		int fontSize = 40;
		
		world.render(g);
		player.render(g);
		g.setColor(Color.GREEN);
		g.fillRect(menuButton.x, menuButton.y, menuButton.width, menuButton.height);
		
		g.setFont(new Font("TimesRoman", Font.BOLD, fontSize));		     
		g.setColor(Color.BLACK);
		g.drawString("Back", menuButton.x, menuButton.y + handler.getHeight() / 18);
		
		
		g.setFont(new Font("TimesRoman", Font.BOLD, fontSize));		     
		g.setColor(Color.RED);
		g.drawString("Score:", (int) (handler.getWidth() - handler.getWidth() / 4), handler.getHeight() / 18);
		
		g.setFont(new Font("TimesRoman", Font.BOLD, fontSize));		     
		g.setColor(Color.RED);
		g.drawString(Integer.toString(score), handler.getWidth() - handler.getWidth() / 8, handler.getHeight() / 18);
	}
}
