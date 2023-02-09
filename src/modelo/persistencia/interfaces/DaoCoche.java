package modelo.persistencia.interfaces;

import java.util.List;

import modelo.entidad.Coche;

public interface DaoCoche {
	
	/**
	 * Método que da de alta un coche en la BBDD. Se generará el ID de manera
	 * automática.
	 * @param c el coche a dar de alta
	 * @return true en caso de que se haya dado de alta. false en caso de error
	 * con la BBDD.
	 */
	public boolean altaCoche(Coche c);
	/**
	 * Método que da de baja un coche en la BBDD. 
	 * @param id del coche a dar de baja.
	 * @return true en caso de que se haya dado de alta. false en caso de error
	 * con la BBDD.
	 */
	public boolean bajaCoche(int id);
	/**
	 * Método que modifica un coche en la BBDD. La modificación será a partir
	 * del ID que contenga el coche.
	 * @param c el coche a modificar
	 * @return true en caso de que se haya modificado. False en caso de error
	 * con la BBDD.
	 */
	public boolean modificarCoche(Coche c);
	/**
	 * Método para consultar un coche en la BBDD. 
	 * @param id del coche a consultar.
	 * @return el coche consultado o mensaje de error en caso de error
	 * con la BBDD.
	 */
	public Coche consultaCoche(int id);
	/**
	 * Método para listar todos los coches de la BBDD. 
	 * @return la lista de coches de la BBDD o mensaje de error en caso de error
	 * con la BBDD.
	 */
	public List<Coche> listarCoches();	

}

