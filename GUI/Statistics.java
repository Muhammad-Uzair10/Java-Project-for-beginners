import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Statistics {

    public static void openStatistics() {
        JFrame statisticsFrame = new JFrame("Statistics");
        statisticsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        statisticsFrame.setSize(600, 400);
        statisticsFrame.getContentPane().setBackground(new Color(139, 69, 19));

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Arial", Font.PLAIN, 16));

        JScrollPane scrollPane = new JScrollPane(textArea);

        JButton issueDataButton = new JButton("Show Issue Data");
        JButton bookDataButton = new JButton("Show Book Data");
        JButton libraryDataButton = new JButton("Show Library Data");
        
        libraryDataButton.setPreferredSize(new Dimension(150, 30));
        bookDataButton.setPreferredSize(new Dimension(150, 30));
        issueDataButton.setPreferredSize(new Dimension(150, 30));

        issueDataButton.addActionListener(e -> textArea.setText(readDataFromFile("issueData.txt")));
        bookDataButton.addActionListener(e -> textArea.setText(readDataFromFile("book_data.txt")));
        libraryDataButton.addActionListener(e -> textArea.setText(readDataFromFile("library_data.txt")));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(139, 69, 19));
        buttonPanel.add(issueDataButton);
        buttonPanel.add(bookDataButton);
        buttonPanel.add(libraryDataButton);

        // Create a JSplitPane to split the frame into two parts
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, scrollPane, buttonPanel);
        splitPane.setResizeWeight(0.5);  // Set the initial position of the divider

        // Add the JSplitPane to the frame
        statisticsFrame.add(splitPane);

        // Center the frame on the screen
        statisticsFrame.setLocationRelativeTo(null);
        statisticsFrame.setVisible(true);
    }

    public static String readDataFromFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        openStatistics();
    }
}
