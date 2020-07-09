/**
 * Models a location on the Grid.
 */
public class Location {
    private int row;
    private int col;

    /**
     * Constructs a Location.
     *
     * @param row
     * @param col
     */
    public Location(int row, int col) {
        this.row = row;
        this.col = col;
    }

    /**
     * Get the row number.
     *
     * @return row
     */
    public int getRow() {
        return this.row;
    }

    /**
     * Get the column number.
     *
     * @return column
     */
    public int getCol() {
        return this.col;
    }
}
