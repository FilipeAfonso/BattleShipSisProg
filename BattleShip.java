
import java.util.Scanner;

public class BattleShip {
	
	public static void main (String[] args){
		
		Scanner in = new Scanner(System.in);
		LongShip lShip = new LongShip();
		SmallShip sShip = new SmallShip();		
		
		int palpite = -1;
		int tries = 0;
		int[] verificadorAcerto = {0, 0, 0, 0, 0};
		int[] verificador = {0, 0, 0};
		int[] grid = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		int[] verificadorAgua = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		
		lShip.create();
		sShip.create(lShip.getRef());
		
		grid[lShip.getRef()] = 1;
		
		if(Limit.limitLong(lShip.getRef()) == 0){
			grid[lShip.getRef() + 1] = 2;
			grid[lShip.getRef() + 2] = 3;
		}else{
			grid[lShip.getRef() - 1] = 2;
			grid[lShip.getRef() - 2] = 3;
		}
		
		grid[sShip.getRef()] = 4;
		
		if(Limit.limitSmall(sShip.getRef()) == 0){
			grid[sShip.getRef() + 1] = 5;
		}else{
			grid[sShip.getRef() - 1] = 5;
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
						sShip.beAttacked();
						System.out.println("Voc� acertou uma embarcacao!");
					}else{
						System.out.println("Voc� j� disse esse n�mero. Insira um diferente e v�lido desta vez");
					}
				}else if(grid[palpite] == 5){
					if(verificadorAcerto[1] == 0){
						verificadorAcerto[1] = 1;
						sShip.beAttacked();
						System.out.println("Voc� acertou uma embarcacao!");
					}else{
						System.out.println("Voc� j� disse esse n�mero. Insira um diferente e v�lido desta vez");
					}
				}else if(grid[palpite] == 1){
					if(verificadorAcerto[2] == 0){
						verificadorAcerto[2] = 1;
						lShip.beAttacked();
						System.out.println("Voc� acertou uma embarcacao!");
					}else{
						System.out.println("Voc� j� disse esse n�mero. Insira um diferente e v�lido desta vez");
					}
				}else if(grid[palpite] == 2){
					if(verificadorAcerto[3] == 0){
						verificadorAcerto[3] = 1;
						lShip.beAttacked();
						System.out.println("Voc� acertou uma embarcacao!");
					}else{
						System.out.println("Voc� j� disse esse n�mero. Insira um diferente e v�lido desta vez");
					}
				}else if(grid[palpite] == 3){
					if(verificadorAcerto[4] == 0){
						verificadorAcerto[4] = 1;
						lShip.beAttacked();
						System.out.println("Voc� acertou uma embarcacao!");
					}else{
						System.out.println("Voc� j� disse esse n�mero. Insira um diferente e v�lido desta vez");
					}
				}
			}else{
				if(verificadorAgua[palpite] == 0){
					verificadorAgua[palpite] = 1;
					System.out.println("Agua!");
				}else{
					System.out.println("Voc� j� disse esse n�mero. Insira um diferente e v�lido desta vez");
				}
			}
		
			tries ++;
		
			if((sShip.getHealth() == 0)&&(verificador[0] == 0)){
				verificador[0] = 1;
				System.out.println("Parabens! Voce destruiu um Destroyer (navio que ocupa dois espacos)");
			}
			if((lShip.getHealth() == 0)&&(verificador[1] == 0)){
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
