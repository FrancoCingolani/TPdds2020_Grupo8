package main;

public class DocumentoComercial {
	
	String tipo; //Quizás un enum, mejor? Porque son pocas opciones y van a ser siempre las mismas
	OperacionEgreso operacion;
	
	
	public DocumentoComercial(String tipo, OperacionEgreso operacion) {
		this.tipo = tipo;
		this.operacion = operacion;
	}


	public String getTipo() {
		return tipo;
	}


	public OperacionEgreso getOperacion() {
		return operacion;
	}

	
	

}
