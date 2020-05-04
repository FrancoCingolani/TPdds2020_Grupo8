package main;
//TIENE LO QUE DICE EL DIAGRAMA DE CLASES
public class Ticket extends MedioDePago{
	String	numeroParaCajero;
	long codigoBarras; 
	
	public Ticket(String numeroParaCajero, long codigoBarras) {
		this.numeroParaCajero = numeroParaCajero;
		this.codigoBarras = codigoBarras;
	}
	
	public String getNumeroParaCajero() {
		return numeroParaCajero;
	}
	public void setNumeroParaCajero(String numeroParaCajero) {
		this.numeroParaCajero = numeroParaCajero;
	}
	public long getcodigoBarras() {
		return codigoBarras;
	}
	public void setcodigoBarras(long codigoBarras) {
		this.codigoBarras = codigoBarras;
	}
}
