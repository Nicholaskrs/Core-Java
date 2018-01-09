package Scene;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;

import com.sun.istack.internal.FragmentContentHandler;

import Character.Character;
import Character.GameObject;

public abstract class SceneTemplate extends JFrame{
	boolean end=false;
	Thread thread;
	private int FPS=15;
	public double averageFPS;

	int frameCount=0;
	int maxFrameCount=20;
	public SceneTemplate(Image backGroundImage) {
		this.backgroundImage=backGroundImage;
		setSize(810,630);
		
		
		setLocationRelativeTo(null);
		setVisible(true);
		thread=new Thread(new Runnable() {
			
			@Override
			public void run() {
			long startTime;
			long URDTimeMillis;
			long waitTime;
			long totalTime=0;
			long targetTime=1000/FPS;
				start();
				while(!end){
					startTime=System.nanoTime();
				gameLoop();
				URDTimeMillis=(System.nanoTime()-startTime)/1000000;
				waitTime=targetTime-URDTimeMillis;
				try {
					Thread.sleep(waitTime);
				} catch (Exception e) {
					// TODO: handle exception
				}
				totalTime +=System.nanoTime()-startTime;
				frameCount++;
				if(frameCount==maxFrameCount){
					averageFPS=1000.0/((totalTime/frameCount)/1000000);
					frameCount=0;
					totalTime=0;
				
				}
				
				
				}
			}
		});
		thread.start();
	}
	
	public abstract void gameLoop();
	public abstract void start();
	
	
	
	public Vector<GameObject>gameObjects=new Vector<>();
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
	public void remove(GameObject gameObject){
		gameObjects.remove(gameObject);
	}
	
	@Override
	public void repaint() {
		// TODO Auto-generated method stub
		super.repaint();
	}
	@Override
	public void paintComponents(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponents(g);
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.drawImage(backgroundImage,0,30,800,600,null);

		g.drawString("FPS: "+averageFPS, 700, 600);
		for (GameObject gameObject2 : gameObjects) {
			g.drawImage(gameObject2.getImage(),gameObject2.getCoordiante().x, gameObject2.getCoordiante().y,gameObject2.getSize().width,gameObject2.getSize().height, null);

		}
		
	}

}
