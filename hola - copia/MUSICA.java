import java.io.File;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class MUSICA {

	public static void main(String[] args) throws Exception {
		
	}
		public static void play(String audio)
		{
		    try
		    {
		        Clip clip = AudioSystem.getClip();
		        clip.open(AudioSystem.getAudioInputStream(new File(audio)));
		        clip.start();
		    }
		    catch (Exception exc)
		    {
		        exc.printStackTrace(System.out);
		        System.out.println("hola");
		    }
		}
    }
