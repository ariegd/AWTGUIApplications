/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awt.gui.applications;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author Z97A
 */
public class AWTCounter extends Frame {
    private TextField tfCount;
    private Button btnCount;
    private int count = 0;
    
    public AWTCounter(){
        setLayout(new FlowLayout());
        
        add(new Label("Counter"));
        
        tfCount = new TextField(count +" ", 10);
        add(tfCount);
        tfCount.setEditable(false);
        
        btnCount = new Button("Count");
        add(btnCount);
        btnCount.addActionListener(new BtnListener());
        
        setTitle("AWT Counter Inner Class");
        setSize(225, 100);
        setVisible(true);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new AWTCounter();
    }

    private class BtnListener implements ActionListener {

        public BtnListener() {
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            ++count;
            tfCount.setText(count+" ");
        }
    }
    
}
