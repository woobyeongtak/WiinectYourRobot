package net.elanesse.wiinect.helper;

import com.sun.comm.Win32Driver;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.comm.CommPortIdentifier;
import javax.comm.PortInUseException;
import javax.comm.SerialPort;
import javax.comm.UnsupportedCommOperationException;

/**
 * Cette classe gere la connexion RS232.
 *
 * @author SilacciA
 * @version 1.0
 * @since 07.12.2012
 */
public class Rs232 {
    private static Rs232 instance;
    private BufferedReader bufRead;
    private BufferedWriter bufWriter;
    private InputStream in;
    private OutputStream outStream;
    private CommPortIdentifier portId;
    private SerialPort sPort;

    /**
     * Constructeur de la classe RS232. Elle prepare la connexion sur le port.
     *
     * @param port String le port a connecter.
     */
    private Rs232() {
        Win32Driver w32Driver = new Win32Driver();
        w32Driver.initialize();
    }
    
    public ArrayList<String> listePorts(){
        ArrayList<String> retour = new ArrayList<>();
        Enumeration e = CommPortIdentifier.getPortIdentifiers();
        while(e.hasMoreElements()){
            retour.add(((CommPortIdentifier) e.nextElement()).getName());
        }
        return retour;
    }

    /**
     * Cette methode permet d'ouvrire la connexion.
     */
    public boolean open(String port) {
        boolean ok = false;
        try {
            portId = CommPortIdentifier.getPortIdentifier(port);
            sPort = (SerialPort) portId.open("test", 2000); // 10000 = timeout
            sPort.setFlowControlMode(SerialPort.FLOWCONTROL_NONE);
            sPort.setSerialPortParams(57600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
            in = sPort.getInputStream();
            outStream = sPort.getOutputStream();
            bufRead = new BufferedReader(new InputStreamReader(in));
            bufWriter = new BufferedWriter(new OutputStreamWriter(outStream));
            ok = true;
        } catch (IOException ex) {
            Logger.getLogger(Rs232.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedCommOperationException ex) {
            System.err.println("Erreur de récupération du port.");
        } catch (PortInUseException ex) {
            System.err.println("Port déjà utilisé.");
        } catch (Exception ex) {
            System.err.println("Erreur rencontrée");
        }
        return ok;
    }

    /**
     * Cette methode permet de fermer la connexion.
     */
    public void close() {
        sPort.close();
    }

    /**
     * Cette methode permet de lire sur l'InputStream de la connexion.
     *
     * @return le String de la lecteure de la ligne.
     */
    public String lire() {
        try {
            return bufRead.readLine();
        } catch (IOException ex) {
            Logger.getLogger(Rs232.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Cette methode permet d'envoyer un String via l'OutputStream de la
     * connexion.
     *
     * @param texte String le texte a envoyer.
     */
    public synchronized void ecrire(String texte) {
        try {
            bufWriter.write(texte + "\n");
        } catch (IOException ex) {
            Logger.getLogger(Rs232.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                bufWriter.flush();
            } catch (IOException ex) {
                Logger.getLogger(Rs232.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static Rs232 getRs232(){
        if(instance == null){
            instance = new Rs232();
        }
        return instance;
    }
}
