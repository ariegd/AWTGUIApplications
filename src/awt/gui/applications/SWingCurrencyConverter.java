/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awt.gui.applications;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author Z97A
 */
public class SWingCurrencyConverter extends JFrame implements ActionListener {

    private JTextField tfSGD, tfUSD, tfEuro;
    private float sgd = 0, usd = 0, euro = 0;

    public SWingCurrencyConverter() {
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(3, 2, 10, 3));

        cp.add(new JLabel("Singapore Dollars"));
        tfSGD = new JTextField(sgd + "", 8);
        tfSGD.addActionListener(this);
        cp.add(tfSGD);

        cp.add(new JLabel("US Dollars"));
        tfUSD = new JTextField(usd + "", 8);
        tfUSD.addActionListener(this);
        cp.add(tfUSD);

        cp.add(new JLabel("Euros"));
        tfEuro = new JTextField(euro + "", 8);
        tfEuro.addActionListener(this);
        cp.add(tfEuro);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Currency Converter");
        pack();
        setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SWingCurrencyConverter();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object component = ae.getSource();
        try {
            if(component == tfSGD){
                sgd = Float.parseFloat(tfSGD.getText());
                tfUSD.setText(String.format("%.2f", sgd * 0.41));
                tfEuro.setText(String.format("%.2f", sgd * 0.65));
            }else if(component == tfUSD){
                usd = Float.parseFloat(tfUSD.getText());
                tfSGD.setText(String.format("%.2f", usd * 1.41));
                tfEuro.setText(String.format("%.2f", usd * 0.92));
            }else if(component == tfEuro){
                euro = Float.parseFloat(tfEuro.getText());
                tfSGD.setText(String.format("%.2f", euro * 0.65));
                tfUSD.setText(String.format("%.2f", euro * 0.92));
            } 
            
        } catch (NumberFormatException nfe) {
            tfSGD.setText("0");
            tfUSD.setText("0");
            tfEuro.setText("0");
        }
    }
}
