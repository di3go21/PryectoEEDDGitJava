
public class Producto { //clase producto
	
	private String nombre;
	private int codigo;
	private int cantidad;
	private double precio;

	
	public Producto( int codigo, String nombre,int cantidad, double precio) {
		this.nombre = nombre;
		this.codigo = codigo;
		this.cantidad= cantidad;
		this.precio = precio;
		
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", codigo=" + codigo + ", cantidad=" + cantidad + ", precio=" + precio
				+ "]";
	}
	
	public String cadenaparaInventario() { //devuelve el producto en una cadena lista para escribirla en el fichero
		return (codigo+" "+nombre+" "+cantidad+" "+precio);
	}


	
	
	
	
	

}

