package clases;

public class Hospedaje {
	private int codigoHospedaje;
	private int codigoIngreso;
	private int numeroBungalow;
	private String fechaIngreso;
	private String horaIngreso;
	private double costoHospedaje;
	private int estado;
	
	public Hospedaje(int codigoHospedaje, int codigoIngreso, int numeroBungalow, String fechaIngreso, String horaIngreso, double costoHospedaje,
			int estado) {
		super();
		this.codigoHospedaje = codigoHospedaje;
		this.codigoIngreso = codigoIngreso;
		this.numeroBungalow = numeroBungalow;
		this.fechaIngreso = fechaIngreso;
		this.horaIngreso = horaIngreso;
		this.costoHospedaje = costoHospedaje;
		this.estado = estado;
	}

	public int getCodigoHospedaje() {
		return codigoHospedaje;
	}

	public void setCodigoHospedaje(int codigoHospedaje) {
		this.codigoHospedaje = codigoHospedaje;
	}

	public int getCodigoIngreso() {
		return codigoIngreso;
	}

	public void setCodigoIngreso(int codigoIngreso) {
		this.codigoIngreso = codigoIngreso;
	}

	public int getNumeroBungalow() {
		return numeroBungalow;
	}

	public void setNumeroBungalow(int numeroBungalow) {
		this.numeroBungalow = numeroBungalow;
	}

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public String getHoraIngreso() {
		return horaIngreso;
	}

	public void setHoraIngreso(String horaIngreso) {
		this.horaIngreso = horaIngreso;
	}

	public double getCostoHospedaje() {
		return costoHospedaje;
	}

	public void setCostoHospedaje(double costoHospedaje) {
		this.costoHospedaje = costoHospedaje;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
	
}
