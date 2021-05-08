package com.o8k.play.acordandorodolfo.personagem;

import java.util.Random;

public class Rodolfo {
    private static final int RODOLFO_ACORDADO_INDICADOR = 4;

    private boolean acordado = false;

    public boolean estaAcordado() {
        return acordado;
    }

    public void tentarAcordar() {
        var indicadorGerado = new Random().nextInt(6);
        acordado = (indicadorGerado == RODOLFO_ACORDADO_INDICADOR);
    }
}
