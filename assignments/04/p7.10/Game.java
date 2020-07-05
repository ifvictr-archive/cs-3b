import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Game {
    public static final int TOKEN_COST = 1;
    public static final int MAX_HAND_SIZE = 5;

    private Deck deck = new Deck();
    private Player player = new Player();

    /**
     * Start a game of Video Poker.
     *
     * @param scanner the scanner to receive input from
     */
    public void start(Scanner scanner) {
        // Shuffle the deck
        this.deck.shuffle();

        // Each game costs tokens
        player.removeTokens(Game.TOKEN_COST);
        System.out.println(String.format("You paid %d token(s) to play! Remaining tokens: %d",
                Game.TOKEN_COST, this.player.getTokensCount()));

        // Populate the player's hand
        while (this.player.getHand().size() < Game.MAX_HAND_SIZE) {
            this.player.addCardToHand(this.deck.dealCard());
        }

        this.player.printHand();

        // Prompt for player's choice to reject none, some, or all their cards
        System.out.println();
        this.promptForChoice(scanner);

        // Add payout to token count
        HandRank rank = this.getRank(this.player.getHand());
        int payout = this.getPayout(rank);
        this.player.addTokens(payout);
        System.out.println("You got " + rank + "!");
        System.out.println(String.format("You gained %d tokens from this round. New total: %d",
                payout, this.player.getTokensCount()));
        System.out.println();
    }

    /**
     * Prompt the user for a choice and then take action on it.
     *
     * @param scanner the scanner to receive input from
     */
    public void promptForChoice(Scanner scanner) {
        while (true) {
            System.out.println("What do you want to do with your cards?");
            System.out.println("A. Keep all");
            System.out.println("B. Replace some");
            System.out.println("C. Reject all");
            System.out.print("> ");
            String choice = scanner.nextLine();
            switch (choice.toUpperCase()) {
                case "A":
                    System.out.println("Keeping all five cards…");
                    return;
                case "B":
                    this.promptForRejectedCards(scanner);
                    return;
                case "C":
                    this.player.getHand().clear();
                    System.out.println("Rejected all five cards…");
                    return;
                default:
                    System.out.println("Please choose either A, B, C, or D!");
                    continue;
            }
        }
    }

    /**
     * Prompt the user to replace cards in their hand.
     *
     * @param scanner the scanner to receive input from
     */
    public void promptForRejectedCards(Scanner scanner) {
        ArrayList<Card> selectedCards = new ArrayList<>();
        while (true) {
            System.out.println(
                    "Which card do you want to select/unselect? (from 1–5; 0 to exit selection)");
            System.out.print("> ");
            int cardNumber = scanner.nextInt();

            // Exit selection
            if (cardNumber == 0) {
                System.out.println("Exiting selection");
                break;
            }

            // Needs to be one of the cards in the hand
            if (cardNumber < 1 || cardNumber > 5) {
                System.out.println("Needs to be card 1, 2, 3, 4, or 5!");
                continue;
            }

            // Select/unselect card for rejection
            int cardIndex = cardNumber - 1;
            Card selectedCard = this.player.getHand().get(cardIndex);
            if (selectedCards.contains(selectedCard)) {
                selectedCards.remove(selectedCard);
                System.out.println("Removed " + selectedCard + "from selected cards to reject.");
            } else {
                selectedCards.add(selectedCard);
                System.out.println("Added " + selectedCard + " to selected cards to reject.");
            }
        }

        // Replace the selected cards
        for (Card card : selectedCards) {
            this.player.replaceCardInHand(card, this.deck.dealCard());
        }
    }

    /**
     * Get the rank of the given hand.
     *
     * @param hand the hand to check
     * @return the rank of the hand
     */
    public HandRank getRank(ArrayList<Card> hand) {
        boolean isHandFlush = this.isHandFlush(hand);
        boolean isHandStraight = this.isHandStraight(hand);
        boolean isHandStraightFlush = isHandFlush && isHandStraight;

        Integer[] pairCounts = this.countValues(hand);

        // Last card must be a king
        if (isHandStraightFlush && hand.get(hand.size() - 1).getValue() == 13) {
            return HandRank.ROYAL_FLUSH;
        } else if (isHandStraightFlush) {
            return HandRank.STRAIGHT_FLUSH;
        } else if (pairCounts[0] == 4) { // Four of a kind
            return HandRank.FOUR_OF_A_KIND;
        } else if (pairCounts[0] == 3 && pairCounts[1] == 2) { // Three of a kind + one pair
            return HandRank.FULL_HOUSE;
        } else if (isHandFlush) {
            return HandRank.FLUSH;
        } else if (isHandStraight) {
            return HandRank.STRAIGHT;
        } else if (pairCounts[0] == 3) { // Three of a kind
            return HandRank.THREE_OF_A_KIND;
        } else if (pairCounts[0] == 2 && pairCounts[1] == 2) { // Two pairs
            return HandRank.TWO_PAIRS;
        } else if (pairCounts[0] == 2) { // One pair
            return HandRank.ONE_PAIR;
        } else {
            return HandRank.NO_PAIR;
        }
    }

    /**
     * Gets the payout associated with the hand.
     *
     * @param rank the hand
     * @return the payout
     */
    public int getPayout(HandRank rank) {
        switch (rank) {
            case ONE_PAIR:
                return 1;
            case TWO_PAIRS:
                return 2;
            case THREE_OF_A_KIND:
                return 3;
            case STRAIGHT:
                return 4;
            case FLUSH:
                return 5;
            case FULL_HOUSE:
                return 6;
            case FOUR_OF_A_KIND:
                return 25;
            case STRAIGHT_FLUSH:
                return 50;
            case ROYAL_FLUSH:
                return 250;
            default:
                return 0;
        }
    }

    /**
     * Counts the total occurrences of each value in a suit.
     *
     * @param hand the hand to check in
     * @return the occurrences
     */
    public Integer[] countValues(ArrayList<Card> hand) {
        Integer[] pairCounts = new Integer[Deck.CARDS_PER_SUIT];
        // Initialize with zeros
        for (int i = 0; i < pairCounts.length; i++) {
            pairCounts[i] = 0;
        }

        // Increment the value counters
        for (Card card : hand) {
            int valueIndex = card.getValue() - 1;
            pairCounts[valueIndex]++;
        }

        // Sort in descending order
        Arrays.sort(pairCounts, Collections.reverseOrder());
        return pairCounts;
    }

    /**
     * Check if all the cards in the hand have the same suit.
     *
     * @param hand the hand to check
     * @return if they have the same suit
     */
    public boolean isHandFlush(ArrayList<Card> hand) {
        // Can't be a flush if there are less cards than the max hand size
        if (hand.size() != Game.MAX_HAND_SIZE) {
            return false;
        }

        Card.Suit suit = hand.get(0).getSuit();
        for (Card card : hand) {
            if (card.getSuit() != suit) {
                return false;
            }
        }

        return true;
    }

    /**
     * Check if all the cards in the hand are consecutive.
     *
     * @param hand the hand to check
     * @return if they are consecutive
     */
    public boolean isHandStraight(ArrayList<Card> hand) {
        // Can't be a straight if there are less cards than the max hand size
        if (hand.size() != Game.MAX_HAND_SIZE) {
            return false;
        }

        // Add card values to array for sorting
        int[] values = new int[Game.MAX_HAND_SIZE];
        for (int i = 0; i < values.length; i++) {
            values[i] = hand.get(i).getValue();
        }
        Arrays.sort(values);

        // Check if the values are consecutive
        int prevValue = values[0];
        for (int i = 1; i < values.length; i++) {
            boolean doesAcePrecedeTen = prevValue == 1 && values[i] == 10;
            boolean isConsecutive = values[i] == prevValue + 1;
            // Ace can precede or follow the king, but it'll always be sorted as [1, 10, 11, 12, 13]
            if (!isConsecutive && !doesAcePrecedeTen) {
                return false;
            }

            prevValue = values[i];
        }

        return true;
    }
}
