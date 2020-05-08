package main;

public class DocumentoComercial {
	
	String nroDoc;
	String tipo; //Quizás un enum, mejor? Porque son pocas opciones y van a ser siempre las mismas
	
	
	public DocumentoComercial(String nroDoc,String tipo) {
		this.nroDoc=nroDoc;
		this.tipo = tipo;
	}


	public String getTipo() {
		return tipo;
	}

	
	

}
