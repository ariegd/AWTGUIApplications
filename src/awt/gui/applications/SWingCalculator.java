/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awt.gui.applications;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Z97A
 */
public class SWingCalculator extends JFrame {

    private JTextField tfDisplay;
    private int result = 0;
    private String numberInStr = "";
    private char previousOpr;
    private char currentOpr;
    
    private JPanel pnlBtns;
    private JButton[] arrBtns;
    
    public SWingCalculator(){
        Container cp = getContentPane();
        
        cp.setLayout(new BorderLayout());
        
        tfDisplay = new JTextField("", 10);
        tfDisplay.setHorizontalAlignment(JTextField.RIGHT);
        cp.add(tfDisplay, BorderLayout.NORTH);
        
        pnlBtns = new JPanel();
        pnlBtns.setLayout(new GridLayout(4,4,3,3));
        
        arrBtns = new JButton[16];
        
        int size = arrBtns.length;
        
        for(int i = 0; i < size; i++){
            switch(i){
                case 0:
                    i = btnsLoop(i, 3, 7, true);
                    break;
                case 3:
                    oprBtns(i, "+");
                    break;
                case 4:
                    i = btnsLoop(i, 7, 0, true);
                    break;
                case 7:
                    oprBtns(i, "-");
                    break;
                case 8:
                    i = btnsLoop(i, 11, 7, false);
                    break;
                case 11:
                    oprBtns(i, "*");
                    break;
                case 12:
                    /***Hay que modificarlo con una inner class***/
                    oprBtns(i, "C");
                    break;
                case 13:
                    btnsLoop(i, 14, 13, false);
                    break;
                case 14:
                    oprBtns(i, "=");
                    break; 
                case 15:
                    oprBtns(i, "/");
                    break;
            }
        }
        
        cp.add(pnlBtns, BorderLayout.CENTER);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("SWing Calculator");
        pack();
        setVisible(true);
    }
    
    private int btnsLoop(int a, int b, int c, boolean flag){
        if(flag){
            while (a < b) {
                arrBtns[a] = new JButton((a + c) + "");
                arrBtns[a].addActionListener(new NumberBtnListener());
                pnlBtns.add(arrBtns[a]);
                a++;
            }
        }else{
            while (a < b) {
                arrBtns[a] = new JButton((a - c) + "");
                arrBtns[a].addActionListener(new NumberBtnListener());
                pnlBtns.add(arrBtns[a]);
                a++;
            }
        }
        return --a;
    }
    
    private void oprBtns(int a, String str){
        arrBtns[a] = new JButton(str);
        arrBtns[a].addActionListener(new OprBtnListener());
        pnlBtns.add(arrBtns[a]);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        javax.swing.SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                new SWingCalculator();
            }
        });
    }

    class NumberBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            numberInStr += ae.getActionCommand();
            tfDisplay.setText(numberInStr);
        }
    }

    class OprBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            previousOpr = currentOpr;
            currentOpr = ae.getActionCommand().charAt(0);
            /*El método charAt devuelve un valor de carácter 
            igual al carácter situado en la posición especificada 
            por index. El primer carácter de una cadena está en el 
            índice 0, el segundo en el índice 1 y así sucesivamente. 
            Los valores de index que no están dentro del intervalo 
            válido devuelven una cadena vacía.*/
            
        }
    }

}
