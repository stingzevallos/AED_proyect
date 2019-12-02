package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import arreglos.ArregloIngreso;
import arreglos.ArregloProducto;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.JScrollPane;

public class JDialogConsumo extends JDialog implements ActionListener {
	
	//ArregloSocio ai = new ArregloSocio();
	ArregloProducto ap = new ArregloProducto();
	
	private JLabel lblCodigoSocio;
	private JComboBox comboBoxCodigoSocio;
	private JTextField textFieldSocio;
	private JLabel lblProducto;
	private JComboBox comboBoxCodigoProducto;
	private JButton buttonAgregar;
	private JLabel lblPrecioUnitario;
	private JLabel lblConsumoDeSocio_1;
	private JTextField textFieldProducto;
	private JTable table;
	private JButton btnQuitar;
	private JLabel labelSocio;
	private JButton btnSalir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JDialogConsumo dialog = new JDialogConsumo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JDialogConsumo() {
		setModal(true);
		setTitle("Registro | Consumo");
		setBounds(100, 100, 560, 366);
		getContentPane().setLayout(null);
		
		lblCodigoSocio = new JLabel("Codigo Socio");
		lblCodigoSocio.setBounds(10, 15, 76, 14);
		getContentPane().add(lblCodigoSocio);
		
		comboBoxCodigoSocio = new JComboBox();
		comboBoxCodigoSocio.setModel(new DefaultComboBoxModel(new String[] {"10001", "10002", "10003"}));
		comboBoxCodigoSocio.setBounds(96, 12, 62, 20);
		comboBoxCodigoSocio.addActionListener(this);
		getContentPane().add(comboBoxCodigoSocio);
		
		textFieldSocio = new JTextField();
		textFieldSocio.setEditable(false);
		textFieldSocio.setEnabled(false);
		textFieldSocio.setBounds(168, 12, 168, 20);
		getContentPane().add(textFieldSocio);
		textFieldSocio.setColumns(10);
		
		lblProducto = new JLabel("Producto");
		lblProducto.setBounds(10, 40, 76, 14);
		getContentPane().add(lblProducto);
		
		comboBoxCodigoProducto = new JComboBox();
		comboBoxCodigoProducto.setModel(new DefaultComboBoxModel(new String[] {"20001", "20002"}));
		comboBoxCodigoProducto.setBounds(96, 37, 62, 20);
		comboBoxCodigoProducto.addActionListener(this);
		getContentPane().add(comboBoxCodigoProducto);
		
		buttonAgregar = new JButton("Agregar");
		buttonAgregar.setBounds(445, 11, 89, 23);
		buttonAgregar.addActionListener(this);
		getContentPane().add(buttonAgregar);
		
		lblPrecioUnitario = new JLabel("S/. p.u.");
		lblPrecioUnitario.setBounds(290, 40, 105, 14);
		getContentPane().add(lblPrecioUnitario);
		
		lblConsumoDeSocio_1 = new JLabel("CONSUMO DE SOCIO: ");
		lblConsumoDeSocio_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblConsumoDeSocio_1.setBounds(10, 68, 119, 14);
		getContentPane().add(lblConsumoDeSocio_1);
		
		textFieldProducto = new JTextField();
		textFieldProducto.setBounds(168, 37, 112, 20);
		getContentPane().add(textFieldProducto);
		textFieldProducto.setColumns(10);
		
		btnQuitar = new JButton("Quitar");
		btnQuitar.setBounds(445, 36, 89, 23);
		getContentPane().add(btnQuitar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 90, 524, 192);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		labelSocio = new JLabel("aca ira el socio");
		labelSocio.setBounds(139, 68, 141, 14);
		getContentPane().add(labelSocio);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(445, 293, 89, 23);
		getContentPane().add(btnSalir);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ( e.getSource() == comboBoxCodigoSocio ) 
			actionPerfomedComboBoxCodigoSocio(e);
		else if ( e.getSource() == comboBoxCodigoProducto )
			actionPerformedComboBoxCodigoProducto(e);
		else if ( e.getSource() == buttonAgregar )
			actionPerformedButtonAgregar(e);
		else if ( e.getSource() == btnQuitar ) 
			actionPerformedBtnQuitar(e);
		else
			actionPerformedBtnSalir(e);
			
	}

	private void actionPerfomedComboBoxCodigoSocio(ActionEvent e) {
		int codigoSocio = leerCodigoSocio();
		//
		textFieldSocio.setText( String.valueOf( codigoSocio) );;
		
	}

	private void actionPerformedComboBoxCodigoProducto(ActionEvent e) {
		int codigoProducto = leerCodigoProducto();
		
		String detalleProducto = ap.buscar(codigoProducto).getDetalle();
		double precioProducto = ap.buscar(codigoProducto).getPrecio();
		
		textFieldProducto.setText(detalleProducto);
		lblPrecioUnitario.setText("S/. "+ precioProducto + " c.u.");
	}

	private void actionPerformedButtonAgregar(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	private void actionPerformedBtnQuitar(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	private void actionPerformedBtnSalir(ActionEvent e) {
		dispose();
	}
	
	int leerCodigoSocio() {
		return Integer.parseInt( comboBoxCodigoSocio.getSelectedItem().toString().trim());
	}
	
	int leerCodigoProducto() {
		return Integer.parseInt( comboBoxCodigoProducto.getSelectedItem().toString().trim());
	}
	
	
}
