package ar.edu.unju.edm.model;

public class ProcesoString {
	private String cadena;
	private String mensaje1;
	private String cadenaInvertida;
	private String mensaje2;
	
	public ProcesoString() {
		
	}

	public ProcesoString(String cadena, String mensaje1, String cadenaInvertida, String mensaje2) {
		super();
		this.cadena = cadena;
		this.mensaje1 = mensaje1;
		this.cadenaInvertida = cadenaInvertida;
		this.mensaje2 = mensaje2;
	}

	public String getCadena() {
		return cadena;
	}

	public void setCadena(String cadena) {
		this.cadena = cadena;
	}

	public String getMensaje1() {
		return mensaje1;
	}

	public void setMensaje1(String mensaje1) {
		this.mensaje1 = mensaje1;
	}

	public String getCadenaInvertida() {
		return cadenaInvertida;
	}

	public void setCadenaInvertida(String cadenaInvertida) {
		this.cadenaInvertida = cadenaInvertida;
	}

	public String getMensaje2() {
		return mensaje2;
	}

	public void setMensaje2(String mensaje2) {
		this.mensaje2 = mensaje2;
	}
	
}
