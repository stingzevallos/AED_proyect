package gui;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import clases.Hospedaje;
import clases.Ingreso;

import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JDialogHospedaje extends JDialog implements ActionListener {
	
	ArrayList<Hospedaje> listaHospedaje = new ArrayList<Hospedaje>();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldCodigoHospedaje;
	private JComboBox comboBoxCodigoIngreso;
	private JComboBox comboBoxBungalow;
	private JButton btnHospedar;
	private JButton btnCancelar;

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
			textFieldCodigoHospedaje.setText("50001");
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
		{
			JPanel panelHospedados = new JPanel();
			panelHospedados.setBackground(Color.LIGHT_GRAY);
			panelHospedados.setBounds(10, 86, 414, 164);
			getContentPane().add(panelHospedados);
		}
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(335, 32, 89, 23);
		getContentPane().add(btnCancelar);
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
		
		int codigoHospedaje = Integer.parseInt( textFieldCodigoHospedaje.getText());
		int codigoIngreso = Integer.parseInt( comboBoxCodigoIngreso.getSelectedItem().toString());
		int numeroBungalow = Integer.parseInt( comboBoxBungalow.getSelectedItem().toString());
		String fechaSalida = "";
		String horaSalida = "";
		double costoHospedaje = 0;
		int estado = 0;
		
		nuevoHospedaje = new Hospedaje( codigoHospedaje, codigoIngreso, numeroBungalow, fechaSalida, horaSalida, costoHospedaje, estado );
		listaHospedaje.add(nuevoHospedaje);
		
	}

	private void actionPerformedBtnCancelar(ActionEvent e) {
		dispose();
	}
}
