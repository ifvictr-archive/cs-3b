import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Login {
    private JFrame frame;
    private JPanel panel;
    private JPanel panel2;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel statusLabel;

    private UserManager manager;
    private int remainingAttempts = 3;

    public Login(UserManager manager) {
        this.manager = manager;

        // Set up components
        this.frame = new JFrame();
        this.panel = new JPanel();
        this.panel2 = new JPanel();
        JLabel usernameLabel = new JLabel("Username: ");
        JLabel passwordLabel = new JLabel("Password: ");
        this.usernameField = new JTextField();
        this.passwordField = new JPasswordField();
        this.loginButton = new JButton("Login");
        this.statusLabel = new JLabel("", SwingConstants.CENTER);
        this.statusLabel.setForeground(Color.RED);

        // Add listeners
        this.loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User user = manager.getUser(usernameField.getText());

                // Make sure the user exists and that the password is correct
                if (user == null || !user.hasCorrectPassword(passwordField.getText())) {
                    remainingAttempts--;
                    if (remainingAttempts > 0) {
                        statusLabel.setText(String.format(
                                "The username or password is incorrect. You have %d login attempt(s) left.",
                                remainingAttempts));
                    } else {
                        System.out.println("You are out of attempts. Exiting…");
                        System.exit(0);
                    }

                    return;
                }

                showWelcomeMessage(user);
            }
        });

        // Add all the components to their respective panels.
        panel.add(usernameLabel);
        panel.add(this.usernameField);
        panel.add(passwordLabel);
        panel.add(this.passwordField);
        panel2.add(this.loginButton);
        panel2.add(this.statusLabel);

        // Show everything to the user.
        frame.setVisible(true);
        frame.setSize(550, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 5, 30));
        panel2.setBorder(BorderFactory.createEmptyBorder(0, 30, 10, 30));
        panel.setLayout(new GridLayout(2, 2));
        panel2.setLayout(new GridLayout(2, 1));
        frame.add(this.panel, BorderLayout.CENTER);
        frame.add(this.panel2, BorderLayout.SOUTH);

    }

    /**
     * Opens a new window with a welcome message to the specified user.
     *
     * @param user the user object
     */
    public void showWelcomeMessage(User user) {
        JFrame success = new JFrame();
        JPanel successPanel = new JPanel();
        JLabel loginMessage = new JLabel(String.format("Welcome, %s!", user.getUsername()));
        this.frame.dispose();
        successPanel.add(loginMessage);
        success.setVisible(true);
        success.setSize(200, 150);
        success.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        successPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 5, 30));
        success.add(successPanel, BorderLayout.CENTER);
    }
}
