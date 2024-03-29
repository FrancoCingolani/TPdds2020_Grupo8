package repositorios;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import main.CurrencyML;
import main.DocumentoComercial;
import main.Proveedor;
import repositorios.AbstractHibernateRepo;

public class RepositorioDocumentosComerciales extends AbstractHibernateRepo{
	
	private static RepositorioDocumentosComerciales instance;

	public static RepositorioDocumentosComerciales getInstance() {
		if (instance == null)
			instance = new RepositorioDocumentosComerciales();
		return instance;
	}

	
	public List<DocumentoComercial> buscarDocumentosComerciales() {

		
		Query query = this.getEntityManager().createQuery("FROM DocumentoComercial documentosComerciales");
		
		@SuppressWarnings("unchecked")
		
		List<DocumentoComercial> results = query.getResultList();
		
		return results;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<DocumentoComercial> buscarDocumentosComercialesPorId(int id_documentoComercial) { //EN REALIDAD VOY A TENER QUE PASAR UNA LISTA DE DOC COMERCIALES
		Query query = this.getEntityManager().createQuery("SELECT documentoComercial FROM DocumentoComercial documentoComercial WHERE id_documento_comercial = :id_documentoComercial");
		query.setParameter("id_documentoComercial", id_documentoComercial);
		
		List<DocumentoComercial> results = query.getResultList();
		
		return results;
	}

}
