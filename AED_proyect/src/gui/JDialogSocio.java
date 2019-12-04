package gui;

import librerias.Lectura;
import librerias.Validacion;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import clases.Producto;
import clases.Socio;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTable;

public class JDialogSocio extends JDialog implements ActionListener, KeyListener{
	Socio pa = new Socio();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblPacientes;
	private JLabel lblAltaPaciente;
	private JLabel lblListadoPacientes;
	private JPanel panel;
	private JComboBox<String> cboSexo;
	private JLabel lblSexo;
	private JLabel lblTelefono;
	private JTextField txtTelefono;
	private JLabel lblApellidos;
	private JLabel lblNombres;
	private JTextField txtCodSocio;
	private JLabel lblCodPaciente;
	private JButton btnNuevo;
	private JButton btnGuardar;
	private JButton btnCancelar;
	private JButton btnSalir;
	private JPanel panel_1;
	private JComboBox<String> cboBuscar;
	private JTextField txtBuscar;
	private JButton btnEliminar;
	private JScrollPane scrollPane;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JLabel lblDni;
	private JTextField txtDni;
	private JTable tableListado;
	private JButton btnBuscar;
	private DefaultTableModel modelo;
	


	public JDialogSocio() {
		setTitle("Mantenimiento | Socio");
		addWindowListener( new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            	Socio ps = new Socio();
            	ps.archivarTodo();
            }
        });
		setLocationRelativeTo(getParent());
		setResizable(false);
		setBounds(100, 100, 772, 389);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblPacientes = new JLabel("Socios");
		lblPacientes.setForeground(Color.BLUE);
		lblPacientes.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblPacientes.setBounds(10, 0, 98, 23);
		contentPane.add(lblPacientes);
		
		lblAltaPaciente = new JLabel("Alta y Modificaci\u00F3n Socios");
		lblAltaPaciente.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblAltaPaciente.setBounds(10, 34, 174, 14);
		contentPane.add(lblAltaPaciente);
		
		lblListadoPacientes = new JLabel("Listado y busqueda socios");
		lblListadoPacientes.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblListadoPacientes.setBounds(362, 34, 217, 14);
		contentPane.add(lblListadoPacientes);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(new Color(204, 255, 204));
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(10, 55, 329, 252);
		contentPane.add(panel);
		
		cboSexo = new JComboBox<String>();
		cboSexo.setModel(new DefaultComboBoxModel<String>(new String[] {"Masculino", "Femenino"}));
		cboSexo.setEnabled(false);
		cboSexo.setEditable(false);
		cboSexo.setBounds(158, 179, 151, 20);
		panel.add(cboSexo);
		
		lblSexo = new JLabel("Sexo");
		lblSexo.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblSexo.setEnabled(true);
		lblSexo.setBounds(10, 179, 82, 14);
		panel.add(lblSexo);
		
		lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblTelefono.setEnabled(true);
		lblTelefono.setBounds(10, 148, 82, 14);
		panel.add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setEnabled(false);
		txtTelefono.addKeyListener(this);
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(158, 148, 151, 20);
		panel.add(txtTelefono);
		
		lblApellidos = new JLabel("Apellidos");
		lblApellidos.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblApellidos.setEnabled(true);
		lblApellidos.setBounds(10, 77, 82, 14);
		panel.add(lblApellidos);
		
		lblNombres = new JLabel("Nombres");
		lblNombres.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblNombres.setEnabled(true);
		lblNombres.setBounds(10, 45, 82, 14);
		panel.add(lblNombres);
		
		txtCodSocio = new JTextField();
		txtCodSocio.setEditable(false);
		txtCodSocio.setEnabled(true);
		txtCodSocio.setColumns(10);
		txtCodSocio.setBounds(158, 14, 86, 20);
		panel.add(txtCodSocio);
		
		lblCodPaciente = new JLabel("Cod. socio");
		lblCodPaciente.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblCodPaciente.setEnabled(true);
		lblCodPaciente.setBounds(10, 14, 82, 14);
		panel.add(lblCodPaciente);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.setForeground(Color.WHITE);
		btnNuevo.setBackground(Color.DARK_GRAY);
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(10, 217, 86, 23);
		panel.add(btnNuevo);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setForeground(Color.WHITE);
		btnGuardar.setBackground(Color.DARK_GRAY);
		btnGuardar.setEnabled(false);
		btnGuardar.addActionListener(this);
		btnGuardar.setBounds(98, 217, 114, 23);
		panel.add(btnGuardar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.addActionListener(this);
		btnCancelar.setBackground(Color.DARK_GRAY);
		btnCancelar.setBounds(214, 217, 105, 23);
		panel.add(btnCancelar);
		
		txtNombres = new JTextField();
		txtNombres.setBounds(158, 43, 151, 20);
		txtNombres.setEnabled(false);
		panel.add(txtNombres);
		txtNombres.setColumns(10);
		
		txtApellidos = new JTextField();
		txtApellidos.setBounds(158, 75, 151, 20);
		txtApellidos.setEnabled(false);
		panel.add(txtApellidos);
		txtApellidos.setColumns(10);
		
		lblDni = new JLabel("N\u00BA DNI");
		lblDni.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblDni.setEnabled(true);
		lblDni.setBounds(10, 112, 82, 14);
		panel.add(lblDni);
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(158, 106, 151, 20);
		txtDni.setEnabled(false);
		txtDni.addKeyListener(this);
		panel.add(txtDni);
		
		btnSalir = new JButton("Salir");
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setBackground(Color.DARK_GRAY);
		btnSalir.addActionListener(this);
		btnSalir.setBounds(628, 318, 105, 23);
		contentPane.add(btnSalir);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(360, 55, 406, 252);
		contentPane.add(panel_1);
		
		cboBuscar = new JComboBox<String>();
		cboBuscar.setModel(new DefaultComboBoxModel<String>(new String[] {"Codigo", "DNI"}));
		cboBuscar.setBounds(10, 11, 79, 20);
		panel_1.add(cboBuscar);
		
		txtBuscar = new JTextField();
		txtBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				mouseClickedTxtBuscar(arg0);
			}
		});
		txtBuscar.setColumns(10);
		txtBuscar.addKeyListener(this);
		txtBuscar.setBounds(96, 11, 127, 20);
		panel_1.add(txtBuscar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setEnabled(false);
		btnEliminar.addActionListener(this);
		btnEliminar.setBackground(Color.DARK_GRAY);
		btnEliminar.setBounds(312, 10, 79, 23);
		panel_1.add(btnEliminar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 45, 386, 196);
		panel_1.add(scrollPane);
		
		tableListado = new JTable();
		tableListado.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent ev) {
				mouseClickedTableListado(ev);
			}
		});
		actualizarTabla();
		scrollPane.setViewportView(tableListado);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setForeground(Color.LIGHT_GRAY);
		btnBuscar.setBackground(Color.DARK_GRAY);
		btnBuscar.setBounds(226, 10, 79, 23);
		btnBuscar.addActionListener(this);
		panel_1.add(btnBuscar);
	}

	private void inicialize() {
		txtCodSocio.setText("");
		txtNombres.setText("");
		txtApellidos.setText("");
		txtDni.setText("");
		txtTelefono.setText("");
	}
	private void habilitar(boolean val) {
		txtNombres.setEnabled(val);
		txtApellidos.setEnabled(val);
		txtDni.setEnabled(val);
		txtTelefono.setEnabled(val);		
		btnNuevo.setEnabled(!val);
		btnGuardar.setEnabled(val);		
		cboSexo.setEnabled(val);
		btnEliminar.setEnabled(val);
	}
	
	private void actualizarTabla() {
		modelo = new Socio().mostrar();
		if(modelo!=null) {
			tableListado.setModel(modelo);
		}
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		
		/*para accder a todos los Socios----metodo arraylist*/
		Socio pa = new Socio();
		
		if(ev.getSource()==btnGuardar) {
			int codSocio = Lectura.leerEntero(txtCodSocio);
			String nombre = Lectura.leerCadena(txtNombres);
			String apellidos = Lectura.leerCadena(txtApellidos);
			String dni = Lectura.leerCadena(txtDni);
			int telefono = Lectura.leerEntero(txtTelefono);
			int sexo = Lectura.leerCbo(cboSexo);
			if(ev.getActionCommand()=="Guardar") {				
					if(!nombre.isEmpty() || !apellidos.isEmpty() || !dni.isEmpty()) {
						pa.agregarSocio(new Socio(codSocio,nombre,apellidos,dni, telefono,sexo));
						inicialize();
						habilitar(false);
						actualizarTabla();
						Validacion.mensajeInformacion(this, "Socio ingresado correctamente");
					}
					else {
						Validacion.mensajeError(this, "Debe ingresar todo los campos solicitados");
					}
			}
			else if(ev.getActionCommand()=="Actualizar") {
				if(!nombre.isEmpty() || !apellidos.isEmpty() || !dni.isEmpty()) {
					pa.modificar(new Socio(codSocio,nombre,apellidos,dni, telefono,sexo), codSocio);
					inicialize();
					habilitar(false);
					actualizarTabla();
					Validacion.mensajeInformacion(this, "Datos del socio con codigo"+"\n "+codSocio + " fueron actualizados.");
				}
				else {
					Validacion.mensajeError(this, "Ingresa todo los campos solicitados");
				}
			}

		}
		else if(ev.getSource()==btnCancelar) {
			habilitar(false);
			inicialize();
		}
		else if(ev.getSource()==btnEliminar) {			
			int codPac = Lectura.leerEntero(txtCodSocio);			
			int rpta = Validacion.mensajeConfirmacion(this, "Estas seguro de eliminar el Registro:" + "\n" 
					    +"Codigo     :"+ Lectura.leerCadena(txtCodSocio) + "\n"
						+"Nombres :"+ Lectura.leerCadena(txtNombres) + " " + Lectura.leerCadena(txtApellidos)+ "\n"
						+"DNI            :"+ Lectura.leerCadena(txtDni));
			if(rpta ==0) {
				pa.eliminar(pa.buscarPorCod(codPac));
				inicialize();
				actualizarTabla();
				habilitar(false);
			}		
			
		}
		else if(ev.getSource()==btnNuevo) {
			habilitar(true);
			actualizarTabla();
			btnGuardar.setText("Guardar");
			btnEliminar.setEnabled(false);
			txtCodSocio.setText(String.valueOf(pa.asignaCodigo()));
		}
		else if(ev.getSource()==btnSalir) {
			pa.archivarTodo();
			dispose();
		}
		
		else if(ev.getSource()==btnBuscar) {
			String param = txtBuscar.getText();
			int opt = cboBuscar.getSelectedIndex();
			if(!param.isEmpty()) {
				modelo = pa.mostrarBusqueda(opt, param);
				tableListado.setModel(modelo);
			}
			else {
				Validacion.mensajeError(this, "Llene el campo de busqueda");
			}
		}
		
		else if(ev.getSource()==txtBuscar) {
			System.out.println("Evento en el cuadro");
		}
	}
	
	
	private void mouseClickedTableListado(MouseEvent ev) {
		int row = tableListado.getSelectedRow();		
		txtCodSocio.setText((String) modelo.getValueAt(row, 0));
		txtNombres.setText((String) modelo.getValueAt(row, 1));
		txtApellidos.setText((String) modelo.getValueAt(row, 2));
		txtDni.setText((String) modelo.getValueAt(row, 3));
		txtTelefono.setText((String) modelo.getValueAt(row, 4));
		String indSexo = (String) modelo.getValueAt(row, 5);
		if(indSexo.equals("Femenino")) cboSexo.setSelectedIndex(1);
		else cboSexo.setSelectedIndex(0);		
		habilitar(true);
		btnGuardar.setText("Actualizar");	
		
	}
	


	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==txtBuscar) {
			actualizarTabla();
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==txtDni) Validacion.soloNumeros(arg0,txtDni, 8);
		else if(arg0.getSource()==txtTelefono) Validacion.soloNumeros(arg0,txtTelefono, 9);
		else if(arg0.getSource()==txtBuscar) Validacion.soloNumeros(arg0, txtBuscar, 8);
		
	}

	
	protected void mouseClickedTxtBuscar(MouseEvent arg0) {
		
		
	}
}
