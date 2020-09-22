package main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import mensajes.Mensaje;

@Entity
@Table(name = "Usuarios")
public class Usuario {
	
	@Id @GeneratedValue
	String nombre;
	String contrasenia;
	int tipo;
	int intentosMaximos = 3;
	int cantidadIntentos = 0;
	
	@Transient //Volver a ver. Por ahora no lo persisto 
	BandejaMensajes bandejaEntrada;
	
	@Transient
	MD5Hashing hash = MD5Hashing.getInstance();
	
	@Transient
	ValidadorDeContrasenia validador = ValidadorDeContrasenia.getInstance();
	
	public Usuario(String nombre, String contrasenia, int tipo) throws FileNotFoundException, IOException {
		this.nombre = nombre;
		this.contrasenia = hash.getMd5(contrasenia);
		this.tipo = tipo;
		this.bandejaEntrada = new BandejaMensajes();
		this.validador.validar(contrasenia);
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
	public int getTipo() {
		return tipo;
	}
	public void setTipo(char tipo) {
		this.tipo = tipo;
	}
	
	public boolean iniciarSesion(String nombre, String contrasenia) {
		if(nombre == this.nombre && hash.getMd5(contrasenia).equals(this.contrasenia) && this.cantidadIntentos < this.intentosMaximos) {
			System.out.println("El usuario se ha logueado exitosamente.");
			return true;
		}else {
			this.cantidadIntentos++;
			return false;
		}
	}
	
	public void recibirMensaje(Mensaje nuevoMensaje) {
		this.bandejaEntrada.nuevoMensaje(nuevoMensaje);
	}
	
	public List<Mensaje> getMensajes () {
		return this.bandejaEntrada.getMensajesTodos();
	}
	
	public List<Mensaje> getMensajesNoLeidos () {
		return this.bandejaEntrada.getMensajesSinLeer();
	}
	
	
		

}


