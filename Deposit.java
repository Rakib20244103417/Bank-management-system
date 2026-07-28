package Bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;

import java.util.Date;

public class Deposit extends JFrame implements ActionListener {

    JTextField textField;
    JButton b1, b2;
    String pin;

    Deposit(String pin) {
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,530,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel l3 =new JLabel(i3);
        l3.setBounds(0,0,1550,830);
        add(l3);

        JLabel label1 = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System", Font.BOLD, 16));
        label1.setBounds(460, 180, 460, 200);
        l3.add(label1);

        textField = new JTextField();
        textField.setBackground(new Color(65,125,128));
        textField.setForeground(Color.white);
        textField.setFont(new Font("Raleway", Font.BOLD, 22));
        textField.setBounds(460, 300, 320, 25);
        l3.add(textField);

        b1 = new JButton("DEPOSIT");
        b1.setBounds(700, 362, 150, 35);
        b1.setBackground(new Color(65,125,128));
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        l3.add(b1);

        b2 = new JButton("BACK");
        b2.setBounds(700, 406, 150, 35);
        b2.addActionListener(this);
        l3.add(b2);


       setLayout(null);
       setSize(1000,1000);
       setLocation(0,0);
       setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            String amount = textField.getText();
            Date date = new Date();
            if (ae.getSource() == b1) {
                if (textField.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
                } else {
                    C c = new C();
                    c.statement.executeUpdate("insert into bank values('" + pin + "', '" + date + "', 'Deposit', '" + amount + "')");
                    JOptionPane.showMessageDialog(null, "Rs. " + amount + " Deposited Successfully");
                    setVisible(false);
                    // Next Main Screen Navigation Here
                }
            } else if (ae.getSource() == b2) {
                setVisible(false);
                // Navigate back to Main Transactions Screen
            }
        } catch (Exception E) {
            E.printStackTrace();
        }
    }


    public static void main(String[] args) {

        new Deposit("");
    }
}
