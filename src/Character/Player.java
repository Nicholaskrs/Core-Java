package Character;

import State.AttackState;
import State.IdleState;
import State.InvicibleState;

public class Player  extends Character{

	
	public int range=30;
	public Player(int x, int y, String path, int width, int height) {
		super(x, y, path, width, height);
		speed=10;
		// TODO Auto-generated constructor stub
	}
	int invicibleCounter=15;
	public boolean isInvicible=false;
	@Override
	public void update() {
		if(isInvicible){
		invicibleCounter--;
		if(invicibleCounter==0){
			isInvicible=false;
			invicibleCounter=10;
		}
		}
		// TODO Auto-generated method stub
		if(this.getState()==AttackState.getInstance()){
			attack();
		}
		else if(this.getState()==IdleState.getInstance()){
			idle();
		}
		if(hp==0){
			die();
		}
		
		
		
	}


	

}
