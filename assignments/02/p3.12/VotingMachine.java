/**
 * VotingMachine models actions that can be taken in a simple election.
 */
public class VotingMachine {
    private int democratVotesCount;
    private int republicanVotesCount;

    /**
     * Resets the vote count of both the Democrat and Republican party.
     */
    public void clear() {
        this.democratVotesCount = 0;
        this.republicanVotesCount = 0;
    }

    /**
     * Add a vote for the Democrats.
     */
    public void addDemocratVote() {
        this.democratVotesCount++;
    }

    /**
     * Add a vote for the Republicans.
     */
    public void addRepublicanVote() {
        this.republicanVotesCount++;
    }

    /**
     * Gets the total votes for the Democrats.
     *
     * @return current vote count for Democrats
     */
    public int getDemocratVotesCount() {
        return this.democratVotesCount;
    }

    /**
     * Gets the total votes for the Republicans.
     *
     * @return current vote count for Republicans
     */
    public int getRepublicanVotesCount() {
        return this.republicanVotesCount;
    }
}
