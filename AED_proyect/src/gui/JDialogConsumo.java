package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import arreglos.ArregloConsumos;
import arreglos.ArregloIngreso;
import arreglos.ArregloProducto;
import clases.Consumo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	private JTextField textFieldCantidad;
	private JLabel lblCantidad;

	private DefaultTableModel modelo;

	private ArregloConsumos ac;

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
		setBounds(100, 100, 560, 398);
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
		
		lblPrecioUnitario = new JLabel("S/. c/u");
		lblPrecioUnitario.setBounds(283, 40, 105, 14);
		getContentPane().add(lblPrecioUnitario);
		
		lblConsumoDeSocio_1 = new JLabel("CONSUMO DE SOCIO: ");
		lblConsumoDeSocio_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblConsumoDeSocio_1.setBounds(10, 93, 119, 14);
		getContentPane().add(lblConsumoDeSocio_1);
		
		textFieldProducto = new JTextField();
		textFieldProducto.setBounds(168, 37, 105, 20);
		getContentPane().add(textFieldProducto);
		textFieldProducto.setColumns(10);
		
		btnQuitar = new JButton("Quitar");
		btnQuitar.setBounds(445, 36, 89, 23);
		getContentPane().add(btnQuitar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 118, 524, 192);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("Cod. Socio");
		modelo.addColumn("Cod. Producto");
		modelo.addColumn("Detalle");
		modelo.addColumn("Precio");
		modelo.addColumn("Cantidad");
		modelo.addColumn("Importe");
		
		table.setModel(modelo);
		
		labelSocio = new JLabel("aca ira el socio");
		labelSocio.setBounds(149, 93, 141, 14);
		getContentPane().add(labelSocio);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(445, 325, 89, 23);
		getContentPane().add(btnSalir);
		
		textFieldCantidad = new JTextField();
		textFieldCantidad.setBounds(96, 62, 33, 20);
		getContentPane().add(textFieldCantidad);
		textFieldCantidad.setColumns(10);
		
		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(10, 65, 76, 14);
		getContentPane().add(lblCantidad);
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
		int codigoSocio = leerCodigoSocio();
		int codigoProducto = leerCodigoProducto();
		String detalle = ap.buscar(codigoProducto).getDetalle();
		double precio = ap.buscar(codigoProducto).getPrecio();
		
		ac = new ArregloConsumos(codigoSocio);
		ac.agregarProductos( new Consumo( codigoProducto, detalle, precio, 1) );
		ac.grabarConsumos();
		
		listar();
		limpieza();
		
	}

	private void actionPerformedBtnQuitar(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	private void actionPerformedBtnSalir(ActionEvent e) {
		dispose();
	}
	
	void listar() {
		modelo.setRowCount(0);
		for (int i=0; i<ac.productosConsumidos(); i++) {
			Object[] fila = { 	ac.getCodigoSocio(),
								ac.obtener(i).getCodigoProducto(),
								ac.obtener(i).getDetalle(),
								ac.obtener(i).getPrecio(),
								ac.obtener(i).getCantidad(),
								ac.obtener(i).importe()
							};
			modelo.addRow(fila);
		}
	}
	
	void limpieza() {
		textFieldCantidad.setText("");
		textFieldSocio.setText("");
		textFieldProducto.setText("");
		lblPrecioUnitario.setText("");
		comboBoxCodigoSocio.requestFocus();
	}	
	
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
	
	void error(String s, JTextField txt) {
		mensaje(s);
		txt.setText("");
		txt.requestFocus();
	}
	
	int leerCodigoSocio() {
		return Integer.parseInt( comboBoxCodigoSocio.getSelectedItem().toString().trim());
	}
	
	int leerCodigoProducto() {
		return Integer.parseInt( comboBoxCodigoProducto.getSelectedItem().toString().trim());
	}
	
	
}
