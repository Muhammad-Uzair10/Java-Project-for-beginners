import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CurrencyConverter {

    public JFrame frame;
    public JTextField amountField;
    public JComboBox<String> fromCurrencyComboBox;
    public JComboBox<String> toCurrencyComboBox;
    public JLabel resultLabel;
    public static final double USD_TO_EUR_RATE = 0.85;
    public static final double USD_TO_GBP_RATE = 0.75;
    public static final double USD_TO_PKR_RATE = 278.0; 
    public static final double USD_TO_SAR_RATE = 3.75; 

    public void openCurrency() {
        frame = new JFrame("Currency Converter");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(new Color(47, 60, 126)); // Blue background

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(5, 2, 10, 10));
        mainPanel.setBorder(new EmptyBorder(20, 100, 20, 100)); // Add padding (top, left, bottom, right)
        mainPanel.setBackground(new Color(47, 60, 126)); // Blue background

        JLabel amountLabel = new JLabel("Amount:");
        amountLabel.setForeground(new Color(251, 234, 235)); // Pink text
        amountLabel.setFont(new Font("Arial", Font.BOLD, 24));

        JTextField amountField = new JTextField();
        amountField.setBackground(new Color(251, 234, 235)); // Pink background

        JLabel fromCurrencyLabel = new JLabel("From Currency:");
        fromCurrencyLabel.setForeground(new Color(251, 234, 235)); // Pink text
        fromCurrencyLabel.setFont(new Font("Arial", Font.BOLD, 18));

        JComboBox fromCurrencyComboBox = new JComboBox<>(new String[]{"USD", "EUR", "GBP", "PKR", "SAR"});
        fromCurrencyComboBox.setForeground(Color.BLACK); // Black text

        JLabel toCurrencyLabel = new JLabel("To Currency:");
        toCurrencyLabel.setForeground(new Color(251, 234, 235)); // Pink text
        toCurrencyLabel.setFont(new Font("Arial", Font.BOLD, 18));

        JComboBox toCurrencyComboBox = new JComboBox<>(new String[]{"USD", "EUR", "GBP", "PKR", "SAR"});
        toCurrencyComboBox.setForeground(Color.BLACK); // Black text

        JButton convertButton = new JButton("Convert");
        convertButton.setBackground(new Color(251, 234, 235)); // Pink background
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertCurrency();
            }
        });

        resultLabel = new JLabel("Result:");
        resultLabel.setForeground(new Color(251, 234, 235)); // Pink text
        resultLabel.setFont(new Font("Arial", Font.BOLD, 18));

        mainPanel.add(amountLabel);
        mainPanel.add(amountField);
        mainPanel.add(fromCurrencyLabel);
        mainPanel.add(fromCurrencyComboBox);
        mainPanel.add(toCurrencyLabel);
        mainPanel.add(toCurrencyComboBox);
        mainPanel.add(new JLabel()); // Empty label for spacing
        mainPanel.add(convertButton);
        mainPanel.add(resultLabel);

        frame.add(mainPanel, BorderLayout.CENTER);
        
        frame.setVisible(true);
    }

    public void convertCurrency() {
       
            double amount = Double.parseDouble(amountField.getText());
            String fromCurrency = fromCurrencyComboBox.getSelectedItem().toString();
            String toCurrency = toCurrencyComboBox.getSelectedItem().toString();

            double result = convert(amount, fromCurrency, toCurrency);

            resultLabel.setText(String.format("Result: %.2f %s", result, toCurrency));
    }   

    private double convert(double amount, String fromCurrency, String toCurrency) {
        double result = 0;

        if (fromCurrency.equals("USD") && toCurrency.equals("EUR")) {
            result = amount * USD_TO_EUR_RATE;
        } else if (fromCurrency.equals("USD") && toCurrency.equals("GBP")) {
            result = amount * USD_TO_GBP_RATE;
        } else if (fromCurrency.equals("USD") && toCurrency.equals("PKR")) {
            result = amount * USD_TO_PKR_RATE;
        } else if (fromCurrency.equals("USD") && toCurrency.equals("SAR")) {
            result = amount * USD_TO_SAR_RATE;
        } else if (fromCurrency.equals("EUR") && toCurrency.equals("USD")) {
            result = amount / USD_TO_EUR_RATE;
        } else if (fromCurrency.equals("GBP") && toCurrency.equals("USD")) {
            result = amount / USD_TO_GBP_RATE;
        } else if (fromCurrency.equals("PKR") && toCurrency.equals("USD")) {
            result = amount / USD_TO_PKR_RATE;
        } else if (fromCurrency.equals("SAR") && toCurrency.equals("USD")) {
            result = amount / USD_TO_SAR_RATE;
        }

        return result;
    }
    // public static void main(String[] args) {
    //     new CurrencyConverter().openCurrency();
    // }
}
