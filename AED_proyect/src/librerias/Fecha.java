package librerias;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Fecha {
	public static void main(String[] args) {

		System.out.println(fechaSistema());
		System.out.println(horaSistema());
		Date fec = construirFecha("17/05/2019");
		int dias = calcularDiasHoy(fec);
		System.out.println(dias);
	}
	
	public static String fechaSistema() {		
		Date fecha = new Date();
		String formFec = "dd/MM/yyyy";
		SimpleDateFormat fecs = new SimpleDateFormat(formFec);	
		return fecs.format(fecha);		
	}
	
	public static String horaSistema() {
		Date fech = new Date();
		String formHor = "hh:mm:ss";
		SimpleDateFormat hors = new SimpleDateFormat(formHor);
		return hors.format(fech);		
	}
	
	public static Date construirFecha(String sfecha) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date fecha = null;
		try {
			fecha = sdf.parse(sfecha);
		} catch (ParseException e) {			
			//e.printStackTrace();
		}
		return fecha;		
	}
	
	public static Date construirFechaHora(String sfechaHor) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:ii:ss");
		Date fecha = null;
		try {
			fecha = sdf.parse(sfechaHor);
		} catch (ParseException e) {			
			//e.printStackTrace();
		}
		return fecha;		
	}
	
	public static int calcularDiasHoy(Date fIni) {
		long dias;
		Date fSist = new Date();
		dias = ((fSist.getTime()-fIni.getTime())/(24 * 60 * 60 * 1000));
		
		return (int) dias;		
	}

}
