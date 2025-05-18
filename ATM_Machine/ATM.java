
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void start() {
        // Create the frame
        JFrame frame = new JFrame("ATM Machine");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Balance Label
        JLabel balanceLabel = new JLabel("Balance: $" + account.getBalance());
        balanceLabel.setBounds(150, 20, 200, 20);
        frame.add(balanceLabel);

        // Withdraw Button
        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(150, 60, 100, 30);
        frame.add(withdrawButton);

        // Deposit Button
        JButton depositButton = new JButton("Deposit");
        depositButton.setBounds(150, 100, 100, 30);
        frame.add(depositButton);

        // Check Balance Button
        JButton checkBalanceButton = new JButton("Check Balance");
        checkBalanceButton.setBounds(150, 140, 120, 30);
        frame.add(checkBalanceButton);

        // Event listeners for buttons
        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Enter withdrawal amount:");
                try {
                    double amount = Double.parseDouble(input);
                    if (account.withdraw(amount)) {
                        JOptionPane.showMessageDialog(frame, "Withdrawal successful!");
                    } else {
                        JOptionPane.showMessageDialog(frame, "Insufficient balance!");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid input!");
                }
                balanceLabel.setText("Balance: $" + account.getBalance());
            }
        });

        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Enter deposit amount:");
                try {
                    double amount = Double.parseDouble(input);
                    if (amount > 0) {
                        account.deposit(amount);
                        JOptionPane.showMessageDialog(frame, "Deposit successful!");
                    } else {
                        JOptionPane.showMessageDialog(frame, "Deposit amount must be positive!");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid input!");
                }
                balanceLabel.setText("Balance: $" + account.getBalance());
            }
        });

        checkBalanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Your current balance is: $" + account.getBalance());
            }
        });

        frame.setVisible(true);
    }
}
