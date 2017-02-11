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
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author Z97A No puede pinchar. jajaj. Imposible
 *
 * /
 * public class SWingTemperatureConverter extends JFrame implements
 * FocusListener {
 *
 * private JTextField tfCelsius, tfFahrenheit; private float celsius = 1,
 * fahrenheit = 2;
 *
 * public SWingTemperatureConverter() { Container cp = getContentPane();
 *
 * cp.setLayout(new GridLayout(2, 2, 10, 3));
 *
 * cp.add(new JLabel("Celsius:")); tfCelsius = new JTextField(celsius + "", 10);
 * tfCelsius.setHorizontalAlignment(JTextField.RIGHT);
 * //tfCelsius.requestFocus(); tfCelsius.addFocusListener(this);
 * cp.add(tfCelsius);
 *
 * cp.add(new JLabel("Fahrenheit:")); tfFahrenheit = new JTextField(fahrenheit +
 * "", 10); tfFahrenheit.setHorizontalAlignment(JTextField.RIGHT);
 * tfFahrenheit.addFocusListener(this); cp.add(tfFahrenheit);
 *
 * setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); setTitle("SWing Temperature
 * Converter"); pack(); setVisible(true); }
 *
 * public static void main(String[] args) { // TODO code application logic here
 * SwingUtilities.invokeLater(new Runnable() {
 * @Override public void run() { new SWingTemperatureConverter(); }
 *
 * }); }
 *
 * @Override public void focusGained(FocusEvent fe) { Object component =
 * fe.getSource(); try { if (component == tfCelsius) { fahrenheit =
 * Float.parseFloat(tfFahrenheit.getText()); celsius = (fahrenheit - 32) * (5 /
 * 9); tfCelsius.setText(Float.toString(celsius) ); //String.format("%.1f",
 * celsius) } else if (component == tfFahrenheit) { celsius =
 * Float.parseFloat(tfCelsius.getText()); fahrenheit = ((9 / 5) * celsius) + 32;
 * tfFahrenheit.setText(Float.toString(fahrenheit) ); //String.format("%.1f",
 * fahrenheit) } } catch (NumberFormatException nfe) {
 * tfFahrenheit.setText("1"); tfCelsius.setText("2");
 * //tfCelsius.requestFocus(); }
 *
 * }
 *
 * @Override public void focusLost(FocusEvent fe) { throw new
 * UnsupportedOperationException("Not supported yet."); //To change body of
 * generated methods, choose Tools | Templates. }
 *
 * }
 */
public class SWingTemperatureConverter extends JFrame implements ActionListener {

    private JTextField tfCelsius, tfFahrenheit;
    private float celsius = 0, fahrenheit = 0;

    public SWingTemperatureConverter() {
        Container cp = getContentPane();

        cp.setLayout(new GridLayout(2, 2, 10, 3));

        cp.add(new JLabel("Celsius:"));
        tfCelsius = new JTextField(celsius + "", 10);
        tfCelsius.setHorizontalAlignment(JTextField.RIGHT);
        tfCelsius.addActionListener(this);
        cp.add(tfCelsius);

        cp.add(new JLabel("Fahrenheit:"));
        tfFahrenheit = new JTextField(fahrenheit + "", 10);
        tfFahrenheit.setHorizontalAlignment(JTextField.RIGHT);
        tfFahrenheit.addActionListener(this);
        cp.add(tfFahrenheit);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("SWing Temperature Converter");
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        // TODO code application logic here
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SWingTemperatureConverter();
            }

        });
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object component = ae.getSource();
        try {
            if (component == tfCelsius) {
                celsius = Float.parseFloat(tfCelsius.getText());
                fahrenheit = ((9/5) * celsius) + 32;
                tfFahrenheit.setText(String.format("%.1f", fahrenheit));
            } else if (component == tfFahrenheit) {
                fahrenheit = Float.parseFloat(tfFahrenheit.getText());
                celsius = (fahrenheit - 32)*5/9; //OJO no pincha (5/9)
                tfCelsius.setText(String.format("%.1f", celsius)); 
            }
        } catch (NumberFormatException nfe) {
            tfFahrenheit.setText("0");
            tfCelsius.setText("0");
            //tfCelsius.requestFocus();
        }
    }

}
