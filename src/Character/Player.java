package Character;

import State.AttackState;
import State.IdleState;

public class Player  extends Character{

	
	public int range=40;
	public Player(int x, int y, String path, int width, int height) {
		super(x, y, path, width, height);
		speed=10;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		if(this.getState()==AttackState.getInstance()){
			attack();
		}
		else if(this.getState()==IdleState.getInstance()){
			idle();
		}
		
	}


	

}
