import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 32, height = 32;
	
	public static BufferedImage dirt, stone, tree, grass, player;
	public static BufferedImage arrow_up, arrow_down, arrow_left, arrow_right;
	public static BufferedImage[] player_down;
	public static BufferedImage[] player_up;
	public static BufferedImage[] player_left;
	public static BufferedImage[] player_right;
	
	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));
		SpriteSheet arrow_up_Sheet = new SpriteSheet(ImageLoader.loadImage("/textures/arrow_up.png"));
		SpriteSheet arrow_down_Sheet = new SpriteSheet(ImageLoader.loadImage("/textures/arrow_down.png"));
		SpriteSheet arrow_left_Sheet = new SpriteSheet(ImageLoader.loadImage("/textures/arrow_left.png"));
		SpriteSheet arrow_right_Sheet = new SpriteSheet(ImageLoader.loadImage("/textures/arrow_right.png"));
		player_down = new BufferedImage[2];
		player_up = new BufferedImage[2];
		player_left = new BufferedImage[2];
		player_right = new BufferedImage[2];
		
		player_down[0] = sheet.crop(width * 4, 0, width, height);
		player_down[1] = sheet.crop(width * 5, 0, width, height);
		
		player_up[0] = sheet.crop(width * 6, 0, width, height);
		player_up[1] = sheet.crop(width * 7, 0, width, height);
		
		player_right[0] = sheet.crop(width * 4, height, width, height);
		player_right[1] = sheet.crop(width * 5, height, width, height);
		
		player_left[0] = sheet.crop(width * 6, height, width, height);
		player_left[1] = sheet.crop(width * 7, height, width, height);
		
		
		
		dirt = sheet.crop(width, 0, width, height);
		grass = sheet.crop(2 * width, 0, width, height);
		stone = sheet.crop(3 * width, 0, width, height);
		tree = sheet.crop(0, 0, width, height);
		
		arrow_up = arrow_up_Sheet.crop(0, 0, width, height);
		arrow_down = arrow_down_Sheet.crop(0, 0, width, height);
		arrow_left = arrow_left_Sheet.crop(0, 0, width, height);
		arrow_right = arrow_right_Sheet.crop(0, 0, width, height);
		
	}
}
