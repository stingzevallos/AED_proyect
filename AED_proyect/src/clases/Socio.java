package clases;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.table.DefaultTableModel;

import arreglos.ArregloSocio;
public class Socio {
	private int codSocio;
	private String nombres;
	private String apellidos;	
	private String dni;
	private int telefono;
	private int sexo;
	private static ArrayList<Socio> listaSocios = new ArrayList<Socio>();
	static{
		ArregloSocio pac = new ArregloSocio();
		Socio pc = new Socio();
		
		if(pac.leerArchivo()!=null) {
			for(int i = 0; i<pac.leerArchivo().size();i++) {
				pc=pac.leerArchivo().get(i);
				listaSocios.add(pc);
			}
		}
	}

	public static void main(String[] args) {
		ArregloSocio dp = new ArregloSocio();		
		Socio pc = new Socio();
		
		pc.cargarListaSocios();
		System.out.println(pc.tamanio());
		

	}

	public Socio(int codSocio, String nombres, String apellidos, String dni,int telefono, int sexo) {
		this.codSocio = codSocio;
		this.nombres = nombres;
		this.apellidos = apellidos;		
		this.dni = dni;
		this.telefono = telefono;
		this.sexo = sexo;
		
	}
	public Socio() {
		
	}

	public int getcodSocio() {
		return codSocio;
	}
	public String getNombres() {
		return nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public int getTelefono() {
		return telefono;
	}
	public String getDni() {
		return dni;
	}	
	public int getSexo() {
		return sexo;
	}
	public void setCodPaciente(int codSocio) {
		this.codSocio = codSocio;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public void setSexo(int sexo) {
		this.sexo = sexo;
	}
	
	
	public String getSexoS() {
		if(sexo ==0) return "Masculino";
		else if(sexo ==1) return "Femenino";
		return "";
	}
	/*Metodos de array list*/
	public void cargarListaSocios() {
		ArregloSocio pac = new ArregloSocio();
		Socio pc = new Socio();
		
		if(pac.leerArchivo()!=null) {
			for(int i = 0; i<pac.leerArchivo().size();i++) {
				pc=pac.leerArchivo().get(i);
				listaSocios.add(pc);
			}
		}
		
	}
	
	public int asignaCodigo() {
		if(listaSocios.size()==0) {
			return 20001;
		}
		else {
			int indice = listaSocios.size()-1;
			int num = listaSocios.get(indice).getcodSocio();
			return num+1;
		}
	}
	public void agregarSocio(Socio pa) {
		listaSocios.add(pa);
	}
	
	public int tamanio() {
		return listaSocios.size();
	}
	public Socio buscarPorCod(int cod) {
		for(int i=0;i<tamanio();i++) {
			if(listaSocios.get(i).getcodSocio()==cod) {
				return listaSocios.get(i);
			}
		}
		return null;
	}
	
	public Socio buscarPorDni(String dni) {
		for(int i=0;i<tamanio();i++) {
			if(listaSocios.get(i).getDni().trim().equalsIgnoreCase(dni)) {
				return listaSocios.get(i);
			}
		}
		return null;
	}
	
	public void eliminar(Socio ps) {
		listaSocios.remove(ps);
	}
	
	public void archivarTodo() {
		ArregloSocio pc = new ArregloSocio();
		pc.archivar(listaSocios);
	}
	
	public void modificar(Socio pas, int codPac) {
		int in = listaSocios.indexOf(buscarPorCod(codPac));
		listaSocios.set(in, pas);
	}
	
	public DefaultTableModel mostrar() {
		try {
			DefaultTableModel table =null;
			String titulos[]= {"Codigo","Nombres","Apellidos","DNI","Telefono", "Sexo"};
			String registros[]= new String[6];
			table = new DefaultTableModel(null,titulos);
			Iterator <Socio> socio = listaSocios.iterator();
			
			while(socio.hasNext()) {
				Socio pas =socio.next();
				registros[0]=Integer.toString(pas.codSocio);
				registros[1] = pas.nombres;
				registros[2]= pas.apellidos;				
				registros[3] = pas.dni;
				registros[4] = Integer.toString(pas.telefono);
				registros[5] = pas.getSexoS();
				table.addRow(registros);
			}
			return table;
		}catch(Exception err) {
			return null;
		}
	}
	public DefaultTableModel mostrarBusqueda(int tip, String par) {
		try {
			DefaultTableModel table =null;
			String titulos[]= {"Codigo","Nombres","Apellidos","DNI","Telefono", "Sexo"};
			String registros[]= new String[6];
			table = new DefaultTableModel(null,titulos);
			
			Socio pe = null;
			if(tip ==0) pe = buscarPorCod(Integer.parseInt(par));
			else pe = buscarPorDni(par);
			registros[0]=Integer.toString(pe.codSocio);
			registros[1] = pe.nombres;
			registros[2]= pe.apellidos;				
			registros[3] = pe.dni;
			registros[4] = Integer.toString(pe.telefono);
			registros[5] = pe.getSexoS();
			table.addRow(registros);
			return table;
		}catch(Exception err) {
			return null;
		}
	}
}
