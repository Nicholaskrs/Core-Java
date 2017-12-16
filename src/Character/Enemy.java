package Character;

public class Enemy extends Character{

	Player target;
	
	public Enemy(int x, int y, String path, int width, int height,Player target) {
		super(x, y, path, width, height);
		speed=8;
		// TODO Auto-generated constructor stub
		this.target=target;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}


}
