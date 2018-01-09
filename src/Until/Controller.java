package Until;

import com.sun.glass.events.KeyEvent;

public class Controller {
	public static int ATTACK=KeyEvent.VK_NUMPAD0;
	public static int UP=KeyEvent.VK_W;
	public static int LEFT=KeyEvent.VK_A;
	public static int RIGHT=KeyEvent.VK_D;
	public static int DOWN=KeyEvent.VK_S;
	
	
	public static void setDefaultKey(){
		ATTACK=KeyEvent.VK_NUMPAD0;
		UP=KeyEvent.VK_W;
		LEFT=KeyEvent.VK_A;
		RIGHT=KeyEvent.VK_D;
		DOWN=KeyEvent.VK_S;
	}
}
