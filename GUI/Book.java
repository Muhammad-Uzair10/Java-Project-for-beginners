import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Book {

    public static String bookInfo = "";

    public static void openBook() {
        JFrame bookFrame = new JFrame("Book Form");
        bookFrame.getContentPane().setBackground(new Color(245, 230, 196));
        bookFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        bookFrame.setSize(600, 600);

        JPanel bookPanel = new JPanel();
        bookPanel.setBackground(new Color(245, 230, 196));
        bookPanel.setLayout(new GridLayout(7, 2));
        bookPanel.setBorder(new EmptyBorder(20, 30, 20, 20));

        JLabel nameBook = new JLabel("Book ID");
        JTextField Field1 = new JTextField();
        Field1.setFont(new Font("Arial", Font.PLAIN, 20));
        Field1.setPreferredSize(new Dimension(50, 25));
        nameBook.setFont(new Font("Arial", Font.PLAIN, 20));

        JLabel name = new JLabel("Name");
        JTextField Field2 = new JTextField();
        Field2.setFont(new Font("Arial", Font.PLAIN, 20));
        Field2.setPreferredSize(new Dimension(50, 25));
        name.setFont(new Font("Arial", Font.PLAIN, 20));

        JLabel Publisher = new JLabel("Publisher");
        JTextField Field3 = new JTextField();
        Field3.setFont(new Font("Arial", Font.PLAIN, 20));
        Field3.setPreferredSize(new Dimension(50, 25));
        Publisher.setFont(new Font("Arial", Font.PLAIN, 20));

        JLabel price = new JLabel("Price");
        JTextField Field4 = new JTextField();
        Field4.setFont(new Font("Arial", Font.PLAIN, 20));
        Field4.setPreferredSize(new Dimension(50, 25));
        price.setFont(new Font("Arial", Font.PLAIN, 20));

        JLabel year = new JLabel("Publish Year");
        JTextField Field5 = new JTextField();
        Field5.setFont(new Font("Arial", Font.PLAIN, 20));
        Field5.setPreferredSize(new Dimension(50, 25));
        year.setFont(new Font("Arial", Font.PLAIN, 20));

        bookPanel.add(nameBook);
        bookPanel.add(Field1);
        bookPanel.add(name);
        bookPanel.add(Field2);
        bookPanel.add(Publisher);
        bookPanel.add(Field3);
        bookPanel.add(price);
        bookPanel.add(Field4);
        bookPanel.add(year);
        bookPanel.add(Field5);

        JButton submit2 = new JButton("Submit");
        submit2.addActionListener(e -> {
            String bookInfo = "Book ID: " + Field1.getText() + "\n"
                    + "Name: " + Field2.getText() + "\n"
                    + "Publisher: " + Field3.getText() + "\n"
                    + "Price: " + Field4.getText() + "\n"
                    + "Publish Year: " + Field5.getText() + "\n";

            Book.bookInfo = bookInfo;

            JOptionPane.showMessageDialog(null, "Form Submitted Successfully\n\n" + bookInfo);

            saveToFile("book_data.txt", bookInfo);
        });

        JButton reset = new JButton("Reset");
        reset.addActionListener(e -> {
            Field1.setText("");
            Field2.setText("");
            Field3.setText("");
            Field4.setText("");
            Field5.setText("");
        });

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(submit2);
        buttonPanel.add(reset);

        bookFrame.add(bookPanel, BorderLayout.CENTER);
        bookFrame.add(buttonPanel, BorderLayout.SOUTH);

        bookFrame.setLocationRelativeTo(null);
        bookFrame.setVisible(true);
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
        openBook();
    }
}
