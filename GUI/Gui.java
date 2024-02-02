import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Multi-Purpose Application.");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setSize(400, 400);
        frame.setIconImage(new ImageIcon("Designer.png").getImage());
        frame.getContentPane().setBackground(new Color(11, 88, 87)); // Sea Green color

        JButton cardButton = new JButton("Credit Card Validator");
        JButton libraryButton = new JButton("Library Management System");
        JButton snakeButton = new JButton("Snake Game");
        JButton primeCheckerButton = new JButton("Prime Checker");
        JButton pasButton=new JButton("Password Checker");

        cardButton.setPreferredSize(new Dimension(200, 100));
        snakeButton.setPreferredSize(new Dimension(200, 100));
        libraryButton.setPreferredSize(new Dimension(300, 100));
        primeCheckerButton.setPreferredSize(new Dimension(200, 100));
        pasButton.setPreferredSize(new Dimension(200, 100));


        cardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validateCreditCard();
            }
        });

        
        snakeButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        // Call the Snake class
            EventQueue.invokeLater(() -> {
                JFrame snakeFrame = new Snake();
                snakeFrame.setVisible(true);
        });
    }
});


        libraryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                // Assuming Login class has an openLogin method
                Login.openLogin();
                // CurrencyConverter.openCurrency();
            }

        });

        

        primeCheckerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Prime.openPrime();
            }
        });
        pasButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                Password.openPasswordFrame();
            }
        });

        // Set bounds for buttons
        cardButton.setBounds(50, 50, 200, 100);
        libraryButton.setBounds(50, 200, 300, 100);
        snakeButton.setBounds(50, 500, 400, 100 );
        primeCheckerButton.setBounds(50, 350, 350, 100); 
        pasButton.setBounds(500, 350, 220, 50);

        // Add buttons to the content pane
        frame.add(cardButton);
        frame.add(libraryButton);
        frame.add(snakeButton);
        frame.add(primeCheckerButton);
        frame.add(pasButton);
        // Create JLabels for the welcome text
        JLabel welcomeLabel1 = new JLabel("Programming Fundamentals");
        welcomeLabel1.setFont(new Font("Arial", Font.BOLD, 26));
        welcomeLabel1.setForeground(Color.WHITE);
        welcomeLabel1.setBounds(600, 50, 600, 50);

        JLabel welcomeLabel2 = new JLabel("SP23-BAI-038");
        welcomeLabel2.setFont(new Font("Arial", Font.BOLD, 24));
        welcomeLabel2.setForeground(Color.WHITE);
        welcomeLabel2.setBounds(600, 100, 300, 50);

        JLabel welcomeLabel3 = new JLabel("SP23-BAI-043");
        welcomeLabel3.setFont(new Font("Arial", Font.BOLD, 24));
        welcomeLabel3.setForeground(Color.WHITE);
        welcomeLabel3.setBounds(600, 150, 300, 50);

        JLabel welcomeLabel4 = new JLabel("Submitted to: Sir Prof.Dr.M.Manzoor ilahi Tamimy");
        welcomeLabel4.setFont(new Font("Arial", Font.BOLD, 22));
        welcomeLabel4.setForeground(Color.WHITE);
        welcomeLabel4.setBounds(600, 200, 600, 50);

        // Add the welcome labels to the content pane
        frame.add(welcomeLabel1);
        frame.add(welcomeLabel2);
        frame.add(welcomeLabel3);
        frame.add(welcomeLabel4);

        frame.setLayout(null);  // Set layout to null for absolute positioning
        frame.setVisible(true);
    }

    private static void validateCreditCard() {
        String input = JOptionPane.showInputDialog("Enter your card number:");
        long card = Long.parseLong(input);
        int evensum = getDigit(card);
        int oddsum = getOdd(card);
        int totalsum = evensum + oddsum;

        if (totalsum % 10 == 0) {
            JOptionPane.showMessageDialog(null, "Card number is valid");
        } else {
            JOptionPane.showMessageDialog(null, "Invalid card number entered");
        }
    }

    private static int getDigit(long number) {
        long num = number;
        int total = 0;
        String digit = Long.toString(num);
        for (int i = 0; i < digit.length(); i += 2) {
            int x = Integer.parseInt(String.valueOf(digit.charAt(i)));
            x = x * 2;
            String even = String.valueOf(x);
            if (even.length() >= 2) {
                int separated = divider(even);
                total += separated;
            } else {
                int odd = Integer.parseInt(even);
                total += odd;
            }
        }
        return total;
    }

    public static int divider(String even) {
        int evenint = Integer.parseInt(even);
        int digit2 = evenint % 10;
        int digit1 = evenint / 10;
        return digit1 + digit2;
    }

    public static int getOdd(long card) {
        String numbers = String.valueOf(card);
        int oddsum = 0;
        for (int i = numbers.length() - 1; i >= 0; i -= 2) {
            int odd2 = Integer.parseInt(String.valueOf(numbers.charAt(i)));
            oddsum += odd2;
        }
        return oddsum;
    }
}
