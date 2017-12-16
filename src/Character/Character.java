package Character;

import java.awt.Dimension;
import java.awt.Image;
import java.util.ArrayList;

import State.State;
import Until.ImageHelper;


public abstract class Character extends GameObject{
	public class Direction{
		public static final int UP=0;
		public static final int DOWN=1;
		public static final int LEFT=2;
		public static final int RIGHT=3;
		
	}
	
	
	
	protected Dimension size;
	protected State state;
	protected int dir;
	protected int hp;
	protected int atk;
	protected ArrayList<ArrayList<Image>>movement;
	protected ArrayList<Image>idle;
	protected ArrayList<Image> die;
	protected ArrayList<ArrayList<Image>>attack;
	protected int count=0;

	public Character(int x,int y, String path,int width,int height) {
		dir=Direction.DOWN;
		image=idle.get(dir);
		coordiante=new Coordinate(x, y);
		insertImage(path);
		size=new Dimension(width, height);
		
	}
	public void attack(){
		
		image=attack.get(dir).get(count);
		if(count==attack.get(dir).size())count=0;
		
	}
	public void idle(){
		image=idle.get(dir);
		count=0;
	}
	public void move(Coordinate coor){
		if(count==movement.get(dir).size())count=0;
		image=movement.get(dir).get(count);
		count++;
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
		die=imageHelper.getAllImagesFromDirectory(path);
	}
	public Dimension getSize() {
		return size;
	}
	public void setSize(Dimension size) {
		this.size = size;
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
		this.state = state;
	}
	
	

}
