package clases;

public class Consumo {
	
	private int codigoProducto;
	private String detalle;
	private double precio;
	private int cantidad;
	
	public Consumo(int codigoProducto, String detalle, double precio, int cantidad) {
		super();
		this.codigoProducto = codigoProducto;
		this.detalle = detalle;
		this.precio = precio;
		this.cantidad = cantidad;
	}

	public int getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
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

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public void aumentarCantidad( int cant ) {
		cantidad += cant;
	}
	
	public void disminuirCantidad( int cant ) {
		cantidad -= cant;
	}
	
	public double importe() {
		return precio * cantidad;
	}
	

}
