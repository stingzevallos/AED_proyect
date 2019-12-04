package arreglos;
import java.io.*;
import java.util.ArrayList;


import clases.Producto;

public class ArregloProducto {
	
	private ArrayList<Producto> pro;

	public ArregloProducto() {
	 pro = new ArrayList <Producto>();
	 cargarProducto();
	}
	
	public void adicionar(Producto produc){
	pro.add(produc);
	}
    public int tamaño() {
		return pro.size();
	}
	public Producto obtener(int i) {
		return pro.get(i);
	}
	
	public int buscarPosicion( int codigo ) {
		for ( int i=0; i<tamaño(); i++ )
			if ( obtener(i).getCodigo() == codigo)
				return i;
		return -1;
	}
	
	public Producto buscar(int codigo) {
		for (int i=0; i<tamaño(); i++)
			if (obtener(i).getCodigo() == codigo)
				return obtener(i);
		return null;
	}
	public void eliminar(Producto x) {
		pro.remove(x);
	}
	public int GenerarCodigo(){
		return 20001 + tamaño();
	}
	
	
	public void grabarProducto() {
		try {
			PrintWriter pw;
			String linea;
			Producto x;
			pw = new PrintWriter(new FileWriter("Producto.txt"));
			for (int i=0; i<tamaño(); i++) {
				x = obtener(i);
				linea = x.getCodigo() + ";" +
					    x.getDetalle() + ";" +
						x.getPrecio() + ";" +
						x.getStok();
				pw.println(linea);
			}
			pw.close();
		}
		catch (Exception e) {
		}
	}
	private void cargarProducto() {
		try {
			BufferedReader br;
			String linea,detalle;
			String[] s;
			int codigo, stok;
			double precio;
			br = new BufferedReader(new FileReader("Producto.txt"));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codigo = Integer.parseInt(s[0].trim());
				detalle = s[1].trim();
				precio = Double.parseDouble(s[2].trim());
				stok = Integer.parseInt(s[3].trim());
				adicionar(new Producto(codigo, stok, detalle, precio));
			}
			br.close();
		}
		catch (Exception e) {
		}
	}
	
}
