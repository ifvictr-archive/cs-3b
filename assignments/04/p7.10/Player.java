import java.util.ArrayList;

public class Player {
    private int tokensCount = 0;
    private ArrayList<Card> hand = new ArrayList<>();

    /**
     * Constructs a Player with a starting amount of tokens.
     *
     * @param initialTokensCount
     */
    public Player(int initialTokensCount) {
        this.tokensCount = initialTokensCount;
    }

    public Player() {
        this(100);
    }

    /**
     * Adds a card to the player's hand.
     *
     * @param card the card to add
     */
    public void addCardToHand(Card card) {
        this.hand.add(card);
    }

    /**
     * Removes a card from the player's hand.
     *
     * @param card the card to remove
     */
    public void removeCardFromHand(Card card) {
        this.hand.remove(card);
    }

    /**
     * Replaces a card with another one.
     *
     * @param oldCard the card to replace
     * @param newCard the card to replace the old one with
     */
    public void replaceCardInHand(Card oldCard, Card newCard) {
        int oldCardIndex = this.hand.indexOf(oldCard);
        this.hand.set(oldCardIndex, newCard);
    }

    /**
     * Remove all cards from the hand.
     */
    public void clearHand() {
        this.hand.clear();
    }

    /**
     * Gets all the cards in the player's hand.
     *
     * @return the player's cards
     */
    public ArrayList<Card> getHand() {
        return this.hand;
    }

    /**
     * Gets the amount of tokens the player has.
     *
     * @return player's token count
     */
    public int getTokensCount() {
        return this.tokensCount;
    }

    /**
     * Gives tokens to the player.
     *
     * @param amount the amount to give
     */
    public void addTokens(int amount) {
        this.tokensCount += amount;
    }

    /**
     * Takes tokens from the player.
     *
     * @param amount the amount to take
     */
    public void removeTokens(int amount) {
        this.tokensCount -= amount;
    }

    /**
     * Print out all the cards in the player's hand.
     */
    public void printHand() {
        System.out.println("Your hand:");
        for (int i = 0; i < this.getHand().size(); i++) {
            Card currentCard = this.getHand().get(i);
            System.out.println(String.format("%d. %s", i + 1, currentCard));
        }
    }
}
