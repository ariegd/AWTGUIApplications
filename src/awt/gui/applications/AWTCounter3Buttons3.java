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

/**
 *
 * @author Z97A
 */
public class AWTCounter3Buttons3 extends Frame {

    private TextField tfCount;
    private Button btnUp;
    private Button btnDown;
    private Button btnReset;
    private int count = 0;

    public AWTCounter3Buttons3() {
        setLayout(new FlowLayout());

        add(new Label("Counter "));

        tfCount = new TextField(count + "", 8);
        tfCount.setEditable(false);
        add(tfCount);

        btnUp = new Button("Count Up");
        btnUp.addActionListener((ActionEvent ae) -> {
            String btnLabel = ae.getActionCommand();
            if (btnLabel.equals("Count Up")) {
                ++count;
                tfCount.setText(count + "");
            }
        });
        add(btnUp);

        btnDown = new Button("Count Down");
        btnDown.addActionListener((ActionEvent ae) -> {
            String btnLabel = ae.getActionCommand();
            if (btnLabel.equals("Count Down")) {
                --count;
                tfCount.setText(count + "");
            }
        });
        add(btnDown);

        btnReset = new Button("Reset");
        btnReset.addActionListener((ActionEvent ae) -> {
            String btnLabel = ae.getActionCommand();
            if (btnLabel.equals("Reset")) {
                count = 0;
                tfCount.setText(count + "");
            }
        });
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
        new AWTCounter3Buttons3();
    }

}
