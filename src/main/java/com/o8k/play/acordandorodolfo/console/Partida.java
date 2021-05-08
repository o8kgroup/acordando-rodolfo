package com.o8k.play.acordandorodolfo.console;

import com.o8k.play.acordandorodolfo.lexico.Frase;
import com.o8k.play.acordandorodolfo.media.Audio;
import com.o8k.play.acordandorodolfo.media.Player;
import com.o8k.play.acordandorodolfo.personagem.Rodolfo;
import com.o8k.play.acordandorodolfo.util.FraseUtil;

import java.util.Scanner;

public class Partida {
    private int tentativa = 1;
    private final int numMaxTentativas;
    private String nomeJogador;

    private final Player player;
    private final Rodolfo rodolfo;
    private final Scanner entrada;

    public Partida() {
        this.player = new Player();
        this.rodolfo = new Rodolfo();
        this.entrada = new Scanner(System.in);
        this.numMaxTentativas = FraseUtil.tentativas.size();

        this.iniciar();
    }

    private void iniciar() {
        perguntarNome();
        iniciarTentativas();
    }

    private void perguntarNome() {
        System.out.println("QUAL É O SEU NOME? - APERTE ENTER QUANDO DIGITAR.");
        while ((nomeJogador = entrada.nextLine()).isBlank()) {
            System.out.println("O NOME NÃO PODE SER EM BRANCO!");
        }  System.out.println("--");
        saudarJogador();
    }

    private void saudarJogador() {
        System.out.println("BEM VINDO(A): " + this.nomeJogador);
        System.out.println("--");
    }

    private void iniciarTentativas() {
        imprimirAviso();

        while (oResultadoEhIndefinido() && entrada.nextLine().isBlank()) {
            imprimirFrase(FraseUtil.tentativas.get(tentativa));
            tocarAudio(FraseUtil.tentativas.get(tentativa));

            rodolfo.tentarAcordar();

            avaliarResultado();
        }
    }

    private void imprimirAviso() {
        System.out.println("MODO DE JOGO:");
        System.out.println("* VOCÊ TEM: " + numMaxTentativas + " TENTATIVAS.");
        System.out.println("* APERTE ENTER PARA IR TENTANDO ACORDAR O RODOLFO.");
        System.out.println("--");
    }

    private boolean oResultadoEhIndefinido() {
        return !rodolfo.estaAcordado() && tentativa <= numMaxTentativas;
    }

    private void imprimirFrase(Frase frase) {
        System.out.println(frase.getConteudo());
    }

    private void tocarAudio(Frase frase) {
        player.play(new Audio(frase.getNomeAudio()));
    }

    private void avaliarResultado() {
        if (rodolfo.estaAcordado()) {
            imprimirVitoria();
        }
        if (tentativa == numMaxTentativas && !rodolfo.estaAcordado()) {
            imprimirDerrota();
        }
        tentativa++;
    }

    private void imprimirVitoria() {
        imprimirFrase(FraseUtil.getDesfechoFeliz());
        tocarAudio(FraseUtil.getDesfechoFeliz());

        System.out.println("--");
        System.out.println("PARABÉNS : " + nomeJogador + ", VOCÊ ACORDOU O RODOLFO NA TENTATIVA NÚMERO: " + tentativa);
    }

    private void imprimirDerrota() {
        System.out.println("--");
        System.out.println("-------- R.I.P --------");
        imprimirFrase(FraseUtil.getDesfechoTriste());
        tocarAudio(FraseUtil.getDesfechoTriste());
    }
}
