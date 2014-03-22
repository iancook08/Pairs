import java.util.Scanner;

public class Play {
	
		public static void printGameStateTerminal (SetOfCards game) {
			String[][] matrix = game.getMatrix();
			
			System.out.println("\nNumber of Tries: "+game.getNumberOfTries()+"\n");
	    		for (int i=0 ; i<matrix.length ; i++) {   
			    	for(int j=0 ; j<matrix[i].length ; j++) {
			    		System.out.printf("%10s", matrix[i][j]);
			    	}
		    	System.out.println();
	    		}
	    		if (game.win())
				System.out.println("\nCongratulation, you won !");
	    		else
				System.out.println("\nAt this time, you have not win yet.");
		}

		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			SetOfCards game = new SetOfCards();
			
			System.out.println(game);
			game.shakeMatrix();
			System.out.println(game);
			
			System.out.println("***** Beginning *****");
			printGameStateTerminal(game);
			
			while (!game.win()) {
				System.out.print("Case numbers: ");
				while (!game.click1(sc.nextInt(), sc.nextInt())) {
					System.out.print("Error, case numbers: ");
				}
				printGameStateTerminal(game);
				System.out.print("Case numbers: ");
				while (!game.click2(sc.nextInt(), sc.nextInt())) {
					System.out.print("Error, case numbers: ");
				}
				printGameStateTerminal(game);
				if (game.getClock()) {
					try {
						Thread.sleep(2000); //sleep for 2s
						game.endClock();
						printGameStateTerminal(game);
					}
					catch(Exception ie){}
				}
			}
			System.out.println("***** End *****");
		}
}
