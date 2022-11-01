package com.group21.app.Entity;

import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Music {

    public static void Music(String filePath){
        File musicPathRelative = new File(filePath);
         try {
            Clip audioClip = AudioSystem.getClip();
            audioClip.open(AudioSystem.getAudioInputStream(musicPathRelative));
            audioClip.start();
            audioClip.loop(Clip.LOOP_CONTINUOUSLY);
        
        } catch (Exception e) {
            System.out.println("Error: Unable to play background music");
         }
    }
    
}
