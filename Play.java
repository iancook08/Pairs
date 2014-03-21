public class Play {
	
	public static void printGameStateTerminal (SetOfCards game) {
		String[][] matrix = game.getMatrix();
		int j=0;
		System.out.println("\nNumber of Tries: "+game.getNumberOfTries()+"\n");
		
    	for (int i=0 ; i<matrix.length ; i++) {   
	    	for(j=0 ; j<matrix[i].length ; j++) {
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
		SetOfCards game = new SetOfCards();
		System.out.println(game);
		game.shakeMatrix();
		System.out.println(game);
		
		System.out.println("***** Beginning *****");
		printGameStateTerminal(game);
	}
}
