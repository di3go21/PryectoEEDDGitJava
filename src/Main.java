
import java.io.IOException;

public class Main { 
//	Sea el archivo de texto �inventario.txt� que guarda la informaci�n acerca de los productos
//	 existentes en un almac�n.
//	 Por cada producto se guarda en una l�nea los siguientes datos:
//	 C�digo del producto (entero positivo), Nombre, Unidades (entero) y Precio (real)
//	 El archivo est� ordenado en orden creciente por el c�digo de producto.
//	 Se dispone adem�s de otro archivo, �movimientos.txt�, en el que se guardan las
//	 variaciones en el n�mero de art�culos que se han producido a lo largo de todo un d�a.
//	 Cada l�nea del archivo �movimientos.txt� consta de los siguientes campos:
//	 C�digo del producto (entero positivo), C�digo de operaci�n: venta (V), compra (C), o
//	 devoluci�n (D) y N�mero de unidades (entero).
//	 
//	 El archivo �movimientos.txt� est� ordenado en orden creciente por el c�digo de
//	 producto. Puede haber varias modificaciones relativas al mismo producto.
//	 Por ejemplo: El producto de c�digo 2331 puede tener asociadas, por ejemplo, tres
//	 l�neas del archivo �movimientos.txt�, la primera puede tratarse de la
//	 devoluci�n de 100 unidades, la segunda de la devoluci�n de 50 unidades y
//	 la tercera de la venta de 550 unidades.
//	 Hacer un programa que actualice el fichero �inventario.txt�, mediante �movimientos.txt�.
//	 Las ventas disminuyen el n�mero de unidades y las compras y devoluciones lo aumentan.
//	 Las unidades no se pueden quedar a negativo.
//	 Mostrar por pantalla el fichero �inventario.txt� actualizado.
//
//	 NOTA: Tened en cuenta, que el tama�o de los ficheros no tiene por qu� ser el mismo y
//	 que si existe un c�digo en inventario y no en modificaciones, ser� que sobre ese
//	 articulo no se ha hecho nada. Si existe en modificaciones y no en inventario y la
//	 operaci�n es Ventas o Devoluci�n ser� un error pues no existe, si es una Compra
//	 habr� que darle de alta pidiendo por teclado los datos que nos faltan. 
	
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