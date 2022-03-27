public class Card {
    private enum suits {
        SPADES,
        CLUBS,
        HEARTS,
        DIAMONDS
    }

    private int value;
    private suits suit;

    public Card(int value, int suit) {
        this.value = value;
        switch (suit) {
            case 0 -> this.suit = suits.SPADES;
            case 1 -> this.suit = suits.CLUBS;
            case 2 -> this.suit = suits.HEARTS;
            case 3 -> this.suit = suits.DIAMONDS;
        }
    }

    public int getCardValue() {
        if (this.value > 10) {
            this.value = 10;
        } else if (this.value == 1) {
            this.value = 11;
        }
        return this.value;
    }

    public String getValue() {
        switch (this.value) {
            case 1 -> {
                return "Ace";
            }
            case 2 -> {
                return "Two";
            }
            case 3 -> {
                return "Three";
            }
            case 4 -> {
                return "Four";
            }
            case 5 -> {
                return "Five";
            }
            case 6 -> {
                return "Six";
            }
            case 7 -> {
                return "Seven";
            }
            case 8 -> {
                return "Eight";
            }
            case 9 -> {
                return "Nine";
            }
            case 10 -> {
                return "Ten";
            }
            case 11 -> {
                return "Jack";
            }
            case 12 -> {
                return "Queen";
            }
            case 13 -> {
                return "King";
            }
        }
        return "";
    }

    public String getSuit() {
        switch (this.suit) {
            case SPADES -> {
                return "Spades";
            }
            case CLUBS -> {
                return "Clubs";
            }
            case HEARTS -> {
                return "Hearts";
            }
            case DIAMONDS -> {
                return "Diamonds";
            }
        }
        return "";
    }

    @Override
    public String toString() {
        return getValue() + " of " + getSuit();
    }
}
