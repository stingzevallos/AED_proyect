package gui;

import clases.*;
import arreglos.*;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.Locale;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class DlgIngresosyConsumosPagados extends JDialog {
	
	private JScrollPane scrollPane;
	private JTextArea txtS;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgIngresosyConsumosPagados dialog = new DlgIngresosyConsumosPagados();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public DlgIngresosyConsumosPagados() {
		setResizable(false);
		setTitle("Reporte | Ingresos y Consumos Pagados");
		setBounds(100, 100, 700, 400);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 15, 675, 345);
		getContentPane().add(scrollPane);
	
		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 15));
		scrollPane.setViewportView(txtS);
		
		listar();
	}
	
	//  Métodos tipo void (sin parámetros)
	void imprimir() {
		imprimir("");
	}
	void listar() {
		
		

		
		ArregloIngreso ai = new ArregloIngreso();
		ArregloSocios as = new ArregloSocios();
		Ingreso a;
		Socio s;
		
		
		
		
		txtS.setText("");
		
		
		
		
		
		for (int i=0; i<ai.tamaño(); i++) {
			i = ai.obtener(i);
			
			
			if (i.getEstado() == 1) {
				
				
				
				s = as.buscar(i.getCodigoSocio());
				
				
				imprimir("Código de ingreso :  " + i.getCodigoIngreso());
				
				imprimir("Datos del Socio");
				
				imprimir("Código del socio   :  " + i.getcodigoSocio());
				imprimir("Nombres            :  " + s.getNombres());
				imprimir("Apellidos          :  " + s.getApellidos());
				imprimir("DNI                :  " + s.getDni());
				imprimir("Teléfono           :  " + s.getTelefono());
				imprimir("Sexo               :  " + s.getSexos());
				
				imprimir("Productos Consumidos")		  
												  
				imprimir("Total pagado       :  S/ " + formato(i.getApagar()));
				
				
				imprimir();
				
				
				
				
			}
		}
		
		
		
	}
	//  Métodos tipo void (con parámetros)
	void imprimir(String s) {
		txtS.append(s + "\n");
	}
	//  Métodos que retornan valor (con parámetros)
	String formato(double real) {
		return String.format(Locale.US, "%-10.2f", real);
	}
	
}