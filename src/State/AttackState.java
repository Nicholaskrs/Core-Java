package State;

public class AttackState extends State{
	private static AttackState attackState=new AttackState();
	private AttackState(){
		
	}
	public static AttackState getInstance(){
		return attackState;
	}
	
}
