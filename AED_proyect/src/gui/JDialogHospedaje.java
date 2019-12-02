package gui;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import arreglos.ArregloHospedaje;
import arreglos.ArregloIngreso;
import clases.Hospedaje;
import librerias.Resaltador;

import javax.swing.JComboBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;

public class JDialogHospedaje extends JDialog implements ActionListener {
	
	ArregloHospedaje listaHospedaje = new ArregloHospedaje();
	ArregloIngreso listaIngreso = new ArregloIngreso();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldCodigoHospedaje;
	private JComboBox<String> comboBoxCodigoIngreso;
	private JComboBox<String> comboBoxBungalow;
	private JButton btnHospedar;
	private JButton btnCancelar;
	private JTable table;
	private JScrollPane scrollPane;
	private DefaultTableModel modelo;
	private JTextField textFieldBuscar;
	private JButton btnBuscar;
	private JButton btnEliminar;
	private JComboBox<String> comboBoxBuscar;
	
	Resaltador resaltado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JDialogHospedaje dialog = new JDialogHospedaje();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JDialogHospedaje() {
		setModal(true);
		setTitle("Registro | Hospedaje");
		setBounds(100, 100, 651, 405);
		getContentPane().setLayout(null);
		{
			JLabel lblCodigoHospedaje = new JLabel("Codigo Hospedaje");
			lblCodigoHospedaje.setBounds(10, 35, 121, 14);
			getContentPane().add(lblCodigoHospedaje);
		}
		{
			textFieldCodigoHospedaje = new JTextField();
			textFieldCodigoHospedaje.setEnabled(false);
			textFieldCodigoHospedaje.setEditable(false);
			textFieldCodigoHospedaje.setText( String.valueOf( listaHospedaje.generarCodigo()));
			textFieldCodigoHospedaje.setBounds(141, 32, 60, 20);
			getContentPane().add(textFieldCodigoHospedaje);
			textFieldCodigoHospedaje.setColumns(10);
		}
		{
			JLabel lblCodigoSocio = new JLabel("Codigo Ingreso");
			lblCodigoSocio.setBounds(10, 60, 121, 14);
			getContentPane().add(lblCodigoSocio);
		}
		{
			comboBoxCodigoIngreso = new JComboBox<String>();
			comboBoxCodigoIngreso.setBounds(141, 57, 60, 20);
			getContentPane().add(comboBoxCodigoIngreso);
		}
		{
			JLabel lblBungalowLibre = new JLabel("Bungalow libre");
			lblBungalowLibre.setBounds(10, 85, 121, 14);
			getContentPane().add(lblBungalowLibre);
		}
		{
			comboBoxBungalow = new JComboBox<String>();
			comboBoxBungalow.setBounds(141, 82, 60, 20);
			getContentPane().add(comboBoxBungalow);
		}
		{
			btnHospedar = new JButton("Hospedar");
			btnHospedar.addActionListener(this);
			btnHospedar.setBounds(525, 31, 100, 23);
			getContentPane().add(btnHospedar);
		}
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(525, 56, 100, 23);
		getContentPane().add(btnCancelar);
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 178, 615, 177);
			getContentPane().add(scrollPane);
			{
				table = new JTable();
				scrollPane.setViewportView(table);
				
				modelo = new DefaultTableModel();
				modelo.addColumn("Codigo Hospedaje");
				modelo.addColumn("Codigo Ingreso");
				modelo.addColumn("Numero Bungalow");
				modelo.addColumn("Fecha Salida");
				modelo.addColumn("Hora Salida");
				modelo.addColumn("Costo Hospedaje");
				modelo.addColumn("Estado");
				
				resaltado = new Resaltador(-1);
				
				table.setModel(modelo);
				table.setDefaultRenderer( Object.class, resaltado);
				
			}
		}
		
		JLabel lblListadoDeHospedajes = new JLabel("LISTA Y CONSULTA DE HOSPEDAJE DE SOCIOS");
		lblListadoDeHospedajes.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblListadoDeHospedajes.setHorizontalAlignment(SwingConstants.CENTER);
		lblListadoDeHospedajes.setBounds(10, 122, 615, 14);
		getContentPane().add(lblListadoDeHospedajes);
		
		comboBoxBuscar = new JComboBox<String>();
		comboBoxBuscar.setModel(new DefaultComboBoxModel<String>(new String[] {"Codigo", "DNI"}));
		comboBoxBuscar.setBounds(10, 147, 81, 20);
		getContentPane().add(comboBoxBuscar);
		
		JLabel lblHospedajeDeSocio = new JLabel("Hospedaje de Socio");
		lblHospedajeDeSocio.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblHospedajeDeSocio.setBounds(10, 11, 170, 14);
		getContentPane().add(lblHospedajeDeSocio);
		
		textFieldBuscar = new JTextField();
		textFieldBuscar.setBounds(101, 147, 100, 20);
		getContentPane().add(textFieldBuscar);
		textFieldBuscar.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(211, 144, 89, 23);
		getContentPane().add(btnBuscar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(310, 144, 89, 23);
		getContentPane().add(btnEliminar);
		
		generarCodigosIngresos();
		generarBungalowLibres();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ( e.getSource() == btnHospedar )
			actionPerformedBtnHospedar(e);
		else if ( e.getSource() == btnBuscar )
			actionPerformedBtnBuscar(e);
		else if ( e.getSource() == btnEliminar )
			actionPerformedBtnEliminar(e);
		else if ( e.getSource() == btnCancelar )
			actionPerformedBtnCancelar(e);
	}

	private void actionPerformedBtnHospedar(ActionEvent e) { // falta obtener datos auto, actualizar bungalow y fechas
		/*
		 * Se genera los codigos y bungalows disponibles
		 */
		generarCodigosIngresos();
		generarBungalowLibres();
		/*
		 * Codigo para hospedar
		 */
		Hospedaje nuevoHospedaje, buscado;
		
		int codigoHospedaje = leerCodigoHospedaje();
		int codigoIngreso = leerCodigoIngreso();
		buscado = listaHospedaje.buscarIngreso(codigoIngreso);
		if ( buscado == null || buscado.getEstado() == 0 ) {
			int numeroBungalow = leerNumeroBungalow();
			String fechaSalida = leerFechaSalida();
			String horaSalida = leerHoraSalida();
			double costoHospedaje = 0;
			int estado = 0;
			
			nuevoHospedaje = new Hospedaje( codigoHospedaje, codigoIngreso, numeroBungalow, fechaSalida, horaSalida, costoHospedaje, estado );
			listaHospedaje.adicionar(nuevoHospedaje);
			listaHospedaje.grabarHospedajes();
			listar();
			
		}
		else
			mensaje("Socio solo puede hospedarse 1 bungalow a la vez");
		
	}

	private void actionPerformedBtnBuscar(ActionEvent e) {
		int opcion = comboBoxBuscar.getSelectedIndex();
		if ( opcion == 0 ) {
			try {
				int codigo = Integer.parseInt( textFieldBuscar.getText().trim());
				int pos = listaHospedaje.buscarPosicion(codigo);
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
	}

	private void actionPerformedBtnEliminar(ActionEvent e) {
		try {
			int codigo = Integer.parseInt( textFieldBuscar.getText().trim());
			Hospedaje hospedaje = listaHospedaje.buscar(codigo);
			if ( hospedaje != null )
				listaHospedaje.eliminar( hospedaje);
			else
				error("No se encuentra registrado el hospedaje.", textFieldBuscar);
		}
		catch( Exception ex ) {
			error("Ingrese CODIGO a buscar.", textFieldBuscar);
		}
	}

	private void actionPerformedBtnCancelar(ActionEvent e) {
		dispose();
	}
	
	void listar() {
		modelo.setRowCount(0);
		for (int i=0; i<listaHospedaje.tamaño(); i++) {
			String estado = ( listaHospedaje.obtener(i).getEstado()==0 ) ? "Pendiente": "Pagado";
			Object[] fila = { 	listaHospedaje.obtener(i).getCodigoHospedaje(),
								listaHospedaje.obtener(i).getCodigoIngreso(),
								listaHospedaje.obtener(i).getNumeroBungalow(),
								listaHospedaje.obtener(i).getFechaIngreso(),
								listaHospedaje.obtener(i).getHoraIngreso(),
								listaHospedaje.obtener(i).getCostoHospedaje(),
								estado
							};
			modelo.addRow(fila);
		}
	}
	
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
	
	void error(String s, JTextField txt) {
		mensaje(s);
		txt.setText("");
		txt.requestFocus();
	}
	
	int leerCodigoHospedaje() {
		return Integer.parseInt( textFieldCodigoHospedaje.getText().trim());
	}
	
	int leerCodigoIngreso() {
		return Integer.parseInt( comboBoxCodigoIngreso.getSelectedItem().toString().trim());
	}
	
	int leerNumeroBungalow() {
		return Integer.parseInt( String.valueOf( comboBoxBungalow.getSelectedItem()).trim() );
	}
	
	String leerFechaSalida() {
		return ""; // aca ira la hora del sistema;
	}
	
	String leerHoraSalida() {
		return "";
	}
	
	int leerCostoHospedaje() {
		return 0;
	}
	
	void generarCodigosIngresos() {
		for ( int i=0; i< listaIngreso.tamaño(); i++ )
			if ( listaIngreso.obtener(i).getEstado() == 0 )
				comboBoxCodigoIngreso.addItem(String.valueOf( listaIngreso.obtener(i).getCodigoIngreso()) );
	}
	
	void generarBungalowLibres() {
		// Aca ira codigo de bungalow
		comboBoxBungalow.addItem("30001");
		comboBoxBungalow.addItem("30002");
		comboBoxBungalow.addItem("30003");
		// ...
		if ( comboBoxBungalow.getSelectedItem().toString().isEmpty() )
			btnHospedar.setEnabled(false);
		else
			btnHospedar.setEnabled(true);
	}
}
