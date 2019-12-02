package arreglos;

import clases.Bungalow;

import java.util.ArrayList;
public class ArregloBungalow {

	private ArrayList<Bungalow> bun;

	public ArregloBungalow() {
		bun = new ArrayList <Bungalow>();
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
	

}
