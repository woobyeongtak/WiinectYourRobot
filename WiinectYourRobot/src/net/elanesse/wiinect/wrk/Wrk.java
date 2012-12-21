/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.elanesse.wiinect.wrk;

import java.awt.image.BufferedImage;
import net.elanesse.wiinect.beans.ItfKinectWrk;
import net.elanesse.wiinect.beans.ItfWiimoteWrk;
import net.elanesse.wiinect.ctrl.ItfCtrlWrk;

/**
 *
 * @author Muscaw
 */
public class Wrk implements ItfWrkCtrl, ItfWrkKinect, ItfWrkWiimote, ItfWrkCamera{
    private boolean isKinect;
    private ItfCtrlWrk refCtrl;
    private ItfKinectWrk refKinect;
    private ItfWiimoteWrk refWiimote;

    @Override
    public void boutonUpDown() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void boutonDownDown() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void boutonRightDown() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void boutonLeftDown() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void boutonADown() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void boutonBDown() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void boutonUnDown() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void boutonDeuxDown() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void afficheImage(BufferedImage image) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean connecte(boolean isKinect, String portCOM) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ItfCtrlWrk getRefCtrl() {
        return refCtrl;
    }

    public void setRefCtrl(ItfCtrlWrk refCtrl) {
        this.refCtrl = refCtrl;
    }

    public ItfKinectWrk getRefKinect() {
        return refKinect;
    }

    public void setRefKinect(ItfKinectWrk refKinect) {
        this.refKinect = refKinect;
    }

    public ItfWiimoteWrk getRefWiimote() {
        return refWiimote;
    }

    public void setRefWiimote(ItfWiimoteWrk refWiimote) {
        this.refWiimote = refWiimote;
    }
    
    
}
