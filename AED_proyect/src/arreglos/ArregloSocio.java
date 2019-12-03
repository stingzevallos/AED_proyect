package arreglos;

import java.util.ArrayList;
import clases.Socio;

public class ArregloSocio {
	
	private ArrayList<Socio> soc;

	public ArregloSocio() {
	 soc = new ArrayList <Socio>();
	}
	
	public void adicionar(Socio soci){
		soc.add(soci);
		
		}
	public int tamaño() {
			return soc.size();
		}
   public Socio obtener(int i) {
			return soc.get(i);
		}
   
   public int GenerarCodigo(){
		if (tamaño() == 0)
			return 1001;
		else
			return obtener(tamaño()-1).getCodigoSocio() + 1;	
	}
   
	public Socio buscar(int codigo) {
		for (int i=0; i<tamaño(); i++)
			if (obtener(i).getCodigoSocio() == codigo)
				return obtener(i);
		return null;
	}
	
	public Socio buscar(String dni) {
		Socio x;
		for (int i=0; i<tamaño(); i++) {
			x = obtener(i);
			if (x.getDni().equals(dni))
				return x;
		}
		return null;
	}
	
	public void eliminar(Socio x) {
		soc.remove(x);
	}

}
