package Character;

import java.awt.Image;

import Until.Coordinate;


public abstract class GameObject {
	

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
