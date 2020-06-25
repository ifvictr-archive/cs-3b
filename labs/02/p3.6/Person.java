/**
 * Models a person that can befriend and unfriend other people.
 */
public class Person {
    private String name;
    private String friendNames = "";

    /**
     * Construct a Person with a specified name.
     */
    public Person(String name) {
        this.name = name;
    }

    /**
     * Adds a person to the friend list.
     *
     * @param person Person to befriend.
     */
    public void befriend(Person person) {
        this.friendNames += " " + person.getName();
        this.friendNames = this.friendNames.trim();
    }

    /**
     * Removes a person from the friend list.
     *
     * @param person Person to unfriend.
     */
    public void unfriend(Person person) {
        // Remove the name from the string
        this.friendNames = this.friendNames.replace(person.getName(), "");
        // For names that were removed from the middle
        this.friendNames = this.friendNames.replace("  ", " ");
        // For names that were removed from the start or end
        this.friendNames = this.friendNames.trim();
    }

    /**
     * Get the person’s name.
     *
     * @return the person’s name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get the person’s list of friends.
     *
     * @return the person’s list of friends
     */
    public String getFriendNames() {
        return this.friendNames;
    }
}
