package Character;

import Until.Coordinate;

public class Enemy extends Character{

	Player target;
	
	public Enemy(int x, int y, String path, int width, int height,Player target) {
		super(x, y, path, width, height);
		speed=5;
		// TODO Auto-generated constructor stub
		this.target=target;
	}

	@Override
	public void update() {
		/*
		int xdif=target.coordiante.x-coordiante.x;
		int ydif=target.coordiante.y-coordiante.y;
		if(xdif!=0){
				if(xdif<speed)
					move(new Coordinate(coordiante.x+xdif, coordiante.y));
				else 
					move(new Coordinate(coordiante.x+speed, coordiante.y));
			
		}else if(ydif!=0){
				if(ydif<speed)
					move(new Coordinate(coordiante.x, coordiante.y+ydif));
				else 
					move(new Coordinate(coordiante.x, coordiante.y+speed));
		}
		*/
		
//		
	}


}
