package modelo.persistencia.interfaces;

import java.util.List;

import modelo.entidad.Pasajero;

public interface DaoPasajero {
	
	public boolean altaPasajero(Pasajero p);
	public boolean bajaPasajero(int id);
	public Pasajero consultaPasajero(int id);
	public List<Pasajero> listarPasajeros();
	public boolean addPasajeroACoche(int idPas, int idCoche);
	public boolean borrarPasajeroDeCoche(int idPas, int idCoche);
	public List<Pasajero> listarPasajerosCoche(int idCoche);
	

}
