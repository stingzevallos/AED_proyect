package gui;

//   import libreria.Lib;

import clases.*;
import arreglos.*;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.Locale;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class DlgHospedajesPendientes extends JDialog {
	
	private JScrollPane scrollPane;
	private JTextArea txtS;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgHospedajesPendientes dialog = new DlgHospedajesPendientes();
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
	public DlgHospedajesPendientes() {
		setResizable(false);
		setTitle("Reporte | Hospedajes pendientes");
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
		
		
		
		ArregloHospedaje ah = new ArregloHospedaje();
		ArregloSocio as = new ArregloSocio();
		ArregloBungalow ab = new ArregloBungalow();
		ArregloIngreso ai = new ArregloIngreso();
		
		
		Hospedaje h;
		Socio s;
		Bungalow b;
		
		
		txtS.setText("");
		for (int j=0; j<ah.tama�o(); j++) {
			h = ah.obtener(j);
			if (h.getEstado() == 0) {
				Ingreso in = ai.buscar( h.getCodigoIngreso());
				s = as.buscar( in.getCodigoSocio());
				b = ab.buscar(h.getNumeroBungalow());
				imprimir("Código de hospedaje :  " + h.getCodigoHospedaje());
				imprimir("Código de socio         :  " + s.getCodigo());
				imprimir("Nombres                 :  " + s.getNombre());
				imprimir("Apellidos               :  " + s.getApellidos());
				imprimir("Número de bugalow          :  " + h.getNumeroBungalow());
			//	imprimir("Categoría               :  " + h.categoriasBungalow[b.getCategoria()]);
				imprimir("Precio por día          :  S/ " + formato(b.getPrecio()));
				imprimir("Fecha de ingreso        :  " + h.getFechaIngreso()
				                                       + " - " + h.getHoraIngreso());
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