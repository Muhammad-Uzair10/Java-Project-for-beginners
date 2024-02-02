import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.SecureRandom;


public class Password {
   private static boolean isPasswordVisible = false;


   public static void openPasswordFrame() {
       JFrame passwordFrame = new JFrame("Password Strength Checker");
       passwordFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       passwordFrame.setSize(750, 550);


       JPanel panel = new JPanel(new BorderLayout());
       panel.setBorder(BorderFactory.createEmptyBorder(100, 50, 50, 100));


       JLabel passwordLabel = new JLabel("Enter Password:");
       JPasswordField passwordField = new JPasswordField(20);
       JButton checkStrengthButton = new JButton("Check Strength");
       JProgressBar strengthBar = new JProgressBar();


       JButton showHidePasswordButton = new JButton("Show Password");
       showHidePasswordButton.setForeground(Color.BLUE);


       JButton generateStrongPasswordButton = new JButton("Generate Very Strong Password");
       generateStrongPasswordButton.setForeground(Color.GREEN);


       JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
       buttonPanel.add(showHidePasswordButton);
       buttonPanel.add(generateStrongPasswordButton);


       panel.add(passwordLabel, BorderLayout.NORTH);
       panel.add(passwordField, BorderLayout.CENTER);
       panel.add(checkStrengthButton, BorderLayout.EAST);
       panel.add(strengthBar, BorderLayout.SOUTH);
       panel.add(buttonPanel, BorderLayout.WEST);
       passwordFrame.add(panel);
       passwordFrame.setVisible(true);


       checkStrengthButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               String password = new String(passwordField.getPassword());
               int strength = calculatePasswordStrength(password);
               updateStrengthBar(strengthBar, strength);
           }
       });


       showHidePasswordButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               isPasswordVisible = !isPasswordVisible;
               if (isPasswordVisible) {
                   passwordField.setEchoChar((char) 0);
                   showHidePasswordButton.setText("Hide Password");
               } else {
                   passwordField.setEchoChar('\u2022');
                   showHidePasswordButton.setText("Show Password");
               }
           }
       });


       generateStrongPasswordButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               String generatedPassword = generateVeryStrongPassword();
               passwordField.setText(generatedPassword);
               updateStrengthBar(strengthBar, 100); // Set strength bar to very strong
           }
       });
   }


   private static int calculatePasswordStrength(String password) {
       // Implement your password strength calculation logic here
       // For example, you could consider length, complexity, etc.
       // For demonstration purposes, a simple length-based calculation is used here
       int length = password.length();
        boolean hasSymbol = password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*");
       boolean hasNumber = password.matches(".*\\d.*");
       boolean hasUppercase = password.matches(".*[A-Z].*");
       boolean hasLowercase = password.matches(".*[a-z].*");


       if (length <= 8) {
           return 33; // Weak password
       } else if (length <= 15 && hasSymbol && hasNumber) {
           return 66; // Strong password
       } else if (length > 15 && hasSymbol && hasNumber && hasUppercase && hasLowercase) {
           return 100; // Very Strong password
       } else {
           return 50; // Default: Moderate password strength
       }
   }


   private static void updateStrengthBar(JProgressBar strengthBar, int strength) {
       strengthBar.setValue(strength);
       if (strength <= 50) {
           strengthBar.setString("Weak");
           strengthBar.setForeground(Color.RED);
       } else if (strength <= 80) {
           strengthBar.setString("Strong");
           strengthBar.setForeground(Color.ORANGE);
       } else {
           strengthBar.setString("Very Strong");
           strengthBar.setForeground(Color.GREEN);
       }
       strengthBar.setStringPainted(true);
   }


   private static String generateVeryStrongPassword() {
       String symbols = "!@#$%^&*()_+-=[]{};':\",./<>?\\|";
       String numbers = "0123456789";
       String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
       String lowercase = "abcdefghijklmnopqrstuvwxyz";


       SecureRandom random = new SecureRandom();


       StringBuilder password = new StringBuilder();
       password.append(symbols.charAt(random.nextInt(symbols.length())));
       password.append(numbers.charAt(random.nextInt(numbers.length())));
       password.append(uppercase.charAt(random.nextInt(uppercase.length())));
       password.append(lowercase.charAt(random.nextInt(lowercase.length())));


       for (int i = 4; i < 16; i++) {
           int category = random.nextInt(4);
           switch (category) {
               case 0:
                   password.append(symbols.charAt(random.nextInt(symbols.length())));
                   break;
               case 1:
                   password.append(numbers.charAt(random.nextInt(numbers.length())));
                   break;
               case 2:
                   password.append(uppercase.charAt(random.nextInt(uppercase.length())));
                   break;
               case 3:
                   password.append(lowercase.charAt(random.nextInt(lowercase.length())));
                   break;
           }
       }


       return password.toString();

   }
}

