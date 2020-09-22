package main;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import enumeradores.TipoDocumentoComercial;

@Entity
@Table(name = "DocumentosComerciales")
public class DocumentoComercial {
	
	@Id @GeneratedValue
	int id_documento_comercial;
	String numero_identificacion;
	@Enumerated
	TipoDocumentoComercial tipo;

	public DocumentoComercial(String numero_identificacion,TipoDocumentoComercial tipo) {
		this.numero_identificacion=numero_identificacion;
		this.tipo = tipo;
	}

	public TipoDocumentoComercial getTipo() {
		return tipo;
	}

}
