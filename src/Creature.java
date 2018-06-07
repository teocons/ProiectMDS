<<<<<<< HEAD
public abstract class Creature extends Entity{
	
	protected Animation animation;
	public static final int DEFAULT_HEALTH = 10;
	public static final float DEFAULT_SPEED = 3.0F;
	public static final int DEFAULT_CREATURE_WIDTH = 60,
							DEFAULT_CREATURE_HEIGHT = 60;
	
	protected float speed;
	protected float xMove, yMove;
	protected HighScore highScore;
	
	protected int health;

	public Creature(Handler handler,float x, float y, int width, int height) {
		super(handler,  x, y, width, height);
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
		animation = new Animation();	
		highScore = handler.getGame().getHighScore();
	}
	
	public void move() {
		moveX();
		moveY();
	}
	
	public void moveX() {
		if(xMove > 0) {//Moving right
			int tx = (int) (x + xMove + bounds.x) / Tile.TILEWIDTH;
			if ((collisionWithTile(tx, (int)(y) / Tile.TILEHEIGHT) == 2) 
			|| (collisionWithTile(tx, (int)(y + bounds.y) / Tile.TILEHEIGHT) == 2)) {
				highScore.addScore(GameState.class.cast(handler.getGame().getGameState()).getScore());	
				highScore.writeFile();
				handler.getGame().setGameState(new GameState(handler, 1));
				State.setState(handler.getGame().getMenuState());
				
				
				
				
				}else if ((collisionWithTile(tx, (int)(y) / Tile.TILEHEIGHT) == 0) 
			&& (collisionWithTile(tx, (int)(y + bounds.y) / Tile.TILEHEIGHT) == 0)){
				x += xMove;
			}
			if(animation.prevRight == false) {
				++animation.prevWaitRight;
				if(animation.prevWaitRight % 10 == 0) {
					animation.prevRight = true;
				}
				
			}else {
				++animation.prevWaitRight;
				if(animation.prevWaitRight % 10 == 0) {
					animation.prevRight = false;
				}
			}
			animation.prevLeft = false;
			animation.prevWaitLeft = 0;
			
		}else if (xMove < 0) {//Moving left
			int tx = (int) (x + xMove) / Tile.TILEWIDTH;
			if(collisionWithTile(tx, (int)(y) / Tile.TILEHEIGHT) == 2 
			|| (collisionWithTile(tx, (int)(y + bounds.y) / Tile.TILEHEIGHT)) == 2) {
				highScore.addScore(GameState.class.cast(handler.getGame().getGameState()).getScore());	
				highScore.writeFile();
				State.setState(handler.getGame().getMenuState());
			}else if (collisionWithTile(tx, (int)(y) / Tile.TILEHEIGHT) == 0 
			&& (collisionWithTile(tx, (int)(y + bounds.y) / Tile.TILEHEIGHT)) == 0) {
				x += xMove;
			}
			if(animation.prevLeft == false) {
				++animation.prevWaitLeft;
				if(animation.prevWaitLeft % 10 == 0) {
					animation.prevLeft = true;
				}
			}else {
				++animation.prevWaitLeft;
				if(animation.prevWaitLeft % 10 == 0) {
					animation.prevLeft = false;
				}
			}
			animation.prevRight = false;
			animation.prevWaitRight = 0;
		}else {
			animation.prevRight = false;
			animation.prevWaitRight = 0;
			animation.prevLeft = false;
			animation.prevWaitLeft = 0;
		}
	}
	
	public void moveY() {
		if(yMove > 0) {
			int ty = (int) (y + yMove  +  bounds.y) / Tile.TILEHEIGHT;
			if ((collisionWithTile(((int)(x) / Tile.TILEWIDTH), ty) == 2) 
			|| (collisionWithTile((int)(x + bounds.x) / Tile.TILEWIDTH , ty) == 2)){
				highScore.addScore(GameState.class.cast(handler.getGame().getGameState()).getScore());	
				highScore.writeFile();
				State.setState(handler.getGame().getMenuState());
			}else if ((collisionWithTile(((int)(x) / Tile.TILEWIDTH), ty) == 0) 
			&& (collisionWithTile((int)(x + bounds.x) / Tile.TILEWIDTH , ty) == 0)){
				y += yMove;
			}
			if(animation.prevDown == false) {
				++animation.prevWaitDown;
				if(animation.prevWaitDown % 10 == 0) {
					animation.prevDown = true;
				}
			}else {
				++animation.prevWaitDown;
				if(animation.prevWaitDown % 10 == 0) {
					animation.prevDown = false;
				}
			}
			animation.prevUp = false;
			animation.prevWaitUp = 0;
		}else 
			
			if(yMove < 0) {
			int ty = (int) (y + yMove) / Tile.TILEHEIGHT;
			if((collisionWithTile(((int)(x) / Tile.TILEWIDTH), ty) == 2) 
			|| (collisionWithTile((int)(x + bounds.x) / Tile.TILEWIDTH , ty) == 2)){
				highScore.addScore(GameState.class.cast(handler.getGame().getGameState()).getScore());	
				highScore.writeFile();
				State.setState(handler.getGame().getMenuState());
			}else if ((collisionWithTile(((int)(x) / Tile.TILEWIDTH), ty) == 0) 
			&& (collisionWithTile((int)(x + bounds.x) / Tile.TILEWIDTH , ty) == 0)){
				y += yMove;
			}
			if(animation.prevUp == false) {
				++animation.prevWaitUp;
				if(animation.prevWaitUp % 10 == 0) {
					animation.prevUp = true;
				}
			}else {
				++animation.prevWaitUp;
				if(animation.prevWaitUp % 10 == 0) {
					animation.prevUp = false;
				}
			}
			animation.prevDown = false;
			animation.prevWaitDown = 0;
		}
		else{
			animation.prevDown = false;
			animation.prevWaitDown = 0;
			animation.prevUp = false;
			animation.prevWaitUp = 0;
		}
			
	}
	
	protected int collisionWithTile(int x, int y) {
		return handler.getWorld().getTile(x, y).isSolid();
	}
	
	//GETTERS AND SETTERS

	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	
	
}
=======
public abstract class Creature extends Entity{
	
	protected Animation animation;
	public static final int DEFAULT_HEALTH = 10;
	public static final float DEFAULT_SPEED = 3.0F;
	public static final int DEFAULT_CREATURE_WIDTH = 64,
							DEFAULT_CREATURE_HEIGHT = 64;
	
	protected float speed;
	protected float xMove, yMove;
	protected HighScore highScore;
	
	protected int health;

	public Creature(Handler handler,float x, float y, int width, int height) {
		super(handler,  x, y, width, height);
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
		animation = new Animation();	
		highScore = handler.getGame().getHighScore();
	}
	
	public void move() {
		moveX();
		moveY();
	}
	
	public void moveX() {
		if(xMove > 0) {//Moving right
			int tx = (int) (x + xMove + bounds.x) / Tile.TILEWIDTH;
			if ((collisionWithTile(tx, (int)(y) / Tile.TILEHEIGHT) == 2) 
			|| (collisionWithTile(tx, (int)(y + bounds.y) / Tile.TILEHEIGHT) == 2)) {
				highScore.addScore(GameState.class.cast(handler.getGame().getGameState()).getScore());	
				highScore.writeFile();
				State.setState(handler.getGame().getMenuState());
				
				
				
				
				}else if ((collisionWithTile(tx, (int)(y) / Tile.TILEHEIGHT) == 0) 
			&& (collisionWithTile(tx, (int)(y + bounds.y) / Tile.TILEHEIGHT) == 0)){
				x += xMove;
			}
			if(animation.prevRight == false) {
				++animation.prevWaitRight;
				if(animation.prevWaitRight % 10 == 0) {
					animation.prevRight = true;
				}
				
			}else {
				++animation.prevWaitRight;
				if(animation.prevWaitRight % 10 == 0) {
					animation.prevRight = false;
				}
			}
			animation.prevLeft = false;
			animation.prevWaitLeft = 0;
			
		}else if (xMove < 0) {//Moving left
			int tx = (int) (x + xMove) / Tile.TILEWIDTH;
			if(collisionWithTile(tx, (int)(y) / Tile.TILEHEIGHT) == 2 
			|| (collisionWithTile(tx, (int)(y + bounds.y) / Tile.TILEHEIGHT)) == 2) {
				highScore.addScore(GameState.class.cast(handler.getGame().getGameState()).getScore());	
				highScore.writeFile();
				State.setState(handler.getGame().getMenuState());
			}else if (collisionWithTile(tx, (int)(y) / Tile.TILEHEIGHT) == 0 
			&& (collisionWithTile(tx, (int)(y + bounds.y) / Tile.TILEHEIGHT)) == 0) {
				x += xMove;
			}
			if(animation.prevLeft == false) {
				++animation.prevWaitLeft;
				if(animation.prevWaitLeft % 10 == 0) {
					animation.prevLeft = true;
				}
			}else {
				++animation.prevWaitLeft;
				if(animation.prevWaitLeft % 10 == 0) {
					animation.prevLeft = false;
				}
			}
			animation.prevRight = false;
			animation.prevWaitRight = 0;
		}else {
			animation.prevRight = false;
			animation.prevWaitRight = 0;
			animation.prevLeft = false;
			animation.prevWaitLeft = 0;
		}
	}
	
	public void moveY() {
		if(yMove > 0) {
			int ty = (int) (y + yMove  +  bounds.y) / Tile.TILEHEIGHT;
			if ((collisionWithTile(((int)(x) / Tile.TILEWIDTH), ty) == 2) 
			|| (collisionWithTile((int)(x + bounds.x) / Tile.TILEWIDTH , ty) == 2)){
				highScore.addScore(GameState.class.cast(handler.getGame().getGameState()).getScore());	
				highScore.writeFile();
				State.setState(handler.getGame().getMenuState());
			}else if ((collisionWithTile(((int)(x) / Tile.TILEWIDTH), ty) == 0) 
			&& (collisionWithTile((int)(x + bounds.x) / Tile.TILEWIDTH , ty) == 0)){
				y += yMove;
			}
			if(animation.prevDown == false) {
				++animation.prevWaitDown;
				if(animation.prevWaitDown % 10 == 0) {
					animation.prevDown = true;
				}
			}else {
				++animation.prevWaitDown;
				if(animation.prevWaitDown % 10 == 0) {
					animation.prevDown = false;
				}
			}
			animation.prevUp = false;
			animation.prevWaitUp = 0;
		}else 
			
			if(yMove < 0) {
			int ty = (int) (y + yMove) / Tile.TILEHEIGHT;
			if((collisionWithTile(((int)(x) / Tile.TILEWIDTH), ty) == 2) 
			|| (collisionWithTile((int)(x + bounds.x) / Tile.TILEWIDTH , ty) == 2)){
				highScore.addScore(GameState.class.cast(handler.getGame().getGameState()).getScore());	
				highScore.writeFile();
				State.setState(handler.getGame().getMenuState());
			}else if ((collisionWithTile(((int)(x) / Tile.TILEWIDTH), ty) == 0) 
			&& (collisionWithTile((int)(x + bounds.x) / Tile.TILEWIDTH , ty) == 0)){
				y += yMove;
			}
			if(animation.prevUp == false) {
				++animation.prevWaitUp;
				if(animation.prevWaitUp % 10 == 0) {
					animation.prevUp = true;
				}
			}else {
				++animation.prevWaitUp;
				if(animation.prevWaitUp % 10 == 0) {
					animation.prevUp = false;
				}
			}
			animation.prevDown = false;
			animation.prevWaitDown = 0;
		}
		else{
			animation.prevDown = false;
			animation.prevWaitDown = 0;
			animation.prevUp = false;
			animation.prevWaitUp = 0;
		}
			
	}
	
	protected int collisionWithTile(int x, int y) {
		return handler.getWorld().getTile(x, y).isSolid();
	}
	
	//GETTERS AND SETTERS

	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	
	
}
>>>>>>> 14557669d7293f081c910e1211d3776f3530645c
