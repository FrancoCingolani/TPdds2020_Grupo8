package main;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import enumeradores.TipoDocumentoComercial;

@Entity
public class DocumentoComercial {
	
	@Id @GeneratedValue
	int id_documento_comercial;
	String numero_identificacion;
	@ManyToOne
	OperacionEgreso id_operacion_egreso;
	@Enumerated
	TipoDocumentoComercial tipo;

	public DocumentoComercial(String numero_identificacion,OperacionEgreso id_operacion_egreso,TipoDocumentoComercial tipo) {
		this.numero_identificacion=numero_identificacion;
		this.id_operacion_egreso = id_operacion_egreso;
		this.tipo = tipo;
	}

	public TipoDocumentoComercial getTipo() {
		return tipo;
	}

}
