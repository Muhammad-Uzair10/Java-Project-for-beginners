import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home {

    public static ImageIcon iconS = new ImageIcon("button1.png");
    public static ImageIcon iconB = new ImageIcon("button2.png");
    public static ImageIcon iconA = new ImageIcon("stat.jpg");
    public static JButton button1, button2, button3, button4, button5;

    public static void openHome() {
        // JFrame
        JFrame homeFrame = new JFrame("Home Page");
        homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        homeFrame.setTitle("Home Page");
        homeFrame.setSize(1600, 1000);

        
        JPanel buttonPanel = new JPanel(new GridLayout(3, 2, 20, 20));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(50, 350, 50, 350)); 
        buttonPanel.setBackground(new Color(188, 158, 130)); // background color

        // Create buttons
        button1 = createButton("New Student", iconS);
        button2 = createButton("New Book", iconB);
        button3 = createButton("Statistics", iconA);
        button4 = createButton("Issue Book", iconB);
        button5 = createButton("Return Book", iconB);

        // Add buttons to the panel
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        buttonPanel.add(button4);
        buttonPanel.add(button5);

        // Set the content pane to the panel
        homeFrame.setContentPane(buttonPanel);

        // Center the frame on the screen
        homeFrame.setLocationRelativeTo(null);
        homeFrame.setVisible(true);
    }

    public static JButton createButton(String buttonText, ImageIcon icon) {
        JButton button = new JButton();
        button.setText(buttonText);
        button.setFocusable(false);
        button.setIcon(icon);
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.BOTTOM);
        button.setFont(new Font("Comic Sans", Font.BOLD, 14));
        button.setIconTextGap(10);
        button.setBorder(BorderFactory.createEtchedBorder());
        // Button background color
        button.setBackground(new Color(255, 200, 0));
        // Set button text color
        button.setForeground(Color.WHITE);

        button.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                handleButtonClick(buttonText);
            }
        });

        return button;
    }

    public static void handleButtonClick(String buttonText) {
        switch (buttonText) {
            case "New Student":
                StudentForm.openStudentForm();
                break;
            case "New Book":
                Book.openBook();
                break;
            case "Issue Book":
                IssueBook.openIssueBook();
                break;
            case "Statistics":
                Statistics.openStatistics();
                break;
            case "Return Book":
                ReturnBook.openReturnBook();
                break;
            // Add cases for other buttons as needed
        }
    }

    public static void main(String[] args) {
        openHome();
    }
}
