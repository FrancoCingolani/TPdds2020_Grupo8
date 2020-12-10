package main;
//TIENE LO QUE DICE EL DIAGRAMA DE CLASES

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "Atm")
@Table(name = "atm")
public class Atm extends MedioDePago{
	int linkPagos; 
	
	public Atm(int linkPagos) {
		this.linkPagos = linkPagos;
	}
	
	public int getLinkPagos() {
		return linkPagos;
	}
	public void setLinkPagos(int linkPagos) {
		this.linkPagos = linkPagos;
	}

}
