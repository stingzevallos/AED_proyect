package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Sistema extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuItem mntmIngreso;
	private JMenuItem mntmConsumo;
	private JMenuItem mntmHospedaje;
	private JMenuItem mntmSocio;
	private JMenuItem mntmProducto;
	private JMenuItem mntmBungalow;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sistema frame = new Sistema();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Sistema() {
		setTitle("Sistema");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mnMantenimiento);
		
		mntmSocio = new JMenuItem("Socio");
		mntmSocio.addActionListener(this);
		mnMantenimiento.add(mntmSocio);
		
	    mntmProducto = new JMenuItem("Producto");
	    mntmProducto.addActionListener(this);
		mnMantenimiento.add(mntmProducto);
		
		mntmBungalow = new JMenuItem("Bungalow");
		mntmBungalow.addActionListener(this);
		mnMantenimiento.add(mntmBungalow);
		
		JMenu mnRegistro = new JMenu("Registro");
		menuBar.add(mnRegistro);
		
		mntmIngreso = new JMenuItem("Ingreso");
		mntmIngreso.addActionListener(this);
		mnRegistro.add(mntmIngreso);
		
		
		mntmConsumo = new JMenuItem("Consumo");
		mntmConsumo.addActionListener(this);
		mnRegistro.add(mntmConsumo);
		
		mntmHospedaje = new JMenuItem("Hospedaje");
		mntmHospedaje.addActionListener(this);
		mnRegistro.add(mntmHospedaje);
		
		
		JMenu mnPago = new JMenu("Pago");
		menuBar.add(mnPago);
		
		JMenu mnReporte = new JMenu("Reporte");
		menuBar.add(mnReporte);
		
		JMenu mnBoleta = new JMenu("Boleta");
		menuBar.add(mnBoleta);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ( e.getSource() == mntmIngreso )
			actionPerformedMntmIngreso(e);
		else if ( e.getSource() == mntmConsumo )
			actionPerformedMntmConsumo(e);
		else if ( e.getSource() == mntmHospedaje )
			actionPerformedMntmHospedaje(e);
		else if ( e.getSource() == mntmSocio )
			actionPerformedMntmSocio(e);
		else if ( e.getSource() == mntmProducto )
			actionPerformedMntmSocio(e);
		else if ( e.getSource() == mntmBungalow )
			actionPerformedMntmSocio(e);
		
	}

	private void actionPerformedMntmSocio(ActionEvent e) {
		JDialogSocio viewIngreso = new JDialogSocio();
		viewIngreso.setVisible(true);
	}

	private void actionPerformedMntmIngreso(ActionEvent e) {
		JDialogIngreso viewIngreso = new JDialogIngreso();
		viewIngreso.setVisible(true);
	}
	
	private void actionPerformedMntmConsumo(ActionEvent e) {
		JDialogConsumo viewConsumo = new JDialogConsumo();
		viewConsumo.setVisible(true);
	}

	private void actionPerformedMntmHospedaje(ActionEvent e) {
		JDialogHospedaje viewHospedaje = new JDialogHospedaje();
		viewHospedaje.setVisible(true);
	}
	
}
