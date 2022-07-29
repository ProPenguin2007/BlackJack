import java.util.Random;

//import Card.Suite;
public class Deck extends Hand {

        public Deck() {
                super(52);
                count = 52;
                for (int i = 0; i < 13; i += 1) {
                        deckOfCards[i] = new Card(Card.Suite.HEARTS, i + 1);
                        deckOfCards[i + 13] = new Card(Card.Suite.DIAMONDS, i + 1);
                        deckOfCards[i + 26] = new Card(Card.Suite.CLUBS, i + 1);
                        deckOfCards[i + 39] = new Card(Card.Suite.SPADES, i + 1);
                }
        }

        public void shuffle() {
                Random rand = new Random();
                for (int i = 0; i < 5200; i++) {
                        int num1 = rand.nextInt(count);
                        int num2 = rand.nextInt(count);
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

        public Hand deal(int handSize) {
                shuffle();
                Hand hand1 = new Hand(52);
                for (int i = 0; i < handSize; i++) {
                        hand1.deckOfCards[i] = popCard();
                        hand1.count++;
                }

                return hand1;
        }

}
