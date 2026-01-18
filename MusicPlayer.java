import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class MusicPlayer {
   public static Clip currentClip;
    
   public static void playMusic(String fileName) {
      stopMusic();
        
      String filePath = "BGM/" + fileName; 
      try {
         File musicFile = new File(filePath);
            
         if (!musicFile.exists()) {
             System.out.println("Music file not found: " + filePath);
             return;
         }
            
         AudioInputStream audioIn = AudioSystem.getAudioInputStream(musicFile);
            
         currentClip = AudioSystem.getClip();
         currentClip.open(audioIn);
         
         currentClip.loop(Clip.LOOP_CONTINUOUSLY);
            
         currentClip.start();
            
      } catch (UnsupportedAudioFileException e) {
         System.out.println("Unsupported audio file format: " + fileName);
         e.printStackTrace();
      } catch (IOException e) {
         System.out.println("Error reading audio file: " + fileName);
         e.printStackTrace();
      } catch (LineUnavailableException e) {
         System.out.println("Audio line is unavailable.");
         e.printStackTrace();
      } catch (Exception e) {
         System.out.println("Error playing music: " + fileName);
         e.printStackTrace();
      }
   }
    
   public static void stopMusic() {
      if (currentClip != null && currentClip.isRunning()) {
         currentClip.stop();
         currentClip.close();
      }

      currentClip = null;
   }
}