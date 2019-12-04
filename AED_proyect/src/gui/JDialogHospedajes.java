package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import clases.Hospedaje;
import clases.Socio;
import clases.Bungalow;
import clases.Ingreso;
import librerias.Fecha;
import arreglos.ArregloHospedaje;
import arreglos.ArregloProducto;
import arreglos.ArregloBungalow;
import arreglos.ArregloSocio;
import arreglos.ArregloIngreso;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.Date;
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
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;

public class JDialogHospedajes extends JDialog {
	private JTextField txtCodigo;
	private JTextField txtNom;
	private JTextField txtApe;
	private JTextField txtFecha;
	private JTextField txtCategoria;
	private JTextField txtPrecio;
	private JTextField txtTotaldias;
	private JTextField txtNumero;
	private JTextField txtTotalPagar;
	private JComboBox<String> cboHospedaje;
	private JButton btnPagar;
	private ArregloHospedaje hospe;
	private boolean Pagar = false;
	private JButton btnSalir;
	private ArregloIngreso ai;
	private JTextField txtEstado;

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
		
		cboHospedaje = new JComboBox<String>();
		cboHospedaje.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				itemStateChangedCboHospedaje(e);	
			}
		});
	
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
		
		txtNom = new JTextField();
		txtNom.setBounds(132, 65, 138, 20);
		panel.add(txtNom);
		txtNom.setColumns(10);
		
		txtApe = new JTextField();
		txtApe.setBounds(132, 89, 138, 20);
		panel.add(txtApe);
		txtApe.setColumns(10);
		
		txtFecha = new JTextField();
		txtFecha.setBounds(435, 40, 138, 20);
		panel.add(txtFecha);
		txtFecha.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(407, 15, 46, 14);
		panel.add(lblEstado);
		
		txtEstado = new JTextField();
		txtEstado.setBounds(463, 12, 86, 20);
		panel.add(txtEstado);
		txtEstado.setColumns(10);
		
		btnPagar = new JButton("Pagar");
		btnPagar.setBackground(Color.RED);
		btnPagar.setBounds(370, 247, 89, 23);
		getContentPane().add(btnPagar);
		
		btnSalir = new JButton("Salir");
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
	
	
	protected void itemStateChangedCboHospedaje(ItemEvent e) {
		if(e.getStateChange()==ItemEvent.SELECTED && cboHospedaje.getSelectedIndex()!=0) {
			hospe = new ArregloHospedaje();
			int codigoH = (int) cboHospedaje.getSelectedItem();		
			Hospedaje ho = hospe.buscar(codigoH);
			ai = new ArregloIngreso();
			int codIn = ho.getCodigoIngreso();
			int codbun = ho.getNumeroBungalow();					
			int codSoc = ai.buscar(codIn).getCodigoSocio();
			Bungalow bungalow = new ArregloBungalow().buscar(codbun);
			Socio so=new Socio().buscarPorCod(codSoc);
			txtNom.setText(so.getNombres());
			txtApe.setText(so.getApellidos());
			txtNumero.setText(String.valueOf(codbun));
			txtCategoria.setText(bungalow.getCategoria());
			txtPrecio.setText(String.valueOf(bungalow.getPrecio()));
			txtEstado.setText(ho.getEstadoS());
		    txtFecha.setText(ho.getFechaIngreso()+ " "+ ho.getHoraIngreso());
		    txtCodigo.setText(String.valueOf(codSoc));
		    Date fInicio = Fecha.construirFecha(ho.getFechaIngreso().trim());
		    int dInter = Fecha.calcularDiasHoy(fInicio);
		    txtTotaldias.setText(dInter + " Dias");
		    txtTotalPagar.setText(String.valueOf(dInter*bungalow.getPrecio()));
		    Pagar = true;
			btnPagar.setEnabled(true);
			
		
		}			
		
		
	}


	private void cargarCombo() {
		hospe = new ArregloHospedaje();
		ArrayList<Hospedaje> li = hospe.hospedajesPendientes();
		cboHospedaje.addItem("Seleccione");
		for(Hospedaje ho : li) {
			String item = String.valueOf(ho.getCodigoHospedaje());
			cboHospedaje.addItem(item);
		}
		
		
	}
		private void limpieza(boolean bt) {
			
			cboHospedaje.removeAllItems();
			cboHospedaje.setSelectedIndex(0);
			txtCodigo.setText("");
			txtNom.setText("");
			txtApe.setText("");
			txtFecha.setText("");
			txtNumero.setText("");
			txtCategoria.setText("");
			txtPrecio.setText("");
			txtTotaldias.setText("");
			txtTotalPagar.setText("");
			btnPagar.setEnabled(bt);
		}
		
		
		public void actionPerformed(ActionEvent evt) {
			if(evt.getSource()==btnPagar && Pagar) {
				
				int nbungalow = leerEntero(txtNumero);			
				String coHospe = leerItemCbo(cboHospedaje);
				double tPagar = leerDouble(txtTotalPagar);
				ArregloBungalow bunga = new ArregloBungalow();
				ArregloHospedaje ah = new ArregloHospedaje();			
				bunga.Liberarbungalow(nbungalow, 0);			
				ah.darAltaHospedaje(coHospe, Fecha.fechaSistema(), Fecha.horaSistema(), tPagar);			
				Pagar= false;
				limpieza(false);				
				cargarCombo();			
			}
			if (evt.getSource()==btnSalir) {
				dispose();
			}
			
		}
		
		
		public static int leerEntero(JTextField txt) {
			return Integer.parseInt(txt.getText().trim());
		}
		public static String leerItemCbo(JComboBox<String> cbo) {		
			return cbo.getSelectedItem().toString();		
		}
		public static double leerDouble(JTextField txt) {
			return Double.parseDouble(txt.getText().trim());
		}

		
		
	
	
	
	
}
