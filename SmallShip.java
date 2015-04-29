
import java.util.Random;

public class SmallShip {
	
	private int reference;
	private int health = 2;
	
	public void create(int ref){
		
		Random rand = new Random();		
		
		if(ref != 18){
			do{
				
				reference = rand.nextInt(20);
				
			}while((reference == ref)||(reference == ref + 1)||(reference == ref + 2)||
					(reference+1 == ref)||(reference+2 == ref + 1)||(reference+3 == ref + 2));
		}else{
			do{
				
				reference = rand.nextInt(20);
				
			}while((reference == ref)||(reference == ref + 1)||(reference == ref + 2)||
					(reference+1 == ref)||(reference+2 == ref + 1)||(reference+3 == ref + 2)||(reference == 19));
			
		}
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