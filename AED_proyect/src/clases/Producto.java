package clases;

public class Producto {
	
	private int codigo, stok;
	private String detalle;
	private double precio;
	public Producto(int codigo, int stok, String detalle, double precio) {
		this.codigo = codigo;
		this.stok = stok;
		this.detalle = detalle;
		this.precio = precio;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getStok() {
		return stok;
	}
	public void setStok(int stok) {
		this.stok = stok;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}


}
