/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafoprocedencias;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Stream
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        GrafoProcedencias h5 = new GrafoProcedencias(5, 2, null);
        GrafoProcedencias h4 = new GrafoProcedencias(4, 1, h5.getSemaphore()); //pasamos o semaforoPrincipal do fillo correspondente
        GrafoProcedencias h3 = new GrafoProcedencias(3, 1, h5.getSemaphore());
        GrafoProcedencias h2 = new GrafoProcedencias(2, 1, h4.getSemaphore());
        GrafoProcedencias h1 = new GrafoProcedencias(1, 0, h3.getSemaphore(), h2.getSemaphore());

        h1.start();
        h2.start();
        h3.start();
        h4.start();
        h5.start();
    }

}
