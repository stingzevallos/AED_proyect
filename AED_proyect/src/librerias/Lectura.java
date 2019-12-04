package librerias;

import javax.swing.*;

public class Lectura {
	public static String leerCadena(JTextField txt) {
		return txt.getText().trim();
	}
	public static String leerCadenaGrande(JTextArea txt) {
		return txt.getText().trim();
	}
	public static int leerEntero(JTextField txt) {
		return Integer.parseInt(txt.getText().trim());
	}
	public static double leerDouble(JTextField txt) {
		return Double.parseDouble(txt.getText().trim());
	}
	public static double leerDouble(JLabel lbl) {
		return Double.parseDouble(lbl.getText().trim());
	}
	public static int leerEntero(JLabel lbl) {
		return Integer.parseInt(lbl.getText().trim());
	}
	public static int leerCbo(JComboBox<String> cbo) {
			return cbo.getSelectedIndex();
	}
	
	public static String leerItemCbo(JComboBox<String> cbo) {		
		return cbo.getSelectedItem().toString();		
	}
}
