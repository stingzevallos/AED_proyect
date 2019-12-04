package librerias;

import java.awt.event.KeyEvent;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Validacion {
	public static void mensajeError(JDialog jd, String s) {
		JOptionPane.showMessageDialog(jd, s, "Mensaje de error - SIL", 0);
		
	}
	public static void mensajeInformacion(JDialog jd, String s) {
		JOptionPane.showMessageDialog(jd, s, "Mensaje de confrimacion - SIL", 1);
	}
	public static void mensajeAdvertencia(JDialog jd, String s) {
		JOptionPane.showMessageDialog(jd, s, "Mensaje de advertencia - SIL", 2);
	}
	public static void soloLetras(KeyEvent e, JTextField txt, int maximo) {
	 	char x = e.getKeyChar();
	 	if (Character.isDigit(x)  &&  x != ' ')
	 		e.consume();
       	if (txt.getText().length() == maximo)
       		e.consume();
    }
    public static void soloNumeros(KeyEvent e, JTextField txt, int maximo) {
    	char x = e.getKeyChar();	 
	 	if (!Character.isDigit(x))
			e.consume();
       	if (txt.getText().length() == maximo)
			e.consume();
    }
	//  Métodos static que retornan valor (con parámetros)
	public static int mensajeConfirmacion(JDialog jd, String s) {
		return JOptionPane.showConfirmDialog(jd, s, "Mensaje de confirmacion - SIL", 0, 3, null);
	}
	
	public static void soloNumerosDouble(KeyEvent e, JTextField txt, int max) {
		char caracter = e.getKeyChar();
		if (((caracter < '0') || (caracter > '9')) 
		        && (caracter != KeyEvent.VK_BACK_SPACE)
		        && (caracter != '.' || txt.getText().contains(".")) ) {
		            e.consume();
		}
		if(txt.getText().length()==max) {
			e.consume();
		}
	}

}
