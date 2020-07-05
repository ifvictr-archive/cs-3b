import java.lang.Math;

/**
 * Models a deck of cards.
 */
public class Deck {
    public static final int SIZE = 52;
    public static final int CARDS_PER_SUIT = 13;

    private Card[] cards = new Card[Deck.SIZE];
    private int topCardIndex = 0;

    public Deck() {
        // Populate the deck with all the cards
        int cardIndex = 0;

        // All the suits
        for (Card.Suit suit : Card.Suit.values()) {
            // Values 1–13
            for (int value = 1; value <= Deck.CARDS_PER_SUIT; value++) {
                cards[cardIndex] = new Card(value, suit);
                cardIndex++;
            }
        }
    }

    /**
     * Get the cards in the deck.
     *
     * @return the cards
     */
    public Card[] getCards() {
        return this.cards;
    }

    /**
     * Get the current top card, then advance to the next one.
     *
     * @return the top card
     */
    public Card dealCard() {
        Card topCard = this.cards[this.topCardIndex];
        this.topCardIndex++;

        return topCard;
    }

    /**
     * Shuffles the deck of cards.
     */
    public void shuffle() {
        for (int i = 0; i < cards.length; i++) {
            Card tempCard = cards[i];
            int randomCardIndex = (int) (Math.random() * cards.length);
            cards[i] = cards[randomCardIndex];
            cards[randomCardIndex] = tempCard;
        }
    }
}
