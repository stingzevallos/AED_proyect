package gui;

import java.awt.EventQueue;
import clases.Socio;
import arreglos.ArregloSocio;

import javax.swing.JDialog;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;

public class JDialogSocio extends JDialog {
	private JTextField txtcodigo;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtdni;
	private JTextField txtTelefono;
	private JTextField txtBuscodigo;
	private JComboBox cbobuscar;
	private JButton btnSalir;
	private JButton btnEliminar;
	private JButton btnConsultar;
	private JButton btnCancelar;
	private JButton btnModificar;
	private JButton btnAdicionar;
	private DefaultTableModel modelo;
	private JTable tblsocio;
	private Component scrollPane;
	
	private int tipoOperacion;
	private JButton btnguardar;
	private JButton btnBuscar;
	
	public final static int ADICIONAR = 0;
	public final static int CONSULTAR = 1;
	public final static int MODIFICAR = 2;
	public final static int ELIMINAR  = 3;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JDialogSocio dialog = new JDialogSocio();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public JDialogSocio() {
		setModal(true);
		setFont(new Font("Dialog", Font.BOLD, 12));
		setTitle("Mantenimiento | Socio");
		setBounds(100, 100, 749, 404);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Socio");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(24, 11, 78, 19);
		getContentPane().add(lblNewLabel);
		
		JLabel lblAgregacionYModificacion = new JLabel("Agregacion y Modificacion del Socio");
		lblAgregacionYModificacion.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAgregacionYModificacion.setBounds(10, 50, 240, 25);
		getContentPane().add(lblAgregacionYModificacion);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setForeground(Color.LIGHT_GRAY);
		panel.setBounds(10, 85, 298, 244);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblCodsocio = new JLabel("Cod.Socio");
		lblCodsocio.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCodsocio.setBounds(11, 15, 61, 14);
		panel.add(lblCodsocio);
		
		txtcodigo = new JTextField();
		txtcodigo.setEditable(false);
		txtcodigo.setBounds(82, 13, 86, 20);
		panel.add(txtcodigo);
		txtcodigo.setColumns(10);
		
		JLabel lblNombres = new JLabel("Nombres");
		lblNombres.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNombres.setBounds(11, 46, 61, 14);
		panel.add(lblNombres);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblApellidos.setBounds(11, 81, 61, 14);
		panel.add(lblApellidos);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTelefono.setBounds(11, 149, 61, 14);
		panel.add(lblTelefono);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDni.setBounds(11, 112, 61, 14);
		panel.add(lblDni);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(82, 44, 208, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(82, 79, 208, 20);
		panel.add(txtApellido);
		
		txtdni = new JTextField();
		txtdni.setColumns(10);
		txtdni.setBounds(82, 110, 208, 20);
		panel.add(txtdni);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(82, 147, 208, 20);
		panel.add(txtTelefono);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAdicionar.setBounds(11, 174, 92, 23);
		panel.add(btnAdicionar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnModificar.setBounds(62, 208, 92, 23);
		panel.add(btnModificar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancelar.setBounds(215, 174, 81, 23);
		panel.add(btnCancelar);
		
		btnguardar = new JButton("Guardar");
		btnguardar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnguardar.setBounds(113, 174, 92, 23);
		panel.add(btnguardar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(164, 208, 92, 23);
		panel.add(btnConsultar);
		btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblListadoYConsulta = new JLabel("Listado y consulta de socio");
		lblListadoYConsulta.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblListadoYConsulta.setBounds(318, 50, 240, 25);
		getContentPane().add(lblListadoYConsulta);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(318, 80, 405, 249);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		cbobuscar = new JComboBox();
		cbobuscar.setBounds(10, 11, 69, 20);
		cbobuscar.setFont(new Font("Tahoma", Font.BOLD, 12));
		cbobuscar.setModel(new DefaultComboBoxModel(new String[] {"Codigo", "DNI"}));
		panel_1.add(cbobuscar);
		
		txtBuscodigo = new JTextField();
		txtBuscodigo.setBounds(89, 12, 126, 20);
		panel_1.add(txtBuscodigo);
		txtBuscodigo.setColumns(10);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEliminar.setBounds(326, 11, 79, 23);
		panel_1.add(btnEliminar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 43, 384, 171);
		panel_1.add(scrollPane);
		
		tblsocio = new JTable();
        tblsocio.setFillsViewportHeight(true);
		scrollPane.setColumnHeaderView(tblsocio);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("CÓDIGO");
		modelo.addColumn("NOMBRE");
		modelo.addColumn("APELLIDOS");
		modelo.addColumn("DNI");
		modelo.addColumn("TELEFONO");
		tblsocio.setModel(modelo);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBuscar.setBounds(224, 11, 92, 23);
		panel_1.add(btnBuscar);
		
	/*	ajustarAnchoColumnas();
		listar();
		
        btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSalir.setBounds(631, 340, 92, 23);
		getContentPane().add(btnSalir);
            */
	}
	

	ArregloSocio as = new ArregloSocio();
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnSalir) {
			actionPerformedBtnSalir(arg0);
		}
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(arg0);
		}
		if (arg0.getSource() == btnCancelar) {
			actionPerformedBtncancelar(arg0);
		}
		if (arg0.getSource() == btnModificar) {
			actionPerformedBtnModificar(arg0);
		}
		if (arg0.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(arg0);
		}
		if (arg0.getSource() == btnguardar) {
			actionPerformedBtnGuardar(arg0);
		}
		if (arg0.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(arg0);
		}
	}

	private void actionPerformedBtnBuscar(ActionEvent arg0) {
		consultarSocio();
		
	}

	private void consultarSocio() {
			try {
				Socio x = as.buscar(leerCodigo());
				if (x != null) {
					txtNombre.setText(x.getNombres());
					txtApellido.setText(x.getApellidos());
					txtdni.setText("" + x.getDni());
					txtTelefono.setText("" + x.getTelefono());;
					txtcodigo.requestFocus();
				}
				else
					error("El código " + leerCodigo() + " no existe", txtcodigo);
			}
			catch (Exception e) {
				error("Ingrese CÓDIGO correcto", txtcodigo);
			}
		}

	private void actionPerformedBtnGuardar(ActionEvent arg0) {
		
		switch (tipoOperacion) {
		case ADICIONAR:
			adicionarSocio();
			break;
		case CONSULTAR:
			break;
		case MODIFICAR:
			modificarSocio();
			break;
		case ELIMINAR:
			eliminarSocio();
	}
		
	}

	private void actionPerformedBtnModificar(ActionEvent arg0) {
		tipoOperacion = MODIFICAR;
		txtcodigo.setEditable(true);
		habilitarEntradas(true);
		habilitarBotones(false);
		txtcodigo.requestFocus();
		
	}

	private void actionPerformedBtncancelar(ActionEvent arg0) {
		
		txtcodigo.setText("");
		txtNombre.setText("");
		txtdni.setText("");
		txtApellido.setText("");
		txtTelefono.setText("");
		txtcodigo.setEditable(false);
		habilitarEntradas(false);
		habilitarBotones(true);
		
	}

	private void actionPerformedBtnAdicionar(ActionEvent arg0) {
		tipoOperacion = ADICIONAR;
		txtcodigo.setText("" + as.GenerarCodigo());
		txtNombre.setText("");
		txtApellido.setText("");
		txtdni.setText("");
		txtTelefono.setText("");
		habilitarEntradas(true);
		habilitarBotones(false);
		txtNombre.requestFocus();
	}

	private void actionPerformedBtnConsultar(ActionEvent arg0) {
		tipoOperacion = CONSULTAR;
		txtcodigo.setEditable(true);
		habilitarBotones(false);
		txtcodigo.requestFocus();
		
	}

	private void actionPerformedBtnSalir(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	private void actionPerformedBtnEliminar(ActionEvent arg0) {
		tipoOperacion = ELIMINAR;
		txtcodigo.setEditable(true);
		habilitarBotones(false);
		txtcodigo.requestFocus();
		
	}
	
	/*void ajustarAnchoColumnas() {
		TableColumnModel tcm = tblsocio.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna( 8));  // codigo
		tcm.getColumn(1).setPreferredWidth(anchoColumna(18));  // nombre
		tcm.getColumn(2).setPreferredWidth(anchoColumna(30));  // apellido
		tcm.getColumn(3).setPreferredWidth(anchoColumna(10));  // dni
		tcm.getColumn(4).setPreferredWidth(anchoColumna(10));  // telefono
	}*/
	
	void listar() {
		Socio x;
		modelo.setRowCount(0);
		for (int i=0; i<as.tamaño(); i++) {
			x = as.obtener(i);
			Object[] fila = { x.getCodigoSocio(),
					          x.getNombres(),
					          x.getApellidos(),
					          x.getDni(),
					          x.getTelefono()};
			modelo.addRow(fila);
		}
	}
	
	void adicionarSocio() {
		int codigo = leerCodigo();
		String nombre = leerNombre();
		if (nombre.length() > 0) {
			String dni = leerDni();
			if (as.buscar(dni) == null) 
				try {
					String apellido = leerApellido();
					try {
						int telefono = leerTelefono();
						Socio nueva = new Socio(codigo, nombre,apellido, dni, telefono);
						as.adicionar(nueva);
						listar();
						txtcodigo.setText("" + as.GenerarCodigo());
						txtNombre.setText("");
						txtdni.setText("");
						txtApellido.setText("");
						txtTelefono.setText("");
						txtNombre.requestFocus();
					}
					catch (Exception e) {
						error("Ingrese ESTATURA correcta", txtTelefono);
					}
				}
				catch (Exception e) {
					error("Ingrese PESO correcto", txtApellido);
				}
			else
				error("Ingrese DNI correcto", txtdni);
		}
		else
			error("Ingrese NOMBRE correcto", txtNombre);
	}
	
	void modificarSocio() {
		try {
			Socio x = as.buscar(leerCodigo());
			String nombre = leerNombre();
			if (nombre.length() > 0) {
				String dni = leerDni();
				Socio y = as.buscar(dni);
				if (y == null  ||  x.equals(y))
					try {
						String apellido = leerApellido();
						try {
							int telefono = leerTelefono();
							x.setNombres(nombre);
							x.setApellidos(apellido);
							x.setDni(dni);
							x.setTelefono(telefono);
							listar();
							txtcodigo.requestFocus();
						}
						catch (Exception e) {
							error("Ingrese ESTATURA correcta", txtTelefono);
						}	
					}
					catch (Exception e) {
						error("Ingrese PESO correcto", txtApellido);
					}
				else
					error("Ingrese DNI correcto", txtdni);
			}
			else
				error("Ingrese NOMBRE correcto", txtNombre);
		}
		catch (Exception e) {
			error("Ingrese CÓDIGO correcto", txtcodigo);
		}
	}
	
	void eliminarSocio() {
		try {
			int codigo = leerCodigo();
			Socio x = as.buscar(codigo);
			if (x != null) {
				int ok = confirmar("¿ Desea eliminar el registro ?");
				if (ok == 0) {
					as.eliminar(x);
					listar();
					txtcodigo.setText("");
					txtNombre.setText("");
					txtdni.setText("");
					txtApellido.setText("");
					txtTelefono.setText("");
					txtcodigo.requestFocus();
				}
			}
			else
				error("El código " + codigo + " no existe", txtcodigo);
		}
		catch (Exception e) {
			error("Ingrese CÓDIGO correcto", txtcodigo);
		}	
	}
	void habilitarEntradas(boolean sino) {
		txtNombre.setEditable(sino);
		txtApellido.setEditable(sino);
		txtdni.setEditable(sino);
		txtTelefono.setEditable(sino);
	}
	void habilitarBotones(boolean sino) {
		if (tipoOperacion != ADICIONAR)
			btnBuscar.setEnabled(!sino);
		btnAdicionar.setEnabled(sino);
		btnConsultar.setEnabled(sino);
		btnModificar.setEnabled(sino);
		btnEliminar.setEnabled(sino);
		if (tipoOperacion == CONSULTAR)
			btnguardar.setEnabled(false);
		else
			btnguardar.setEnabled(!sino);
		btnCancelar.setEnabled(!sino);		
	}
	
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s, "Información", 0);
	}
	void error(String s, JTextField txt) {
		mensaje(s);
		txt.setText("");
		txt.requestFocus();
	}
	//  Métodos que retornan valor (sin parámetros)
	int leerCodigo() {
		return Integer.parseInt(txtcodigo.getText().trim());
	}
	
	String leerNombre() {
		return txtNombre.getText().trim();
	}
	
	String leerApellido() {
		return txtApellido.getText().trim();
	}
	String leerDni() {
		return txtdni.getText().trim();
	}
	
	int leerTelefono() {
		return Integer.parseInt(txtTelefono.getText().trim());
	}
	//  Métodos que retornan valor (con parámetros)
	/*int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}*/
	
	int confirmar(String s) {
		return JOptionPane.showConfirmDialog(this, s, "Alerta", 0, 1, null);
	}
}
