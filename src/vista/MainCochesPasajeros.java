package vista;

import java.util.List;
import java.util.Scanner;

import modelo.entidad.Coche;
import modelo.entidad.Pasajero;
import modelo.persistencia.DaoCocheMySql;
import modelo.persistencia.DaoPasajeroMySql;
import modelo.persistencia.interfaces.DaoCoche;
import modelo.persistencia.interfaces.DaoPasajero;

public class MainCochesPasajeros {
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		correrMenu();
	}
	 	
					
	public static int menu() {
		
		System.out.println("\n --------- COCHES PIJ ---------- \n");
		System.out.println("1. Añadir nuevo coche");
		System.out.println("2. Dar de baja un coche por ID");
		System.out.println("3. Consulta un coche por ID");
		System.out.println("4. Modificar coche por ID");
		System.out.println("5. Listado de coches");
		System.out.println("6. Gestión de pasajeros");
		System.out.println("7. Salir de la aplicación");
		int option = sc.nextInt();
		System.out.println("Has elegido la opción: " + option);
		return option;
		
		
	}
	public static int subMenu() {
		
		System.out.println("\n --------- PASAJEROS PIJ ---------- \n");
		System.out.println("1. Añadir nuevo pasajero");
		System.out.println("2. Borrar pasajero por ID");
		System.out.println("3. Consultar un pasajero por ID");
		System.out.println("4. Listar todos los pasajeros");
		System.out.println("5. Añadir pasajero a coche");
		System.out.println("6. Eliminar pasajero de un coche");
		System.out.println("7. Listar todos los pasajeros de un coche");
		System.out.println("8. Volver al menú de coches");
		int option = sc.nextInt();
		System.out.println("Has elegido la opción: " + option);
		return option;
	}
	
	public static void correrMenu() {
		
		int opcion,idAux;
		Coche cocheAux;
		DaoCoche dc = new DaoCocheMySql();
		
		do {
			opcion = menu();

			switch (opcion) {

			case 1: //Añadir nuevo coche
				try {
				cocheAux = new Coche();
				
				System.out.println("Añade la matricula");
				cocheAux.setMatricula(sc.next());

				System.out.println("Añade la marca");
				cocheAux.setMarca(sc.next());

				System.out.println("Añade el modelo");
				cocheAux.setModelo(sc.next());

				System.out.println("Añade el color");
				cocheAux.setColor(sc.next());

				dc.altaCoche(cocheAux);
				
				System.out.println("Se ha registrado el coche: \n" + cocheAux);
				
				}catch (Exception e) {
					System.out.println("El coche no se ha podido añadir");
				}
				break;

			case 2: //Dar de baja un coche por ID
				try {
				System.out.println("Escribe el ID del coche a dar de baja: ");
				idAux = sc.nextInt();
				dc.bajaCoche(idAux);
				
				System.out.println("Se ha borrado el coche con ID: " + idAux);
				}catch (Exception e) {
					System.out.println("No se ha podido borrar el coche");
				}
				break;

			case 3: //Consulta un coche por ID
				try {
				System.out.println("Escribe el ID del vehículo a consultar: ");
				idAux = sc.nextInt();
				Coche coche =dc.consultaCoche(idAux);
				System.out.println(coche);
				}catch (Exception e) {
					System.out.println("No se ha podido realizar la consulta");
				}
				break;

			case 4:	//Modificar coche por ID
				try {
				cocheAux = new Coche();

				System.out.println("Introduce el ID del coche a modificar: ");
				cocheAux.setId(sc.next());

				System.out.println("Introduce la matricula");
				cocheAux.setMatricula(sc.next());

				System.out.println("Introduce la marca");
				cocheAux.setMarca(sc.next());

				System.out.println("Introduce el modelo");
				cocheAux.setModelo(sc.next());

				System.out.println("Introduce el color");
				cocheAux.setColor(sc.next());

				dc.modificarCoche(cocheAux);
				
				System.out.println("Se ha modificado el registro del coche con Id: " + cocheAux.getId() 
				+ "\npor los siguientes datos: \n" + cocheAux);
				
				}catch (Exception e) {
					System.out.println("No se ha podido modificar el coche");
				}
				break;

			case 5: //Listado de coches
				try {
				List<Coche> listaCoches = dc.listarCoches();
				for(Coche c:listaCoches)
					System.out.println(c);
				}catch (Exception e) {
					System.out.println("No se puede mostrar el listado");
				}
				break;
				
			case 6: //Gestión de pasajeros
				
					correrSubMenu();
				
				break;

			case 7: //Salir de la aplicación
				System.out.println("Saliendo de la aplicación");

				break;

			default:
				System.out.println("Elige una opción correcta por favor");
				break;
			}
		} while (opcion != 7);
	}
		
	
	
	public static void correrSubMenu() {
		
		Pasajero pasajeroAux;
		int idAux, subOpcion;
		DaoPasajero dp = new DaoPasajeroMySql();
		//CREADO PARA PODER IMPLEMENTAR EL MÉTODO
		DaoCoche dc = new DaoCocheMySql();
		
		do {
			subOpcion = subMenu();

			switch (subOpcion) {

			case 1: //Añadir nuevo pasajero
				try {
				pasajeroAux = new Pasajero();

				System.out.println("Añade el Nombre");
				pasajeroAux.setNombre(sc.next());

				System.out.println("Añade la edad");
				pasajeroAux.setEdad(sc.nextInt());
				sc.nextLine();

				System.out.println("Añade el peso");
				pasajeroAux.setPeso(sc.nextDouble());
				sc.nextLine();

				dp.altaPasajero(pasajeroAux);
				
				System.out.println("Se ha registrado el pasajero: \n" + pasajeroAux);
				}catch (Exception e) {
					System.out.println("No se ha podido registrar al pasajero");
				}
				break;

			case 2: //Borrar pasajero por ID
				try {
				System.out.println("Escribe el ID del pasajero a dar de baja: ");
				idAux = sc.nextInt();
				dp.bajaPasajero(idAux);
				
				System.out.println("Se ha borrado el pasajero con ID: " + idAux);
				
				}catch (Exception e) {
					System.out.println("No se ha podido borrar al pasajero");
				}
				break;

			case 3: //Consultar un pasajero por ID
				try {
				System.out.println("Escribe el ID del pasajero a consultar: ");
				idAux = sc.nextInt();
				Pasajero pasajero =dp.consultaPasajero(idAux);
				System.out.println(pasajero);	
				
				}catch (Exception e) {
					System.out.println("No se ha podido realizar la consulta");
				}
				break;

			case 4:	//Listar todos los pasajeros
				try {
				List<Pasajero> listaPasajeros = dp.listarPasajeros();
				for(Pasajero p:listaPasajeros)
					System.out.println(p);
				
				}catch (Exception e) {
					System.out.println("No se puede mostrar el listado");
				}
				break;

			case 5: //Añadir pasajero a coche
				try {
				System.out.println("Estos son los vehículos disponibles:");
				//SOLO ME DEJA SI LO METO EN LA INTERFAZ TAMBIÉN, REVISAR
				dc.comprobarDisponibilidad();
				
				System.out.println("Introduce el ID del coche donde añadir un pasajero:");
				int idCoche = sc.nextInt();
				sc.nextLine();
				System.out.println("Introduce el ID del pasajero a añadir:");
				int idPas = sc.nextInt();
				sc.nextLine();
				dp.addPasajeroACoche(idPas, idCoche);
				
				System.out.println("Pasajero con ID: " + idPas + " añadido al coche con ID: " + idCoche);
				}catch (Exception e) {
					System.out.println("No se ha podido añadir el pasajero al coche");
				}
				break;
				
			case 6: //Eliminar pasajero de un coche
				try {
				System.out.println("Mostrando los pasajeros:");
				dp.listarPasajeros();
				System.out.println("Introduce el ID del coche donde eliminar un pasajero:");
				int idCocheBorrar = sc.nextInt();
				sc.nextLine();
				System.out.println("Introduce el ID del pasajero a eliminar:");
				int idPasBorrar = sc.nextInt();
				sc.nextLine();
				dp.borrarPasajeroDeCoche(idPasBorrar, idCocheBorrar);
				
				System.out.println("Pasajero con ID: " + idPasBorrar + " eliminado del coche con ID: " + idCocheBorrar);
				
				}catch (Exception e) {
					System.out.println("No se ha podido eliminar el pasajero del coche");
				}
				break;
				
				
			case 7: //Listar todos los pasajeros de un coche
				try {
				System.out.println("Introduce el ID del coche del que quieres listar los pasajeros:");
				int idCocheListar = sc.nextInt();
				sc.nextLine();
				List<Pasajero> listaPasajerosPorCoche = dp.listarPasajerosCoche(idCocheListar);
				for(Pasajero p : listaPasajerosPorCoche)
					System.out.println(p);
				}catch (Exception e) {
					System.out.println("No se puede mostrar el listado");
				}
				break;
				
			case 8: //Salir
				System.out.println("Volviendo al menú de coches");
				
				break;

			default:
				System.out.println("Elige una opción correcta por favor");
				break;
			}
		} while (subOpcion != 8);
		
	}
	

}
