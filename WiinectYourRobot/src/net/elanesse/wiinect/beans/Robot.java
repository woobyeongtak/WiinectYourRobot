/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.elanesse.wiinect.beans;

import net.elanesse.wiinect.helper.Rs232;

/**
 *
 * @author Muscaw
 */
public class Robot {
    private int vitesse = 20;
    private boolean stop = true;
    private static final Rs232 COM_PORT = Rs232.getRs232();
    
    public Robot(String port) {
        COM_PORT.open(port);
    }

    public void avance(){
        COM_PORT.ecrire("D," + vitesse + "," + vitesse);
    }
    
    public void recule(){
        COM_PORT.ecrire("D,-" + vitesse + ",-" + vitesse);
    }
    
    public void tourneDroite(){
        COM_PORT.ecrire("D," + vitesse + ",0");
    }
    
    public void tourneGauche(){
        COM_PORT.ecrire("D,0," + vitesse);
    }
    
    public void beep(){
        
    }
    
    public void levePince(){
        
    }
    
    public void baissePince(){
        
    }
    
    public void ouvrePince(){
        
    }
    
    public void fermePince(){
        
    }
    
    public void requeteFermeture(){
        COM_PORT.close();
    }
}
