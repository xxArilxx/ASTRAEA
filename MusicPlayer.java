import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;


public class MusicPlayer {
    public static void playMusic(String fileName) {;
        String filePath = "BGM/" + fileName; 
        try {
           File musicFile = new File(filePath);

           AudioInputStream audioIn = AudioSystem.getAudioInputStream(musicFile);

           Clip clip = AudioSystem.getClip();

           clip.open(audioIn);

           clip.start();
           Thread.sleep(clip.getMicrosecondLength() / 1000);
           clip.close();
        } catch (UnsupportedAudioFileException e) {
           System.out.println("Unsupported audio file format.");
           e.printStackTrace();
        } catch (IOException e) {
           System.out.println("Error reading audio file.");
           e.printStackTrace();
        } catch (LineUnavailableException e) {
           System.out.println("Audio line is unavailable.");
           e.printStackTrace();
        } catch (InterruptedException e) {
           System.out.println("Music playback was interrupted.");
           e.printStackTrace();
        }
    }
}