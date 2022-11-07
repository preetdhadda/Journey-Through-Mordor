package com.group21.app.Entity;

import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * This class creates an entity for the game's background music.
 * @author Jessy
 */
public class Music {

    /**
     * This method reads the audio clip and loops continuously
     * @param filePath represents the relative path to the audio clip
     * @author Jessy
     */
    public static void setMusic(String filePath){
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
