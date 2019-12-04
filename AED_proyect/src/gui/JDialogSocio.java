package gui;

import java.awt.BorderLayout;
import javax.swing.table.DefaultTableModel;

import arreglos.ArregloSocio;
import clases.Socio;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import librerias.Resaltador;

import javax.swing.JTable;
public class JDialogSocio extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodproducto;
	private JTextField txtDni;
	private JTextField txtTelefono;
	private JTextField txtConsultar;
	private JTable table;
	private DefaultTableModel modelo;
	private JButton buttonAdicionar;
	private JButton buttonModificar;
	private JButton buttonConsultar;
	private JButton buttonEliminar;

	/**
	 * Launch the application.
	 */
	
	private JTextField textFieldNombre;
	private JLabel lblCodigo;
	private Resaltador resaltado;
	private JButton buttonSalir;
	 
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
	public JDialogSocio() {
		setModal(true);
		setTitle("Mantenimiento | Socio");
		setBounds(100, 100, 768, 431);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblProducto = new JLabel("Socio");
			lblProducto.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblProducto.setBounds(10, 23, 78, 19);
			contentPanel.add(lblProducto);
		}
		{
			JLabel lblRegistroDeProducto = new JLabel("Registro de Socios");
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
				JLabel lblCodproducto = new JLabel("Cod. Socio");
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
				txtCodproducto.setText(String.valueOf(ab.generarCodigo()));
			    
			}
			{
				JLabel lblStock = new JLabel("Telefono");
				lblStock.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblStock.setBounds(11, 115, 61, 14);
				panel.add(lblStock);
			}
			{
				JLabel lblPrecio = new JLabel("DNI");
				lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblPrecio.setBounds(11, 90, 61, 14);
				panel.add(lblPrecio);
			}
			{
				txtDni = new JTextField();
				txtDni.setColumns(10);
				txtDni.setBounds(112, 88, 161, 20);
				panel.add(txtDni);
			}
			{
				txtTelefono = new JTextField();
				txtTelefono.setColumns(10);
				txtTelefono.setBounds(112, 113, 161, 20);
				panel.add(txtTelefono);
			}
			{
				buttonAdicionar = new JButton("Adicionar");
				buttonAdicionar.addActionListener(this);
				buttonAdicionar.setFont(new Font("Tahoma", Font.BOLD, 11));
				buttonAdicionar.setBounds(82, 160, 92, 23);
				panel.add(buttonAdicionar);
			}
			{
			    buttonModificar = new JButton("Modificar");
				buttonModificar.setFont(new Font("Tahoma", Font.BOLD, 11));
				buttonModificar.setBounds(182, 160, 91, 23);
				buttonModificar.addActionListener(this);
				panel.add(buttonModificar);
			}
			{
				JLabel lblNombre = new JLabel("Nombre");
				lblNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblNombre.setBounds(11, 40, 61, 14);
				panel.add(lblNombre);
			}
			{
				textFieldNombre = new JTextField();
				textFieldNombre.setBounds(112, 38, 161, 20);
				panel.add(textFieldNombre);
				textFieldNombre.setColumns(10);
			}
			{
				lblApellidos = new JLabel("Apellidos");
				lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblApellidos.setBounds(11, 65, 61, 14);
				panel.add(lblApellidos);
			}
			
			textFieldApellidos = new JTextField();
			textFieldApellidos.setBounds(112, 63, 161, 20);
			panel.add(textFieldApellidos);
			textFieldApellidos.setColumns(10);
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
				buttonConsultar = new JButton("Consultar");
				buttonConsultar.setFont(new Font("Tahoma", Font.BOLD, 11));
				buttonConsultar.addActionListener(this);
				buttonConsultar.setBounds(213, 12, 92, 23);
				panel.add(buttonConsultar);
			}
			{
			    buttonEliminar = new JButton("Eliminar");
				buttonEliminar.setFont(new Font("Tahoma", Font.BOLD, 11));
				buttonEliminar.addActionListener(this);
				buttonEliminar.setBounds(315, 12, 79, 23);
				panel.add(buttonEliminar);
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
					modelo.addColumn("Nombre");
					modelo.addColumn("Apellidos");
					modelo.addColumn("Dni");
					modelo.addColumn("Telefono");
					table.setModel(modelo);
					
					resaltado = new Resaltador(-1);
					table.setDefaultRenderer( Object.class, resaltado);
				}
			}
			
			lblCodigo = new JLabel("Codigo");
			lblCodigo.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblCodigo.setBounds(10, 16, 46, 14);
			panel.add(lblCodigo);
		}
		{
			JLabel lblListadoDeProductos = new JLabel("Listado de socios");
			lblListadoDeProductos.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblListadoDeProductos.setBounds(317, 53, 240, 25);
			contentPanel.add(lblListadoDeProductos);
		}
		{
			buttonSalir = new JButton("Salir");
			buttonSalir.addActionListener(this);
			buttonSalir.setFont(new Font("Tahoma", Font.BOLD, 11));
			buttonSalir.setBounds(630, 345, 92, 23);
			contentPanel.add(buttonSalir);
			listar();
		}
		
	}

	ArregloSocio ab =  new ArregloSocio();
	private JLabel lblApellidos;
	private JTextField textFieldApellidos;
	
	void limpieza() {
		txtConsultar.setText("");
		textFieldNombre.setText("");
		txtDni.setText("");
		txtTelefono.setText("");
		textFieldNombre.requestFocus();
	}	
   	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if ( e.getSource()== buttonAdicionar){
			actionPerformedButtonAdicionar(e);
		}
		else if ( e.getSource()== buttonModificar ){
			actionPerformedButtonModificar(e);
		}
		else if (e.getSource()==buttonConsultar){
			actionPerformedButtonConsultar(e);
		}
		else if (e.getSource()== buttonEliminar){
			actionPerformedButtonEliminar(e);		
		}
		else
			actionPerformedButtonSalir(e);
		
	}

	private void actionPerformedButtonSalir(ActionEvent e) {
		dispose();
	}

	private void actionPerformedButtonEliminar(ActionEvent eo) {
		resaltado.setFila(-1);
		try {
			int codigo = Integer.parseInt(txtConsultar.getText().trim());
			Socio a = ab.buscar(codigo);
			if (a == null)
				mensaje("el CÓDIGO no existe");
			else {
				ab.eliminar(a);
				listar();
			}
			limpieza();
			txtCodproducto.setText(String.valueOf(ab.generarCodigo()));
		}
		catch (Exception e) {
			error("ingrese CÓDIGO", txtConsultar);
		}
		
	}

	private void actionPerformedButtonConsultar(ActionEvent es) {
		try {
			int codigo = Integer.parseInt(txtConsultar.getText().trim());
			Socio a = ab.buscar(codigo);
			if (a == null) {
				mensaje("el CÓDIGO no existe");
				limpieza();
			}
			else {
				int pos = ab.buscarPosicion(codigo);
				textFieldNombre.setText(a.getNombre());
				textFieldApellidos.setText(a.getApellidos());
				txtDni.setText(a.getDni());
				txtTelefono.setText("" + a.getTelefono());
				txtConsultar.requestFocus();
				listar();
				resaltado.setFila(pos);
			}
			txtCodproducto.setText(String.valueOf(ab.generarCodigo()));
		}
		catch (Exception e) {
			mensaje("ingrese CÓDIGO");
			limpieza();
		}
	}

	private void actionPerformedButtonModificar(ActionEvent ee) {
		resaltado.setFila(-1);
		try {
			int codigo = Integer.parseInt(txtConsultar.getText().trim());
			Socio x = ab.buscar(codigo);
			if (x != null) {
				String nombre = leerNombre();
				if (nombre.length() > 0) {
					String apellidos = leerApellido();
					if ( apellidos.length() > 0 ) {
						String dni = leerDni();
						if ( dni.length() > 0 ) {
							try {
								int telefono = leerTelefono();
								x.setCodigo(codigo);
								x.setNombre(nombre);
								x.setApellidos(apellidos);
								x.setDni(dni);
								x.setTelefono(telefono);
								ab.grabarSocio();
								
								listar();
								limpieza();
								txtCodproducto.setText(String.valueOf(ab.generarCodigo()));
							}
							catch (Exception e) {
								error("ingrese TELEFONO", txtTelefono);
							}
						}
						else {
							error("ingrese DNI", txtDni);
						}
					}
					else
						error("ingrese APELLIDOS", textFieldApellidos);
				}
				else 
					error("ingrese NOMBRE", textFieldNombre);
			}
			else
				error("el CÓDIGO no existe", txtConsultar);
		}
		catch (Exception e) {
			error("ingrese CÓDIGO", txtConsultar);
		}
		
		
	}

	private void actionPerformedButtonAdicionar(ActionEvent ea) {
		resaltado.setFila(-1);
		try {
			int codigo = leerCodigo();
			if (ab.buscar(codigo) == null) {
				String nombre = leerNombre();
				if (nombre.length() > 0) {
					String apellidos = leerApellido();
					if ( apellidos.length() > 0 ) {
						String dni = leerDni();
						if ( dni.length() > 0 ) 
							try {
								int telefono = leerTelefono();
								Socio nuevo = new Socio( codigo, nombre, apellidos, dni, telefono);
								ab.adicionar(nuevo);
								ab.grabarSocio();
								listar();
								limpieza();
	
								txtCodproducto.setText(String.valueOf(ab.generarCodigo()));
							}
							catch (Exception e) {
								error("ingrese TELEFONO", txtTelefono);
							}
						else
							error("ingrese DNI", txtDni);
					}
					else 
						error("ingrese APELLIDOS", textFieldApellidos);
				}
				else 
					error("ingrese NOMBRE", textFieldNombre);
			}
			else
				error("el CÓDIGO ya existe", txtConsultar);
		}
		catch (Exception e) {
			error("ingrese CÓDIGO", txtConsultar);
		}
		
	}
	
	void listar() {
		modelo.setRowCount(0);
		for (int i=0; i<ab.tamaño(); i++) {
			Object[] fila = { 	ab.obtener(i).getCodigo(),		
								ab.obtener(i).getNombre(),
					          	ab.obtener(i).getApellidos(),
					          	ab.obtener(i).getDni(),
					          	ab.obtener(i).getTelefono()
					         };
					          
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
		return textFieldNombre.getText().trim();
	}
	String leerApellido() {
		return textFieldApellidos.getText().trim();
	}
	String leerDni() {
		return txtDni.getText().trim();
	}
	int leerTelefono() {
		return Integer.parseInt(txtTelefono.getText().trim());
	}
}
