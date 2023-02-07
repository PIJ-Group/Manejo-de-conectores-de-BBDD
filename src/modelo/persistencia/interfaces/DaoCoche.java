package modelo.persistencia.interfaces;

import java.util.List;

import modelo.entidad.Coche;

public interface DaoCoche {
	public boolean altaCoche(Coche c);
	public boolean bajaCoche(int id);
	public boolean modificarCoche(Coche c);
	public Coche consultaCoche(int id);
	public List<Coche> listarCoches();

}
