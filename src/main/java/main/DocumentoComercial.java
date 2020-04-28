package main;

public class DocumentoComercial {
	
	String tipo; //Quizás un enum, mejor? Porque son pocas opciones y van a ser siempre las mismas
	
	
	public DocumentoComercial(String tipo) {
		this.tipo = tipo;
	}


	public String getTipo() {
		return tipo;
	}

	
	

}
