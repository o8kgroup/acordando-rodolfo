package com.o8k.play.acordandorodolfo.media;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Player {
    public void play(Audio audio) {
        File arquivo = new File(audio.getPath());
        try {
            Clip clip = AudioSystem.getClip();

            clip.open(AudioSystem.getAudioInputStream(arquivo));
            clip.start();

            Thread.sleep(clip.getMicrosecondLength() / 930);

            clip.close();
        } catch (Exception ex) {
            System.out.println("Erro encontrado no áudio:");
            ex.printStackTrace();
        }
    }
}
