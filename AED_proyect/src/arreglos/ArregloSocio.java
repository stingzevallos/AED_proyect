package arreglos;
<<<<<<< HEAD
=======

import java.util.ArrayList;

import clases.Producto;
import clases.Socio;

>>>>>>> branch 'master' of https://github.com/stingzevallos/AED_proyect.git
import java.io.*;
import java.util.ArrayList;
import clases.Socio;

public class ArregloSocio {
<<<<<<< HEAD
=======
	public static void main(String[] args) {
		
		ArregloSocio d = new ArregloSocio();
		ArrayList <Socio> al = d.leerArchivo();
		
		System.out.println(al);
		System.out.println(al.size());
		System.out.println(al.get(0).getcodSocio());
		System.out.println(al.get(0).getDni());
		System.out.println(al.get(0).getNombres());
		System.out.println(al.get(0).getApellidos());
		System.out.println(al.get(0).getTelefono());
	}
	
	
>>>>>>> branch 'master' of https://github.com/stingzevallos/AED_proyect.git

	private ArrayList<Socio> pro;

	public ArregloSocio() {
	 pro = new ArrayList<Socio>();
	 cargarSocio();
	}
	
	public void adicionar(Socio socio){
		pro.add(socio);
	}
    public int tamaño() {
		return pro.size();
	}
	public Socio obtener(int i) {
		return pro.get(i);
	}
	
	public int buscarPosicion( int codigo ) {
		for ( int i=0; i<tamaño(); i++ )
			if ( obtener(i).getCodigo() == codigo)
				return i;
		return -1;
	}
	
	public Socio buscar(int codigo) {
		for (int i=0; i<tamaño(); i++)
			if (obtener(i).getCodigo() == codigo)
				return obtener(i);
		return null;
	}
	public void eliminar(Socio x) {
		pro.remove(x);
	}
	public int generarCodigo(){
		return 10001 + tamaño();
	}
	
	
	public void grabarSocio() {
		try {
			PrintWriter pw;
			String linea;
			Socio x;
			pw = new PrintWriter(new FileWriter("socios.txt"));
			for (int i=0; i<tamaño(); i++) {
				x = obtener(i);
				linea = x.getCodigo() + ";" +
					    x.getNombre() + ";" +
						x.getApellidos() + ";" +
						x.getDni() + ";" +
						x.getTelefono();
				pw.println(linea);
			}
			pw.close();
		}
		catch (Exception e) {
		}
	}
	private void cargarSocio() {
		try {
			BufferedReader br;
			String linea,nombre, apellidos, dni;
			String[] s;
			int codigo, telefono;
			br = new BufferedReader(new FileReader("socios.txt"));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codigo = Integer.parseInt(s[0].trim());
				nombre = s[1].trim();
				apellidos = s[2].trim();
				dni = s[3].trim();
				telefono = Integer.parseInt(s[4].trim());
				adicionar(new Socio(codigo, nombre, apellidos, dni, telefono));
			}
			br.close();
		}
		catch (Exception e) {
		}
	}
	
}
