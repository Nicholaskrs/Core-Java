package State;

public class MoveState {
	private static MoveState Instance=new MoveState();
	private MoveState(){
		
	}
	public static MoveState getInstance(){
		return Instance;
	}
}
