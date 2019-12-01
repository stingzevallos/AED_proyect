package arreglos;
import java.util.ArrayList;

import clases.Producto;

public class ArregloProducto {
	
	private ArrayList<Producto> pro;

	public ArregloProducto() {
	 pro = new ArrayList <Producto>();
	}
	
	public void adicionar(Producto produc){
	pro.add(produc);
	
	}
    public int tama�o() {
		return pro.size();
	}
	public Producto obtener(int i) {
		return pro.get(i);
	}
	public Producto buscar(int codigo) {
		for (int i=0; i<tama�o(); i++)
			if (obtener(i).getCodigo() == codigo)
				return obtener(i);
		return null;
	}
	public void eliminar(Producto x) {
		pro.remove(x);
	}
	
	
}
