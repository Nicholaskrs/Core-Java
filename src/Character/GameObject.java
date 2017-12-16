package Character;

import java.awt.Image;

import Character.GameObject.Coordinate;

public abstract class GameObject {
	public class Coordinate{
		public Coordinate(int x,int y) {
			this.x=x;
			this.y=y;
			// TODO Auto-generated constructor stub
		}
		public int x,y;

		
		
	}

	protected Coordinate coordiante;
	protected Image image;

	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	public Coordinate getCoordiante() {
		return coordiante;
	}
	public void setCoordiante(Coordinate coordiante) {
		this.coordiante = coordiante;
	}
	public abstract void update();

}
