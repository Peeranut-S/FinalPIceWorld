import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
import javax.swing.*;
   
// To play sound using Clip, the process need to be alive.
// Hence, we use a Swing application.
public class Audio {//extends JFrame {
   Clip clip;
   // Constructor
   public Audio(String music) {

      try {
         // Open an audio input stream.
         URL url = this.getClass().getClassLoader().getResource(music);
         AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
         // Get a sound clip resource.
          clip = AudioSystem.getClip();
         // Open audio clip and load samples from the audio input stream.
         clip.open(audioIn);
         clip.loop(Clip.LOOP_CONTINUOUSLY);
      } catch (UnsupportedAudioFileException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      } catch (LineUnavailableException e) {
         e.printStackTrace();
      }
      
   }
   public void stop(){
	   clip.stop();
   }
   
   public void decrease()//decrease volume
   {
       FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
     
       gainControl.setValue(-10.0f); // Reduce volume by 10 decibels.
     
       
   }
   public void increase()//increase volume
   {
       FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
       gainControl.setValue(+10.0f); 
   }
   
 
}