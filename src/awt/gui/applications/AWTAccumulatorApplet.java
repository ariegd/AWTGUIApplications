/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awt.gui.applications;

import java.applet.Applet;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;

/**
 *
 * @author Z97A
 */
public class AWTAccumulatorApplet extends Applet {
    private TextField tfInput;
    private int sum = 0;  
    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     */
    @Override
    public void init() {
        // TODO start asynchronous download of heavy resources
        add(new Label("Enter an integer"));
        
        tfInput = new TextField(10);
        add(tfInput);
        tfInput.addActionListener((ActionEvent ae) -> {
            int numberIn = Integer.parseInt(tfInput.getText());
            sum += numberIn;
            tfInput.setText("");
            showStatus("The accumulated sum is: " + sum);
        });
    }

    // TODO overwrite start(), stop() and destroy() methods
}
