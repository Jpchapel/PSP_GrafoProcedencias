/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafo;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joaquin Pereira Chapel
 */
public class GrafoProcedencias extends Thread {

    Semaphore semaforo = new Semaphore(0);
    Semaphore[] semaforos;

    private int id, recursos;

    public GrafoProcedencias(int id, int recursos, Semaphore... semaforos) {
        this.semaforos = semaforos;
        this.id = id;
        this.recursos = recursos;
    }

    public Semaphore getSemaphore() {
        return semaforo;
    }

    @Override
    public void run() {
        try {
            semaforo.acquire(recursos);
            System.out.println("Proceso " + id + " Trabajando");

            if (semaforos != null) {
                for (Semaphore semafSecundario : semaforos) {
                    semafSecundario.release();
                }
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(GrafoProcedencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
