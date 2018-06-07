import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game implements Runnable {
	private Display display;
	private int width, height;
	private String title;
	
	private Thread thread;
	private boolean running = false; 
	
	private BufferStrategy bs;
	private Graphics g;
	
	//States
	private State gameState;
	private State menuState;
	private State gameMenuState;
	private State scoresState;
	
	//Input
	private KeyManager keyManager;
	private MouseManager mouseManager;
	
	private HighScore highScore;
	
	//Input, Output for Highscore
	
	private WFile writeFile;
	private RFile readFile;
	
	//Camera
	private GameCamera gameCamera;
	
	//Handler
	
	Handler handler;
	
	public Game(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
	}

	public WFile getWriteFile() {
		return writeFile;
	}

	public void setWriteFile(WFile writeFile) {
		this.writeFile = writeFile;
	}

	public RFile getReadFile() {
		return readFile;
	}

	public void setReadFile(RFile readFile) {
		this.readFile = readFile;
	}

	public void init() {
		
		
		keyManager = new KeyManager();
		mouseManager = new MouseManager();
		
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		Assets.init(); 	
		
		handler = new Handler(this);
		gameCamera = new GameCamera(handler, 0, 0);
		
		readFile = new RFile("HighScore.txt");
		writeFile = new WFile("HighScore.txt");
		
		highScore = new HighScore(handler);
		
		//gameState = new GameState(handler, 1);
		menuState = new MenuState(handler);
		gameMenuState = new GameMenuState(handler);
		scoresState = new ScoresState(handler);
		
		State.setState(menuState);
	}
	
	public State getScoresState() {
		return scoresState;
	}

	public void setScoresState(State scoresState) {
		this.scoresState = scoresState;
	}

	public HighScore getHighScore() {
		return highScore;
	}

	public void setHighScore(HighScore highScore) {
		this.highScore = highScore;
	}

	public State getGameMenuState() {
		return gameMenuState;
	}

	public void setGameMenuState(State gameMenuState) {
		this.gameMenuState = gameMenuState;
	}

	public State getGameState() {
		return gameState;
	}

	public void setGameState(State gameState) {
		this.gameState = gameState;
	}

	public State getMenuState() {
		return menuState;
	}

	public void setMenuState(State menuState) {
		this.menuState = menuState;
	}

	public void tick() {
		keyManager.tick();
		if(State.getState() != null) {
			State.getState().tick();
		}
	}
	
	public void render() {
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null)
		{
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		//Clear Screen
		g.clearRect(0, 0, width, height);
		//Draw here!
		if(State.getState() != null) {
			State.getState().render(g);
		}
		
		
		//End draw!
		
		bs.show();
		g.dispose();
		
	}

	public void run() {
		init();
		
		double fps = 100.0;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		while(running)
		{
			long now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			if(delta >= 1)
			{
				tick();
				render();
				ticks++;
				delta--;
			}
			render();
			if(timer >= 1000000000)
			{
				System.out.println("Ticks and frames: " + ticks);
				
				timer = 0;
				ticks = 0;
			}
		}
		stop(); 
	}
	
	public KeyManager getKeyManager() {
		return keyManager;
	}
	
	public MouseManager getMouseManager() {
		return mouseManager;
	}
	
	public GameCamera getGameCamera() {
		return gameCamera;
	}
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public synchronized void start()
	{
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop() {
		if(!running)
			return;
		
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
