package Scene;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import Character.Character;
import Character.Enemy;
import Character.GameObject;
import Character.Player;
import State.AttackState;
import State.DieState;
import State.MoveState;
import Until.Coordinate;
import javafx.scene.input.KeyCode;

public class GameScene extends SceneTemplate implements KeyListener{
	Player player;
	public GameScene(Image backGroundImage) {
		super(backGroundImage);
		addKeyListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		player=new Player(20,10,"Images/Character",10,10);
		add(player);
		repaint();
		while(player.getHp()!=0){
			try {
				Thread.sleep(500);
				this.update();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// TODO Auto-generated constructor stub
	}
	int enemyCountDown=29;
	@Override
	public void update() {
		// TODO Auto-generated method stub
		super.update();
		if(enemyCountDown==30){
			enemyCountDown=31;
			add(new Enemy(10,10,"Images/Enemy",10,10,player));
		}
		else
		enemyCountDown++;
		
		if(player.getState()==AttackState.getInstance()){
			int playerx=player.getCoordiante().x;
			int playery=player.getCoordiante().y;
			int playerUntily=0;
			int playerUntilx=0;
			if(player.getDir()==Character.Direction.UP){			
				playerUntily=playery-player.range;
				playerUntilx=playerx+player.range;
				playerx-=player.getSize().width;
				}
			if(player.getDir()==Character.Direction.DOWN){		
				playerUntily=playery+player.range;
				playerUntilx=playerx+player.range;
				playery=player.getCoordiante().y-player.getSize().height;
				}
			if(player.getDir()==Character.Direction.LEFT){	
				playerUntily=playery+player.range;
				playerUntilx=playerx-player.range;
				playerx-=player.getSize().width;
				}
			if(player.getDir()==Character.Direction.RIGHT){
				playerUntilx=playerx+player.range;
				playerUntily=playery+player.range;
				playerx=player.getCoordiante().x+player.getSize().width;
			}
			ArrayList<GameObject>removedGameObject=new ArrayList<>();
			for (GameObject gameObject : gameObjects) {
				
				if(gameObject.getClass()==Enemy.class){
					if(isBetween(playerx, playerUntilx, gameObject.getCoordiante().x)&& isBetween(playery,playerUntily, gameObject.getCoordiante().y)){
						((Enemy)gameObject).setState(DieState.getInstance());
						removedGameObject.add(gameObject);
					}
				}
			}
			for (GameObject gameObject : removedGameObject) {
				gameObjects.remove(gameObject);
			}

		}
		
		repaint();
		
	}
	public boolean isBetween(int start,int end,int number){
		if(start<end)
		{
			start=start^end;
			end=start^end;
			start=start^end;
		}
		if(number<=start && number>=end)
			return true;
		return false;
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
				player.setState(AttackState.getInstance());repaint();
			}
			else if(e.getKeyCode()==KeyEvent.VK_A){

				player.setState(MoveState.getInstance());
				player.move(new Coordinate(player.getCoordiante().x-player.speed, player.getCoordiante().y));
				repaint();
			}
			else if(e.getKeyCode()==KeyEvent.VK_W){
				player.setState(MoveState.getInstance());
				player.move(new Coordinate(player.getCoordiante().x, player.getCoordiante().y-player.speed));repaint();
			}
			else if(e.getKeyCode()==KeyEvent.VK_S){
				player.setState(MoveState.getInstance());
				player.move(new Coordinate(player.getCoordiante().x, player.getCoordiante().y+player.speed));repaint();}
			else if(e.getKeyCode()==KeyEvent.VK_D){
				player.setState(MoveState.getInstance());
				player.move(new Coordinate(player.getCoordiante().x+player.speed, player.getCoordiante().y));repaint();}
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
