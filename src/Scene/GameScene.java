package Scene;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Character.Player;

public class GameScene extends SceneTemplate implements KeyListener{

	public GameScene(Image backGroundImage) {
		super(backGroundImage);
		addKeyListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new Player(10,10,"Images/Character",10,10));
		repaint();
		// TODO Auto-generated constructor stub
	}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		repaint();
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
