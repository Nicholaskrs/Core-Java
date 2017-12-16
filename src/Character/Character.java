package Character;

import java.awt.Image;
import java.util.ArrayList;

import Until.ImageHelper;


public abstract class Character {
	public class Direction{
		public static final int UP=0;
		public static final int DOWN=1;
		public static final int LEFT=2;
		public static final int RIGHT=3;
		
	}
	public class Coordinate{
		public Coordinate(int x,int y) {
			this.x=x;
			this.y=y;
			// TODO Auto-generated constructor stub
		}
		public int x,y;

		
		
	}
	protected int dir;
	protected int hp;
	protected int atk;
	protected Coordinate coordiante;
	protected ArrayList<ArrayList<Image>>movement;
	protected ArrayList<Image>idle;
	protected Image die;
	protected ArrayList<ArrayList<Image>>attack;
	protected Image current;	
	protected int count=0;

	public Character(int x,int y, String path) {
		dir=Direction.DOWN;
		current=idle.get(dir);
		coordiante=new Coordinate(x, y);
		insertImage(path);
		
	}
	public void attack(){
		current=attack.get(dir).get(count);
		count=0;
	}
	public void idle(){
		current=idle.get(dir);
		count=0;
	}
	public void move(Coordinate coor){
		current=movement.get(dir).get(count);
		count++;
	}
	public int getDirection(Coordinate coor){
		if(coor.x>coordiante.x){
			return Direction.RIGHT;
		}
		else if(coor.y>coordiante.y){

			return Direction.DOWN;
		}
		else if(coor.y<coordiante.y){
			return Direction.UP;
		}
		else if(coor.x>coordiante.x){
			return Direction.LEFT;
		}
		else if(coor.x==coordiante.x&& coor.y==coordiante.y){
			return dir;
		}
		return -1;
	}

	private ImageHelper imageHelper=new ImageHelper();
	
	public void insertImage(String path){
		insertAttackImage(path+"/Attack");
		insertDieImage(path+"/Die");
		insertIdleImage(path+"/Idle");
		insertMovementImage(path+"/Move");
		
	}
	
	public void insertMovementImage(String path){
		addAllDirection(movement, path);
	}
	public void addAllDirection(ArrayList<ArrayList<Image>> images,String path){
		images.add(Direction.UP, imageHelper.getAllImagesFromDirectory(path+"/UP"));
		images.add(Direction.DOWN, imageHelper.getAllImagesFromDirectory(path+"/DOWN"));
		images.add(Direction.LEFT, imageHelper.getAllImagesFromDirectory(path+"/LEFT"));
		images.add(Direction.RIGHT, imageHelper.getAllImagesFromDirectory(path+"/RIGHT"));
	}
	
	public void insertAttackImage(String path){
		addAllDirection(attack, path);
	}
	public void insertIdleImage(String path){
		idle.add(Direction.UP, imageHelper.getAllImagesFromDirectory(path+"/UP").get(0));
		idle.add(Direction.DOWN, imageHelper.getAllImagesFromDirectory(path+"/DOWN").get(0));
		idle.add(Direction.LEFT, imageHelper.getAllImagesFromDirectory(path+"/LEFT").get(0));
		idle.add(Direction.RIGHT, imageHelper.getAllImagesFromDirectory(path+"/RIGHT").get(0));
	}
	public void insertDieImage(String path){
		die=imageHelper.getAllImagesFromDirectory(path).get(0);
	}
	
	
	
	

}
