/*
 * Lab 6: P20.6 by Victor Truong and Leon Evangelista
 *
 * This program reads a file filled with user names and passwords. It will show the user a login
 * window, and if the user inputs a username matching one from the file (case insensitive) and
 * password (case sensitive), it'll "log them in" by showing a welcome message. If the user fails
 * too many login attempts, the program will automatically exit.
 */

public class LoginDemo {
    public static void main(String[] args) {
        UserManager manager = new UserManager();
        manager.loadUsers();

        Login login = new Login(manager);
    }
}
