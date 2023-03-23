import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound {
    File wavFile;
    URL defaultSound;
    public static Clip clip;
    public static AudioInputStream audioInputStream; 

    public void play(String path) {
        try {
            defaultSound = new URL(path);
            audioInputStream = AudioSystem.getAudioInputStream(defaultSound);

            try {
                clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();

            } catch (LineUnavailableException e) {
            }

        } catch (UnsupportedAudioFileException | IOException e) {
        }
    }
    public static void main(String[] args) {
        new Sound();
    }
}
