public enum HandRank {
    NO_PAIR, ONE_PAIR, TWO_PAIRS, THREE_OF_A_KIND, STRAIGHT, FLUSH, FULL_HOUSE, FOUR_OF_A_KIND, STRAIGHT_FLUSH, ROYAL_FLUSH;

    public String toString() {
        switch (this) {
            case NO_PAIR:
                return "No pair";
            case ONE_PAIR:
                return "One pair";
            case TWO_PAIRS:
                return "Two pairs";
            case THREE_OF_A_KIND:
                return "Three of a kind";
            case STRAIGHT:
                return "Straight";
            case FLUSH:
                return "Flush";
            case FULL_HOUSE:
                return "Full House";
            case FOUR_OF_A_KIND:
                return "Four of a Kind";
            case STRAIGHT_FLUSH:
                return "Straight Flush";
            case ROYAL_FLUSH:
                return "Royal Flush";
            default:
                return "???";
        }
    }
}
