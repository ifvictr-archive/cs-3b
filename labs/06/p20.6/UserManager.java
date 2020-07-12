import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserManager {
    private ArrayList<User> users = new ArrayList<>();

    /**
     * Loads all the users in the users file into memory.
     */
    public void loadUsers() {
        File file = new File("users.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                // Create user and add them to the list
                String[] credentials = scanner.nextLine().split(" ");
                String username = credentials[0];
                String password = credentials[1];

                User newUser = new User(username, password);
                this.users.add(newUser);

                System.out.println("Added " + newUser.getUsername() + " to users list");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the user by their username.
     *
     * @param username Case-insensitive name of the user
     * @return the user, or null if none was found
     */
    public User getUser(String username) {
        for (User user : this.users) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                return user;
            }
        }

        return null;
    }
}
