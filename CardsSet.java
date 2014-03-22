public class CardsSet {

    	final static int cardsPerLine = 4;
    	final static int cardsPerRow = 4;
	private Card[][] card_matrix = new Card[cardsPerLine][cardsPerRow];
	private int numberOfTries;
    
    	SetOfCards () {
	    	int j=0;
	    	for (int i=0 ; i<cardsPerRow ; i++) {   
		    	for(j=0 ; j<cardsPerLine ; j=j+2) {
		    		card_matrix[i][j]= new Card();
		    		card_matrix[i][j+1]= new Card(card_matrix[i][j].getCardString());
		    	}
	    	}
	    	this.numberOfTries = 0;
    	}
    
    	public void shakeMatrix () {
    	/*
    	 *  Let t be a n length table to shake
		 *	for i from n-1 to 2 included, do:
		 *	j = take a random number between 0 and i included
		 *	exchange t[i] and t[j]
		 *	end for
    	 */
	    	int rand;
	    	Card temp;
	    	for(int i= cardsPerLine*cardsPerRow -1 ; i>=2 ; i--) {
	    		rand = (int) (Math.random() * (i+1));
	    		temp = card_matrix[(int) i/cardsPerLine][i%cardsPerLine];
	    		card_matrix[(int) i/cardsPerLine][i%cardsPerLine]=card_matrix[(int) rand/cardsPerLine][rand%cardsPerLine];
	    		card_matrix[(int) rand/cardsPerLine][rand%cardsPerLine] = temp;
	    	}
    	}
    
    	public String[][] getMatrix() {
	    	String[][] matrix = new String [cardsPerLine][cardsPerRow];
	    	int j=0;
	    	for (int i=0 ; i<cardsPerRow ; i++) {   
		    	for(j=0 ; j<cardsPerLine ; j=j+2) {
		    		if (card_matrix[i][j].isHidden())
		    			matrix[i][j]="null";
		    		else
		    			matrix[i][j]=card_matrix[i][j].getCardString();
		    	}
	    	}
	    	return matrix;
    	}
    
    	public int getNumberOfTries() {
    		return this.numberOfTries;
    	}
    
	public boolean win() {
		int j=0;
	    	for (int i=0 ; i<cardsPerRow ; i++) {   
			for(j=0 ; j<cardsPerLine ; j++) {
		    		if (card_matrix[i][j].isHidden())
		    		return false;
		    	}
	    	}
	    	return true;
	}
    
    
    	// public void click1 (int x, int y) (to do)
    	// public void click2 (int x, int y) (to do)

    
    	public String toString() {
	    	String print="";
	    	int j=0;
	    	for (int i=0 ; i<cardsPerRow ; i++) {   
		    	for(j=0 ; j<cardsPerLine ; j++) {
		    		if (card_matrix[i][j].isHidden())
		    		print= print + "Card ("+(i+1) + ","+ (j+1)+ "): "+ card_matrix[i][j].getCardString()+" (hidden)\n";
		    		else
			    	print= print + "Card ("+(i+1) + ","+ (j+1)+ "): "+ card_matrix[i][j].getCardString()+" (visible)\n";
		    	}
	    	}
	    	return print;
    	}
}
