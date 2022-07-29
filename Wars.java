public class Wars {
    Deck deck = new Deck();
    Hand playerHand = new Hand(52);
    Hand aiHand = new Hand(52);
    Hand tieHand = new Hand(52);

    boolean playing = true;

    public void War() {

        playerHand = deck.deal(26);
        aiHand = deck.deal(26);

        while (playing) {

            // Check if out of cards ---------------
            if (playerHand.count == 0) {
                System.out.println("You Lost the Game!");
                return;
            } else if (aiHand.count == 0) {
                System.out.println("You Won the Game!");
                return;
            }
            // -------------------------------------

            Card playerCard1 = playerHand.popCard();
            Card aiCard1 = aiHand.popCard();

            System.out.println("Player's Card: " + playerCard1);
            System.out.println("AI's Card: " + aiCard1);

            if ((playerCard1.cardNum > aiCard1.cardNum && playerCard1.cardNum != 1 && aiCard1.cardNum != 1) || (playerCard1.cardNum == 1 && aiCard1.cardNum != 1)) {
                System.out.println("You win the round!");
                playerHand.addCard(playerCard1, 0);
                playerHand.addCard(aiCard1, 0);
                System.out.println("Player: " + playerHand.count + " cards \nAI: " + aiHand.count + " cards");
                // Check if out of cards ---------------
                if (aiHand.count == 0) {
                    System.out.println("You Won the Game!");
                    return;
                }
                // -------------------------------------
            } else if ((playerCard1.cardNum < aiCard1.cardNum && aiCard1.cardNum != 1 && playerCard1.cardNum != 1) || (aiCard1.cardNum == 1 && playerCard1.cardNum != 1)) {
                System.out.println("You lose the round!");
                aiHand.addCard(aiCard1, 0);
                aiHand.addCard(playerCard1, 0);
                System.out.println("Player: " + playerHand.count + " cards \nAI: " + aiHand.count + " cards");
                // Check if out of cards ---------------
                if (playerHand.count == 0) {
                    System.out.println("You Lost the Game!");
                    return;
                }
                // -------------------------------------
            } else {
                tieHand.addCard(playerCard1, 0);
                tieHand.addCard(aiCard1, 0);
                while (true) {

                    System.out.println("Tie! \nPlace 3 cards face down!");

                    // Check if out of cards ---------------
                    if (playerHand.count == 0) {
                        System.out.println("You Lost the Game!");
                        return;
                    } else if (aiHand.count == 0) {
                        System.out.println("You Won the Game!");
                        return;
                    }
                    // -------------------------------------

                    // Player tie cards
                    Card playerTie1 = playerHand.popCard();
                    while (playerTie1 == null && playerHand.count > 0) {
                        playerTie1 = playerHand.popCard();
                    }
                    Card playerTie2 = playerHand.popCard();
                    while (playerTie2 == null && playerHand.count > 0) {
                        playerTie2 = playerHand.popCard();
                    }
                    Card playerTie3 = playerHand.popCard();
                    while (playerTie3 == null && playerHand.count > 0) {
                        playerTie3 = playerHand.popCard();
                    }
                    tieHand.addCard(playerTie1, 0);
                    tieHand.addCard(playerTie2, 0);
                    tieHand.addCard(playerTie3, 0);

                    // AI tie cards
                    Card aiTie1 = aiHand.popCard();
                    while (aiTie1 == null && aiHand.count > 0) {
                        aiTie1 = playerHand.popCard();
                    }
                    Card aiTie2 = aiHand.popCard();
                    while (aiTie2 == null && aiHand.count > 0) {
                        aiTie2 = playerHand.popCard();
                    }
                    Card aiTie3 = aiHand.popCard();
                    while (aiTie3 == null && aiHand.count > 0) {
                        aiTie3 = playerHand.popCard();
                    }
                    tieHand.addCard(aiTie1, 0);
                    tieHand.addCard(aiTie2, 0);
                    tieHand.addCard(aiTie3, 0);


                    Card playerTieBreaker = playerHand.popCard();
                    Card aiTieBreaker = playerHand.popCard();

                    System.out.println("Player's Tie Breaker Card: " + playerTieBreaker);
                    System.out.println("AI's Tie Breaker Card: " + aiTieBreaker);

                    tieHand.addCard(playerTieBreaker, 0);
                    tieHand.addCard(aiTieBreaker, 0);

                    // Check if out of cards ---------------
                    if (playerHand.count == 0) {
                        System.out.println("You Lost the Game!");
                        return;
                    } else if (aiHand.count == 0) {
                        System.out.println("You Won the Game!");
                        return;
                    }
                    // -------------------------------------

                    if (playerTieBreaker.cardNum > aiTieBreaker.cardNum || (playerCard1.cardNum == 1 && aiCard1.cardNum != 1)) {
                        System.out.println("You won the tiebreaker!!");
                        while (tieHand.count != 0) {
                            Card moveCard = tieHand.popCard();
                            playerHand.addCard(moveCard, 0);
                        }
                        System.out.println(tieHand.count);
                        System.out.println("Player: " + playerHand.count + " cards \nAI: " + aiHand.count + " cards");
                        // Check if out of cards ---------------
                        if (aiHand.count == 0) {
                            System.out.println("You Won the Game!");
                            return;
                        }
                        // -------------------------------------
                        break;
                    } else if (playerTieBreaker.cardNum < aiTieBreaker.cardNum || (aiCard1.cardNum == 1 && playerCard1.cardNum != 1)) {
                        System.out.println("You lost the tiebreaker!");
                        while (tieHand.count != 0) {
                            Card moveCard = tieHand.popCard();
                            aiHand.addCard(moveCard, 0);
                        }
                        System.out.println("Player: " + playerHand.count + " cards \nAI: " + aiHand.count + " cards");
                        // Check if out of cards ---------------
                        if (playerHand.count == 0) {
                            System.out.println("You Lost the Game!");
                            return;
                        }
                        // -------------------------------------
                        break;
                    } else {
                        continue;
                    }
                }
            }

        }
    }

}
