package Models;

import java.util.Date;

public class Pasajero {

	private String Dinero;
	private Date Fecha;
	public Pasajero(String dinero, Date fecha) {
		super();
		setDinero(dinero);
		setFecha(fecha);
	}
	public String getDinero() {
		return Dinero;
	}
	public void setDinero(String dinero) {
		Dinero = dinero;
	}
	public Date getFecha() {
		return Fecha;
	}
	public void setFecha(Date fecha) {
		Fecha = fecha;
	}

	
	

}
