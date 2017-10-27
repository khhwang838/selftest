package image;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class ImageSize {
	
	public static void main(String[] args) throws IOException {
		
		URL url = new URL("http://cdn.gamemeca.com/gmdb/g000/28/35/221151(0).jpg");
		BufferedImage img = ImageIO.read(url);
		
		System.out.println(img.getWidth());
		System.out.println(img.getHeight());
		
		
	}
	
}
