public class Card {
    enum Suite {
        SPADES,
        HEARTS,
        DIAMONDS,
        CLUBS
    }
    public Suite cardSuite;
    public int cardNum;

    public Card (Suite suiteOfCard, int numberOfCard) {
        cardSuite = suiteOfCard;
        cardNum = numberOfCard;
    }

    public String toString() {
        String[] royals = {"Jack", "Queen", "King"};
        String output = "";
        output += "Card: " + (cardNum > 10? royals[this.cardNum - 11]:(this.cardNum == 1? "Ace": this.cardNum) ) + " of " + cardSuite;
        return output;
    }
}

