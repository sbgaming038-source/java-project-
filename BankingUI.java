import javax.swing.*;
import java.awt.event.*;

public class BankingUI extends JFrame implements ActionListener {

    JTextField amountField;
    JLabel result;
    JButton depositBtn, withdrawBtn, balanceBtn;

    BankAccount account;

    BankingUI(){

        account = new BankAccount(1000);

        setTitle("Banking System");
        setSize(350,250);
        setLayout(null);

        JLabel label = new JLabel("Enter Amount:");
        label.setBounds(50,30,100,30);
        add(label);

        amountField = new JTextField();
        amountField.setBounds(150,30,120,30);
        add(amountField);

        depositBtn = new JButton("Deposit");
        depositBtn.setBounds(30,80,100,30);
        add(depositBtn);

        withdrawBtn = new JButton("Withdraw");
        withdrawBtn.setBounds(140,80,100,30);
        add(withdrawBtn);

        balanceBtn = new JButton("Balance");
        balanceBtn.setBounds(90,120,100,30);
        add(balanceBtn);

        result = new JLabel("");
        result.setBounds(100,160,200,30);
        add(result);

        depositBtn.addActionListener(this);
        withdrawBtn.addActionListener(this);
        balanceBtn.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){

        try {

            double amount = Double.parseDouble(amountField.getText());

            if(e.getSource()==depositBtn){
                account.deposit(amount);
                result.setText("Deposited Successfully");
            }

            if(e.getSource()==withdrawBtn){
                if(account.withdraw(amount))
                    result.setText("Withdraw Successful");
                else
                    result.setText("Insufficient Balance");
            }

            if(e.getSource()==balanceBtn){
                result.setText("Balance: "+account.getBalance());
            }

        } catch(Exception ex){
            result.setText("Enter valid number");
        }

    }

    public static void main(String[] args) {
        new BankingUI();
    }
}
