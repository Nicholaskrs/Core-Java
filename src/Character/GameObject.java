package Character;

import java.awt.Dimension;
import java.awt.Image;

import Until.Coordinate;


public abstract class GameObject {
	

	protected Dimension size;
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
	public Dimension getSize() {
		return size;
	}
	public void setSize(Dimension size) {
		this.size = size;
	}
	public abstract void update();

}
