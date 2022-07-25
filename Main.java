
public class Main {
    public static void main(String args[]) {
        //Deck deck = new Deck();
        BlackJack game = new BlackJack();
        //Card card = new Card(Card.Suite.HEARTS,9);
        // deck.shuffle();
        // Card y = deck.popCard();
        // deck.addCard(y, 25 );
        // for (int i = 0; i < 52; i++) {
        //     if (deck.deckOfCards[i] != null) {
        //         System.out.println(deck.deckOfCards[i].cardSuite);
        //         System.out.println(deck.deckOfCards[i].cardNum);
        //     }
        //     else {
        //         System.out.println("There is no card here!");
        //     }
            
        // }
        //Card y = new Card(Card.Suite.SPADES,12);
        
        game.Game();
        // System.out.println(deck.toString());
        
    }
}
