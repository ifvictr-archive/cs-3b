# P7.10 Design

## Methods

### `Card`

- Get the suit
- Get the value

### `Deck`

- Shuffle the deck

### `Game`

### `Player`

- Add card to hand
- Remove card from hand
- Clear all the cards that are in the hand
- Get token count
- Add tokens
- Remove tokens
- Get hand

## Public interface

```java
// Card
public Card.Suit getSuit();
public int getValue();

// Deck
public Deck();
public Card[] getCards();
public Card dealCard();
public void shuffle();

// Game
public Game();
public void start();
public Game.Hand checkHand(ArrayList<card> hand);

// Player
public Player(int initialTokensCount);
public Player();
public void addCardToHand(Card card);
public void removeCardFromHand(Card card);
public void replaceCardInHand(Card oldCard, Card newCard);
public void clearHand();
public ArrayList<Card> getHand();
public int getTokensCount();
public void addTokens(int amount);
public void removeTokens(int amount);
```

## Instance variables

```java
// Card
private Card.Suit suit;
private int value;

// Deck
private Card[] cards;
private int topIndex;

// Game
private Deck deck;
private Player player;

// Player
private ArrayList<Card> hand;
private int tokensCount;
```
