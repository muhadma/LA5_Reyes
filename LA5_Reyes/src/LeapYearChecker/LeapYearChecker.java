package LeapYearChecker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeapYearChecker extends JFrame{
    private JTextField yearTextField;
    private JPanel pMain;
    private JButton checkYearButton;

    LeapYearChecker() {
        checkYearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num = Integer.parseInt(yearTextField.getText());
                if(num % 4 == 0 && num % 100 != 0 || num % 400 == 0) {
                    JOptionPane.showMessageDialog(null, "Leap Year");
                } else {
                    JOptionPane.showMessageDialog(null, "Not a leap year");
                }
            }
        });
    }

    public static void main(String[] args) {
        LeapYearChecker checker = new LeapYearChecker();
        checker.setContentPane(checker.pMain);
        checker.setSize(400, 300);
        checker.setDefaultCloseOperation(EXIT_ON_CLOSE);
        checker.setTitle("Leap Year Checker");
        checker.setVisible(true);
    }
}
