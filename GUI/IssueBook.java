import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class IssueBook {

    public static void openIssueBook() {
        JFrame issueFrame = new JFrame("Issue Book");
        issueFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        issueFrame.setSize(400, 200);
        issueFrame.setMinimumSize(new Dimension(400, 200));

        JPanel issuePanel = new JPanel();
        issuePanel.setLayout(new GridLayout(4, 2, 10, 10));
        issuePanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        JLabel studentIdLabel = new JLabel("Student ID:");
        JTextField studentIdField = new JTextField();
        studentIdField.setColumns(10);
        studentIdField.setPreferredSize(new Dimension(150, 30));

        JLabel issueDateLabel = new JLabel("Issue Date:");
        JTextField issueDateField = new JTextField();
        issueDateField.setEditable(false);
        issueDateField.setPreferredSize(new Dimension(150, 30));

        JLabel returnDateLabel = new JLabel("Return Date:");
        JTextField returnDateField = new JTextField();
        returnDateField.setEditable(false);
        returnDateField.setPreferredSize(new Dimension(150, returnDateField.getPreferredSize().height));

        JButton issueButton = new JButton("Issue Book");

        issuePanel.add(studentIdLabel);
        issuePanel.add(studentIdField);
        issuePanel.add(issueDateLabel);
        issuePanel.add(issueDateField);
        issuePanel.add(returnDateLabel);
        issuePanel.add(returnDateField);
        issuePanel.add(new JLabel()); // Empty label for spacing
        issuePanel.add(issueButton);

        issueButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                // Generate current date for issue date
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String currentDate = dateFormat.format(new Date());

                // 15 days from the issue date
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(new Date());
                calendar.add(Calendar.DATE, 15);
                String returnDate = dateFormat.format(calendar.getTime());

                // Get input from the user
                String studentId = studentIdField.getText();
                String issueDate = currentDate;

                // Validate input
                if (studentId.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter Student ID");
                    return;
                }

                // Save the information to the issueData.txt file
                saveToFile("issueData.txt", studentId + "," + issueDate + "," + returnDate);

                JOptionPane.showMessageDialog(null, "Book issued successfully\n\nStudent ID: " + studentId
                        + "\nIssue Date: " + issueDate + "\nReturn Date: " + returnDate);

                // Reset the student ID field
                studentIdField.setText("");
                // Update the issueDateField and returnDateField
                issueDateField.setText(issueDate);
                returnDateField.setText(returnDate);
            }
        });

        issueFrame.add(issuePanel);
        issueFrame.setLocationRelativeTo(null);
        issueFrame.setVisible(true);
    }

    public static void saveToFile(String fileName, String data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(data);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        openIssueBook();
    }
}
