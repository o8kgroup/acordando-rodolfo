package com.o8k.play.acordandorodolfo.util;

import com.o8k.play.acordandorodolfo.lexico.Frase;
import lombok.experimental.UtilityClass;

import java.util.HashMap;
import java.util.Map;

@UtilityClass
public class FraseUtil {
    public Map<Integer, Frase> desfecho = new HashMap<>();
    public Map<Integer, Frase> tentativas = new HashMap<>();

    static {
        desfecho.put(1, new Frase(
                "Rodolfo!!! Ahhhh!! Estava dormindo, ai que susto, que susto em, que susto!",
                "12_Alivio.wav"));

        desfecho.put(2, new Frase("Ôh não, Rudi morreu!!!", "13_Triste.wav"));
    }

    static {
        tentativas.put(1, new Frase("Rodolfo!", "1_Rodolfo.wav"));
        tentativas.put(2, new Frase("RRodolfoo!!", "2_RRodolfoo.wav"));
        tentativas.put(3, new Frase("RRRodolfooo!!!!!!!", "3_RRRodolfooo.wav"));
        tentativas.put(4, new Frase("Que te passa?!", "4_Que_te_passa.wav"));
        tentativas.put(5, new Frase("Rudi!, Rudi!", "5_Rudi_Rudi.wav"));
        tentativas.put(6, new Frase("Rodolfin!!", "6_Rodolfin.wav"));
        tentativas.put(7, new Frase("Rodolfin!!!", "7_Rodolfin.wav"));
        tentativas.put(8, new Frase("Ãhuuu!! Rodolfo!!", "8_Ahuuu_Rodolfo.wav"));

        tentativas.put(9, new Frase(
                "Rodolfo!! Rodolfoôô!!!", "9_Rodolfo_Rodolfooo.wav"));

        tentativas.put(10, new Frase(
                "Está morto! Não respira!", "10_Esta_morto_Nao_respira.wav"));

        tentativas.put(11, new Frase(
                "Não respi... acho que respira... respira... será que está vivo?",
                "11_Nao_respi_acho_que_Respira_respira_sera_que_esta_vivo.wav"));
    }

    public Frase getDesfechoFeliz() {
        return desfecho.get(1);
    }

    public Frase getDesfechoTriste() {
        return desfecho.get(2);
    }
}
