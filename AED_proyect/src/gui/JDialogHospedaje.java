package gui;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import arreglos.ArregloHospedaje;
import clases.Hospedaje;
import javax.swing.JComboBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class JDialogHospedaje extends JDialog implements ActionListener {
	
	ArregloHospedaje listaHospedaje = new ArregloHospedaje();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldCodigoHospedaje;
	private JComboBox comboBoxCodigoIngreso;
	private JComboBox comboBoxBungalow;
	private JButton btnHospedar;
	private JButton btnCancelar;
	private JTable table;
	private JScrollPane scrollPane;
	private DefaultTableModel modelo;

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
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		{
			JLabel lblCodigoHospedaje = new JLabel("Codigo Hospedaje");
			lblCodigoHospedaje.setBounds(10, 11, 100, 14);
			getContentPane().add(lblCodigoHospedaje);
		}
		{
			textFieldCodigoHospedaje = new JTextField();
			textFieldCodigoHospedaje.setEnabled(false);
			textFieldCodigoHospedaje.setEditable(false);
			textFieldCodigoHospedaje.setText( String.valueOf( listaHospedaje.generarCodigo()));
			textFieldCodigoHospedaje.setBounds(120, 8, 60, 20);
			getContentPane().add(textFieldCodigoHospedaje);
			textFieldCodigoHospedaje.setColumns(10);
		}
		{
			JLabel lblCodigoSocio = new JLabel("Codigo Ingreso");
			lblCodigoSocio.setBounds(10, 36, 100, 14);
			getContentPane().add(lblCodigoSocio);
		}
		{
			comboBoxCodigoIngreso = new JComboBox();
			comboBoxCodigoIngreso.setBounds(120, 33, 60, 20);
			getContentPane().add(comboBoxCodigoIngreso);
		}
		{
			JLabel lblBungalowLibre = new JLabel("Bungalow libre");
			lblBungalowLibre.setBounds(10, 61, 100, 14);
			getContentPane().add(lblBungalowLibre);
		}
		{
			comboBoxBungalow = new JComboBox();
			comboBoxBungalow.setBounds(120, 58, 60, 20);
			getContentPane().add(comboBoxBungalow);
		}
		{
			btnHospedar = new JButton("Hospedar");
			btnHospedar.addActionListener(this);
			btnHospedar.setBounds(335, 7, 89, 23);
			getContentPane().add(btnHospedar);
		}
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(335, 32, 89, 23);
		getContentPane().add(btnCancelar);
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 86, 414, 164);
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
				
				table.setModel(modelo);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ( e.getSource() == btnHospedar )
			actionPerformedBtnHospedar(e);
		else
			actionPerformedBtnCancelar(e);
	}

	private void actionPerformedBtnHospedar(ActionEvent e) { // falta obtener datos auto, actualizar bungalow y fechas
		Hospedaje nuevoHospedaje;
		
		int codigoHospedaje = leerCodigoHospedaje();
		int codigoIngreso = leerCodigoIngreso();
		int numeroBungalow = leerNumeroBungalow();
		String fechaSalida = leerFechaSalida();;
		String horaSalida = leerHoraSalida();
		double costoHospedaje = 0;
		int estado = 0;
		
		nuevoHospedaje = new Hospedaje( codigoHospedaje, codigoIngreso, numeroBungalow, fechaSalida, horaSalida, costoHospedaje, estado );
		listaHospedaje.adicionar(nuevoHospedaje);
		
	}

	private void actionPerformedBtnCancelar(ActionEvent e) {
		dispose();
	}
	
	int leerCodigoHospedaje() {
		return Integer.parseInt( textFieldCodigoHospedaje.getText());
	}
	
	int leerCodigoIngreso() {
		return Integer.parseInt( comboBoxCodigoIngreso.getSelectedItem().toString());
	}
	
	int leerNumeroBungalow() {
		return Integer.parseInt( comboBoxBungalow.getSelectedItem().toString());
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
	
}
