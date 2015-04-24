import java.util.Random;

public class LongShip {
	
	public static int firstLongShip(){
		
		int position;
		
		Random longShip = new Random();
		
		position = longShip.nextInt(20);
		
		return position;
	}

}
