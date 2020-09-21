package main;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CurrencyML {
	
	@Id @GeneratedValue
	int id_moneda;

	private String Descripcion;
	private String Symbol;
	private int Decimal_places; 
	
	
	public CurrencyML(String desc) {
		this.Descripcion = desc;
		
	}
	
	public CurrencyML(String desc,  String symbol, int decimales) {
		this.Descripcion = desc; 
		this.Symbol = symbol;
		this.Decimal_places = decimales;
	}
	
	public String getDescripcion() {
		return Descripcion;
	}


	public String getSymbol() {
		return Symbol;
	}
	public int getDecimal_places() {
		return Decimal_places;
	}
	
}


