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
	
	public int getTelefono() {
		return telefono;
	}
	public String getDni() {
		return dni;
	}	
	}
	public void setCodSocio(int codSocio) {
		this.codSocio = codSocio;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	
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