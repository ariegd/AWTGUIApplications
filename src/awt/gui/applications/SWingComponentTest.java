/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awt.gui.applications;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author Z97A
 *******No pincha con JTextField si con JButton******
 */
/*public class SWingComponentTest extends JFrame implements ActionListener {
    private JTextField tfInput1, tfInput2;
    
    public SWingComponentTest(){
        super("Barra de Titulos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setLayout(new FlowLayout());
        
        tfInput1 = new JTextField("JavaScript", 8);
        tfInput1.addActionListener(this);
        add(tfInput1);
        
        tfInput2 = new JTextField("PHP", 8);
        tfInput2.addActionListener(this);
        add(tfInput2);
        
        pack();
        setVisible(true);
    }
    /**
     * @param args the command line arguments
 */
 /*public static void main(String[] args) {
        // TODO code application logic here
        new SWingComponentTest();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object fuente = ae.getSource();
        if(fuente == tfInput1){
            setTitle("JavaScript");
        }else if(fuente == tfInput2){
            setTitle("PHP");
        }
        repaint();
    }
}*/

/******Ahora si pincha JTextField con FocusListener********/
/*public class SWingComponentTest extends JFrame implements FocusListener {

    private JTextField tfInput1, tfInput2;

    public SWingComponentTest() {
        super("Barra de Titulos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new FlowLayout());

        tfInput1 = new JTextField("JavaScript", 8);
        tfInput1.addFocusListener(this);
        add(tfInput1);

        tfInput2 = new JTextField("PHP", 8);
        tfInput2.addFocusListener(this);
        add(tfInput2);

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        // TODO code application logic here
        new SWingComponentTest();
    }

    @Override
    public void focusGained(FocusEvent fe) {
        Object fuente = fe.getSource();
        if (fuente == tfInput1) {
            setTitle("JavaScript");
        } else if (fuente == tfInput2) {
            setTitle("PHP");
        }
        repaint();
    }

    @Override
    public void focusLost(FocusEvent fe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}*/

public class SWingComponentTest extends JFrame implements FocusListener {

    private JTextField tfInput1, tfInput2;
    private int count = 0;
    
    public SWingComponentTest() {
        super("Barra de Titulos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new FlowLayout());

        tfInput1 = new JTextField("JavaScript", 8);
        tfInput1.addFocusListener(this);
        add(tfInput1);

        tfInput2 = new JTextField("PHP", 8);
        tfInput2.addFocusListener(this);
        add(tfInput2);

        pack();
        setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new SWingComponentTest();
    }

    @Override
    public void focusGained(FocusEvent fe) {
        Object fuente = fe.getSource();
        try{
            if (fuente == tfInput1) {
                count = Integer.parseInt(tfInput2.getText()) + 10;
                tfInput1.setText(count + "");
                setTitle("JavaScript");
            } else if (fuente == tfInput2) {
                count = Integer.parseInt(tfInput1.getText()) + 10;
                tfInput2.setText(count + "");
                setTitle("PHP");
            }
            repaint();
        }catch(NumberFormatException nfe){
            tfInput1.setText("1");
            tfInput2.setText("2");
        }
    }

    @Override
    public void focusLost(FocusEvent fe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
