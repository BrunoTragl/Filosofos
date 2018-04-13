
import jantardosfilosofos.MesaDeJantar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rodrigo
 */
public class JantarDosFilosofos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /* Mesa de jantar para os filósofos */
        MesaDeJantar mesa = new MesaDeJantar();
        /* Criação das threads representando os cinco filósofos */
        for (int filosofo = 0; filosofo < 5; filosofo++) {
            new Filosofo("Filosofo_" + filosofo, mesa, filosofo).start();
        }
    }
}


