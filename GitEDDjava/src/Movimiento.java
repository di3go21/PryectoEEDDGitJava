public class Movimiento { //clase movimiento
	
	private int codigo;
	private char tipoOperacion;
	private int cantidad;
	
	public Movimiento(int codigo, char tipoOperacion, int cantidad) {
		this.codigo = codigo;
		this.tipoOperacion = tipoOperacion;
		this.cantidad = cantidad;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public char getTipoOperacion() {
		return tipoOperacion;
	}

	public void setTipoOperacion(char tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "Movimiento [codigo=" + codigo + ", tipoOperacion=" + tipoOperacion + ", cantidad=" + cantidad + "]";
	}

}
