package Scene;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Character.Player;
import State.AttackState;
import State.MoveState;
import Until.Coordinate;
import javafx.scene.input.KeyCode;

public class GameScene extends SceneTemplate implements KeyListener{
	Player player;
	public GameScene(Image backGroundImage) {
		super(backGroundImage);
		addKeyListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		player=new Player(300,200,"Images/Character",10,10);
		add(player);
		repaint();
		while(player.getHp()!=0){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			update();
		}
		// TODO Auto-generated constructor stub
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		super.update();
		repaint();
		
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
	boolean isAttack=false;
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		if(!isAttack){
			if(e.getKeyCode()==KeyEvent.VK_NUMPAD0){
				isAttack=true;
				player.setState(AttackState.getInstance());
			}
			else if(e.getKeyCode()==KeyEvent.VK_A){

				player.setState(MoveState.getInstance());
				player.move(new Coordinate(player.getCoordiante().x-player.speed, player.getCoordiante().y));
			}
			else if(e.getKeyCode()==KeyEvent.VK_W){
				player.setState(MoveState.getInstance());
				player.move(new Coordinate(player.getCoordiante().x, player.getCoordiante().y-player.speed));
			}
			else if(e.getKeyCode()==KeyEvent.VK_S){
				player.setState(MoveState.getInstance());
				player.move(new Coordinate(player.getCoordiante().x, player.getCoordiante().y+player.speed));}
			else if(e.getKeyCode()==KeyEvent.VK_D){
				player.setState(MoveState.getInstance());
				player.move(new Coordinate(player.getCoordiante().x+player.speed, player.getCoordiante().y));}
		}
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_NUMPAD0){
			isAttack=false;
		}
	}
	

}
