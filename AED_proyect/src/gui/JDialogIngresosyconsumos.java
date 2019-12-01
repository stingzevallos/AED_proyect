package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Ingreso;
import clases.Hospedaje;
import clases.Producto;
import arreglos.ArregloIngreso;
import arreglos.ArregloHospedaje;
import arreglos.ArregloProducto;
import clases.Socio;


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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JDialogIngresosyconsumos extends JDialog {
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtDNI;
	private JTable tableConsumo;
	private JComboBox cboCodigo; 
	private JTextField txtPago;
	private JTextField txtEstado;
	private DefaultTableModel model;
	

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
		setBounds(100, 100, 498, 330);
		getContentPane().setLayout(null);
		{
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
			panel_1.setLayout(null);
			panel_1.setBackground(Color.WHITE);
			panel_1.setBounds(10, 11, 466, 114);
			getContentPane().add(panel_1);
			{
				JButton btnConsultarDatos = new JButton("Consultar");
				btnConsultarDatos.setFont(new Font("Tahoma", Font.BOLD, 11));
				btnConsultarDatos.setBounds(225, 11, 97, 23);
				panel_1.add(btnConsultarDatos);
			}
			{
				JLabel lblCdigo = new JLabel("C\u00F3digo de ingreso:");
				lblCdigo.setBounds(10, 15, 99, 14);
				panel_1.add(lblCdigo);
			}
			
			cboCodigo = new JComboBox();
			cboCodigo.setBounds(119, 12, 86, 20);
			panel_1.add(cboCodigo);
			
			JLabel lblNewLabel = new JLabel("Nombre de cliente:");
			lblNewLabel.setBounds(10, 49, 91, 14);
			panel_1.add(lblNewLabel);
			
			txtNombre = new JTextField();
			txtNombre.setBounds(121, 46, 110, 20);
			panel_1.add(txtNombre);
			txtNombre.setColumns(10);
			
			JLabel lblApellidosDelCliente = new JLabel("Apellidos del cliente:");
			lblApellidosDelCliente.setBounds(10, 80, 110, 14);
			panel_1.add(lblApellidosDelCliente);
			
			txtApellidos = new JTextField();
			txtApellidos.setBounds(121, 77, 110, 20);
			panel_1.add(txtApellidos);
			txtApellidos.setColumns(10);
			
			JLabel dni = new JLabel("DNI:");
			dni.setBounds(243, 45, 46, 14);
			panel_1.add(dni);
			
			txtDNI = new JTextField();
			txtDNI.setBounds(306, 46, 117, 20);
			panel_1.add(txtDNI);
			txtDNI.setColumns(10);
			
			JLabel lblEstado = new JLabel("Estado:");
			lblEstado.setBounds(241, 80, 46, 14);
			panel_1.add(lblEstado);
			
			txtEstado = new JTextField();
			txtEstado.setBounds(306, 77, 117, 20);
			panel_1.add(txtEstado);
			txtEstado.setColumns(10);
		}
		
		JButton btnPagar = new JButton("Pagar");
		btnPagar.setBackground(Color.RED);
		btnPagar.setBounds(284, 249, 89, 23);
		getContentPane().add(btnPagar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBackground(Color.RED);
		btnSalir.setBounds(387, 249, 89, 23);
		getContentPane().add(btnSalir);
		{
			Panel panel = new Panel();
			panel.setBackground(Color.WHITE);
			panel.setBounds(10, 249, 219, 32);
			getContentPane().add(panel);
			
			JLabel lblTotalAPagar = new JLabel("Total a pagar:");
			panel.add(lblTotalAPagar);
			
			txtPago = new JTextField();
			panel.add(txtPago);
			txtPago.setColumns(10);
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 136, 466, 98);
		getContentPane().add(scrollPane);
		
		tableConsumo = new JTable();
		tableConsumo.setFillsViewportHeight(true);
		scrollPane.setViewportView(tableConsumo);
	}
	
	private void inicializar(){
		txtDNI.setText("");
		txtNombre.setText("");
		txtApellidos.setText("");
		txtEstado.setText("");
		txtPago.setText("00.00");
		cboCodigo.removeAllItems();			
		tableConsumo.setModel(model);
		ArregloIngreso ai= new ArregloIngreso("00000");
				model = ai.("00000");
				
					
		
		
				
				
				

		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private void calcular(){
		int codIn = Integer.parseInt((String) cboCodigo.getSelectedItem());
		
		Ingreso in = new ArregloIngreso().buscar(codIn);	
		ArregloIngreso ai = new ArregloIngreso();
		txtDNI.setText(codSo.getDni());
		txtNombre.setText(codSo.getNombres());
		
		txtEstado.setText(in.getEstado());
		txtPago.setText(String.valueOf(in.getTotalPagar()));
		
		
		
		
		
		
		
		
		
		
	
	}
	
	
	
	
	
	
}
