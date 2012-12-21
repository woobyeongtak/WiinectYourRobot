/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.elanesse.wiinect.ihm;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import net.elanesse.wiinect.ctrl.ItfCtrlIhm;

/**
 *
 * @author Muscaw
 */
public class Ihm implements ItfIhmCtrl{
    private ItfCtrlIhm refCtrl;
    private JFrame frame;
    private JButton bKinect, bWiimote, bDemarrer;
    private JLabel lChoixKinectWiimote, lChoixPortCom;
    private JComboBox<String> cbListePorts;
    

    @Override
    public void afficheImage(BufferedImage image) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void start(ArrayList<String> listePortsCom) {
        frame = new JFrame("Choix du périphérique");
        
        
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                refCtrl.close();
                System.exit(0);
            }
            
        });
    }

    @Override
    public void afficheErreur(String erreur) {
        JOptionPane.showMessageDialog(null, erreur);
    }

    public ItfCtrlIhm getRefCtrl() {
        return refCtrl;
    }

    public void setRefCtrl(ItfCtrlIhm refCtrl) {
        this.refCtrl = refCtrl;
    }
}
