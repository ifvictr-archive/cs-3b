public class User {
    private String username;
    private String password;

    /**
     * Constructs a User.
     *
     * @param username the user's name
     * @param password the user's password
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Gets the user's name.
     *
     * @return username
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Checks the given credentials match for the user.
     *
     * @param password
     * @return if the credentials match
     */
    public boolean hasCorrectPassword(String password) {
        return password.equals(this.password);
    }
}
