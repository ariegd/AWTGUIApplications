/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awt.gui.applications;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Z97A
 */
public class AWTCounter3Buttons extends Frame implements ActionListener {
    private TextField tfCount;
    private Button btnUp;
    private Button btnDown;
    private Button btnReset;
    private int count = 0;
    
    public AWTCounter3Buttons(){
        setLayout(new FlowLayout());
        
        add(new Label("Counter "));
        
        tfCount = new TextField(count + "", 8);
        tfCount.setEditable(false);
        add(tfCount);
        
        btnUp = new Button("Count Up");
        btnUp.addActionListener(this);
        add(btnUp);
        
        btnDown = new Button("Count Down");
        btnDown.addActionListener(this);
        add(btnDown);
        
        btnReset = new Button("Reset");
        btnReset.addActionListener(this);
        add(btnReset);
        
        setTitle("AWT Counter 3 Buttons");
        pack();
        setVisible(true);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new AWTCounter3Buttons();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String btnLabel = ae.getActionCommand();
        switch(btnLabel){
            case "Count Up":
                ++count;
                tfCount.setText(count + "");
                break;
            case "Count Down":
                --count;
                tfCount.setText(count + "");
                break;
            case "Reset":
                count = 0;
                tfCount.setText(count + "");
                break;
        }
    }
    
}
