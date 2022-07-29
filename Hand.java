import java.util.Random;

public class Hand {

    public int count = 0;
    public Card[] deckOfCards = new Card[count];

    public Hand(int handSize) {
        deckOfCards = new Card[handSize];
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

    public Card popCard() {
        if (count != 0) {
            Card poppedCard = deckOfCards[count - 1];
            deckOfCards[count - 1] = null;
            count--;
            return poppedCard;
        }
        else {
            return null;
        }

    }

    public void addCard(Card newCard, int deckArea) {
        // int t = deckArea;
        // Card z = deckOfCards[t];
        // deckOfCards[deckArea + 1] = deckOfCards[deckArea];
        count++;
        for (int i = 0; count - 1 - i != deckArea; i++) {
            deckOfCards[count - i - 1] = deckOfCards[count - i - 2];
            // t++;
        }
        deckOfCards[deckArea] = newCard;
        // deckOfCards[count] =

    }

    public String toString() {
        String output = "Hand -";
        for (int i = 0; i < count; i++) {
            if (deckOfCards[i].cardSuite == null) {
                System.out.println(deckOfCards[i - 1].cardNum + " " + deckOfCards[i - 1].cardSuite);
            } else {
                output += deckOfCards[i].toString();
            }

        }
        return output;
    }
}
