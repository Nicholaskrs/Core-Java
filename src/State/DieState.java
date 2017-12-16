package State;

public class DieState extends State{
	private static DieState dieState=new DieState();
	private DieState(){
		
	}
	public static DieState getInstance(){
		return dieState;
	}
}
