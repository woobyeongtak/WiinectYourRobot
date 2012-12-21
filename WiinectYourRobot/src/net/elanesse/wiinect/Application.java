/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.elanesse.wiinect;

import net.elanesse.wiinect.ctrl.Ctrl;
import net.elanesse.wiinect.ihm.Ihm;
import net.elanesse.wiinect.wrk.Wrk;

/**
 *
 * @author Muscaw
 */
public class Application {

    public static void main(String[] args) {
        Wrk wrk = new Wrk();
        Ihm ihm = new Ihm();
        Ctrl ctrl = new Ctrl();
        
        wrk.setRefCtrl(ctrl);
        ihm.setRefCtrl(ctrl);
        ctrl.setRefIhm(ihm);
        ctrl.setRefWrk(wrk);
        ctrl.start();
    }
}
