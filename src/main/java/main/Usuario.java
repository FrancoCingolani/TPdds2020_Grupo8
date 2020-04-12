package main;

public class Usuario {
	
	String nombre;
	String contrasenia;
	char tipo;
	
	public Usuario(String nombre, String contrasenia, char tipo) {
		this.nombre = nombre;
		this.contrasenia = contrasenia;
		this.tipo = tipo;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	public char getTipo() {
		return tipo;
	}
	public void setTipo(char tipo) {
		this.tipo = tipo;
	}
	
	

}
