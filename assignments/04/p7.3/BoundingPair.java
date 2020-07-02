/**
 * Class to contain bounding results from DiceUtil#getLongestRun.
 */
public class BoundingPair {
    private int startPos;
    private int endPos;

    /**
     * Constructs a bounding pair for an array.
     *
     * @param startPos the index of the first element to include in the bound
     * @param endPos   the index of the first element to exclude from the bound
     */
    public BoundingPair(int startPos, int endPos) {
        this.startPos = startPos;
        this.endPos = endPos;
    }

    /**
     * Get the starting position.
     *
     * @return the starting position
     */
    public int getStartPos() {
        return this.startPos;
    }

    /**
     * Get the end position.
     *
     * @return the end position
     */
    public int getEndPos() {
        return this.endPos;
    }

    /**
     * Get the length of the bound.
     *
     * @return the length of the bound
     */
    public int length() {
        return this.getEndPos() - this.getStartPos();
    }
}
