import java.awt.Graphics;

public class Player extends Creature{
	
	
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		bounds.x = 60;
		bounds.y = 60;
		Assets.player = Assets.player_down[0];
	}

	@Override
	public void tick() {
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
		
		
	}
	
	private void getInput() {
		xMove = 0;
		yMove = 0;
		
		if(handler.getKeyManager().up)
			yMove = -speed;
		
		if(handler.getKeyManager().down)
			yMove = speed;
		
		if(handler.getKeyManager().left)
			xMove = -speed;
		
		if(handler.getKeyManager().right)
			xMove = speed;
		
	}

	@Override
	public void render(Graphics g) {
		if(xMove > 0) {
			if(animation.prevRight == false) {
				Assets.player = Assets.player_right[0];
			}else {
				Assets.player = Assets.player_right[1];
			}
		}
		
		else if(xMove < 0) {
			if(animation.prevLeft == false) {
				Assets.player = Assets.player_left[0];
			}else {
				Assets.player = Assets.player_left[1];
			}
		}
		
		else if(yMove > 0) {
			if(animation.prevDown == false) {
				Assets.player = Assets.player_down[0];
			}else {
				Assets.player = Assets.player_down[1];
			}
		}
		
		else if(yMove < 0) {
			if(animation.prevUp == false) {
				Assets.player = Assets.player_up[0];
			}else {
				Assets.player = Assets.player_up[1];
			}
		}
		g.drawImage(Assets.player, (int)(x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		
		/*g.setColor(Color.RED);
		g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset() ), 
				   (int) (y + bounds.y - handler.getGameCamera().getyOffset()), 
				   bounds.width, bounds.height);
		*/
	}
}
