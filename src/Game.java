import java.util.Scanner;
public class Game {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean gameActive = true;
        System.out.println("Welcome to Blackjack!\n");

        Deck deck = new Deck();
        deck.shuffleDeck();

        Dealer dealer = new Dealer(deck);
        dealer.printDealerHand();
        dealer.printPlayerHand();

        if (dealer.getHandSum() == 21 && dealer.getDealerHandSum() != 21) {
            System.out.println("Blackjack! You Win!");
            gameActive = false;
        } else if (dealer.getDealerHandSum() == 21 && dealer.getHandSum() != 21) {
            System.out.println("Dealer has blackjack. You Lose!");
            gameActive = false;
        } else if (dealer.getHandSum() == 21 && dealer.getDealerHandSum() == 21) {
            System.out.println("You both got blackjack! It's a tie!");
            gameActive = false;
        }

        String prompt = (
                """
                What would you like to do?\s
                1. Hit\s
                2. Stand\s
                """
                );

        while (gameActive) {
            int ans = 0;

            while (ans < 1 || ans > 2) {
                System.out.println(prompt);
                System.out.print(">>> ");
                ans = sc.nextInt();
            }

            if (ans == 1) {

                dealer.playerHit();

                dealer.printPlayerHand();

                if (dealer.getHandSum() > 21) {
                    System.out.println("You went bust!");
                    gameActive = false;
                } else if (dealer.getHandSum() == 21) {
                    System.out.println("Blackjack! You win!");
                    gameActive = false;
                }

            } else if (ans == 2) {

                dealer.playerStands();
                gameActive = false;

                while (dealer.getDealerHandSum() < 17) {
                    dealer.dealerHit();
                }

                if (dealer.getHandSum() > dealer.getDealerHandSum() || dealer.getDealerHandSum() > 21) {
                    dealer.printDealerHand();
                    System.out.println("You win!");
                } else if (dealer.getHandSum() == dealer.getDealerHandSum()) {
                    dealer.printDealerHand();
                    System.out.println("It's a tie!");
                } else if (dealer.getHandSum() < dealer.getDealerHandSum() && dealer.getDealerHandSum() <= 21) {
                    dealer.printDealerHand();
                    System.out.println("You Lose!");
                }
            }
        }
    }
}
