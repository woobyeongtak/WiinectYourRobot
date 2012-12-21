/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.elanesse.wiinect.ctrl;

/**
 *
 * @author Muscaw
 */
public interface ItfCtrlIhm {
    void connecte(boolean isKinect, String portCOM);
    void close();
}
