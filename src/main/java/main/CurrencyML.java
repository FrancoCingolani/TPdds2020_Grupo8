package main;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "currencyml")
public class CurrencyML {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	int id_moneda;

	private String descripcion;
	private String symbol;
	private int decimal_places; 
	
	/*
	public CurrencyML(String desc) {
		this.descripcion = desc;
		
	}*/
	
	public CurrencyML() {
	}
	
	public CurrencyML(String desc,  String symbol, int decimales) {
		this.descripcion = desc; 
		this.symbol = symbol;
		this.decimal_places = decimales;
	}
	
	public String getDescripcion() {
		return descripcion;
	}


	public String getSymbol() {
		return symbol;
	}
	public int getDecimal_places() {
		return decimal_places;
	}

	public int getId_moneda() {
		return id_moneda;
	}
	
}


