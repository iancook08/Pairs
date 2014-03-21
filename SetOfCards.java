public class SetOfCards {

    final static int cardsNumber = 16;
    
    public static void main (String[] args)
    {
      Card[] card_list = new Card[cardsNumber];
      
      for(int i=0 ; i<cardsNumber ; i=i+2) {
          card_list[i]= new Card();
          card_list[i+1]= new Card(card_list[i].getCardString());
          System.out.println("Card "+(i+1) + ": "+ card_list[i].getCardString());
          System.out.println("Card "+(i+2) + ": "+ card_list[i+1].getCardString());
      }
    }
}
