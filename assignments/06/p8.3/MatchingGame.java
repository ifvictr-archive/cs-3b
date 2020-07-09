import java.util.ArrayList;
import java.util.Scanner;

/**
 * Models a matching game with a tile grid and player score.
 */
public class MatchingGame {
    private Grid grid = new Grid(4, 4);
    private int score = 0;

    /**
     * Starts a game.
     */
    public void start() {
        while (!this.grid.areAllTilesMatched()) {
            // Prompt for tile selections
            ArrayList<Tile> selectedTiles = this.promptForTiles(2);
            this.printGrid(selectedTiles);

            // Check the selected tiles for matches
            if (doAllTilesMatch(selectedTiles)) {
                // Mark all the selected tiles as matched
                for (Tile tile : selectedTiles) {
                    tile.setMatched(true);
                }

                // Calculate gained points and increase score
                int gainedPoints = 1;
                if (selectedTiles.get(0).isAdjacent(selectedTiles.get(1))) { // Bonus for adjacency
                    gainedPoints++;
                }
                this.score += gainedPoints;

                System.out.println(String.format("+%d pt for getting matching tiles! New score: %d",
                        gainedPoints, this.score));
            } else {
                System.out.println("Oof, the tiles you selected do not match!");
            }
        }
    }

    /**
     * Print the contents of the grid, and whether or not they've already been flipped.
     */
    public void printGrid(ArrayList<Tile> selectedTiles) {
        // Print out header with column numbers
        System.out.print("   ");
        for (int col = 0; col < grid.columns(); col++) {
            System.out.print(String.format("%d    ", col + 1));
        }
        System.out.println();

        // Print out everything else
        for (int row = 0; row < grid.rows(); row++) {
            // Print current row number at start of line
            System.out.print(String.format("%d  ", row + 1));

            // Print the words of the tiles in the row
            for (int col = 0; col < grid.columns(); col++) {
                Tile currentTile = grid.getTileAt(row, col);
                // Show the word if it has already been matched, or if the player is currently
                // selecting it
                String output = currentTile.hasBeenMatched() || selectedTiles.contains(currentTile)
                        ? currentTile.getWord()
                        : "----";
                // String output = currentTile.getWord();
                System.out.print(output + " ");
            }
            System.out.println();
        }
    }

    public void printGrid() {
        this.printGrid(new ArrayList<Tile>());
    }

    /**
     * Prompts the player for a specified amount of valid tiles.
     *
     * @param count the amount of tiles to get from the player
     * @return the selected tiles
     */
    public ArrayList<Tile> promptForTiles(int count) {
        ArrayList<Tile> selectedTiles = new ArrayList<>();
        while (selectedTiles.size() != count) {
            Tile validTile = this.promptForValidTile(selectedTiles);
            selectedTiles.add(validTile);
        }

        return selectedTiles;
    }

    /**
     * Prompt the player to select a valid title. Takes non zero-index inputs for the row and column
     * numbers.
     *
     * @param selectedTiles currently selected tiles
     * @return a valid tile from the grid
     */
    public Tile promptForValidTile(ArrayList<Tile> selectedTiles) {
        Tile tile;

        // Keep asking the player until they select a valid tile
        Scanner scanner = new Scanner(System.in);
        while (true) {
            this.printGrid(selectedTiles);

            // Select row and column
            System.out.print("Enter the number of row of the tile you want to select: ");
            int rowNumber = scanner.nextInt();
            System.out.print("Now, enter the column: ");
            int colNumber = scanner.nextInt();

            // Shift the player-friendly numbers to their actual indices
            tile = this.grid.getTileAt(rowNumber - 1, colNumber - 1);

            // Was invalid, so let them know before going again
            if (tile == null) {
                System.out.println("Invalid tile selected. Please try again!");
                continue;
            }

            // Can't select the same tile as one in the current selection
            if (selectedTiles.contains(tile)) {
                System.out.println("You can’t select the same tile again.");
            } else if (tile.hasBeenMatched()) { // Found a tile, but it can't be matched
                System.out.println("The selected tile has already been matched. Try again.");
            } else { // Looks great, returning
                System.out.println(String.format("You’ve selected the tile on row %d, column %d.",
                        rowNumber, colNumber));
                break;
            }
        }

        return tile;
    }

    public Tile promptForValidTile() {
        return this.promptForValidTile(new ArrayList<Tile>());
    }

    /**
     * Check if all the tiles in the given list match up.
     *
     * @param tiles tiles to check
     * @return whether they all match
     */
    public boolean doAllTilesMatch(ArrayList<Tile> tiles) {
        // Needs at least two tiles to check
        if (tiles.size() < 2) {
            return false;
        }

        Tile prevTile = tiles.get(0); // First tile to check against everything else
        for (Tile tile : tiles) {
            // Immediately return false if a tile doesn't match
            if (!tile.hasMatchingWord(prevTile)) {
                return false;
            }
        }

        return true;
    }
}
