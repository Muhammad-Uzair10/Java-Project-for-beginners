import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class StudentForm {

    public static String storedInformation = "";

    public static void openStudentForm() {
        JFrame studentFrame = new JFrame("Student Form");
        studentFrame.getContentPane().setBackground(new Color(245, 230, 196));
        studentFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        studentFrame.setSize(800, 800);
        

        JPanel studentPanel = new JPanel();
        studentPanel.setBackground(new Color(245, 230, 196));
        studentPanel.setLayout(new GridLayout(5, 2));
        studentPanel.setBorder(new EmptyBorder(20, 30, 20, 20));


        JLabel nameLabel = new JLabel("Student Name:");
        JTextField nameField = new JTextField();
        nameField.setFont(new Font("Arial", Font.PLAIN, 20));
        nameField.setPreferredSize(new Dimension(50, 25));
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 20));

        JLabel semesterLabel = new JLabel("Semester:");
        JTextField semesterField = new JTextField();
        semesterField.setFont(new Font("Arial", Font.PLAIN, 20));
        semesterField.setPreferredSize(new Dimension(50, 25));
        semesterLabel.setFont(new Font("Arial", Font.PLAIN, 20));

        JLabel studentIdLabel = new JLabel("Student ID:");
        studentIdLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        JTextField studentIdField = new JTextField();
        studentIdField.setFont(new Font("Arial", Font.PLAIN, 20));
        studentIdField.setPreferredSize(new Dimension(50, 25));

        JLabel dropDownLabel = new JLabel("Course Name:");
        dropDownLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        String[] dropDownValues = {"Artificial Intelligence", "Computer Science", "Software Engineering", "Data Science"};
        JComboBox<String> dropDownField = new JComboBox<>(dropDownValues);

        studentPanel.add(nameLabel);
        studentPanel.add(nameField);
        studentPanel.add(semesterLabel);
        studentPanel.add(semesterField);
        studentPanel.add(studentIdLabel);
        studentPanel.add(studentIdField);
        studentPanel.add(dropDownLabel);
        studentPanel.add(dropDownField);

        JButton submit = new JButton("Submit");
        submit.addActionListener(e -> {
            // Handle form submission logic here
            // You can access the entered values using nameField.getText(), semesterField.getText(), etc.
            String information = "Name: " + nameField.getText() + "\n"
                    + "Semester: " + semesterField.getText() + "\n"
                    + "Student ID: " + studentIdField.getText() + "\n"
                    + "Course: " + dropDownField.getSelectedItem();

            storedInformation = information;

            JOptionPane.showMessageDialog(null, "Form Submitted Successfully\n\n" + information);

            // Save the information to a file
            saveToFile("library_data.txt", information);

            // Optional: Reset the text fields after submission
            nameField.setText("");
            semesterField.setText("");
            studentIdField.setText("");
            dropDownField.setSelectedIndex(0);
        });

        JButton reset = new JButton("Reset");
        reset.addActionListener(e -> {
            // Handle reset logic here
            nameField.setText("");
            semesterField.setText("");
            studentIdField.setText("");
            dropDownField.setSelectedIndex(0);
        });

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(submit);
        buttonPanel.add(reset);

        studentFrame.add(studentPanel, BorderLayout.CENTER);
        studentFrame.add(buttonPanel, BorderLayout.SOUTH);

        studentFrame.setLocationRelativeTo(null);
        studentFrame.setVisible(true);
    }

    private static void saveToFile(String fileName, String data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(data);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        openStudentForm();
    }
}
