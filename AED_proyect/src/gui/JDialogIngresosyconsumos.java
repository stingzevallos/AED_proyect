package gui;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;


import clases.Ingreso;

import arreglos.ArregloIngreso;

import clases.Socio;

import arreglos.ArregloSocio;


import arreglos.ArregloConsumos;



import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.SystemColor;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import java.awt.Component;
import java.awt.Rectangle;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.BevelBorder;
import java.awt.ScrollPane;
import java.awt.Panel;
import java.awt.Label;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;

public class JDialogIngresosyconsumos extends JDialog implements ActionListener {	
	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtDNI;
	private JComboBox<String> cboCodigo; 
	private JTextField txtPagoTotal;
	private JTextField txtEstado;
	private DefaultTableModel model;
	private JTextField txtPagoIngreso;
	private JTextField txtFecha;
	private JButton btnPagar;
	private JButton btnSalir;
	private JTable tableConsumo;
	private JScrollPane scrollPane;
	private JButton btnConsultarDatos;
	
	ArregloIngreso ai = new ArregloIngreso();
	ArregloSocio as = new ArregloSocio();
	ArregloConsumos ac;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JDialogIngresosyconsumos dialog = new JDialogIngresosyconsumos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JDialogIngresosyconsumos() {
		getContentPane().setBackground(SystemColor.scrollbar);
		setBackground(Color.ORANGE);
		setTitle("Pago | Ingresos y Consumos");
		setBounds(100, 100, 606, 330);
		getContentPane().setLayout(null);
		{
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
			panel_1.setLayout(null);
			panel_1.setBackground(Color.WHITE);
			panel_1.setBounds(10, 11, 570, 114);
			getContentPane().add(panel_1);
			{
				btnConsultarDatos = new JButton("");
				btnConsultarDatos.addActionListener(this);
				btnConsultarDatos.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\buscar.jpg"));
				btnConsultarDatos.setFont(new Font("Tahoma", Font.BOLD, 11));
				btnConsultarDatos.setBounds(241, 11, 32, 23);
				panel_1.add(btnConsultarDatos);
			}
			{
				JLabel lblCdigo = new JLabel("C\u00F3digo de ingreso:");
				lblCdigo.setBounds(10, 15, 110, 14);
				panel_1.add(lblCdigo);
			}
			
			cboCodigo = new JComboBox<String>();
			cargarCombo();
			cboCodigo.addActionListener(this);
			cboCodigo.setBounds(119, 12, 112, 20);
			panel_1.add(cboCodigo);
			
			JLabel lblNewLabel = new JLabel("Nombre de cliente:");
			lblNewLabel.setBounds(10, 49, 91, 14);
			panel_1.add(lblNewLabel);
			
			txtNombre = new JTextField();
			txtNombre.setBounds(121, 46, 110, 20);
			panel_1.add(txtNombre);
			txtNombre.setColumns(10);
			
			JLabel lblApellidosDelCliente = new JLabel("Apellidos del cliente:");
			lblApellidosDelCliente.setBounds(10, 80, 110, 14);
			panel_1.add(lblApellidosDelCliente);
			
			txtApellidos = new JTextField();
			txtApellidos.setBounds(121, 77, 110, 20);
			panel_1.add(txtApellidos);
			txtApellidos.setColumns(10);
			
			JLabel dni = new JLabel("DNI:");
			dni.setBounds(376, 49, 46, 14);
			panel_1.add(dni);
			
			txtDNI = new JTextField();
			txtDNI.setBounds(443, 46, 117, 20);
			panel_1.add(txtDNI);
			txtDNI.setColumns(10);
			
			JLabel lblEstado = new JLabel("Estado:");
			lblEstado.setBounds(376, 80, 46, 14);
			panel_1.add(lblEstado);
			
			txtEstado = new JTextField();
			txtEstado.setBounds(443, 77, 117, 20);
			panel_1.add(txtEstado);
			txtEstado.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("Fecha de ingreso:");
			lblNewLabel_1.setBounds(294, 17, 100, 14);
			panel_1.add(lblNewLabel_1);
			
			txtFecha = new JTextField();
			txtFecha.setBounds(398, 14, 162, 20);
			panel_1.add(txtFecha);
			txtFecha.setColumns(10);
		}
		
		btnPagar = new JButton("Pagar");
		btnPagar.addActionListener(this);
		btnPagar.setBackground(Color.RED);
		btnPagar.setBounds(371, 263, 89, 23);
		getContentPane().add(btnPagar);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(this);
		btnSalir.setBackground(Color.RED);
		btnSalir.setBounds(491, 263, 89, 23);
		getContentPane().add(btnSalir);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 136, 570, 77);
		getContentPane().add(scrollPane);
		
		tableConsumo = new JTable();
		tableConsumo.setFillsViewportHeight(true);
		scrollPane.setViewportView(tableConsumo);
		
		txtPagoIngreso = new JTextField();
		txtPagoIngreso.setBounds(122, 224, 86, 20);
		getContentPane().add(txtPagoIngreso);
		txtPagoIngreso.setColumns(10);
		
		JLabel lblIngreso = new JLabel("Total por ingresos:");
		lblIngreso.setBounds(10, 227, 112, 14);
		getContentPane().add(lblIngreso);
		
		JLabel lblTotalAPagar = new JLabel("Total a pagar:");
		lblTotalAPagar.setBounds(371, 227, 102, 14);
		getContentPane().add(lblTotalAPagar);
		
		txtPagoTotal = new JTextField();
		txtPagoTotal.setBounds(494, 224, 86, 20);
		getContentPane().add(txtPagoTotal);
		txtPagoTotal.setColumns(10);
	}
	
	private void cargarCombo() {
		cboCodigo.removeAllItems();
		for ( int i=0; i<ai.tamaño(); i++ ) {
			if ( ai.obtener(i).getEstado() == 0 ) 
				cboCodigo.addItem( String.valueOf(ai.obtener(i).getCodigoIngreso() ) );
		}
	}

	int leerCodigoIngreso() {
		return Integer.parseInt( cboCodigo.getSelectedItem().toString().trim() );
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ( e.getSource() == btnConsultarDatos )
			actionPerformedBtnConsultarDatos(e);
	}

	private void actionPerformedBtnConsultarDatos(ActionEvent e) {
		int codigoIngreso = leerCodigoIngreso();
		int codigoSocio = ai.buscar(codigoIngreso).getCodigoSocio();
		
		Socio socio = as.buscar(codigoSocio);
		txtNombre.setText( socio.getNombre());
		txtApellidos.setText( socio.getApellidos());
		txtDNI.setText( socio.getDni());
		txtFecha.setText( ai.buscar(codigoIngreso).getFechaIngreso().toString() );
		txtEstado.setText( String.valueOf( ai.buscar(codigoIngreso).getEstado()) );
	}
}

