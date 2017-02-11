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
public class SWingAdder extends JFrame implements ActionListener {
    private JTextField tfFirst, tfSecond, tfSum;
    private JButton btnAdd, btnClear;
    private int first = 0, second = 0, sum = 0;
    
    public SWingAdder(){
        Container cp = getContentPane();
        
        cp.setLayout(new GridLayout(4, 2, 10, 4));
        
        cp.add(new JLabel("First Number"));
        tfFirst = new JTextField(first + "", 8);
        cp.add(tfFirst);
        
        cp.add(new JLabel("Second Number"));
        tfSecond = new JTextField(second + "", 8);
        cp.add(tfSecond);
        
        cp.add(new JLabel("Sum"));
        tfSum = new JTextField(sum + "", 8);
        tfSum.setEditable(false);
        cp.add(tfSum);
        
        btnAdd = new JButton("ADD");
        btnAdd.addActionListener(this);
        cp.add(btnAdd);
        
        btnClear = new JButton("CLEAR");
        btnClear.addActionListener(this);
        cp.add(btnClear);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setTitle("Swing Adder");
        setVisible(true);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // For thread safety, use the event-dispatching thread to construct UI
        javax.swing.SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                new SWingAdder();
            }  
        });
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String btnLabel = ae.getActionCommand();
        try{
            switch(btnLabel){
                case "ADD":
                    first = Integer.parseInt(tfFirst.getText());
                    second = Integer.parseInt(tfSecond.getText());
                    sum = first + second;

                    tfSum.setText("" + sum);
                    break;
                case "CLEAR":
                    throw new NumberFormatException();
            }
        } catch(NumberFormatException nfe){
            tfFirst.setText("0");
            tfSecond.setText("0");
            tfSum.setText("0");
        }
    }
    
}
