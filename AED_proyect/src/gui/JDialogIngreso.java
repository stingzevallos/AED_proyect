package gui;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import arreglos.ArregloIngreso;
import clases.Ingreso;
import librerias.Fecha;
import librerias.Resaltador;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JScrollPane;

public class JDialogIngreso extends JDialog implements ActionListener {

	
	ArregloIngreso listaIngreso = new ArregloIngreso();
	//ArregloSocio listaSocio = new ArregloSocio();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblIngresoDeSocio;
	private JLabel lblCodigoDeIngreso;
	private JLabel lblCodigoSocio;
	private JLabel lblNDeInvitados;
	private JTextField textFieldCodigoIngreso;
	private JComboBox<String> comboBoxCodigoSocio;
	private JTextField textFieldNumInvitados;
	private JLabel lblSX;
	private JButton btnIngresar;
	private JButton btnBuscar;
	private JLabel lblListaDeSocio;
	private JTable table;
	private DefaultTableModel modelo;
	private JTextField textFieldBuscar;
	private JComboBox<String> comboBoxBuscador;
	
	Resaltador resaltado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JDialogIngreso dialog = new JDialogIngreso();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JDialogIngreso() {
		setModal(true);
		setTitle("Registro | Ingreso");
		setBounds(100, 100, 651, 405);
		getContentPane().setLayout(null);
		
		lblIngresoDeSocio = new JLabel("Ingreso de Socio");
		lblIngresoDeSocio.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIngresoDeSocio.setBounds(10, 11, 115, 14);
		getContentPane().add(lblIngresoDeSocio);
		
		lblCodigoDeIngreso = new JLabel("Codigo de Ingreso");
		lblCodigoDeIngreso.setBounds(10, 36, 115, 14);
		getContentPane().add(lblCodigoDeIngreso);
		
		lblCodigoSocio = new JLabel("Codigo Socio");
		lblCodigoSocio.setBounds(10, 61, 115, 14);
		getContentPane().add(lblCodigoSocio);
		
		lblNDeInvitados = new JLabel("N\u00B0 de invitados");
		lblNDeInvitados.setBounds(10, 86, 115, 14);
		getContentPane().add(lblNDeInvitados);
		
		textFieldCodigoIngreso = new JTextField();
		textFieldCodigoIngreso.setEditable(false);
		textFieldCodigoIngreso.setText( String.valueOf( listaIngreso.generarCodigo()) );
		textFieldCodigoIngreso.setBounds(135, 33, 82, 20);
		getContentPane().add(textFieldCodigoIngreso);
		textFieldCodigoIngreso.setColumns(10);
		
		comboBoxCodigoSocio = new JComboBox<String>();
		comboBoxCodigoSocio.setModel(new DefaultComboBoxModel<String>(new String[] {"10001", "10002", "10003"}));
		comboBoxCodigoSocio.setBounds(135, 58, 82, 20);
		getContentPane().add(comboBoxCodigoSocio);
		
		textFieldNumInvitados = new JTextField();
		textFieldNumInvitados.setBounds(135, 83, 46, 20);
		getContentPane().add(textFieldNumInvitados);
		textFieldNumInvitados.setColumns(10);
		
		lblSX = new JLabel("S/ 25.00 x invitado");
		lblSX.setBounds(191, 86, 107, 14);
		getContentPane().add(lblSX);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.setBounds(524, 32, 101, 23);
		btnIngresar.addActionListener(this);
		getContentPane().add(btnIngresar);
		
		lblListaDeSocio = new JLabel("LISTA Y CONSULTA DE SOCIO INGRESADOS");
		lblListaDeSocio.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblListaDeSocio.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaDeSocio.setBounds(10, 121, 615, 14);
		getContentPane().add(lblListaDeSocio);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(524, 57, 101, 23);
		btnCancelar.addActionListener(this);
		getContentPane().add(btnCancelar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 177, 615, 178);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setEnabled(false);
		table.setForeground(Color.BLACK);
		scrollPane.setViewportView(table);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("Cod. ingreso");
		modelo.addColumn("Cod. socio");
		modelo.addColumn("Fecha ingreso");
		modelo.addColumn("Hora ingreso");
		modelo.addColumn("N° invitados");
		modelo.addColumn("Costo ingreso");
		modelo.addColumn("Estado");

		resaltado = new Resaltador(-1);
		
		table.setModel(modelo);
		table.setDefaultRenderer( Object.class, resaltado);
		
		
		comboBoxBuscador = new JComboBox<String>();
		comboBoxBuscador.setModel(new DefaultComboBoxModel<String>(new String[] {"C\u00F3digo", "DNI"}));
		comboBoxBuscador.setBounds(10, 146, 86, 20);
		getContentPane().add(comboBoxBuscador);
		
		textFieldBuscar = new JTextField();
		textFieldBuscar.setBounds(106, 146, 111, 20);
		getContentPane().add(textFieldBuscar);
		textFieldBuscar.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(227, 145, 89, 23);
		btnBuscar.addActionListener(this);
		getContentPane().add(btnBuscar);
		
		listar();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ( e.getSource() == btnIngresar )
			actionPerformedBtnIngresar(e);
		else if ( e.getSource() == btnBuscar )
			actionPerformedBtnBuscar(e);
		else
			actionPerformedBtnCancelar(e);
	}

	private void actionPerformedBtnIngresar(ActionEvent e) { //falta obtener mejor datos, generar auto cod socio
		Ingreso nuevoIngreso;
		
		resaltado.setFila(-1);
		try {
			int codigoIngreso = leerCodigoIngreso();
			int codigoSocio = leerCodigoSocio();
			Ingreso ingreso = listaIngreso.buscarSocio(codigoSocio);
			if ( (ingreso == null) || (ingreso.getEstado() == 1) ) {
				String fechaIngreso = leerFechaIngreso();
				String horaIngreso = leerHoraIngreso();
				int numeroInvitados =  leerNumeroInvitados();
				double costoIngreso = leerCostoIngreso();
				int estado = 0;
				
				nuevoIngreso = new Ingreso( codigoIngreso, codigoSocio, fechaIngreso, horaIngreso, numeroInvitados, costoIngreso, estado );
				listaIngreso.adicionar(nuevoIngreso);
				listaIngreso.grabarIngresos();
				listar();
				limpieza();

				textFieldCodigoIngreso.setText( String.valueOf( listaIngreso.generarCodigo()) );
			}
			else {
				mensaje("No se puede ingresar a socio. Socio esta presente en el club.");
			}
			
		}
		catch( Exception exc ) {
			error("Ingrese numero de Invitados", textFieldNumInvitados);
		}
		
	}

	private void actionPerformedBtnBuscar(ActionEvent e) {
		int opcion = comboBoxBuscador.getSelectedIndex();
		if ( opcion == 0 ) {
			try {
				int codigo = Integer.parseInt( textFieldBuscar.getText().trim());
				int pos = listaIngreso.buscarPosicion(codigo);
				if ( pos != -1 ) {
					resaltado.setFila(pos);
					listar();
				}
				else
					error("No se encontro el CODIGO", textFieldBuscar);
			}
			catch( Exception ex ) {
				error( "Ingrese CODIGO a buscar", textFieldBuscar);
			}
		}
		/*else if ( opcion == 1 ) {
			String dni = textFieldBuscar.getText().trim();
			if ( dni.length() > 0 ) {
				int pos = listaSocio.buscarDni(dni);
				if ( pos != -1 ) {
					resaltado.setFila(pos);
					listar();
				}
				else
					error("No se encontro el CODIGO", textFieldBuscar);
			}
			else
				error( "Ingrese CODIGO a buscar", textFieldBuscar);
		}*/ // Se pondra despues el buscar dni
	}

	private void actionPerformedBtnCancelar(ActionEvent e) {
		dispose();
	}
	
	void listar() {
		modelo.setRowCount(0);
		for (int i=0; i<listaIngreso.tamaño(); i++) {
			String estado = ( listaIngreso.obtener(i).getEstado()==0 ) ? "Pendiente": "Pagado";
			Object[] fila = { 	listaIngreso.obtener(i).getCodigoIngreso(),
								listaIngreso.obtener(i).getCodigoSocio(),
								listaIngreso.obtener(i).getFechaIngreso(),
								listaIngreso.obtener(i).getHoraIngreso(),
								listaIngreso.obtener(i).getNumeroInvitados(),
								listaIngreso.obtener(i).getCostoIngreso(),
								estado
							};
			modelo.addRow(fila);
		}
	}
	
	void limpieza() {
		textFieldNumInvitados.setText("");
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
	
	int leerCodigoIngreso() {
		return Integer.parseInt( textFieldCodigoIngreso.getText().trim());
	}
	
	int leerCodigoSocio() {
		return Integer.parseInt( comboBoxCodigoSocio.getSelectedItem().toString().trim());
	}
	
	String leerFechaIngreso() {
		return Fecha.fechaSistema();
	}
	
	String leerHoraIngreso() {
		return Fecha.horaSistema();
	}
	
	int leerNumeroInvitados() {
		return Integer.parseInt( textFieldNumInvitados.getText().trim());
	}
	
	int leerCostoIngreso() {
		return leerNumeroInvitados() * 25;
	}
	
}
