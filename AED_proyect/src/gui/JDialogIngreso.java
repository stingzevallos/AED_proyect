package gui;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;

import clases.Ingreso;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JDialogIngreso extends JDialog implements ActionListener {

	
	ArrayList<Ingreso> listaIngreso = new ArrayList<Ingreso>();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblIngresoDeSocio;
	private JLabel lblCodigoDeIngreso;
	private JLabel lblCodigoSocio;
	private JLabel lblNDeInvitados;
	private JTextField textFieldCodigoIngreso;
	private JComboBox comboBoxCodigoSocio;
	private JTextField textFieldNumInvitados;
	private JLabel lblSX;
	private JButton btnIngresar;
	private JLabel lblListaDeSocio;
	private JPanel panelListaSocio;
	private JTable table;

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
		setBounds(100, 100, 450, 342);
		getContentPane().setLayout(null);
		
		lblIngresoDeSocio = new JLabel("Ingreso de Socio");
		lblIngresoDeSocio.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIngresoDeSocio.setBounds(10, 11, 115, 14);
		getContentPane().add(lblIngresoDeSocio);
		
		lblCodigoDeIngreso = new JLabel("Codigo de Ingreso");
		lblCodigoDeIngreso.setBounds(10, 36, 93, 14);
		getContentPane().add(lblCodigoDeIngreso);
		
		lblCodigoSocio = new JLabel("Codigo Socio");
		lblCodigoSocio.setBounds(10, 61, 93, 14);
		getContentPane().add(lblCodigoSocio);
		
		lblNDeInvitados = new JLabel("N\u00B0 de invitados");
		lblNDeInvitados.setBounds(10, 86, 93, 14);
		getContentPane().add(lblNDeInvitados);
		
		textFieldCodigoIngreso = new JTextField();
		textFieldCodigoIngreso.setEditable(false);
		textFieldCodigoIngreso.setText("40001");
		textFieldCodigoIngreso.setBounds(113, 33, 86, 20);
		getContentPane().add(textFieldCodigoIngreso);
		textFieldCodigoIngreso.setColumns(10);
		
		comboBoxCodigoSocio = new JComboBox();
		comboBoxCodigoSocio.setModel(new DefaultComboBoxModel(new String[] {"10001", "10002", "10003"}));
		comboBoxCodigoSocio.setBounds(113, 58, 86, 20);
		getContentPane().add(comboBoxCodigoSocio);
		
		textFieldNumInvitados = new JTextField();
		textFieldNumInvitados.setBounds(113, 83, 46, 20);
		getContentPane().add(textFieldNumInvitados);
		textFieldNumInvitados.setColumns(10);
		
		lblSX = new JLabel("S/ 25.00 x invitado");
		lblSX.setBounds(169, 86, 107, 14);
		getContentPane().add(lblSX);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.setBounds(335, 32, 89, 23);
		btnIngresar.addActionListener(this);
		getContentPane().add(btnIngresar);
		
		lblListaDeSocio = new JLabel("LISTA DE SOCIO INGRESADOS");
		lblListaDeSocio.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblListaDeSocio.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaDeSocio.setBounds(10, 121, 414, 14);
		getContentPane().add(lblListaDeSocio);
		
		panelListaSocio = new JPanel();
		panelListaSocio.setBackground(Color.LIGHT_GRAY);
		panelListaSocio.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelListaSocio.setBounds(10, 136, 414, 156);
		getContentPane().add(panelListaSocio);
		
		table = new JTable();
		panelListaSocio.add(table);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(335, 57, 89, 23);
		btnCancelar.addActionListener(this);
		getContentPane().add(btnCancelar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ( e.getSource() == btnIngresar )
			actionPerformedBtnIngresar(e);
		else
			actionPerformedBtnCancelar(e);
	}

	private void actionPerformedBtnIngresar(ActionEvent e) { //falta obtener mejor datos, generar auto cod socio
		Ingreso nuevoIngreso;
		
		int codigoIngreso = Integer.parseInt( textFieldCodigoIngreso.getText());
		int codigoSocio = Integer.parseInt( comboBoxCodigoSocio.getSelectedItem().toString());
		String fechaIngreso = ""; //aca ira la fecha de ingreso
		String horaIngreso = ""; // aca ira la hora del sistema;
		int numeroInvitados =  Integer.parseInt( textFieldNumInvitados.getText());
		double costoIngreso = 25;
		int estado = 0;
		
		nuevoIngreso = new Ingreso( codigoIngreso, codigoSocio, fechaIngreso, horaIngreso, numeroInvitados, costoIngreso, estado );
		listaIngreso.add(nuevoIngreso);
	}

	private void actionPerformedBtnCancelar(ActionEvent e) {
		dispose();
	}
}
