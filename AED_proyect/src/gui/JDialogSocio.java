package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;

public class JDialogSocio extends JDialog {
	private JTextField txtcodigo;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtdni;
	private JTextField txtTelefono;
	private JTextField txtBuscodigo;

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
		setBounds(100, 100, 749, 379);
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
		panel.setBounds(10, 85, 298, 220);
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
		
		JButton btnNuevo = new JButton("Adicionar");
		btnNuevo.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNuevo.setBounds(10, 178, 92, 23);
		panel.add(btnNuevo);
		
		JButton btnGuardar = new JButton("Modificar");
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGuardar.setBounds(106, 178, 92, 23);
		panel.add(btnGuardar);
		
		JButton btnModificar = new JButton("Cancelar");
		btnModificar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnModificar.setBounds(198, 178, 92, 23);
		panel.add(btnModificar);
		
		JLabel lblListadoYConsulta = new JLabel("Listado y consulta de socio");
		lblListadoYConsulta.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblListadoYConsulta.setBounds(318, 50, 240, 25);
		getContentPane().add(lblListadoYConsulta);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(318, 80, 405, 225);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 11, 69, 20);
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Codigo", "DNI"}));
		panel_1.add(comboBox);
		
		txtBuscodigo = new JTextField();
		txtBuscodigo.setBounds(89, 12, 126, 20);
		panel_1.add(txtBuscodigo);
		txtBuscodigo.setColumns(10);
		
		JButton btnBuscar = new JButton("Consultar");
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBuscar.setBounds(226, 12, 92, 23);
		panel_1.add(btnBuscar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEliminar.setBounds(326, 11, 79, 23);
		panel_1.add(btnEliminar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 43, 384, 171);
		panel_1.add(scrollPane);
		
		JButton button = new JButton("Salir");
		button.setFont(new Font("Tahoma", Font.BOLD, 11));
		button.setBounds(631, 313, 92, 23);
		getContentPane().add(button);

	}
}
