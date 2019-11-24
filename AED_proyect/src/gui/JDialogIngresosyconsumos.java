package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Component;
import java.awt.Rectangle;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.BevelBorder;
import java.awt.ScrollPane;
import java.awt.Panel;
import java.awt.Label;

public class JDialogIngresosyconsumos extends JDialog {
	private JTextField textField_1;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JDialogIngresosyconsumos dialog = new JDialogIngresosyconsumos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JDialogIngresosyconsumos() {
		getContentPane().setBackground(SystemColor.scrollbar);
		setBackground(Color.ORANGE);
		setTitle("Pago | Ingresos y Consumos");
		setBounds(100, 100, 450, 307);
		getContentPane().setLayout(null);
		{
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
			panel_1.setLayout(null);
			panel_1.setBackground(SystemColor.info);
			panel_1.setBounds(10, 11, 219, 202);
			getContentPane().add(panel_1);
			{
				textField_1 = new JTextField();
				textField_1.setColumns(10);
				textField_1.setBounds(52, 13, 110, 20);
				panel_1.add(textField_1);
			}
			{
				JButton btnConsultarDatos = new JButton("Consultar datos");
				btnConsultarDatos.setFont(new Font("Tahoma", Font.BOLD, 11));
				btnConsultarDatos.setBounds(10, 55, 182, 23);
				panel_1.add(btnConsultarDatos);
			}
			{
				JButton button = new JButton("Eliminar");
				button.setFont(new Font("Tahoma", Font.BOLD, 11));
				button.setBounds(10, 152, 182, 23);
				panel_1.add(button);
			}
			{
				JLabel lblCdigo = new JLabel("C\u00F3digo");
				lblCdigo.setBounds(10, 15, 46, 14);
				panel_1.add(lblCdigo);
			}
			{
				JButton btnNewButton = new JButton("Ver detalle de consumo");
				btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
				btnNewButton.setBounds(10, 103, 182, 23);
				panel_1.add(btnNewButton);
			}
		}
		
		JButton btnPagar = new JButton("Pagar");
		btnPagar.setBackground(new Color(255, 200, 0));
		btnPagar.setBounds(236, 231, 89, 23);
		getContentPane().add(btnPagar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBackground(Color.ORANGE);
		btnSalir.setBounds(335, 231, 89, 23);
		getContentPane().add(btnSalir);
		{
			ScrollPane scrollPane = new ScrollPane();
			scrollPane.setBackground(SystemColor.info);
			scrollPane.setBounds(235, 11, 189, 87);
			getContentPane().add(scrollPane);
		}
		{
			ScrollPane scrollPane = new ScrollPane();
			scrollPane.setBackground(SystemColor.info);
			scrollPane.setBounds(235, 118, 189, 95);
			getContentPane().add(scrollPane);
		}
		{
			Panel panel = new Panel();
			panel.setBackground(SystemColor.info);
			panel.setBounds(10, 219, 219, 35);
			getContentPane().add(panel);
			
			Label label = new Label("Total a pagar:");
			panel.add(label);
			
			textField = new JTextField();
			panel.add(textField);
			textField.setColumns(10);
		}
	}
}
