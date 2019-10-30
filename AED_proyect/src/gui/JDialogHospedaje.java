package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Color;

public class JDialogHospedaje extends JDialog {
	private JTextField textFieldCodigoHospedaje;

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
			JLabel lblCodigoSocio = new JLabel("Codigo Socio");
			lblCodigoSocio.setBounds(10, 36, 100, 14);
			getContentPane().add(lblCodigoSocio);
		}
		{
			JComboBox comboBoxCodigoSocio = new JComboBox();
			comboBoxCodigoSocio.setBounds(120, 33, 60, 20);
			getContentPane().add(comboBoxCodigoSocio);
		}
		{
			JLabel lblBungalowLibre = new JLabel("Bungalow libre");
			lblBungalowLibre.setBounds(10, 61, 100, 14);
			getContentPane().add(lblBungalowLibre);
		}
		{
			JComboBox comboBox = new JComboBox();
			comboBox.setBounds(120, 58, 60, 20);
			getContentPane().add(comboBox);
		}
		{
			JButton btnHospedar = new JButton("Hospedar");
			btnHospedar.setBounds(335, 27, 89, 23);
			getContentPane().add(btnHospedar);
		}
		{
			JPanel panelHospedados = new JPanel();
			panelHospedados.setBackground(Color.LIGHT_GRAY);
			panelHospedados.setBounds(10, 86, 414, 164);
			getContentPane().add(panelHospedados);
		}
	}

}
