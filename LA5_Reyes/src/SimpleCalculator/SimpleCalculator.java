package SimpleCalculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator extends JFrame{
    private JTextField tfNumber1;
    private JComboBox cbOperations;
    private JTextField tfResult;
    private JTextField tfNumber2;
    private JButton btnCompute;
    private JPanel pMain;

    SimpleCalculator() {
        tfResult.setEditable(false);

        btnCompute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{
                    Integer n1 = Integer.parseInt(tfNumber1.getText());
                    Integer n2 = Integer.parseInt(tfNumber2.getText());

                    if(n2 == 0) {
                        throw new ArithmeticException("Cannot be divided by zero");
                    }

                    int res = 0;
                    int index = cbOperations.getSelectedIndex();

                    switch (index) {
                        case 0:
                            res = n1 + n2;
                            break;
                        case 1:
                            res = n1 - n2;
                            break;
                        case 2:
                            res = n1 * n2;
                            break;
                        case 3:
                            res = n1 / n2;
                            break;
                    }

                    tfResult.setText(Integer.toString(res));


                }catch (ArithmeticException ae) {
                    JOptionPane.showMessageDialog(null, ae.getMessage());
                    tfNumber1.setText("");
                    tfNumber2.setText("");
                }
            }
        });
    }

    public static void main(String[] args) {
        SimpleCalculator calc = new SimpleCalculator();
        calc.setContentPane(calc.pMain);
        calc.setSize(500, 300);
        calc.setDefaultCloseOperation(EXIT_ON_CLOSE);
        calc.setTitle("Simple Calculator");
        calc.setVisible(true);
    }
}
