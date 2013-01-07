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
        COM_PORT.ecrire("W,96,39,FF");
        COM_PORT.ecrire("W,96,35,58");
        COM_PORT.ecrire("W,96,36,1B");
    }
    
    public void baissePince(){
        COM_PORT.ecrire("W,96,39,FF");
        COM_PORT.ecrire("W,96,35,00");
        COM_PORT.ecrire("W,96,36,00");
    }
    
    public void ouvrePince(){
        COM_PORT.ecrire("W,96,3A,FF");
        COM_PORT.ecrire("W,96,37,EC");
        COM_PORT.ecrire("W,96,38,13");
    }
    
    public void fermePince(){
        COM_PORT.ecrire("W,96,3A,FF");
        COM_PORT.ecrire("W,96,37,00");
        COM_PORT.ecrire("W,96,38,00");
    }
    
    public void requeteFermeture(){
        COM_PORT.close();
    }
}
