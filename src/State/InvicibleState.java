package State;

public class InvicibleState extends State {
	private static InvicibleState InvicibleState=new InvicibleState();
	private InvicibleState(){
		
	}
	public static InvicibleState getInstance(){
		return InvicibleState;
	}
}
