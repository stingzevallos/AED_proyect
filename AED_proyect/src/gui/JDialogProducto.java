package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;

public class JDialogProducto extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodproducto;
	private JTextField txtPrecio;
	private JTextField txtStock;
	private JTextField txtConsultar;
	private JTextField txtNombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			JDialogProducto dialog = new JDialogProducto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JDialogProducto() {
		setTitle("Mantenimiento | Producto");
		setBounds(100, 100, 752, 418);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblProducto = new JLabel("Producto");
			lblProducto.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblProducto.setBounds(10, 23, 78, 19);
			contentPanel.add(lblProducto);
		}
		{
			JLabel lblRegistroDeProducto = new JLabel("Registro de Producto");
			lblRegistroDeProducto.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblRegistroDeProducto.setBounds(10, 53, 240, 25);
			contentPanel.add(lblRegistroDeProducto);
		}
		{
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setForeground(Color.LIGHT_GRAY);
			panel.setBackground(Color.LIGHT_GRAY);
			panel.setBounds(10, 86, 298, 246);
			contentPanel.add(panel);
			{
				JLabel lblCodproducto = new JLabel("Cod.Producto");
				lblCodproducto.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblCodproducto.setBounds(11, 15, 91, 14);
				panel.add(lblCodproducto);
			}
			{
				txtCodproducto = new JTextField();
				txtCodproducto.setEditable(false);
				txtCodproducto.setColumns(10);
				txtCodproducto.setBounds(112, 13, 86, 20);
				panel.add(txtCodproducto);
			}
			{
				JLabel lblDetalle = new JLabel("Nom.Produc");
				lblDetalle.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblDetalle.setBounds(11, 46, 85, 14);
				panel.add(lblDetalle);
			}
			{
				JLabel lblStock = new JLabel("Stock");
				lblStock.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblStock.setBounds(11, 174, 61, 14);
				panel.add(lblStock);
			}
			{
				JLabel lblPrecio = new JLabel("Precio");
				lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblPrecio.setBounds(11, 149, 61, 14);
				panel.add(lblPrecio);
			}
			{
				txtPrecio = new JTextField();
				txtPrecio.setColumns(10);
				txtPrecio.setBounds(112, 147, 178, 20);
				panel.add(txtPrecio);
			}
			{
				txtStock = new JTextField();
				txtStock.setColumns(10);
				txtStock.setBounds(112, 172, 178, 20);
				panel.add(txtStock);
			}
			{
				JButton button = new JButton("Adicionar");
				button.setFont(new Font("Tahoma", Font.BOLD, 11));
				button.setBounds(4, 212, 92, 23);
				panel.add(button);
			}
			{
				JButton button = new JButton("Modificar");
				button.setFont(new Font("Tahoma", Font.BOLD, 11));
				button.setBounds(99, 212, 91, 23);
				panel.add(button);
			}
			{
				JButton button = new JButton("Cancelar");
				button.setFont(new Font("Tahoma", Font.BOLD, 11));
				button.setBounds(198, 212, 92, 23);
				panel.add(button);
			}
			
			JTextArea txtSDetalle = new JTextArea();
			txtSDetalle.setBounds(109, 67, 181, 69);
			panel.add(txtSDetalle);
			{
				JLabel label = new JLabel("Detalle");
				label.setFont(new Font("Tahoma", Font.BOLD, 12));
				label.setBounds(11, 71, 61, 14);
				panel.add(label);
			}
			{
				txtNombre = new JTextField();
				txtNombre.setEditable(false);
				txtNombre.setColumns(10);
				txtNombre.setBounds(112, 44, 121, 20);
				panel.add(txtNombre);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(Color.LIGHT_GRAY);
			panel.setLayout(null);
			panel.setBounds(317, 86, 405, 246);
			contentPanel.add(panel);
			{
				txtConsultar = new JTextField();
				txtConsultar.setColumns(10);
				txtConsultar.setBounds(10, 13, 126, 20);
				panel.add(txtConsultar);
			}
			{
				JButton button = new JButton("Consultar");
				button.setFont(new Font("Tahoma", Font.BOLD, 11));
				button.setBounds(167, 12, 92, 23);
				panel.add(button);
			}
			{
				JButton button = new JButton("Eliminar");
				button.setFont(new Font("Tahoma", Font.BOLD, 11));
				button.setBounds(282, 12, 79, 23);
				panel.add(button);
			}
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 43, 384, 192);
				panel.add(scrollPane);
			}
		}
		{
			JLabel lblListadoDeProductos = new JLabel("Listado de productos");
			lblListadoDeProductos.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblListadoDeProductos.setBounds(317, 53, 240, 25);
			contentPanel.add(lblListadoDeProductos);
		}
		{
			JButton button = new JButton("Salir");
			button.setFont(new Font("Tahoma", Font.BOLD, 11));
			button.setBounds(630, 345, 92, 23);
			contentPanel.add(button);
		}
	}
}
