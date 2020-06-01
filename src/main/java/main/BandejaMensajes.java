package main;

import java.util.ArrayList;
import java.util.List;

import mensajes.*;

public class BandejaMensajes {
	List<Mensaje> mensajes;
	
	public BandejaMensajes() {
		this.mensajes = new ArrayList<Mensaje>();
	}
	
	public void nuevoMensaje (Mensaje nuevoMensaje) {
		this.mensajes.add(nuevoMensaje);
	}
	
	public List<Mensaje> getMensajesTodos() {
		return this.mensajes;
	}
	
	public List<Mensaje> getMensajesSinLeer() {
		List<Mensaje> mensajesSinLeer = new ArrayList<Mensaje>();
		for (Mensaje msj : mensajes) {
			if (!msj.mensajeFueLeido()) {
				mensajesSinLeer.add(msj);
			}
		}
		
		return mensajesSinLeer;
	}
}
