/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.elanesse.wiinect.ihm;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author Muscaw
 */
public interface ItfIhmCtrl {
    void afficheImage(BufferedImage image);
    void start(ArrayList<String> listePortsCom);
    void afficheErreur(String erreur);
}
