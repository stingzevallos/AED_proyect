package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import clases.Hospedaje;
import clases.Socio;
import arreglos.ArregloHospedaje;
import arreglos.ArregloProducto;
import java.awt.SystemColor;
import java.util.ArrayList;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Button;
import java.awt.Panel;
import java.awt.ScrollPane;
import javax.swing.JComboBox;

public class JDialogHospedajes extends JDialog {
	private JTextField txtCodigo;
	private JTextField txtCli;
	private JTextField txtApe;
	private JTextField txtFecha;
	private JTextField txtCategoria;
	private JTextField txtPrecio;
	private JTextField txtTotaldias;
	private JTextField txtNumero;
	private JTextField txtTotalPagar;
	private JComboBox cboHospedaje;

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
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setTitle("Pago | Hospedajes");
		setBounds(100, 100, 619, 325);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 8, 583, 131);
		getContentPane().add(panel);
		
		JButton btnConsultarDatos = new JButton("Consultar");
		btnConsultarDatos.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConsultarDatos.setBounds(295, 11, 99, 23);
		panel.add(btnConsultarDatos);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo de hospedaje:");
		lblCdigo.setBounds(10, 15, 121, 14);
		panel.add(lblCdigo);
		
		JLabel lblFecha = new JLabel("Fecha y hora de ingreso:");
		lblFecha.setBounds(295, 43, 130, 14);
		panel.add(lblFecha);
		
		cboHospedaje = new JComboBox();
		cboHospedaje.setBounds(132, 12, 138, 20);
		panel.add(cboHospedaje);
		
		JLabel lblCdigoDelCliente = new JLabel("C\u00F3digo del cliente:");
		lblCdigoDelCliente.setBounds(10, 40, 112, 14);
		panel.add(lblCdigoDelCliente);
		
		JLabel lblNombreDelCliente = new JLabel("Nombre del cliente:");
		lblNombreDelCliente.setBounds(10, 65, 99, 14);
		panel.add(lblNombreDelCliente);
		
		JLabel lblApellidosDelCliente = new JLabel("Apellidos del cliente:");
		lblApellidosDelCliente.setBounds(10, 90, 99, 14);
		panel.add(lblApellidosDelCliente);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(132, 40, 138, 20);
		panel.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtCli = new JTextField();
		txtCli.setBounds(132, 65, 138, 20);
		panel.add(txtCli);
		txtCli.setColumns(10);
		
		txtApe = new JTextField();
		txtApe.setBounds(132, 89, 138, 20);
		panel.add(txtApe);
		txtApe.setColumns(10);
		
		txtFecha = new JTextField();
		txtFecha.setBounds(435, 40, 138, 20);
		panel.add(txtFecha);
		txtFecha.setColumns(10);
		
		JButton btnPagar = new JButton("Pagar");
		btnPagar.setBackground(Color.RED);
		btnPagar.setBounds(370, 247, 89, 23);
		getContentPane().add(btnPagar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBackground(Color.RED);
		btnSalir.setBounds(504, 247, 89, 23);
		getContentPane().add(btnSalir);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 150, 583, 79);
		getContentPane().add(panel_1);
		
		JLabel lblNmeroDeBungalow = new JLabel("N\u00FAmero de bungalow");
		lblNmeroDeBungalow.setBounds(10, 15, 112, 14);
		panel_1.add(lblNmeroDeBungalow);
		
		JLabel lblTotalDeDas = new JLabel("Total de d\u00EDas:");
		lblTotalDeDas.setBounds(300, 40, 130, 14);
		panel_1.add(lblTotalDeDas);
		
		JLabel lblCategora = new JLabel("Categor\u00EDa:");
		lblCategora.setBounds(10, 40, 112, 14);
		panel_1.add(lblCategora);
		
		JLabel lblPrecioPorDa = new JLabel("Precio por d\u00EDa:");
		lblPrecioPorDa.setBounds(300, 15, 110, 14);
		panel_1.add(lblPrecioPorDa);
		
		txtCategoria = new JTextField();
		txtCategoria.setColumns(10);
		txtCategoria.setBounds(132, 40, 138, 20);
		panel_1.add(txtCategoria);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(420, 12, 153, 20);
		panel_1.add(txtPrecio);
		
		txtTotaldias = new JTextField();
		txtTotaldias.setColumns(10);
		txtTotaldias.setBounds(420, 40, 153, 20);
		panel_1.add(txtTotaldias);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(134, 12, 136, 20);
		panel_1.add(txtNumero);
		txtNumero.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 240, 218, 30);
		getContentPane().add(panel_2);
		
		JLabel lblTotalAPagar = new JLabel("Total a pagar:");
		panel_2.add(lblTotalAPagar);
		
		txtTotalPagar = new JTextField();
		panel_2.add(txtTotalPagar);
		txtTotalPagar.setColumns(10);
	}
	
	
	private void cargarCbo() {
		hospe = new ArregloHospedaje();
		ArrayList<ArregloHospedaje> li = hospe.hospedajespendientes();
		cboHospedaje.addItem("Seleccione");
		
		
		
		private void inicializar() {
			
			
		}
		
		
		
		
		
		
		
		
		
	
	
	
	
}
