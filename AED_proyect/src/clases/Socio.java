package clases;

public class Socio {
	
	private int codigo;
	private String nombre, apellidos, dni;
	private int telefono;
	
	public Socio(int codigo, String nombre, String apellidos, String dni, int telefono) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.telefono = telefono;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}
<<<<<<< HEAD

=======
	public int getTelefono() {
		return telefono;
	}
	public String getDni() {
		return dni;
	}	
	public int getSexo() {
		return sexo;
	}
	public void setCodSocio(int codSocio) {
		this.codSocio = codSocio;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
>>>>>>> branch 'master' of https://github.com/stingzevallos/AED_proyect.git
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
<<<<<<< HEAD

=======
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

	
>>>>>>> branch 'master' of https://github.com/stingzevallos/AED_proyect.git
}
