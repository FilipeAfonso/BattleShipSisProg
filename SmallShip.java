import java.util.Random;

public class SmallShip {
	
	public static int firstSmallShip(int reference){
		
		Random smallShip = new Random();
		
		int position;
		
		
		if(reference != 18){
			do{
				
				position = smallShip.nextInt(20);
				
			}while((position == reference)||(position == reference + 1)||(position == reference + 2)||(position+1 == reference)||(position+2 == reference + 1)||(position+3 == reference + 2));
		}else{
			do{
				
				position = smallShip.nextInt(20);
				
			}while((position == reference)||(position == reference + 1)||(position == reference + 2)||(position+1 == reference)||(position+2 == reference + 1)||(position+3 == reference + 2)||(position == 19));
			
		}
		return position;
	}
}