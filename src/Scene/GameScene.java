package Scene;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import Character.Character;
import Character.Enemy;
import Character.GameObject;
import Character.Player;
import State.AttackState;
import State.DieState;
import State.InvicibleState;
import State.MoveState;
import Until.Controller;
import Until.Coordinate;
import javafx.scene.input.KeyCode;
import zenoNK.HighScoreFrame;
import zenoNK.MainFrame;

public class GameScene extends SceneTemplate implements KeyListener{
	Player player;
	int score=0;
	String playerName="";
	
	public GameScene(Image backGroundImage,String name) {
		super(backGroundImage);
		playerName=name;
		setResizable(false);
		
		repaint();  
		// TODO Auto-generated constructor stub
	}
	
	public void gameLoop(){
		this.update();
		if(player.getHp()==0){end=true;
		
		gameObjects.clear();
		gameObjects.add(player);
		this.removeKeyListener(this);
		for(int i=0;i<3;i++){
			this.update();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		JOptionPane.showMessageDialog(null, "You Lose Your Score is:"+score);
		HighScoreFrame.getInstance().addScore(playerName, score, 0);
		HighScoreFrame.getInstance().setVisible(true);
		dispose();
		}
	}
	int enemyCountDown=29;
	int totalEnemy=0;
	@Override
	public void update() {
		// TODO Auto-generated method stub
		super.update();
		if(totalEnemy<10){
			if(enemyCountDown==30){
				totalEnemy++;
				enemyCountDown=0;
				Random rand=new Random();
				int randx=rand.nextInt(800)+30;
				int randy=rand.nextInt(600);
				add(new Enemy(randx,randy,"Images/Enemy",50,50,player));
			}
			else
				enemyCountDown++;
		}
		int playerx=player.getCoordiante().x;
		int playery=player.getCoordiante().y;
		int playerUntily=0;
		int playerUntilx=0;
		
		if(player.getState()==AttackState.getInstance()){
			
			if(player.getDir()==Character.Direction.UP){			
				playerUntily=playery-player.range;
				playerUntilx=playerx+player.range;
				playerx-=player.getSize().width;
				}
			if(player.getDir()==Character.Direction.DOWN){		
				playerUntily=playery+player.range;
				playerUntilx=playerx+player.range;
				playery+=player.getSize().height;
				

				}
			if(player.getDir()==Character.Direction.LEFT){	

				playerUntily=playery+player.range;
				playerUntilx=playerx-player.range;
				}
			if(player.getDir()==Character.Direction.RIGHT){

				playerUntilx=playerx+player.range+player.getSize().width/2;
				playerUntily=playery+player.range;
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
				totalEnemy--;
				gameObjects.remove(gameObject);
				score+=10;
			}
			

		}else{
			if(!player.isInvicible){
				for (GameObject gameObject : gameObjects) {
					
					if(gameObject.getClass()==Enemy.class){
						if(isBetween(player.getCoordiante().x+player.getSize().width/4,player.getSize().width/2+player.getCoordiante().x, gameObject.getCoordiante().x)&& isBetween(playery,playery+player.getSize().height/2, gameObject.getCoordiante().y)){
							player.isInvicible=true;
							player.setHp(player.getHp()-1);
						}
					}
					
				}
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
	Image heartImage=null;
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		if(player!=null){
		for(int i=0;i<player.getHp();i++){
		g.drawImage(heartImage, 60*i+10, 50, 50, 50,null);
		}
		
		g.drawString("Score:", 700, 50);
		g.drawString(""+score,750 ,50);
		
		//(player.getCoordiante().x+,player.getSize().width/2+player.getCoordiante().x, gameObject.getCoordiante().x)&& isBetween(playery,playery+player.getSize().width, gameObject.getCoordiante().y)){
		//g.drawRect(player.getCoordiante().x+player.getSize().width/4, player.getCoordiante().y, player.getSize().width/2,player.getSize().height/2);
		}
		//for (GameObject gameObject : gameObjects) {
		//	g.drawRect(gameObject.getCoordiante().x, gameObject.getCoordiante().y, 10, 10);
			
		//}
		
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
			if(e.getKeyCode()==Controller.ATTACK){
				isAttack=true;
				player.setState(AttackState.getInstance());repaint();
			}
			else if(e.getKeyCode()==Controller.LEFT){
				if(player.getCoordiante().x<=-20)return;
				player.setState(MoveState.getInstance());
				player.move(new Coordinate(player.getCoordiante().x-player.speed, player.getCoordiante().y));
				repaint();
			}
			else if(e.getKeyCode()==Controller.UP){
				if(player.getCoordiante().y<=10)return;
				player.setState(MoveState.getInstance());
				player.move(new Coordinate(player.getCoordiante().x, player.getCoordiante().y-player.speed));repaint();
			}
			else if(e.getKeyCode()==Controller.DOWN){
				if(player.getCoordiante().y>=550)return;
				player.setState(MoveState.getInstance());
				player.move(new Coordinate(player.getCoordiante().x, player.getCoordiante().y+player.speed));repaint();}
			else if(e.getKeyCode()==Controller.RIGHT){
				if(player.getCoordiante().x>=750)return;
				player.setState(MoveState.getInstance());
				player.move(new Coordinate(player.getCoordiante().x+player.speed, player.getCoordiante().y));repaint();}
		}
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==Controller.ATTACK){
			isAttack=false;
		}
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		File jpegFile = new File("Images/Utilities/heart.png");
		try {
			heartImage=ImageIO.read(jpegFile);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		addKeyListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		player=new Player(300,300,"Images/Character",100,80);
		add(player);
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		super.dispose();
	}
	

}
