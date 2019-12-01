package arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import clases.Hospedaje;

public class ArregloHospedaje {
	
	ArrayList<Hospedaje> ah;
	
	public ArregloHospedaje() {
		ah = new ArrayList<Hospedaje>();
		cargarHospedajes();
	}
	
	public int tama�o() {
		return ah.size();
	}
	
	public void adicionar( Hospedaje e ) {
		ah.add(e);
		e.setEstado(0);
	}
	
	public Hospedaje obtener( int pos ) {
		return ah.get(pos);
	}
	
	public Hospedaje buscar( int codigo ) {
		for ( int i=0; i<tama�o(); i++ )
			if ( obtener(i).getCodigoIngreso() == codigo)
				return obtener(i);
		return null;
	}
	
	public void eliminar( Hospedaje e ) {
		ah.remove(e);
	}
	
	public void grabarHospedajes() {
		try {
			PrintWriter pw;
			String linea;
			
			pw = new PrintWriter( new FileWriter("ingreso.txt"));
			for( int i=0; i<tama�o(); i++ ) {
				linea = obtener(i).getCodigoHospedaje() + ";" + 
						obtener(i).getCodigoIngreso() + ";" + 
						obtener(i).getNumeroBungalow() + ";" +
						obtener(i).getFechaSalida() + ";" + 
						obtener(i).getHoraSalida() + ";" + 
						obtener(i).getCostoHospedaje() + ";" + 
						obtener(i).getEstado();
				pw.println(linea);
			}
			pw.close();
		}
		catch( Exception e ) {
			
		}
	}
	
	public void cargarHospedajes() {
		try {
			BufferedReader br;
			String linea, fechaSalida, horaSalida;
			int codigoIngreso, codigoHospedaje, numeroBungalow, estado;
			double costoHospedaje;
			String[] s;
			
			br = new BufferedReader( new FileReader("ingreso.txt"));
			linea = br.readLine();
			while( linea != null ) {
				s = linea.split(";");
				codigoHospedaje = Integer.parseInt( s[0].trim());
				codigoIngreso = Integer.parseInt( s[1].trim());
				numeroBungalow = Integer.parseInt( s[2].trim());
				fechaSalida = s[3].trim();
				horaSalida = s[4].trim();
				costoHospedaje = Double.parseDouble( s[5]);
				estado = Integer.parseInt( s[6]);
				adicionar( new Hospedaje( codigoHospedaje, codigoIngreso, numeroBungalow, fechaSalida, 
						horaSalida, costoHospedaje, estado));
				linea  = br.readLine();
			}
			br.close();
		}
		catch( Exception e ) {
			
		}
	}
	
	public int generarCodigo() {
		return 50001 + tama�o();
	}

}
