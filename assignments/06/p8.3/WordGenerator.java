import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class WordGenerator {
    public static final String[] DEFAULT_WORDS = new String[] {"love", "wolf", "fish", "five",
            "king", "tree", "tire", "star", "time", "mask", "java", "city", "line", "moon", "fire",
            "rock", "wand", "rose", "mary", "kent", "alan", "lord", "risk", "beer", "dark", "pipe",
            "navy", "rank", "gaze", "daze", "disc", "seed"};

    private final int wordsNeeded;
    private final int groupSize;
    private ArrayList<String> words;

    /**
     * Constructs the word generator.
     *
     * @param wordsNeeded size of the word pool to generate
     * @param groupSize   how many times each word should be duplicated
     */
    public WordGenerator(int wordsNeeded, int groupSize) {
        this.wordsNeeded = wordsNeeded;
        this.groupSize = groupSize;

        this.populate();
    }

    /**
     * Populates the word pool with a shuffled set of random words, which also include multiples of
     * the same word.
     */
    private void populate() {
        ArrayList<String> newWords = new ArrayList<>();

        while (newWords.size() < this.wordsNeeded) {
            // Add the word X times into the pool so there are multiples of it
            int defaultWordsIndex = newWords.size() % WordGenerator.DEFAULT_WORDS.length;
            String currentWord = WordGenerator.DEFAULT_WORDS[defaultWordsIndex];
            for (int i = 0; i < this.groupSize; i++) {
                // Cycle if we go past the length
                newWords.add(currentWord);
            }
        }

        // Shuffle and save the new pool of words
        Collections.shuffle(newWords);
        this.words = newWords;
    }

    /**
     * Gets another random word from the pool.
     *
     * @return a random word
     */
    public String nextWord() {
        Random random = new Random();

        // Save the word
        int randomIndex = random.nextInt(this.words.size());
        String randomWord = this.words.get(randomIndex);

        // Remove it from the pool
        this.words.remove(randomIndex);

        return randomWord;
    }
}
