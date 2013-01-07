/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.elanesse.wiinect.beans;

import com.googlecode.javacv.FrameGrabber.Exception;
import com.googlecode.javacv.VideoInputFrameGrabber;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.elanesse.wiinect.wrk.ItfWrkCamera;

/**
 *
 * @author Muscaw
 */
public class Camera extends Thread{
    private ItfWrkCamera refWrk;
    private volatile boolean running = true;
    
    public Camera(ItfWrkCamera refWrk){
        this.refWrk = refWrk;
    }
    
    public void stopCamera(){
        this.running = false;
    }

    @Override
    public void run() {
        VideoInputFrameGrabber vifg = new VideoInputFrameGrabber(0);
        try {
            vifg.start();
            
            while(running){
                refWrk.afficheImage(vifg.grab().getBufferedImage());
            }
        } catch (Exception ex) {
            Logger.getLogger(Camera.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
