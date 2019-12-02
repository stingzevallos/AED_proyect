package arreglos;

import clases.Bungalow;

import java.io.*;
import java.util.ArrayList;

public class ArregloBungalow {

	private ArrayList<Bungalow> bun;

	public ArregloBungalow() {
		bun = new ArrayList <Bungalow>();
		cargarBungalow();
	}
	
	public void adicionar(Bungalow bung){
		bun.add(bung);
	
	}
    public int tamaño() {
		return bun.size();
	}
	public Bungalow obtener(int i) {
		return bun.get(i);
	}
	public Bungalow buscar(int codigo) {
		for (int i=0; i<tamaño(); i++)
			if (obtener(i).getCodigo() == codigo)
				return obtener(i);
		return null;
	}
	public void eliminar(Bungalow x) {
		bun.remove(x);
	}
	public int GenerarCodigo(){
		return 30001 + tamaño();
	}
	
	public void grabarBungalow() {
		try {
			PrintWriter pw;
			String linea;
			Bungalow x;
			pw = new PrintWriter(new FileWriter("Bungalow.txt"));
			for (int i=0; i<tamaño(); i++) {
				x = obtener(i);
				linea = x.getCodigo() + ";" +
					    x.getCategoria() + ";" +
						x.getEstado() + ";" +
						x.getPrecio();
				pw.println(linea);
			}
			pw.close();
		}
		catch (Exception e) {
		}
	}
	private void cargarBungalow() {
		try {
			BufferedReader br;
			String linea;
			String[] s;
			int codigo, categoria, estado;
			double precio;
			br = new BufferedReader(new FileReader("Bungalow.txt"));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codigo = Integer.parseInt(s[0].trim());
				estado = Integer.parseInt(s[1].trim());
				categoria = Integer.parseInt(s[2].trim());
				precio = Double.parseDouble(s[3].trim());
				adicionar(new Bungalow(codigo, categoria, estado, precio));
			}
			br.close();
		}
		catch (Exception e) {
		}
	}
}
