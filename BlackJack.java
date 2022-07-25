import java.util.Scanner;

public class BlackJack {

    Scanner sc = new Scanner(System.in);
    Deck deck = new Deck();
    boolean playing = true;
    int total = 0;
    boolean skipAI = false;
    int numAce = 0;
    int aiNumAce = 0;

    public void Game() {
        while (playing) {
            total = 0;
            skipAI = false;
            numAce = 0;
            aiNumAce = 0;

            System.out.println("Do you want to play Blackjack? y/n");
            String playGame = sc.nextLine();
            if (playGame.toLowerCase().equals("y")) {
                deck.shuffle();
                System.out.println("Shuffling... ");
                Card pCard1 = deck.popCard();
                Card pCard2 = deck.popCard();
                System.out.println("First Card: " + pCard1);
                System.out.println("Second Card: " + pCard2);
                //Card 1 point values
                if (pCard1.cardNum > 10) {
                    total += 10;
                }
                else if (pCard1.cardNum == 1) {
                    total += 11;
                    numAce++;
                }
                else {
                    total += pCard1.cardNum;
                }
                //Card 2 point values
                if (pCard2.cardNum > 10) {
                    total += 10;
                }
                else if (pCard2.cardNum == 1) {
                    total += 11;
                    numAce++;
                }
                else if (total > 21 && numAce > 0) {
                    total -= 10;
                    numAce--;
                }
                else {
                    total += pCard2.cardNum;
                }
                System.out.println("Total: " + total);

                if (total == 21) {
                    System.out.println("You Win!");
                    continue;
                }
                else if (total > 21) {
                    System.out.println("You Lose! :(");
                }
                else {
                    System.out.println("Hit? y/n - ");
                    String hit = sc.nextLine();
                    while (hit.toLowerCase().equals("y")) {
                        Card pCard3 = deck.popCard();
                        System.out.println("Next Card: " + pCard3);
                        if (pCard3.cardNum > 10) {
                            total += 10;
                        }
                        else if (pCard3.cardNum == 1) {
                            total += 11;
                            numAce++;
                        }
                        else if (total > 21 && numAce > 0) {
                            total -= 10;
                            numAce--;
                        }
                        else {
                            total += pCard3.cardNum;
                        }
                        System.out.println("Total: " + total);

                        if (total == 21) {
                            System.out.println("You Win!");
                            skipAI = true;
                            break;
                        }
                        else if (total > 21) {
                            System.out.println("You Lose! :(");
                            skipAI = true;
                            break;
                        }
                        System.out.println("Hit again? y/n - ");
                        hit = sc.nextLine();

                    }
                    if (skipAI != true) {
                        Card aiCard1 = deck.popCard();
                        Card aiCard2 = deck.popCard();
                        System.out.println("Enemy's first Card: " + aiCard1);
                        System.out.println("Enemy's Second Card: " + aiCard2);
                        int aiTotal = 0;
                        if (aiCard1.cardNum > 10) {
                            aiTotal += 10;
                        }
                        else if (aiCard1.cardNum == 1) {
                            aiTotal += 11;
                            aiNumAce++;
                        }
                        else if (aiTotal > 21 && numAce > 0) {
                            aiTotal -= 10;
                        }
                        else {
                            aiTotal += aiCard1.cardNum;
                        }
                        if (aiCard2.cardNum > 10) {
                            aiTotal += 10;
                        }
                        else if (aiCard1.cardNum == 1) {
                            aiTotal += 11;
                            aiNumAce++;
                        }
                        else if (aiTotal > 21 && numAce > 0) {
                            aiTotal -= 10;
                            aiNumAce--;
                        }
                        else {
                            aiTotal += aiCard2.cardNum;
                        }
                        System.out.println("AI's Total: " + aiTotal);
                        if (aiTotal < total && aiTotal < 21) {
                            System.out.println("You Win");
                            continue;
                        }   
                        else if (aiTotal == total) {
                            System.out.println("It's a draw");
                            continue;
                        }
                        else {
                            System.out.println("You Lose");
                            continue;
                        }
                    }
                    

                }
            }
            else {
                System.out.println("Goodbye!");
                break;
            }
        }
    }
}
