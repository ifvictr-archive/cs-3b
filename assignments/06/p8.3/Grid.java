/**
 * Models a grid of tiles.
 */
public class Grid {
    private final int rows;
    private final int cols;
    private Tile[][] tiles;

    /**
     * Constructs a grid.
     *
     * @param rows number of rows it should have
     * @param cols number of columns each row should haves
     */
    public Grid(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.tiles = new Tile[rows][cols];

        this.populate();
    }

    /**
     * Populate the grid with tiles.
     */
    public void populate() {
        WordGenerator wordGen = new WordGenerator(this.rows() * this.columns(), 2);

        for (int row = 0; row < this.rows(); row++) {
            for (int col = 0; col < this.columns(); col++) {
                Location location = new Location(row, col);
                Tile newTile = new Tile(wordGen.nextWord(), location);
                tiles[row][col] = newTile;
            }
        }
    }

    /**
     * Gets the number of rows in the grid.
     *
     * @return number of rows
     */
    public int rows() {
        return this.rows;
    }

    /**
     * Gets the number of columns in a row of the grid.
     *
     * @return number of columns
     */
    public int columns() {
        return this.cols;
    }

    /**
     * Gets a tile in the grid.
     *
     * @param row Row number of the tile. Starts at 0.
     * @param col Column number of the tile. Starts at 0.
     * @return the tile
     */
    public Tile getTileAt(int row, int col) {
        if (row < 0 || row >= this.rows() || col < 0 || col >= this.columns()) {
            return null;
        }

        return tiles[row][col];
    }

    /**
     * Checks whether all the tiles in the grid have been matched.
     *
     * @return if all tiles have been matched
     */
    public boolean areAllTilesMatched() {
        for (int row = 0; row < this.rows(); row++) {
            for (int col = 0; col < this.columns(); col++) {
                Tile tile = this.getTileAt(row, col);
                if (!tile.hasBeenMatched()) {
                    return false;
                }
            }
        }

        return true;
    }
}
