/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awt.gui.applications;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Z97A
 */
public class SWingNumberGuess extends JFrame {

    private JTextField tfInput;
    private JPasswordField pfRandom;
    private JButton btnGenerate;
    private JLabel lblOut;
    private int input, random;

    public SWingNumberGuess() {
        setLayout(new GridLayout(2, 3, 5, 5));

        add(new JLabel("The Number is"));
        pfRandom = new JPasswordField(10);
        pfRandom.setHorizontalAlignment(JPasswordField.RIGHT);
        add(pfRandom);
        btnGenerate = new JButton("Generate");
        btnGenerate.addActionListener((ActionEvent ae) -> {
            try{
                random = (int) Math.floor(Math.random() * 100 + 1);
                pfRandom.setText(random + "");
                input = Integer.parseInt(tfInput.getText());
                if (input != 0) {
                    comparar();
                }
            }catch(NumberFormatException nfe){
                random = 0;
                input = 0;
                pfRandom.setText("");
                tfInput.setText("0"); //OJO si no lanza la exception
            }
        });
        add(btnGenerate);
        add(new JLabel("Enter your guess"));
        tfInput = new JTextField(input+"", 10); //OJO si no lanza la exception
        tfInput.setHorizontalAlignment(JTextField.RIGHT);
        tfInput.addActionListener((ActionEvent ae) -> {
            try{
                input = Integer.parseInt(tfInput.getText());
                if (random != 0) {
                    comparar();
                }
            }catch(NumberFormatException nfe){
                random = 0;
                input = 0;
                pfRandom.setText("");
                tfInput.setText("");
            }
        });
        add(tfInput);
        lblOut = new JLabel("The out");
        add(lblOut);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Guess Number");
        pack();
        setVisible(true);

    }

    private void comparar() {
        if (random > input) {
            lblOut.setText("Try Higher.");
        } else if (random < input) {
            lblOut.setText("Try Lower.");
        } else {
            lblOut.setText("Yot Got it :)");
        }
        lblOut.repaint();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        javax.swing.SwingUtilities.invokeLater(() -> {
            new SWingNumberGuess();
        });
    }

}
