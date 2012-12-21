/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.elanesse.wiinect.ctrl;

import java.awt.image.BufferedImage;
import net.elanesse.wiinect.ihm.ItfIhmCtrl;
import net.elanesse.wiinect.wrk.ItfWrkCtrl;

/**
 *
 * @author Muscaw
 */
public class Ctrl implements ItfCtrlIhm, ItfCtrlWrk{

    private ItfIhmCtrl refIhm;
    private ItfWrkCtrl refWrk;
    
    public void start(){
        
    }
    
    @Override
    public void connecte(boolean isKinect, String portCOM) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void afficheImage(BufferedImage image) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
        public ItfIhmCtrl getRefIhm() {
        return refIhm;
    }

    public void setRefIhm(ItfIhmCtrl refIhm) {
        this.refIhm = refIhm;
    }

    public ItfWrkCtrl getRefWrk() {
        return refWrk;
    }

    public void setRefWrk(ItfWrkCtrl refWrk) {
        this.refWrk = refWrk;
    }
}
