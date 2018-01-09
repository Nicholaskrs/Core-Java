package Character;

import java.awt.Dimension;
import java.awt.Image;
import java.util.ArrayList;

import State.DieState;
import State.IdleState;
import State.State;
import Until.Coordinate;
import Until.ImageHelper;


public abstract class Character extends GameObject{
	public class Direction{
		public static final int UP=0;
		public static final int DOWN=1;
		public static final int LEFT=2;
		public static final int RIGHT=3;
		
	}
	
	

	public int speed=5;
	protected State state;
	protected int dir;
	protected int hp;
	protected int atk;
	protected ArrayList<ArrayList<Image>>movement=new ArrayList<>();
	protected ArrayList<Image>idle=new ArrayList<>();
	protected ArrayList<Image> die=new ArrayList<>();
	protected ArrayList<ArrayList<Image>>attack=new ArrayList<>();
	protected int count=0;

	public Character(int x,int y, String path,int width,int height) {
		insertImage(path);
		dir=Direction.DOWN;
		image=idle.get(dir);
		coordiante=new Coordinate(x, y);
		size=new Dimension(width, height);
		hp=3;
		
	}
	public void attack(){
		
		image=attack.get(dir).get(count);
		if(count==attack.get(dir).size()-1) {state=IdleState.getInstance(); count=0;}
		
		count++;
		
	}
	public void idle(){
		image=idle.get(dir);
		count=0;
	}
	public void move(Coordinate coor){
		int prevdir=dir;
		dir=getDirection(coor);
		if(count==movement.get(dir).size()-1)count=-1;
		if(prevdir!=dir)count=-1;
			count++;
		image=movement.get(dir).get(count);
		
		this.coordiante=coor;
	}
	public void die(){
		image=die.get(count);
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
		else if(coor.x<coordiante.x){
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
		insertDieImage(path+"/Dead");
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
		die=imageHelper.getAllImagesFromDirectory(path);
	}
	
	public int getDir() {
		return dir;
	}
	public void setDir(int dir) {
		this.dir = dir;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
		if(this.hp==0){
			count=0;
		}
	}
	public int getAtk() {
		return atk;
	}
	public void setAtk(int atk) {
		this.atk = atk;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		if(this.state!=state)count=0;
		this.state = state;
	}
	
	

}
