public class Card {
	private static String possibleLetters = "abcdefghijklmnopqrstuvwxyz";
    private String cardString;
    private boolean hidden;
    
    Card () {
		int randomNumber = (int) (Math.random() * (possibleLetters.length()));
		char character = possibleLetters.charAt(randomNumber);
	    this.cardString = Character.toString(character);
		this.hidden = true;
		possibleLetters = possibleLetters.substring(0, randomNumber) + possibleLetters.substring(randomNumber+1);
    }
    
    Card (String cardString) {
		this.cardString = cardString;
		this.hidden = true;
    }
    
    public boolean isHidden () {
        return hidden;
    }
    
    public void hide () {
    	this.hidden = true;   
    }

    public void discover () {
    	this.hidden = false;   
    }

    public String getCardString () {
    	return this.cardString;
    }

    public String toString() {
        return ("Card "+cardString+", hidden: "+ this.hidden);
    }
}
