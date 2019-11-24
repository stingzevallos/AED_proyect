package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Button;
import java.awt.Panel;
import java.awt.ScrollPane;

public class JDialogHospedajes extends JDialog {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JDialogHospedajes dialog = new JDialogHospedajes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JDialogHospedajes() {
		getContentPane().setBackground(SystemColor.textInactiveText);
		setTitle("Pago | Hospedajes");
		setBounds(100, 100, 523, 303);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBackground(SystemColor.info);
		panel.setBounds(10, 11, 212, 205);
		getContentPane().add(panel);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(52, 13, 110, 20);
		panel.add(textField);
		
		JButton btnConsultarDatos = new JButton("Ver datos");
		btnConsultarDatos.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConsultarDatos.setBounds(10, 104, 192, 23);
		panel.add(btnConsultarDatos);
		
		JButton button_1 = new JButton("Eliminar");
		button_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		button_1.setBounds(10, 172, 192, 23);
		panel.add(button_1);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setBounds(10, 15, 46, 14);
		panel.add(lblCdigo);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(10, 44, 46, 14);
		panel.add(lblFecha);
		
		JLabel lblHora = new JLabel("Hora:");
		lblHora.setBounds(10, 73, 46, 14);
		panel.add(lblHora);
		
		textField_1 = new JTextField();
		textField_1.setBounds(52, 42, 110, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(52, 73, 110, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnVerDeuda = new JButton("Ver detalle de hospedaje");
		btnVerDeuda.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVerDeuda.setBounds(10, 138, 192, 23);
		panel.add(btnVerDeuda);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_2.setBackground(SystemColor.info);
		panel_2.setBounds(232, 11, 267, 99);
		getContentPane().add(panel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBackground(SystemColor.info);
		panel_1.setBounds(232, 121, 267, 95);
		getContentPane().add(panel_1);
		
		JLabel lblTotalAPagar = new JLabel("Total a pagar:");
		lblTotalAPagar.setBounds(20, 67, 104, 14);
		panel_1.add(lblTotalAPagar);
		
		textField_3 = new JTextField();
		textField_3.setBounds(134, 64, 86, 20);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnPagar = new JButton("Pagar");
		btnPagar.setBackground(Color.YELLOW);
		btnPagar.setBounds(410, 224, 89, 23);
		getContentPane().add(btnPagar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBackground(Color.YELLOW);
		btnSalir.setBounds(10, 224, 89, 23);
		getContentPane().add(btnSalir);
	}
}
