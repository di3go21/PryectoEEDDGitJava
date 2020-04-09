
import java.io.IOException;

public class Main { 
//	Sea el archivo de texto “inventario.txt” que guarda la información acerca de los productos
//	 existentes en un almacén.
//	 Por cada producto se guarda en una línea los siguientes datos:
//	 Código del producto (entero positivo), Nombre, Unidades (entero) y Precio (real)
//	 El archivo está ordenado en orden creciente por el código de producto.
//	 Se dispone además de otro archivo, “movimientos.txt”, en el que se guardan las
//	 variaciones en el número de artículos que se han producido a lo largo de todo un día.
//	 Cada línea del archivo “movimientos.txt” consta de los siguientes campos:
//	 Código del producto (entero positivo), Código de operación: venta (V), compra (C), o
//	 devolución (D) y Número de unidades (entero).
//	 
//	 El archivo “movimientos.txt” está ordenado en orden creciente por el código de
//	 producto. Puede haber varias modificaciones relativas al mismo producto.
//	 Por ejemplo: El producto de código 2331 puede tener asociadas, por ejemplo, tres
//	 líneas del archivo “movimientos.txt”, la primera puede tratarse de la
//	 devolución de 100 unidades, la segunda de la devolución de 50 unidades y
//	 la tercera de la venta de 550 unidades.
//	 Hacer un programa que actualice el fichero “inventario.txt”, mediante “movimientos.txt“.
//	 Las ventas disminuyen el número de unidades y las compras y devoluciones lo aumentan.
//	 Las unidades no se pueden quedar a negativo.
//	 Mostrar por pantalla el fichero “inventario.txt” actualizado.
//
//	 NOTA: Tened en cuenta, que el tamaño de los ficheros no tiene por qué ser el mismo y
//	 que si existe un código en inventario y no en modificaciones, será que sobre ese
//	 articulo no se ha hecho nada. Si existe en modificaciones y no en inventario y la
//	 operación es Ventas o Devolución será un error pues no existe, si es una Compra
//	 habrá que darle de alta pidiendo por teclado los datos que nos faltan. 
	
	public static void main(String[] args) throws IOException {
		
		
		Listaproductos basededatos= Listaproductos.getInstance();
		System.out.println("############################################");
		System.out.println("Rellenamos con inventario.txt");
		System.out.println("############################################");
		basededatos.rellenarconInventario();
		System.out.println("############################################");
		System.out.println("Actualizamos  con movimientos.txt");
		System.out.println("############################################");
		basededatos.actualizarConMovimientos();
		basededatos.actualizarFicheroInventario();
		System.out.println("############################################");
		System.out.println("Pintamos el fichero actualizado");
		System.out.println("############################################");
		basededatos.getLista().forEach(p -> System.out.println(p)); //es una expresion lambda que aprendi en openwebbinars es un for each de toda la vida en una linea
		
	}

}