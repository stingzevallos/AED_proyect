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
	private JMenuItem mntmIngresosYConsumos;
	private JMenuItem mntmHospedajes;
	private JMenuItem mntmIngresosYConsumos_1;
	private JMenuItem mntmIngresosYConsumos_2;
	private JMenuItem mntmHospedajesPendientes;
	private JMenuItem mntmHospedajesPagados;

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
		setBounds(100, 100, 548, 311);
		
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
		
		mntmIngresosYConsumos = new JMenuItem("Ingresos y consumos");
		mntmIngresosYConsumos.addActionListener(this);
		mnPago.add(mntmIngresosYConsumos);
		
		mntmHospedajes = new JMenuItem("Hospedajes");
		mntmHospedajes.addActionListener(this);
		mnPago.add(mntmHospedajes);
		
		JMenu mnReporte = new JMenu("Reporte");
		menuBar.add(mnReporte);
		
		mntmIngresosYConsumos_1 = new JMenuItem("Ingresos y consumos pendientes");
		mntmIngresosYConsumos_1.addActionListener(this);
		mnReporte.add(mntmIngresosYConsumos_1);
		
		mntmIngresosYConsumos_2 = new JMenuItem("Ingresos y consumos pagados");
		mntmIngresosYConsumos_2.addActionListener(this);
		mnReporte.add(mntmIngresosYConsumos_2);
		
		mntmHospedajesPendientes = new JMenuItem("Hospedajes pendientes");
		mntmHospedajesPendientes.addActionListener(this);
		mnReporte.add(mntmHospedajesPendientes);
		
		mntmHospedajesPagados = new JMenuItem("Hospedajes pagados");
		mntmHospedajesPagados.addActionListener(this);
		mnReporte.add(mntmHospedajesPagados);
		
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
			actionPerformedMntmProducto(e);
		else if ( e.getSource() == mntmBungalow )
			actionPerformedMntmBungalow(e);
		else if ( e.getSource() == mntmIngresosYConsumos )
			actionPerformedMntmIngresosYConsumos(e);
		else if ( e.getSource() == mntmHospedajes )
			actionPerformedmntmHospedajes(e);
		else if ( e.getSource() == mntmIngresosYConsumos_1 )
			actionPerformedmntmIngresosYConsumos_1(e);
		else if ( e.getSource() == mntmIngresosYConsumos_2 )
			actionPerformedmntmIngresosYConsumos_2(e);
		else if ( e.getSource() == mntmHospedajesPendientes )
			actionPerformedmntmHospedajesPendientes(e);
		else if ( e.getSource() == mntmHospedajesPagados )
			actionPerformedmntmHospedajesPagados(e);
		
	}

	private void actionPerformedmntmHospedajesPagados(ActionEvent e) {
		DlgHospedajesPagados dlgHPa = new DlgHospedajesPagados();
		dlgHPa.setVisible(true);
	}

	private void actionPerformedmntmHospedajesPendientes(ActionEvent e) {
		DlgHospedajesPendientes dlgHP = new DlgHospedajesPendientes();
		dlgHP.setVisible(true);
	}

	private void actionPerformedmntmIngresosYConsumos_2(ActionEvent e) {
		DlgIngresosyConsumosPagados dlgICPa = new DlgIngresosyConsumosPagados();
		dlgICPa.setVisible(true);
	}

	private void actionPerformedmntmIngresosYConsumos_1(ActionEvent e) {
		DlgIngresosyConsumosPendientes dlgICPe = new DlgIngresosyConsumosPendientes();
		dlgICPe.setVisible(true);
	}

	private void actionPerformedmntmHospedajes(ActionEvent e) {
		JDialogHospedajes viewHospedajes = new JDialogHospedajes();
		viewHospedajes.setVisible(true);
	}

	private void actionPerformedMntmIngresosYConsumos(ActionEvent e) {
		JDialogIngresosyconsumos viewIngresos = new JDialogIngresosyconsumos();
		viewIngresos.setVisible(true);
	}

	private void actionPerformedMntmBungalow(ActionEvent e) {
		JDialogBungalow viewBungalow = new JDialogBungalow();
		viewBungalow.setVisible(true);
	}

	private void actionPerformedMntmProducto(ActionEvent e) {
		JDialogProducto viewProducto = new JDialogProducto();
		viewProducto.setVisible(true);
	}

	private void actionPerformedMntmSocio(ActionEvent e) {
		JDialogSocio viewProducto = new JDialogSocio();
		viewProducto.setVisible(true);
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
