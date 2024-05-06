package controladores;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class reproductorWav {
	private Clip clip;

	public void cargarSonido(String ruta) {
		try {
			File archivoSonido = new File(ruta);
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(archivoSonido);
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void reproducir() {
		if (clip != null) {
			clip.setFramePosition(0);
			clip.start();
		}
	}
	
	public void detener() {
		if (clip != null && clip.isRunning()) {
			clip.stop();
		}
	}
	public void reproducirConRepetir() {
	    if (clip != null) {
	        clip.loop(Clip.LOOP_CONTINUOUSLY); // Reproduce el clip en bucle continuamente
	    }
	}

}
