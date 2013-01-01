/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.elanesse.wiinect.beans;

import net.elanesse.wiinect.wrk.ItfWrkWiimote;
import wiiusej.WiiUseApiManager;
import wiiusej.Wiimote;
import wiiusej.wiiusejevents.physicalevents.ExpansionEvent;
import wiiusej.wiiusejevents.physicalevents.IREvent;
import wiiusej.wiiusejevents.physicalevents.MotionSensingEvent;
import wiiusej.wiiusejevents.physicalevents.WiimoteButtonsEvent;
import wiiusej.wiiusejevents.utils.WiimoteListener;
import wiiusej.wiiusejevents.wiiuseapievents.ClassicControllerInsertedEvent;
import wiiusej.wiiusejevents.wiiuseapievents.ClassicControllerRemovedEvent;
import wiiusej.wiiusejevents.wiiuseapievents.DisconnectionEvent;
import wiiusej.wiiusejevents.wiiuseapievents.GuitarHeroInsertedEvent;
import wiiusej.wiiusejevents.wiiuseapievents.GuitarHeroRemovedEvent;
import wiiusej.wiiusejevents.wiiuseapievents.NunchukInsertedEvent;
import wiiusej.wiiusejevents.wiiuseapievents.NunchukRemovedEvent;
import wiiusej.wiiusejevents.wiiuseapievents.StatusEvent;

/**
 *
 * @author Muscaw
 */
public class WiimoteAdapter implements ItfWiimoteWrk, WiimoteListener{
    private ItfWrkWiimote refWrk;
    public WiimoteAdapter(ItfWrkWiimote refWrk){
        Wiimote[] wiimotes = WiiUseApiManager.getWiimotes(1, true);
        Wiimote wiimote = wiimotes[0];
        wiimote.addWiiMoteEventListeners(this);
        this.refWrk = refWrk;
    }

    @Override
    public void onButtonsEvent(WiimoteButtonsEvent wbe) {
        if(wbe.isButtonAPressed()){
            refWrk.boutonADown();
        } else {
            refWrk.boutonAUp();
        }
        if(wbe.isButtonBPressed()){
            refWrk.boutonBDown();
        } else {
            refWrk.boutonBUp();
        }
        if(wbe.isButtonLeftPressed()){
            refWrk.boutonLeftDown();
        } else {
            refWrk.boutonLeftUp();
        }
        if(wbe.isButtonRightPressed()){
            refWrk.boutonRightDown();
        } else {
            refWrk.boutonRightUp();
        }
        if(wbe.isButtonUpPressed()){
            refWrk.boutonUpDown();
        } else {
            refWrk.boutonUpUp();
        }
        if(wbe.isButtonDownPressed()){
            refWrk.boutonDownDown();
        } else {
            refWrk.boutonDownUp();
        }
        if(wbe.isButtonOnePressed()){
            refWrk.boutonUnDown();
        } else {
            refWrk.boutonUnUp();
        }
        if(wbe.isButtonTwoPressed()){
            refWrk.boutonDeuxDown();
        } else {
            refWrk.boutonDeuxUp();
        }
    }

    @Override
    public void onIrEvent(IREvent ire) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void onMotionSensingEvent(MotionSensingEvent mse) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void onExpansionEvent(ExpansionEvent ee) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void onStatusEvent(StatusEvent se) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void onDisconnectionEvent(DisconnectionEvent de) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void onNunchukInsertedEvent(NunchukInsertedEvent nie) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void onNunchukRemovedEvent(NunchukRemovedEvent nre) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void onGuitarHeroInsertedEvent(GuitarHeroInsertedEvent ghie) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void onGuitarHeroRemovedEvent(GuitarHeroRemovedEvent ghre) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void onClassicControllerInsertedEvent(ClassicControllerInsertedEvent ccie) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void onClassicControllerRemovedEvent(ClassicControllerRemovedEvent ccre) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
