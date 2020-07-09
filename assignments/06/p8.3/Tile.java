public class Tile {
    private String word;
    private Location location;
    private boolean hasBeenMatched = false;

    /**
     * Constructs a tile.
     *
     * @param word
     * @param location
     */
    public Tile(String word, Location location) {
        this.word = word;
        this.location = location;
    }

    /**
     * Gets the tile's word.
     *
     * @return tile's word
     */
    public String getWord() {
        return this.word;
    }

    /**
     * Gets the tile's location on the grid.
     *
     * @return tile's location
     */
    public Location getLocation() {
        return this.location;
    }

    /**
     * Check whether or not the tile has already been matched.
     *
     * @return if it has been matched
     */
    public boolean hasBeenMatched() {
        return this.hasBeenMatched;
    }

    /**
     * Change the match value.
     *
     * @param matched new matched value
     */
    public void setMatched(boolean matched) {
        this.hasBeenMatched = matched;
    }

    /**
     * Check if the current tile has a word that matches with that of another tile.
     *
     * @param otherTile the tile to check the word of
     * @return whether or not they match
     */
    public boolean hasMatchingWord(Tile otherTile) {
        return this.getWord().equals(otherTile.getWord());
    }

    /**
     * Checks whether or not a tile is adjacent from the given tile (includes diagonals).
     *
     * @param otherTile the tile to check adjacency to
     * @return whether or not they're adjacent
     */
    public boolean isAdjacent(Tile otherTile) {
        Location loc1 = this.getLocation();
        Location loc2 = otherTile.getLocation();

        boolean isInSameRow = loc1.getRow() == loc2.getRow();
        boolean isInSameCol = loc1.getCol() == loc2.getCol();
        boolean isAboveOf = loc1.getRow() - 1 == loc2.getRow();
        boolean isBelowOf = loc1.getRow() + 1 == loc2.getRow();
        boolean isLeftOf = loc1.getCol() - 1 == loc2.getCol();
        boolean isRightOf = loc1.getCol() + 1 == loc2.getCol();

        // Visualization of the tiles that are checked. X is the current tile.
        // 1 2 3
        // 8 X 4
        // 7 6 5
        boolean isTopLeftTile = isAboveOf && isLeftOf;
        boolean isTopTile = isAboveOf && isInSameCol;
        boolean isTopRightTile = isAboveOf && isRightOf;
        boolean isRightTile = isInSameRow && isRightOf;
        boolean isBottomRightTile = isBelowOf && isRightOf;
        boolean isBottomTile = isBelowOf && isInSameCol;
        boolean isBottomLeftTile = isBelowOf && isLeftOf;
        boolean isLeftTile = isInSameRow && isLeftOf;

        return isTopLeftTile || isTopTile || isTopRightTile || isRightTile || isBottomRightTile
                || isBottomTile || isBottomLeftTile || isLeftTile;
    }
}
