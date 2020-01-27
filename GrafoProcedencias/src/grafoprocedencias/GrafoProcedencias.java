/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafoprocedencias;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Stream
 */
public class GrafoProcedencias extends Thread {

    Semaphore semaforoPropio = new Semaphore(0);
    Semaphore[] semaforosSecundarios;

    private int id, recursos;

    public GrafoProcedencias(int id, int recursos, Semaphore... semafSecundarios) {
        this.semaforosSecundarios = semafSecundarios;
        this.id = id;
        this.recursos = recursos;
    }

    public Semaphore getSemaphore() {
        return semaforoPropio;
    }
    
    @Override
    public void run() {
        try {
            semaforoPropio.acquire(recursos);
            System.out.println("Proceso " + id + " trabajando");
            
            if (semaforosSecundarios != null) {
                for (Semaphore nuevoSemaforo : semaforosSecundarios) {
                    nuevoSemaforo.release();
                }
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(GrafoProcedencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}
