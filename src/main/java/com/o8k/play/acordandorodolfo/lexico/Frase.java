package com.o8k.play.acordandorodolfo.lexico;

public class Frase {
    private final String conteudo;
    private final String nomeAudio;

    public Frase(String conteudo, String nomeAudio) {
        this.conteudo = conteudo;
        this.nomeAudio = nomeAudio;
    }

    public String getConteudo() {
        return conteudo;
    }

    public String getNomeAudio() {
        return nomeAudio;
    }
}
