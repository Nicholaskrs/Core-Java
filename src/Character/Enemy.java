package Character;

import State.DieState;
import State.IdleState;
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
	
		if(getState()==DieState.getInstance()){
			image=die.get(0);
			return;
		}
		int xdif=target.coordiante.x+target.getSize().width/4-coordiante.x;
		int ydif=target.coordiante.y+target.getSize().height/4-coordiante.y;
		if(xdif!=0){
				if(Math.abs(xdif)<speed)
					move(new Coordinate(coordiante.x+xdif, coordiante.y));
				else {
					if(xdif>0){
					move(new Coordinate(coordiante.x+speed, coordiante.y));
					}
					else
						move(new Coordinate(coordiante.x-speed, coordiante.y));
					
				}
			
		}else if(ydif!=0){
				if(Math.abs(ydif)<speed)
					move(new Coordinate(coordiante.x, coordiante.y+ydif));
				else {
					if(ydif>0){
					move(new Coordinate(coordiante.x, coordiante.y+speed));
					}
					else
						move(new Coordinate(coordiante.x, coordiante.y-speed));}
		}
		else
			this.state=IdleState.getInstance();
		
//		
	}


}
