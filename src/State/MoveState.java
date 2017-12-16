package State;

public class MoveState extends State{
	private static MoveState Instance=new MoveState();
	private MoveState(){
		
	}
	public static MoveState getInstance(){
		return Instance;
	}
}
