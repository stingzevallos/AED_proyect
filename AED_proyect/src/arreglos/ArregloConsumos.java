package arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import clases.Consumo;

public class ArregloConsumos {
	
	private int codigoSocio;
	private ArrayList<Consumo> ac;
	
	public ArregloConsumos( int codigoSocio ) {
		this.codigoSocio = codigoSocio;
		ac = new ArrayList<Consumo>();
		cargarConsumos();
	}

	public int getCodigoSocio() {
		return codigoSocio;
	}

	public void setCodigoSocio(int codigoSocio) {
		this.codigoSocio = codigoSocio;
	}
	
	public Consumo obtener( int pos ) {
		return ac.get(pos);
	}
	
	public void agregarProductos( Consumo c ) {
		if ( buscarProductos(c) == null )
			ac.add(c);
		else {
			int cantidad = c.getCantidad();
			buscarProductos(c).aumentarCantidad( cantidad );
		}
	}
	
	public void quitarProductos( Consumo c ) {
		ac.remove(c);
	}
	
	public Consumo buscarProductos( Consumo c ) {
		for ( int i=0; i<productosConsumidos(); i++ )
			if ( obtener(i).getCodigoProducto() == c.getCodigoProducto() )
				return obtener(i);
		return null;
	}
	
	public int productosConsumidos() {
		return ac.size();
	}
	
	public double importeTotal() {
		double total = 0;
		for ( int i=0; i<productosConsumidos(); i++ )
			total += obtener(i).importe();
		return total;
	}
	
	public void grabarConsumos() {
		try {
			PrintWriter pw;
			String linea, codigo;
			
			codigo = codigoSocio+".txt";
			pw = new PrintWriter( new FileWriter(codigo));
			for( int i=0; i<productosConsumidos(); i++ ) {
				linea = obtener(i).getCodigoProducto() + ";" + 
						obtener(i).getDetalle() + ";" + 
						obtener(i).getPrecio() + ";" + 
						obtener(i).getCantidad();
				pw.println(linea);
			}
			pw.close();
		}
		catch( Exception e ) {
			
		}
	}
	
	public void cargarConsumos() {
		try {
			BufferedReader br;
			String linea, codigo, detalle;
			int codigoProducto, cantidad;
			double precio;
			String[] s;
			
			codigo = codigoSocio+".txt";
			br = new BufferedReader( new FileReader(codigo));
			linea = br.readLine();
			while( linea != null ) {
				s = linea.split(";");
				codigoProducto = Integer.parseInt( s[0].trim());
				detalle = s[1].trim();
				precio = Double.parseDouble( s[2].trim());
				cantidad = Integer.parseInt( s[3].trim());
				agregarProductos( new Consumo( codigoProducto, detalle, precio, cantidad));
				linea  = br.readLine();
			}
			br.close();
		}
		catch( Exception e ) {
			
		}
	}

}
