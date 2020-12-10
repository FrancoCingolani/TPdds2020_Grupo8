package main;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import enumeradores.TipoDocumentoComercial;

@Entity
@Table(name = "documentoscomerciales")
public class DocumentoComercial {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	int id_documento_comercial;
	String numero_identificacion;
	@Enumerated
	TipoDocumentoComercial tipo;
	
	public DocumentoComercial() {
	}

	public DocumentoComercial(String numero_identificacion,TipoDocumentoComercial tipo) {
		this.numero_identificacion=numero_identificacion;
		this.tipo = tipo;
	}

	public TipoDocumentoComercial getTipo() {
		return tipo;
	}
	
	public int getId_documento_comercial() {
		return id_documento_comercial;
	}

}
