/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package grafo;

/**
 *
 * @author Stream
 */
public class Grafo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GrafoProcedencias gf5 = new GrafoProcedencias(5, 2, null);
        GrafoProcedencias gf4 = new GrafoProcedencias(4, 1, gf5.getSemaphore()); //pasamos o semaforoPrincipal do fillo correspondente
        GrafoProcedencias gf3 = new GrafoProcedencias(3, 1, gf5.getSemaphore());
        GrafoProcedencias gf2 = new GrafoProcedencias(2, 1, gf4.getSemaphore());
        GrafoProcedencias gf1 = new GrafoProcedencias(1, 0, gf3.getSemaphore(), gf2.getSemaphore());
        
        gf1.start();
        gf2.start();
        gf3.start();
        gf4.start();
        gf5.start();
    }
    
}
