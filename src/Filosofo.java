
import jantardosfilosofos.MesaDeJantar;

public class Filosofo extends Thread {

    final static int TEMPO_MAXIMO = 100;
    /* Referência à mesa de jantar */

    MesaDeJantar mesa;
    /* Filósofo na mesa [0,1,2,3,4] */
    int filosofo;

    public Filosofo(String nomeThread, MesaDeJantar mesa, int filosofo) {
        /* construtor da classe pai */
        super(nomeThread);
        this.mesa = mesa;
        this.filosofo = filosofo;
    }

    public void run() {
        int tempo = 0;
        /* Laço representando a vida de um filósofo : pensar e comer */
        while (true) {
            if (aindaTemComida() > 0) {
                if(mesa.getQuantidadeComida() == 0)
                    super.stop();
                
                /* sorteando o tempo pelo qual o filósofo vai pensar */
                tempo = (int) (Math.random() * TEMPO_MAXIMO);
                /* filósofo pensando */
                pensar(tempo);
                /* filósofo pegando garfos */
                pegarGarfos();
                /* sorteando o tempo pelo qual o filósofo vai comer */
                tempo = (int) (Math.random() * TEMPO_MAXIMO);
                /* filósofo comendo */
                comer(tempo);
                /* filósofo devolvendo garfos */
                devolverGarfos();

                if(mesa.jaAcabouAComida())
                    exibeQuantidadeQueFilosofoComeu(filosofo);
                
            } else {
                super.stop();
            }
        }
    }

    /* simula o filósofo pensando */
    private void pensar(int tempo) {
        try {
            /* filósofo dorme de tempo milisegundos */
            sleep(tempo);
        } catch (InterruptedException e) {
            System.out.println("Filófoso pensou demais, morreu");
        }
    }

    /* simula o filósofo comendo */
    private void comer(int tempo) {
        try {
            sleep(tempo);
            mesa.comeu(filosofo);
        } catch (InterruptedException e) {
            System.out.println("Filófoso comeu demais, morreu");
        }
    }

    /* pega os garfos */
    private void pegarGarfos() {
        mesa.pegandoGarfos(filosofo);
    }

    /* devolve os garfos */
    private void devolverGarfos() {
        mesa.devolvendoGarfos(filosofo);
    }

    private int aindaTemComida() {
        return mesa.getQuantidadeComida();
    }

    private void informaQuantidadeComida() {
        if (!mesa.jaAcabouAComida()) {
            int quantidadeComida = aindaTemComida();
            System.out.println("Ainda temos " + quantidadeComida + " porções!");
        }else{
            System.out.println("Não temos mais comida!");
        }
    }
    
    private void exibeQuantidadeQueFilosofoComeu(int i){
        int quantidadeComidaFilosoComeu = mesa.exibeQuantidadeQueFilosofoComeu(i);
        System.out.println("Eu filósofo do array número " + filosofo + " comi " + quantidadeComidaFilosoComeu + " porções!");
    }
}
