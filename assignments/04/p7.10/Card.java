/**
 * Models a single card in a deck of cards.
 */
public class Card {
    public enum Suit {
        CLUB, DIAMOND, HEART, SPADE;

        public String toString() {
            switch (this) {
                case CLUB:
                    return "Club";
                case DIAMOND:
                    return "Diamond";
                case HEART:
                    return "Heart";
                case SPADE:
                    return "Spade";
                default:
                    return "???";
            }
        }
    }

    private Card.Suit suit;
    private int value;

    /**
     * Constructs a card with the specified value and suit.
     *
     * @param value
     * @param suit
     */
    public Card(int value, Card.Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    /**
     * Gets the suit of the card.
     *
     * @return the suit
     */
    public Card.Suit getSuit() {
        return this.suit;
    }

    /**
     * Gets the value of the card.
     *
     * @return the value
     */
    public int getValue() {
        return this.value;
    }

    /**
     * Gets the object in string form.
     *
     * @return string form
     */
    public String toString() {
        String valueString;
        switch (this.getValue()) {
            case 1:
                valueString = "Ace";
                break;
            case 2:
                valueString = "Two";
                break;
            case 3:
                valueString = "Three";
                break;
            case 4:
                valueString = "Four";
                break;
            case 5:
                valueString = "Five";
                break;
            case 6:
                valueString = "Six";
                break;
            case 7:
                valueString = "Seven";
                break;
            case 8:
                valueString = "Eight";
                break;
            case 9:
                valueString = "Nine";
                break;
            case 10:
                valueString = "Ten";
                break;
            case 11:
                valueString = "Jack";
                break;
            case 12:
                valueString = "Queen";
                break;
            case 13:
                valueString = "King";
                break;
            default:
                valueString = "???";
                break;
        }

        return String.format("%s of %ss", valueString, this.getSuit());
    }
}
