package zenoNK;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Scene.GameScene;

public class Main {
	public Main() {
		File jpegFile = new File("Images/Background/background.jpg");
		BufferedImage image=null;
		try {
			image = ImageIO.read(jpegFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new GameScene(image);
	}
	public static void main(String[] args) {
		new Main();
	}

}
