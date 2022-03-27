import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private int deckCount;
    private ArrayList<Card> doc = new ArrayList<>();

    public Deck() {
         for(int i = 0; i < 4; i++) {
             for(int j = 1; j < 14; j++) {
                 doc.add(new Card(j,i));
             }
         }
    }

    public void shuffleDeck() {
        Collections.shuffle(doc);
    }

    public Card getCard(int card) {
        return doc.get(card);
    }

    @Override
    public String toString() {
        return doc.toString();
    }
}
