import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {

    public static void openLogin() {
        ImageIcon backgroundIcon = new ImageIcon("pic2.jpeg");

        // Create a JFrame with the background image
        JFrame loginFrame = new JFrame("Library Management System - Login");
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setSize(800, 500);

        // Create a JPanel with the background image
        JPanel backgroundPanel = new JPanel() {
            
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };

        // Set layout for the background panel to null for absolute positioning
        backgroundPanel.setLayout(null);

        // Create labels, text fields, and button
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        usernameLabel.setForeground(new Color(255, 255, 255));
        JTextField usernameField = new JTextField(18);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 16));
        JPasswordField passwordField = new JPasswordField(18);
        passwordLabel.setForeground(new Color(255, 255, 255));
        JButton loginButton = new JButton("Login");
        


        //  bounds for components 
        usernameLabel.setBounds(250, 150, 80, 20);
        usernameField.setBounds(400, 150, 160, 40);

        passwordLabel.setBounds(250, 200, 80, 20);
        passwordField.setBounds(400, 200, 160, 40);

        loginButton.setBounds(360, 250, 110, 40);

        // Add action listener to the button
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String enteredUsername = usernameField.getText();
                String enteredPassword = new String(passwordField.getPassword());

                if (enteredUsername.equals("admin") && enteredPassword.equals("admin")) {
                    
                    Home.openHome();
                    loginFrame.dispose();  
                } else {
                    
                    JOptionPane.showMessageDialog(null, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        
        backgroundPanel.add(usernameLabel);
        backgroundPanel.add(usernameField);
        backgroundPanel.add(passwordLabel);
        backgroundPanel.add(passwordField);
        backgroundPanel.add(loginButton);
        

        
        loginFrame.setContentPane(backgroundPanel);

        
        loginFrame.setLocationRelativeTo(null);

        
        loginFrame.setVisible(true);
    }

    public static void main(String[] args) {
        openLogin();
    }
}
