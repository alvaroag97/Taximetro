package Models;

import java.util.ArrayList;
import java.util.Date;

public class controlador {

	private static ArrayList<Pasajero> ListaPasajero = new ArrayList<Pasajero>();
	public static int indice = 0;

	public static void AnadirEmpleado( String Dinero , Date Fecha){
			ListaPasajero.add(new Pasajero(Dinero , Fecha));
}
	

	
	public static Pasajero ObtenerPasajero(int indice){
		if(ListaPasajero.isEmpty()) throw new RuntimeException("No hay ningún empleado añadido");
		if(indice < 0 || indice >= ListaPasajero.size()) throw new RuntimeException("Te sales del indice de pasajeros");
		return ListaPasajero.get(indice);
	}
	
	public static ArrayList<Pasajero> ObtenerLista(){
		return ListaPasajero;
	}
	
	
	
	public static Pasajero nextEmpleado(){
		if(indice+1 >= ListaPasajero.size())
		indice++;
		return ObtenerPasajero(indice);
	}
	
	public static Pasajero lastEmpleado(){
		if(indice-1 < 0)
		indice--;
		return ObtenerPasajero(indice);
	}
	
}
