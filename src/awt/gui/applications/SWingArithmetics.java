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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Z97A
 */
public class SWingArithmetics extends JFrame implements ActionListener {

    private JTextField tfFirst, tfSecond, tfResult;
    private JButton btnAdd, btnLess, btnMultiply,
            btnDivide, btnRest, btnClear;
    private float first = 0, second = 0, result = 0;

    public SWingArithmetics() {
        Container cp = getContentPane();

        cp.setLayout(new GridLayout(6, 2, 10, 4));

        cp.add(new JLabel("First Number"));
        tfFirst = new JTextField(first + "", 8);
        tfFirst.setHorizontalAlignment(JTextField.RIGHT);
        cp.add(tfFirst);

        cp.add(new JLabel("Second Number"));
        tfSecond = new JTextField(second + "", 8);
        tfSecond.setHorizontalAlignment(JTextField.RIGHT);
        cp.add(tfSecond);

        cp.add(new JLabel("Result"));
        tfResult = new JTextField(result + "", 8);
        tfResult.setHorizontalAlignment(JTextField.RIGHT);
        tfResult.setEditable(false);
        cp.add(tfResult);

        btnAdd = new JButton("+");
        btnAdd.addActionListener(this);
        cp.add(btnAdd);

        btnLess = new JButton("-");
        btnLess.addActionListener(this);
        cp.add(btnLess);

        btnMultiply = new JButton("*");
        btnMultiply.addActionListener(this);
        cp.add(btnMultiply);

        btnDivide = new JButton("/");
        btnDivide.addActionListener(this);
        cp.add(btnDivide);

        btnRest = new JButton("%");
        btnRest.addActionListener(this);
        cp.add(btnRest);

        btnClear = new JButton("CLEAR");
        btnClear.addActionListener(this);
        cp.add(btnClear);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setTitle("Swing Arithmetics");
        setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SWingArithmetics();
            }

        });
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String btnLabel = ae.getActionCommand();    
        try {
            first = Float.parseFloat(tfFirst.getText());
            second = Float.parseFloat(tfSecond.getText());
            
            switch (btnLabel) {
                case "+":
                    result = first + second;
                    tfResult.setText("" + result);
                    break;
                case "-":
                    result = first - second;
                    tfResult.setText("" + result);
                    break;
                case "*":
                    result = first * second;
                    tfResult.setText("" + result);
                    break;
                case "/":
                    result = first / second;
                    tfResult.setText("" + result);
                    break;
                case "%":
                    result = first % second;
                    tfResult.setText("" + result);
                    break;
                case "CLEAR":
                    throw new NumberFormatException();
            }
        } catch (NumberFormatException nfe) {
            tfFirst.setText("0");
            tfSecond.setText("0");
            tfResult.setText("0");
        }
    }

}
