package main;

public class CurrencyML {
	private String Id;
	private String Descripcion;
	private String Symbol;
	private int Decimal_places; 
	
	
	public CurrencyML(String desc, String Id) {
		this.Descripcion = desc;
		this.Id = Id; 
	}
	
	public CurrencyML(String desc, String Id, String symbol, int decimales) {
		this.Descripcion = desc;
		this.Id = Id; 
		this.Symbol = symbol;
		this.Decimal_places = decimales;
	}
	
	public String getDescripcion() {
		return Descripcion;
	}

	public String getId() {
		return Id;
	}
	public String getSymbol() {
		return Symbol;
	}
	public int getDecimal_places() {
		return Decimal_places;
	}
	
}


