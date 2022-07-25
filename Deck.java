import java.util.Random;

//import Card.Suite;
public class Deck {
        
        public Card[] deckOfCards = new Card[52];
        
        public Deck() {
                
                for (int i = 0; i < 13;i += 1) {
                        deckOfCards[i] = new Card(Card.Suite.HEARTS,i + 1);
                        deckOfCards[i + 13] = new Card(Card.Suite.DIAMONDS,i + 1);
                        deckOfCards[i + 26] = new Card(Card.Suite.CLUBS,i + 1);
                        deckOfCards[i + 39] = new Card(Card.Suite.SPADES,i + 1);
                }
        }
        public void shuffle() {
                Random rand = new Random();
                for (int i = 0; i < 5200;i++) {
                        int num1 = rand.nextInt(52);
                        int num2 = rand.nextInt(52);
                        Card x = deckOfCards[num1];
                        Card y = deckOfCards[num2];
                        Card c = x;
                        x = y;
                        y = c;
                        
                        Card z = deckOfCards[num1];
                        deckOfCards[num1] = deckOfCards[num2];
                        deckOfCards[num2] = z;

                        
                }
        }
        public int count = 51;
        public Card popCard() {

                Card poppedCard = deckOfCards[count];
                deckOfCards[count] = null;
                count--;
                return poppedCard;
        }

        public void addCard(Card newCard, int deckArea) {
                //int t = deckArea;
                //Card z = deckOfCards[t];
                //deckOfCards[deckArea + 1] = deckOfCards[deckArea];
                count++;
                for (int i = 0; count - i != deckArea; i++) {
                        deckOfCards[count - i] = deckOfCards[count - i - 1];
                        //t++;
                }
                deckOfCards[deckArea] = newCard;
                //deckOfCards[count] = 
                
        }

        // public String toString() {
        //         String output = "";
        //         for (int i = 0; i < count + 1; i++) {
        //                 if (deckOfCards[i].cardSuite == null) {
        //                         System.out.println(deckOfCards[i - 1].cardNum + " " + deckOfCards[i - 1].cardSuite);
        //                 }
        //                 else {
        //                         output += deckOfCards[i].toString();
        //                 }
                        
                        
        //         }
        //         return output;
        // }

        
}
