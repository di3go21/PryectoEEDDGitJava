
import java.io.*;
import java.util.*;

public class Listaproductos { //Singleton (clase de una unica instancia)

	private static Listaproductos instance = null; //como parámetro su unica instancia
	private static ArrayList<Producto> lista; //segundo parámetro la lista de produtcos

	public ArrayList<Producto> getLista() { //seter de la lista
		return lista;
	}

	private Listaproductos() { //constructor privado para que no se pueda crear objetos
		lista = new ArrayList<>();
	}

	public static Listaproductos getInstance() { //crea el objeto solo si no existe, sino devuelve el q ya existe

		if (instance == null)
			instance = new Listaproductos();
		return instance;
	}

	public void rellenarconInventario() throws IOException { //lee inventario.txt e introduce los productos a la lista

		BufferedReader lecturainv = new BufferedReader(new FileReader(
				new File("inventario.txt")));

		String linea = lecturainv.readLine();

		while (linea != null) {
			agregarlineadeinv(linea);

			linea = lecturainv.readLine();
		}
		lecturainv.close();

	}
	
	public void actualizarConMovimientos() throws IOException { //lee movimientos.txt y actualiza la lista de productos
		
		BufferedReader lecturaMov = new BufferedReader(new FileReader(
				new File("movimientos.txt")));

		String linea = lecturaMov.readLine();
		String [] lineaMov;
		while (linea != null) {
			
			lineaMov= linea.split(" ");
			Movimiento movim = new Movimiento(Integer.parseInt(lineaMov[0]),lineaMov[1].charAt(0), Integer.parseInt(lineaMov[2]));
			if (existeProd(movim))
				actualiza(movim);
			else
				creaNuevo(movim);

			linea = lecturaMov.readLine();
		}
		lecturaMov.close();
		
		
		
	}

	private static void agregarlineadeinv(String linea) { // agrega un producto a partir de una linea leida del inventario

		String[] hola = linea.split(" ");
		lista.add(new Producto(Integer.parseInt(hola[0]), hola[1], Integer.parseInt(hola[2]),
				Double.parseDouble(hola[3])));

	}

	private boolean existeProd(Movimiento movim) { //comprueba si un movimiento tiene un codigo que eiste en la lista

		for (Producto prod : Listaproductos.lista) {

			if (prod.getCodigo() == movim.getCodigo())
				return true;
		}
		System.out.println("el producto del "+movim.toString()+" no existe");
		return false;
	}

	private void actualiza(Movimiento movim) { //actualiza la lista de productos a partir de un movimiento

		for (Producto prod : Listaproductos.lista) {

			if (prod.getCodigo() == movim.getCodigo()) {

				if (movim.getTipoOperacion() == 'C' || movim.getTipoOperacion() == 'D')
					prod.setCantidad(prod.getCantidad() + movim.getCantidad()); // si es c o d aumentamos
				else {
					if(prod.getCantidad()==0)
						System.out.println("no quedan existencias del producto "+prod.getNombre());
					else if (movim.getCantidad() > prod.getCantidad()) {
						System.out.println("la venta " + movim.toString()
								+ " era mayor que el stock. se vendieron todas las unidades que eran: "
								+ (prod.getCantidad()));
						prod.setCantidad(0);
					}
					else prod.setCantidad(prod.getCantidad()-movim.getCantidad());
				}

			}
		}
	}

	private void creaNuevo(Movimiento movim) { //crea un nuevo producto a partir de un movimiento, si es D o V lanza error
		Scanner teclado = new Scanner(System.in);
		if (movim.getTipoOperacion() == 'C') {
			System.out.println("el producto de codigo " + movim.getCodigo() + " va a ser creado, introduzca su nombre: ");
			String nombre = teclado.next();
			System.out.println("ahora dime el precio para el producto " + nombre + ":");
			double precio = teclado.nextDouble();
			getLista().add(new Producto(movim.getCodigo(), nombre, movim.getCantidad(), precio));
		} else {
			System.out.println("Error 2123-b: un producto que no existe no se puede devolver ni vender");
		}
	}

	public void actualizarFicheroInventario() throws IOException { //actualiza el fichero inventario.txt a partir de la lista de productos
		
		BufferedWriter bf = new BufferedWriter(new FileWriter(new File("inventario.txt")));
		
		for (Producto producto : lista) {
			bf.write(producto.cadenaparaInventario());
			bf.newLine();
		}
		bf.close();
		
		
	}
}
