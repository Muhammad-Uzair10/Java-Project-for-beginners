import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReturnBook {

    public static void openReturnBook() {
        JFrame returnFrame = new JFrame("Return Book");
        returnFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        returnFrame.setVisible(true);
        
        JPanel returnPanel = new JPanel();
        returnPanel.setLayout(new GridLayout(6, 2));
        returnPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        JLabel studentIdLabel = new JLabel("Student ID:");
        studentIdLabel.setFont(new Font("Arial", Font.BOLD, 16));
        JTextField studentIdField = new JTextField();
        JButton searchButton = new JButton("Search");
        searchButton.setPreferredSize(new Dimension(80, 30)); // Set preferred size

        JLabel issueDateLabel = new JLabel("Issue Date:");
        issueDateLabel.setFont(new Font("Arial", Font.BOLD, 16));
        JLabel returnDateLabel = new JLabel("Return Date:");
        returnDateLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JTextField issueDateField = new JTextField();
        issueDateField.setPreferredSize(new Dimension(100, 20));
        JTextField returnDateField = new JTextField();
        returnDateField.setPreferredSize(new Dimension(100, 20));

        returnPanel.add(studentIdLabel);
        returnPanel.add(studentIdField);
        returnPanel.add(searchButton);
        returnPanel.add(new JLabel()); // Empty label for spacing
        returnPanel.add(issueDateLabel);
        returnPanel.add(issueDateField);
        returnPanel.add(returnDateLabel);
        returnPanel.add(returnDateField);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform the search and update the issueDateField and returnDateField
                String studentId = studentIdField.getText();
                String filePath = "issueData.txt";  // Replace with your actual file path

                try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        String[] parts = line.split(",");
                        if (parts.length == 3 && parts[0].trim().equals(studentId.trim())) {
                            issueDateField.setText(parts[1].trim());
                            returnDateField.setText(parts[2].trim());
                            return;
                        }
                    }
                    // If the student ID is not found
                    JOptionPane.showMessageDialog(null, "Student ID not found");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        returnFrame.add(returnPanel);
        returnFrame.setLocationRelativeTo(null);
        returnFrame.pack(); // Adjust the frame size
        returnFrame.setVisible(true);
    }

    public static void main(String[] args) {
        openReturnBook();
    }
}
