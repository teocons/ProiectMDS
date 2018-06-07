<<<<<<< HEAD
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {
	public static BufferedImage loadImage(String path) {
		try {
			return ImageIO.read(ImageLoader.class.getResource(path));
		} catch (IOException e) {
 			e.printStackTrace();
 			System.exit(1);
		}
		return null;
	}
}
=======
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {
	public static BufferedImage loadImage(String path) {
		try {
			return ImageIO.read(ImageLoader.class.getResource(path));
		} catch (IOException e) {
 			e.printStackTrace();
 			System.exit(1);
		}
		return null;
	}
}
>>>>>>> 14557669d7293f081c910e1211d3776f3530645c
