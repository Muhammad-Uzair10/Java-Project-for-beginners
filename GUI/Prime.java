import javax.swing.JOptionPane;

public class Prime {
    public static void openPrime() {
        String name = JOptionPane.showInputDialog(null, "Enter your name:");
        JOptionPane.showMessageDialog(null, "Hello " + name + "! Enter a number to check whether it's prime or not.");

        String numberInput = JOptionPane.showInputDialog(null, "Enter a number:");
        int number = Integer.parseInt(numberInput);

        boolean isPrime = true;

        if (number <= 1) {
            isPrime = false;
        } else {
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }

        if (isPrime) {
            JOptionPane.showMessageDialog(null, "It is a prime number.");
        } else {
            JOptionPane.showMessageDialog(null, "It's not a prime number.");
        }
        }
    public static void main(String[] args) {
        openPrime();
    }
}


