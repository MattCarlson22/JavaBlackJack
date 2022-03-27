import java.util.ArrayList;

public class Dealer {

    private ArrayList<Card> dealersHand = new ArrayList<>();
    private ArrayList<Card> playersHand = new ArrayList<>();
    private final Deck dealersDeck;
    private static int cardNumber = 0;
    private boolean playerDone = false;

    public static int getCardNumber() {
        return cardNumber;
    }

    public static void handDealt() {
        cardNumber += 2;
    }

    public boolean checkPlayerAces() {
        for (Card c : playersHand) {
            if (c.getCardValue() == 11)
                return true;
        }
        return false;
    }

    public boolean checkDealerAces() {
        for (Card c : dealersHand) {
            if (c.getCardValue() == 11)
                return true;
        }
        return false;
    }

    public Dealer(Deck deck) {
        dealersDeck = deck;

        dealersHand.add(deck.getCard(getCardNumber()));
        dealersHand.add(deck.getCard(getCardNumber()+1));
        handDealt();

        playersHand.add(deck.getCard(getCardNumber()));
        playersHand.add(deck.getCard(getCardNumber()+1));
        handDealt();

    }


    public int getHandSum() {
        int pHandSum = 0;
        for (Card c : playersHand) {
            pHandSum += c.getCardValue();
        }
        return pHandSum;
    }

    public int getDealerHandSum() {
        int dHandSum = 0;
        for (Card c : dealersHand) {
            dHandSum += c.getCardValue();
        }
        return dHandSum;
    }

    public void playerStands() {
        playerDone = true;
    }

    public void printPlayerHand() {
        String playerHas = "You are showing: ";
        for(Card c : playersHand) {
            playerHas += "[ " + c.getValue() + " of " + c.getSuit() + " ] ";
        }
        System.out.println(playerHas);
        System.out.println("Total showing: "+getHandSum());
        System.out.println("\n");
    }

    private String dealerHas = "The dealer is showing: ";

    public void printDealerHand() {

        if (!playerDone) {
            System.out.println(dealerHas + "[ " + dealersHand.get(0).getValue() + " of " + dealersHand.get(0).getSuit() + " ] [ Hidden ]");
            System.out.println("Total showing: " + dealersHand.get(0).getCardValue());
        } else {
            dealerHas = "The dealer is showing: ";
            for(Card c : dealersHand) {
                dealerHas += "[ " + c.getValue() + " of " + c.getSuit() + " ] ";
            }
            System.out.println(dealerHas);
            System.out.println("Total showing: " + getDealerHandSum());
        }
        System.out.println("\n");
    }

    public void playerHit() {
        playersHand.add(dealersDeck.getCard(getCardNumber()));
        cardNumber++;
    }

    public void dealerHit() {
        dealersHand.add(dealersDeck.getCard(getCardNumber()));
        cardNumber++;
    }

}
