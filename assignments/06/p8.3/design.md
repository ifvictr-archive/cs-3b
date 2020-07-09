# P8.3 Design

## Methods

### `Grid`

- Populate grid with tiles (with associated words and location)
- Get total rows
- Get total columns
- Get tile at specified location
- Check if the entire grid has been matched

### `Location`

- Get row number
- Get column number

### `MatchingGame`

- Start a game
- Prompt the player to select a tile
- Prompt the player for a set of tiles. Returns the tiles at the end
- Print the grid
- Check if the given list of tiles all match each other

### `Tile`

- Get word
- Get location
- Check whether or not the tile has already been matched
- Set the matched value of a tile
- Check if the tile has a matching word with another tile
- Check if the tile is adjacent to another given tile

### `WordGenerator`

- Draw a random word from the pool, then remove
- Populate the pool with words

## Public interface

```java
// Grid
public Grid(int rows, int cols);
public void populate();
public int rows();
public int columns();
public Tile getTileAt(int row, int rol);
public boolean areAllTilesMatched();

// Location
public Location(int row, int col);
public int getRow();
public int getCol();

// MatchingGame
public MatchingGame();
public void start();
public void printGrid();
public Tile promptForTiles(int count);
public Tile promptForValidTile();
public boolean doAllTilesMatch(ArrayList<Tile> tiles);

// Tile
public Tile(String word, Location location);
public String getWord();
public Location getLocation();
public boolean hasBeenMatched();
public void setMatched(boolean matched);
public boolean hasMatchingWord(Tile otherTile);
public boolean isAdjacent(Tile otherTile);

// WordGenerator
public WordGenerator(int wordsNeeded, int groupSize);
private void populate();
public String nextWord();
```

## Instance variables

```java
// Grid
private Tile[][] tiles;

// Location
private int row;
private int col;

// MatchingGame
private Grid grid;
private int score = 0;

// Tile
private String word;
private Location location;
private boolean hasBeenMatched;

// WordGenerator
private int wordsNeeded;
private int groupSize;
private ArrayList<String> words;
```
