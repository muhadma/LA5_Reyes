package FoodOrderingSystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FoodOrderingSystem extends JFrame{
    private JCheckBox cPizza;
    private JCheckBox cBurger;
    private JCheckBox cFries;
    private JCheckBox cSoftDrinks;
    private JCheckBox cTea;
    private JRadioButton rbNone;
    private JRadioButton rb5;
    private JRadioButton rb10;
    private JRadioButton rb15;
    private JButton btnOrder;
    private JCheckBox cSundae;
    private JPanel pMain;

    FoodOrderingSystem() {
        JCheckBox[] cbIndex = {cPizza, cBurger, cFries, cSoftDrinks, cTea, cSundae};
        JRadioButton[] rbDiscounts = {rbNone, rb5, rb10, rb15};
        double[] discs = {0, 0.05, 0.10, 0.15};
        int[] prices = {100, 80, 65, 55, 50, 40};

        btnOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double total = 0;
                int count = 0;
                double disc = 0;

                for(JCheckBox s : cbIndex) {
                    if(s.isSelected()) {
                        total += prices[count];
                    }
                    count++;
                }

                for(int i = 0; i < 4; i++) {
                    if(rbDiscounts[i].isSelected()) {
                        disc = discs[i];
                        break;
                    }
                }

                total -= (total * disc);

                JOptionPane.showMessageDialog(null, "The total price is Php " + String.format("%.2f", total));
            }
        });

    }

    public static void main(String[] args) {
        FoodOrderingSystem order = new FoodOrderingSystem();
        order.setContentPane(order.pMain);
        order.setSize(500, 300);
        order.setDefaultCloseOperation(EXIT_ON_CLOSE);
        order.setTitle("Food Ordering System");
        order.setVisible(true);
    }
}
