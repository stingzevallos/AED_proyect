package clases;

public class Bungalow {
 
	private int codigo, categoria,estado;
	private double precio;
	public Bungalow(int codigo, int categoria, int estado, double precio) {
	
		this.codigo = codigo;
		this.categoria = categoria;
		this.estado = estado;
		this.precio = precio;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
}
