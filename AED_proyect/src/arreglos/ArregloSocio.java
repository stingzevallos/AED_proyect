package arreglos;

import java.util.ArrayList;

import clases.Producto;
import clases.Socio;

import java.io.*;

import clases.Socio;

public class ArregloSocio {
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
	
	

	/*Metodo que guarda en el fichero, agrega en la ultima linea*/	
	public boolean escribirFichero(Socio pac) {
		BufferedWriter fichero = null;
		String linea;
		try {
			fichero = new BufferedWriter(new FileWriter("Socios.txt", true));
			linea = pac.getcodSocio() + ";" 				
				+ pac.getNombres() + ";"
				+ pac.getApellidos() + ";"
				+ pac.getDni() + ";" 
				+ pac.getTelefono() + ";"
				+ pac.getSexo();
			fichero.write(linea);
			fichero.close();
			return true;
		}catch(Exception err) {
			return false;
		}		
	}
	
	public void archivar (ArrayList<Socio> list) {
		BufferedWriter fichero = null;
		String linea;
		try {
			fichero = new BufferedWriter (new FileWriter("Socios.txt",false));
			for(Socio pas: list) {
				linea  = pas.getcodSocio() + ";" 
						+ pas.getNombres() + ";"
						+ pas.getApellidos() + ";"
						+ pas.getDni() + ";"
						+ pas.getTelefono() + ";"
						+ pas.getSexo();
				fichero.write(linea);
				fichero.newLine();
			}
			fichero.close();
			
		}catch(Exception err) {
			
		}
	}
	
	public boolean eliminarArchivo() {
		
		File archivo = new File("socios.txt");
		if(archivo.exists()) {
			archivo.delete();
			return true;
		}
	   return false;  
	}
	/*Metodo que lee el fichero*/

	public ArrayList <Socio> leerArchivo(){
		try {
			BufferedReader br = new BufferedReader(new FileReader("socios.txt"));
			String linea;
			String cadena[]=null;
			ArrayList <Socio> listPacientes = new ArrayList <Socio>();
			
			while((linea=br.readLine()) !=null) {
				cadena=linea.split(";");
				int codPa = Integer.parseInt(cadena[0]);				
				String nom = cadena[1];
				String ape = cadena[2];
				String dni = cadena[3];
				int tel = Integer.parseInt(cadena[4]);	
				int sex = Integer.parseInt(cadena[5]);
				listPacientes.add(new Socio(codPa,nom,ape,dni,tel,sex));				
			}
			br.close();
			return listPacientes;
			
		}catch(Exception err) {
			return null;
		}	
		
	}

}


