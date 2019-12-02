package gui;

import java.awt.BorderLayout;
import javax.swing.table.DefaultTableModel;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import arreglos.ArregloProducto;
import clases.Producto;
import javax.swing.JTable;
public class JDialogProducto extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodproducto;
	private JTextField txtPrecio;
	private JTextField txtStock;
	private JTextField txtConsultar;
	private JTable table;
	private DefaultTableModel modelo;
	private JButton button;
	private JButton button01;
	private JButton button02;
	private JButton button03;

	/**
	 * Launch the application.
	 */
	 ArregloProducto ab =  new ArregloProducto();
	private JTextField txtSDetalle;
	private JLabel lblCodigo;
	 
	public static void main(String[] args) {
		try {
			JDialogProducto dialog = new JDialogProducto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JDialogProducto() {
		setModal(true);
		setTitle("Mantenimiento | Producto");
		setBounds(100, 100, 768, 431);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblProducto = new JLabel("Producto");
			lblProducto.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblProducto.setBounds(10, 23, 78, 19);
			contentPanel.add(lblProducto);
		}
		{
			JLabel lblRegistroDeProducto = new JLabel("Registro de Producto");
			lblRegistroDeProducto.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblRegistroDeProducto.setBounds(10, 53, 240, 25);
			contentPanel.add(lblRegistroDeProducto);
		}
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setForeground(Color.LIGHT_GRAY);
			panel.setBackground(Color.LIGHT_GRAY);
			panel.setBounds(10, 86, 298, 246);
			contentPanel.add(panel);
			{
				JLabel lblCodproducto = new JLabel("Cod.Producto");
				lblCodproducto.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblCodproducto.setBounds(11, 15, 91, 14);
				panel.add(lblCodproducto);
			}
			{
				txtCodproducto = new JTextField();
				txtCodproducto.setEditable(false);
				txtCodproducto.setColumns(10);
				txtCodproducto.setBounds(112, 13, 86, 20);
				panel.add(txtCodproducto);
				txtCodproducto.setText(String.valueOf(ab.GenerarCodigo()));
			    
			}
			{
				JLabel lblStock = new JLabel("Stock");
				lblStock.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblStock.setBounds(11, 174, 61, 14);
				panel.add(lblStock);
			}
			{
				JLabel lblPrecio = new JLabel("Precio");
				lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblPrecio.setBounds(11, 149, 61, 14);
				panel.add(lblPrecio);
			}
			{
				txtPrecio = new JTextField();
				txtPrecio.setColumns(10);
				txtPrecio.setBounds(112, 147, 178, 20);
				panel.add(txtPrecio);
			}
			{
				txtStock = new JTextField();
				txtStock.setColumns(10);
				txtStock.setBounds(112, 172, 178, 20);
				panel.add(txtStock);
			}
			{
				button = new JButton("Adicionar");
				button.addActionListener(this);
				button.setFont(new Font("Tahoma", Font.BOLD, 11));
				button.setBounds(4, 212, 92, 23);
				panel.add(button);
			}
			{
			    button01 = new JButton("Modificar");
				button01.setFont(new Font("Tahoma", Font.BOLD, 11));
				button01.setBounds(99, 212, 91, 23);
				button01.addActionListener(this);
				panel.add(button01);
			}
			{
				JButton button = new JButton("Cancelar");
				button.setFont(new Font("Tahoma", Font.BOLD, 11));
				button.setBounds(198, 212, 92, 23);
				panel.add(button);
			}
			{
				JLabel label = new JLabel("Detalle");
				label.setFont(new Font("Tahoma", Font.BOLD, 12));
				label.setBounds(11, 71, 61, 14);
				panel.add(label);
			}
			{
				txtSDetalle = new JTextField();
				txtSDetalle.setBounds(112, 69, 161, 54);
				panel.add(txtSDetalle);
				txtSDetalle.setColumns(10);
			}
		}
		
		{
			JPanel panel = new JPanel();
			panel.setBackground(Color.LIGHT_GRAY);
			panel.setLayout(null);
			panel.setBounds(317, 86, 405, 246);
			contentPanel.add(panel);
			{
				txtConsultar = new JTextField();
				txtConsultar.setColumns(10);
				txtConsultar.setBounds(66, 13, 109, 20);
				panel.add(txtConsultar);
			}
			{
				button02 = new JButton("Consultar");
				button02.setFont(new Font("Tahoma", Font.BOLD, 11));
				button02.addActionListener(this);
				button02.setBounds(213, 12, 92, 23);
				panel.add(button02);
			}
			{
			    button03 = new JButton("Eliminar");
				button03.setFont(new Font("Tahoma", Font.BOLD, 11));
				button03.addActionListener(this);
				button03.setBounds(315, 12, 79, 23);
				panel.add(button03);
			}
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 43, 384, 192);
				panel.add(scrollPane);
				{
					table = new JTable();
					table.setFillsViewportHeight(true);
					scrollPane.setViewportView(table);
					modelo =  new DefaultTableModel();
					modelo.addColumn("Código");
					modelo.addColumn("Detalle");
					modelo.addColumn("Precio");
					modelo.addColumn("Stock");
					table.setModel(modelo);
				}
			}
			
			lblCodigo = new JLabel("Codigo");
			lblCodigo.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblCodigo.setBounds(10, 16, 46, 14);
			panel.add(lblCodigo);
		}
		{
			JLabel lblListadoDeProductos = new JLabel("Listado de productos");
			lblListadoDeProductos.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblListadoDeProductos.setBounds(317, 53, 240, 25);
			contentPanel.add(lblListadoDeProductos);
		}
		{
			JButton button = new JButton("Salir");
			button.setFont(new Font("Tahoma", Font.BOLD, 11));
			button.setBounds(630, 345, 92, 23);
			contentPanel.add(button);
			listar();
		}
		
	}
	void limpieza() {
		txtCodproducto.setText("");
		txtSDetalle.setText("");
		txtPrecio.setText("");
		txtStock.setText("");
		txtCodproducto.requestFocus();
	}	
   	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if ( e.getSource()== button){
			actionPerformedButton(e);
		}
		else if ( e.getSource()== button01 ){
			actionPerformedButton01(e);
		}
		else if (e.getSource()==button02){
			actionPerformedButton02(e);
		}
		else if (e.getSource()== button03){
			actionPerformedButton03(e);		}
		
	}

	private void actionPerformedButton03(ActionEvent eo) {
		try {
			int codigo = Integer.parseInt(txtConsultar.getText().trim());
			Producto a = ab.buscar(codigo);
			if (a == null)
				mensaje("el CÓDIGO no existe");
			else {
				ab.eliminar(a);
				
				listar();
			}
			limpieza();
			txtCodproducto.setText(String.valueOf(ab.GenerarCodigo()));
		}
		catch (Exception e) {
			error("ingrese CÓDIGO", txtConsultar);
		}
		
	}

	private void actionPerformedButton02(ActionEvent es) {
		
		try {
			int codigo = Integer.parseInt(txtConsultar.getText().trim());
			Producto a = ab.buscar(codigo);
			if (a == null) {
				mensaje("el CÓDIGO no existe");
				limpieza();
			}
			else {
				txtSDetalle.setText(a.getDetalle());
				txtPrecio.setText("" + a.getPrecio());
				txtStock.setText("" + a.getStok());
				txtCodproducto.requestFocus();
			}
		}
		catch (Exception e) {
			mensaje("ingrese CÓDIGO");
			limpieza();
		}
		
	}

	private void actionPerformedButton01(ActionEvent ee) {
	
		try {
			int codigo = Integer.parseInt(txtConsultar.getText().trim());
			Producto x = ab.buscar(codigo);
			if (x != null) {
				String nombre = leerNombre();
				if (nombre.length() > 0)
					try {
						double nota1 = leerPrecio();
						try {
							int nota2 = leerNota2();
							x.setCodigo(codigo);
							x.setDetalle(nombre);
							x.setPrecio(nota1);
							x.setStok(nota2);
							
							listar();
							limpieza();
							txtCodproducto.setText(String.valueOf(ab.GenerarCodigo()));
						}
						catch (Exception e) {
							error("ingrese Precio", txtPrecio);
						}
					}
					catch (Exception e) {
						error("ingrese Stock", txtStock);
					}
				else 
					error("ingrese Descripcion", txtSDetalle);
			}
			else
				error("el CÓDIGO no existe", txtCodproducto);
		}
		catch (Exception e) {
			error("ingrese CÓDIGO", txtCodproducto);
		}
		
		
	}

	private void actionPerformedButton(ActionEvent ea) {
		
		try {
			int codigo = leerCodigo();
			if (ab.buscar(codigo) == null) {
				String descripcion = leerNombre();
				if (descripcion.length() > 0)
					try {
						double precio = leerPrecio();
						try {
							int stock = leerNota2();
							Producto nuevo = new Producto(codigo, stock, descripcion,precio );
							ab.adicionar(nuevo);
							ab.grabarProducto();
							listar();
							limpieza();

							txtCodproducto.setText(String.valueOf(ab.GenerarCodigo()));
						}
						catch (Exception e) {
							error("Ingrese Detalle", txtStock);
						}
					}
					catch (Exception e) {
						error("ingrese Precio", txtPrecio);
					}
				else 
					error("ingrese Stock", txtSDetalle);
			}
			else
				error("el CÓDIGO ya existe", txtCodproducto);
		}
		catch (Exception e) {
			error("ingrese CÓDIGO", txtCodproducto);
		}
		
	}
	
	void listar() {
		modelo.setRowCount(0);
		for (int i=0; i<ab.tamaño(); i++) {
			Object[] fila = { ab.obtener(i).getCodigo(),
					          ab.obtener(i).getDetalle(),
					          ab.obtener(i).getPrecio(),
					          ab.obtener(i).getStok(),};
					          
			modelo.addRow(fila);
			
		}
	}
//  Métodos tipo void (con parámetros)
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
	void error(String s, JTextField txt) {
		mensaje(s);
		txt.setText("");
		txt.requestFocus();
	}
	//  Métodos que retornan valor (sin parámetros)
	int leerCodigo() {
		return Integer.parseInt(txtCodproducto.getText().trim());
	}
	String leerNombre() {
		return txtSDetalle.getText().trim();
	}
	double leerPrecio() {
		return Integer.parseInt(txtPrecio.getText().trim());
	}
	int leerNota2() {
		return Integer.parseInt(txtStock.getText().trim());
	}
}
