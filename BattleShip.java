import java.util.Scanner;

public class BattleShip {
	
	public static void main (String[] args){
		
		Scanner in = new Scanner(System.in);
		
		int secondReference;
		int reference;
		int palpite = -1;
		int smallHealth = 2;
		int longHealth = 3;
		int tries = 0;
		int[] verificadorAcerto = {0, 0, 0, 0, 0};
		int[] verificador = {0, 0, 0};
		int[] grid = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		int[] verificadorAgua = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		
		reference = LongShip.firstLongShip();
		secondReference = SmallShip.firstSmallShip(reference);
		
		grid[reference] = 1;
		
		if(Limit.limitLong(reference) == 0){
			grid[reference + 1] = 2;
			grid[reference + 2] = 3;
		}else{
			grid[reference - 1] = 2;
			grid[reference - 2] = 3;
		}
		
		grid[secondReference] = 4;
		
		if(Limit.limitSmall(secondReference) == 0){
			grid[secondReference + 1] = 5;
		}else{
			grid[secondReference - 1] = 5;
		}
		
		do{
			do{
				System.out.println("Digite um numero inteiro de 0 a 19, o qual correspondera a sua tentativa de acertar o navio numa matriz 1x20: ");
				palpite = in.nextInt();
			
			}while (!((palpite >= 0) && (palpite <= 19)));
		
			if(grid[palpite] != 0){
				if(grid[palpite] == 4){
					if(verificadorAcerto[0] == 0){
						verificadorAcerto[0] = 1;
						smallHealth --;
						System.out.println("Você acertou uma embarcacao!");
					}else{
						System.out.println("Você já disse esse número. Insira um diferente e válido desta vez");
					}
				}else if(grid[palpite] == 5){
					if(verificadorAcerto[1] == 0){
						verificadorAcerto[1] = 1;
						smallHealth --;
						System.out.println("Você acertou uma embarcacao!");
					}else{
						System.out.println("Você já disse esse número. Insira um diferente e válido desta vez");
					}
				}else if(grid[palpite] == 1){
					if(verificadorAcerto[2] == 0){
						verificadorAcerto[2] = 1;
						longHealth --;
						System.out.println("Você acertou uma embarcacao!");
					}else{
						System.out.println("Você já disse esse número. Insira um diferente e válido desta vez");
					}
				}else if(grid[palpite] == 2){
					if(verificadorAcerto[3] == 0){
						verificadorAcerto[3] = 1;
						longHealth --;
						System.out.println("Você acertou uma embarcacao!");
					}else{
						System.out.println("Você já disse esse número. Insira um diferente e válido desta vez");
					}
				}else if(grid[palpite] == 3){
					if(verificadorAcerto[4] == 0){
						verificadorAcerto[4] = 1;
						longHealth --;
						System.out.println("Você acertou uma embarcacao!");
					}else{
						System.out.println("Você já disse esse número. Insira um diferente e válido desta vez");
					}
				}
			}else{
				if(verificadorAgua[palpite] == 0){
					verificadorAgua[palpite] = 1;
					System.out.println("Agua!");
				}else{
					System.out.println("Você já disse esse número. Insira um diferente e válido desta vez");
				}
			}
		
			tries ++;
		
			if((smallHealth == 0)&&(verificador[0] == 0)){
				verificador[0] = 1;
				System.out.println("Parabens! Voce destruiu um Destroyer (navio que ocupa dois espacos)");
			}
			if((longHealth == 0)&&(verificador[1] == 0)){
				verificador[1] = 1;
				System.out.println("Parabens! Voce destruiu um Cruzador (navio que ocupa tres espacos)");
			}
			if((verificador[0] == 1)&&(verificador[1] == 1)){
				verificador[2] = 1;
				System.out.println("Parabens! Voce destruiu todas as embarcacoes!");
				System.out.println("Voce utilizou " + tries + " jogadas.");
			}
		}while(verificador[2] == 0);
	}

}
