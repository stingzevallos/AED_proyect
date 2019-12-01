package arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import clases.Ingreso;

public class ArregloIngreso {
	
	ArrayList<Ingreso> ai;
	
	public ArregloIngreso() {
		ai = new ArrayList<Ingreso>();
		cargarIngresos();
	}
	
	public int tamaño() {
		return ai.size();
	}
	
	public void adicionar( Ingreso e ) {
		ai.add(e);
		e.setEstado(0);
	}
	
	public Ingreso obtener( int pos ) {
		return ai.get(pos);
	}
	
	public Ingreso buscar( int codigo ) {
		for ( int i=0; i<tamaño(); i++ )
			if ( obtener(i).getCodigoIngreso() == codigo)
				return obtener(i);
		return null;
	}
	
	public void eliminar( Ingreso e ) {
		ai.remove(e);
	}
	
	public void grabarIngresos() {
		try {
			PrintWriter pw;
			String linea;
			
			pw = new PrintWriter( new FileWriter("ingreso.txt"));
			for( int i=0; i<tamaño(); i++ ) {
				linea = obtener(i).getCodigoIngreso() + ";" + 
						obtener(i).getCodigoSocio() + ";" + 
						obtener(i).getFechaIngreso() + ";" + 
						obtener(i).getHoraIngreso() + ";" + 
						obtener(i).getNumeroInvitados() + ";" +
						obtener(i).getCostoIngreso() + ";" + 
						obtener(i).getEstado();
				pw.println(linea);
			}
			pw.close();
		}
		catch( Exception e ) {
			
		}
	}
	
	public void cargarIngresos() {
		try {
			BufferedReader br;
			String linea, fechaIngreso, horaIngreso;
			int codigoIngreso, codigoSocio, numeroInvitados, estado;
			double costoIngreso;
			String[] s;
			
			br = new BufferedReader( new FileReader("ingreso.txt"));
			linea = br.readLine();
			while( linea != null ) {
				s = linea.split(";");
				codigoIngreso = Integer.parseInt( s[0].trim());
				codigoSocio = Integer.parseInt( s[1].trim());
				fechaIngreso = s[2].trim();
				horaIngreso = s[3].trim();
				numeroInvitados = Integer.parseInt( s[4].trim());
				costoIngreso = Double.parseDouble( s[5]);
				estado = Integer.parseInt( s[6]);
				adicionar( new Ingreso( codigoIngreso, codigoSocio, fechaIngreso, horaIngreso, 
						numeroInvitados, costoIngreso, estado));
				linea  = br.readLine();
			}
			br.close();
		}
		catch( Exception e ) {
			
		}
	}
	
	public int generarCodigo() {
		return 40001 + tamaño();
	}
	
	
	

}
