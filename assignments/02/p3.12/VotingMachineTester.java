/*
 * Assignment 2: P3.12 by Victor Truong
 *
 * This program instantiates an instance of VotingMachine and tests all the voting methods.
 */

/**
 * Tests our VotingMachine class.
 */
public class VotingMachineTester {
    public static void main(String[] args) {
        VotingMachine machine = new VotingMachine();

        // See initial vote counts
        System.out.println("Initial values:");
        VotingMachineTester.printVotes(machine);

        // Vote for Democrats
        machine.addDemocratVote();
        System.out.println("Someone voted for the Democrats! New results:");
        VotingMachineTester.printVotes(machine);

        // Vote for Republicans
        machine.addRepublicanVote();
        System.out.println("Someone voted for the Republicans! New results:");
        VotingMachineTester.printVotes(machine);

        // Vote for Democrats again
        machine.addDemocratVote();
        System.out.println("Someone voted for the Democrats again! New results:");
        VotingMachineTester.printVotes(machine);

        // Clear the votes
        machine.clear();
        System.out.println("Oops, the machine broke and all the votes were cleared!");
        VotingMachineTester.printVotes(machine);
    }

    public static void printVotes(VotingMachine machine) {
        System.out.println("  Votes for Democrats: " + machine.getDemocratVotesCount());
        System.out.println("  Votes for Republicans: " + machine.getRepublicanVotesCount());
    }
}
