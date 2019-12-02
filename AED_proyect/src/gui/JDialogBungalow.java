package gui;

import java.awt.EventQueue;
import clases.Bungalow;
import clases.Producto;
import arreglos.ArregloBungalow;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JDialogBungalow extends JDialog implements ActionListener {
	private JTextField txtbunga;
	private JTextField txtPrecio;
	private JTextField txtBuscar;
	private JTable table;
	private DefaultTableModel modelo;
   private JButton button;
   private JButton button_1;
   private JButton button_3;
   private JButton button_4;
   private JComboBox comboBox;
   private JComboBox comboBox_2;
   private JButton btnSalir;
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
		setModal(true);
		setTitle("Mantenimiento | Bungalow");
		setBounds(100, 100, 755, 426);
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
		panel.setBounds(10, 91, 304, 192);
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
		txtbunga.setText(String.valueOf(ao.GenerarCodigo()));
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEstado.setBounds(11, 46, 61, 14);
		panel.add(lblEstado);
		
		JLabel label_3 = new JLabel("Precio");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_3.setBounds(11, 107, 61, 14);
		panel.add(label_3);
		
		txtPrecio = new JTextField();
		txtPrecio.setText(100+"");
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(112, 105, 86, 20);
		panel.add(txtPrecio);
		
	    button = new JButton("Adicionar");
		button.addActionListener(this);
		button.setFont(new Font("Tahoma", Font.BOLD, 11));
		button.setBounds(11, 158, 92, 23);
		panel.add(button);
		
		button_1 = new JButton("Modificar");
		button_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		button_1.setBounds(107, 158, 91, 23);
		panel.add(button_1);
		
		JButton button_2 = new JButton("Cancelar");
		button_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		button_2.setBounds(202, 158, 92, 23);
		panel.add(button_2);
		
		comboBox = new JComboBox();
		comboBox.addActionListener(this);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Libre", "Ocupado", "Mantenimiento"}));
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		comboBox.setBounds(112, 44, 86, 20);
		panel.add(comboBox);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(11, 82, 61, 14);
		panel.add(lblCategoria);
		
		comboBox_2 = new JComboBox();
		comboBox_2.addActionListener(this); 
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Simple", "Doble", "Familiar"}));
		comboBox_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		comboBox_2.setBounds(112, 74, 86, 20);
		panel.add(comboBox_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(324, 91, 405, 251);
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
		
	    button_3 = new JButton("Consultar");
		button_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		button_3.setBounds(226, 12, 92, 23);
		panel_1.add(button_3);
		
	    button_4 = new JButton("Eliminar");
		button_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		button_4.setBounds(326, 11, 79, 23);
		panel_1.add(button_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 43, 384, 197);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		modelo = new DefaultTableModel();
		modelo.addColumn("Codigo");
		modelo.addColumn("Categoria");
		modelo.addColumn("Precio");
		modelo.addColumn("Estado");
		table.setModel(modelo);
		
		
		btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSalir.setBounds(637, 353, 92, 23);
		getContentPane().add(btnSalir);
		
		listar();

	}
	ArregloBungalow ao = new ArregloBungalow();
	@Override
	public void actionPerformed(ActionEvent e) {
	    if (e.getSource()== button){
	    	actionPerformedbutton(e);
	    }
	    else if (e.getSource()== button_1){
	    	actionPerformedbutton_1(e);
	    }
	    else if (e.getSource()==comboBox_2){
	    	actionPerformedcomboBox_2(e);
	    }
	    else if (e.getSource()== button_3){
	    	actionPerformedbutton_3(e);
	    }
	    else if (e.getSource()== button_4){
	    	actionPerformedbutton_4(e);
	    }
		
	}
    private void actionPerformedcomboBox_2(ActionEvent e) {
		int opcionCategoria = comboBox_2.getSelectedIndex();
		switch(opcionCategoria) {
		case 0: txtPrecio.setText(100+"");
		break;
		case 1: txtPrecio.setText(200+"");
		break;
		case 2: txtPrecio.setText(500 + "");
		break;
		}
    	
	}

	
	private void actionPerformedbutton_4(ActionEvent e) {
		
		
	}

	private void actionPerformedbutton_3(ActionEvent e) {
	
		
	}

	private void actionPerformedbutton_1(ActionEvent e) {
		
		
	}

	private void actionPerformedbutton(ActionEvent e) {
		int codigo = leerCodigo();
			if (ao.buscar(codigo) == null) {
				int estado = leerEstado();
				double precio = leerPrecio();
				int categoria = leerCategoria();
				Bungalow nuevo = new Bungalow(codigo, categoria, estado,precio );
				ao.adicionar(nuevo);
				ao.grabarBungalow();
				listar();
				limpieza();

				txtbunga.setText(String.valueOf(ao.GenerarCodigo()));
			}
			else
				error("el CÓDIGO ya existe", txtbunga);
	}
	void limpieza() {
		txtbunga.setText("");
		
		txtPrecio.setText("");
		
		txtbunga.requestFocus();
	}	
   	void listar() {
		modelo.setRowCount(0);
		for (int i=0; i<ao.tamaño(); i++) {
			String categoria = ( ao.obtener(i).getCategoria() == 0 ) ? "Simple":
				( ao.obtener(i).getCategoria() == 1 ) ? "Doble": "Familiar";
			String estado = ( ao.obtener(i).getEstado() == 0 ) ? "Libre": "Ocupado";
			Object[] fila = { ao.obtener(i).getCodigo(),
					          categoria,
					          ao.obtener(i).getPrecio(),
					          estado
					          };
					          
			modelo.addRow(fila);
		
		}
	}
	//  Métodos tipo void (con parámetros)
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
	void error(String s, JTextField txt) {
		mensaje(s);
		txt.setText("");
		txt.requestFocus();
	}
	//  Métodos que retornan valor (sin parámetros)
	int leerCodigo() {
		return Integer.parseInt(txtbunga.getText().trim());
	}
	int leerEstado() {
		return comboBox.getSelectedIndex();
	}
	double leerPrecio() {
		return Integer.parseInt(txtPrecio.getText().trim());
	}
	int leerCategoria() {
		return comboBox_2.getSelectedIndex();
	}
	
}
