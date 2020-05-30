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
}
