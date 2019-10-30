package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;

public class JDialogConsumo extends JDialog {
	private JLabel lblCodigoSocio;
	private JComboBox comboBoxCodigoSocio;
	private JTextField textFieldSocio;
	private JLabel lblProducto;
	private JComboBox comboBoxCodigoProducto;
	private JButton button;
	private JLabel lblPrecioUnitario;
	private JLabel lblConsumoDeSocio_1;
	private JLabel labelSocio;
	private JPanel panel;

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
		setTitle("Registro | Consumo");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		lblCodigoSocio = new JLabel("Codigo Socio");
		lblCodigoSocio.setBounds(10, 15, 76, 14);
		getContentPane().add(lblCodigoSocio);
		
		comboBoxCodigoSocio = new JComboBox();
		comboBoxCodigoSocio.setModel(new DefaultComboBoxModel(new String[] {"10001", "10002", "10003"}));
		comboBoxCodigoSocio.setBounds(96, 12, 62, 20);
		getContentPane().add(comboBoxCodigoSocio);
		
		textFieldSocio = new JTextField();
		textFieldSocio.setEditable(false);
		textFieldSocio.setEnabled(false);
		textFieldSocio.setBounds(168, 12, 86, 20);
		getContentPane().add(textFieldSocio);
		textFieldSocio.setColumns(10);
		
		lblProducto = new JLabel("Producto");
		lblProducto.setBounds(10, 40, 76, 14);
		getContentPane().add(lblProducto);
		
		comboBoxCodigoProducto = new JComboBox();
		comboBoxCodigoProducto.setModel(new DefaultComboBoxModel(new String[] {"20001", "20002"}));
		comboBoxCodigoProducto.setBounds(96, 37, 62, 20);
		getContentPane().add(comboBoxCodigoProducto);
		
		button = new JButton("New button");
		button.setBounds(335, 11, 89, 23);
		getContentPane().add(button);
		
		lblPrecioUnitario = new JLabel("S/. p.u.");
		lblPrecioUnitario.setBounds(168, 40, 46, 14);
		getContentPane().add(lblPrecioUnitario);
		
		lblConsumoDeSocio_1 = new JLabel("CONSUMO DE SOCIO: ");
		lblConsumoDeSocio_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblConsumoDeSocio_1.setBounds(10, 75, 119, 14);
		getContentPane().add(lblConsumoDeSocio_1);
		
		labelSocio = new JLabel("...");
		labelSocio.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelSocio.setBounds(140, 75, 46, 14);
		getContentPane().add(labelSocio);
		
		panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(10, 90, 414, 160);
		getContentPane().add(panel);
	}
}
