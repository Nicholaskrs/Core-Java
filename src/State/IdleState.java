package State;

public class IdleState extends State{
	private static IdleState Instance=new IdleState();
	private IdleState(){
		
	}
	public static IdleState getInstance(){
		return Instance;
	}
}
