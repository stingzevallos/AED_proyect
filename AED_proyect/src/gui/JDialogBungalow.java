package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;

public class JDialogBungalow extends JDialog {
	private JTextField txtbunga;
	private JTextField txtPrecio;
	private JTextField txtBuscar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JDialogBungalow dialog = new JDialogBungalow();
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
	public JDialogBungalow() {
		setTitle("Mantenimiento | Bungalow");
		setBounds(100, 100, 755, 350);
		getContentPane().setLayout(null);
		
		JLabel lblBungalow = new JLabel("Bungalow");
		lblBungalow.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBungalow.setBounds(10, 25, 78, 19);
		getContentPane().add(lblBungalow);
		
		JLabel lblRegistroDeBungalow = new JLabel("Registro de Bungalow");
		lblRegistroDeBungalow.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRegistroDeBungalow.setBounds(10, 55, 240, 25);
		getContentPane().add(lblRegistroDeBungalow);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(Color.LIGHT_GRAY);
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(10, 91, 304, 170);
		getContentPane().add(panel);
		
		JLabel lblCodbungalow = new JLabel("Cod.Bungalow");
		lblCodbungalow.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCodbungalow.setBounds(11, 15, 91, 14);
		panel.add(lblCodbungalow);
		
		txtbunga = new JTextField();
		txtbunga.setEditable(false);
		txtbunga.setColumns(10);
		txtbunga.setBounds(112, 13, 86, 20);
		panel.add(txtbunga);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEstado.setBounds(11, 46, 61, 14);
		panel.add(lblEstado);
		
		JLabel label_3 = new JLabel("Precio");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_3.setBounds(11, 75, 61, 14);
		panel.add(label_3);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(112, 73, 154, 20);
		panel.add(txtPrecio);
		
		JButton button = new JButton("Adicionar");
		button.setFont(new Font("Tahoma", Font.BOLD, 11));
		button.setBounds(10, 117, 92, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("Modificar");
		button_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		button_1.setBounds(107, 117, 91, 23);
		panel.add(button_1);
		
		JButton button_2 = new JButton("Cancelar");
		button_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		button_2.setBounds(206, 117, 92, 23);
		panel.add(button_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Libre", "Ocupado", "Mantenimiento"}));
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		comboBox.setBounds(112, 44, 86, 20);
		panel.add(comboBox);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(324, 91, 405, 170);
		getContentPane().add(panel_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Codigo", "Estado"}));
		comboBox_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		comboBox_1.setBounds(10, 11, 69, 20);
		panel_1.add(comboBox_1);
		
		txtBuscar = new JTextField();
		txtBuscar.setColumns(10);
		txtBuscar.setBounds(89, 12, 126, 20);
		panel_1.add(txtBuscar);
		
		JButton button_3 = new JButton("Consultar");
		button_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		button_3.setBounds(226, 12, 92, 23);
		panel_1.add(button_3);
		
		JButton button_4 = new JButton("Eliminar");
		button_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		button_4.setBounds(326, 11, 79, 23);
		panel_1.add(button_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 43, 384, 116);
		panel_1.add(scrollPane);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSalir.setBounds(637, 277, 92, 23);
		getContentPane().add(btnSalir);

	}

}
