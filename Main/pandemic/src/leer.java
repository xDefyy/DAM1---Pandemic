import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;

public class leer {

	public static void main(String[] args) {
		String nombreFichero = "ciudades-enfermedad.bin";
		try {

			FileInputStream fi = new FileInputStream(nombreFichero);
			DataInputStream di = new DataInputStream(fi);
			while (true) {
				String nombreLeido = di.readUTF();
				System.out.println(nombreLeido);

				

			}

		} catch (EOFException e1) {
			System.out.println("Has llegado al final");
		} catch (IOException e2) {

		}

	}

}
