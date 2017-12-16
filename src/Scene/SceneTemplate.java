package Scene;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.JFrame;

import Character.Character;
import Character.GameObject;

public abstract class SceneTemplate extends JFrame{
	
	
	public SceneTemplate(Image backGroundImage) {
		this.backgroundImage=backGroundImage;
		setSize(800,600);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public ArrayList<GameObject>gameObjects=new ArrayList<>();
	protected Image backgroundImage;
	
 
	public Image getBackgroundImage() {
		return backgroundImage;
	}

	public void setBackgroundImage(Image backgroundImage) {
		this.backgroundImage = backgroundImage;
	}

	public void update(){
		for (GameObject gameObject : gameObjects) {
			gameObject.update();
		}
	}
	
	
	public void add(GameObject gameObject){
		gameObjects.add(gameObject);
	}
	
	@Override
	public void repaint() {
		// TODO Auto-generated method stub
		super.repaint();
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.drawImage(backgroundImage,0,0,this.getWidth(),getHeight(),null);
		for (GameObject gameObject2 : gameObjects) {
			g.drawImage(gameObject2.getImage(),gameObject2.getCoordiante().x, gameObject2.getCoordiante().y, null);
		}
		
	}

}
