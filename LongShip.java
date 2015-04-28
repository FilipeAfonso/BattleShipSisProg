
import java.util.Random;

public class LongShip {
	
	private int reference;
	private int health = 3;
	
	public void create(){
				
		Random rand = new Random();
		
		reference = rand.nextInt(20);

	}
	
	public int getRef() {
		return reference;
	}
	
	public int getHealth() {
		return health;
	}
	
	public void beAttacked() {
		health--;
	}
}
