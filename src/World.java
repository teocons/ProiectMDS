import java.awt.Graphics;

public class World {
	
	private int width = 64, height = 64;
	public int getSpawnX() {
		return spawnX;
	}

	public void setSpawnX(int spawnX) {
		this.spawnX = spawnX;
	}

	public int getSpawnY() {
		return spawnY;
	}

	public void setSpawnY(int spawnY) {
		this.spawnY = spawnY;
	}

	private int spawnX, spawnY;
	private int[][] tiles;
	private Handler handler;
	
	public World(Handler handler,String path) {	
		this.handler = handler;
		loadWorld(path);
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH );
		int xEnd = (int) Math.min(width, xStart + handler.getWidth() / Tile.TILEWIDTH + 1);
		int yStart = (int) Math.max(0,  handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
		int yEnd = (int) Math.min(height, yStart + handler.getHeight() / Tile.TILEHEIGHT + 2);
		
		for(int y = yStart; y < yEnd; ++y) {
			for(int x = xStart; x < xEnd; ++x) {
				getTile(x, y).render(g, (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()), (int) (y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
	}
	
	public Tile getTile(int x, int y) {
		if(x < 0 || y < 0 || x >= width || y >= height)
			return Tile.grassTile;
		
		
		Tile t = Tile.tiles[tiles[x][y]]; 
		if(t == null) {
			return Tile.dirtTile;
		}
		return t;
	}
	
	private void loadWorld(String path) {
		MazeGenerator gen = new MazeGenerator(20, 20, 1, 5, 60);

		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = 20;
		height = 20;
		spawnX = 45;
		spawnY = 30;
		
		tiles = gen.generateMaze(1,1);;
		
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
}
