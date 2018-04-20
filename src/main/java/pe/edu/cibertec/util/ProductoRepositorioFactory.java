package pe.edu.cibertec.util;

import pe.edu.cibertec.producer.ProductoRepositorioProducer;
import pe.edu.cibertec.repositorio.ProductoRepositorio;
import pe.edu.cibertec.repositorio.impl.ProductoJpaRepositorioImpl;

import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * Created by CHRISTIAN on 15/04/2018.
 */
public class ProductoRepositorioFactory {

    @Produces
    @ProductoRepositorioProducer
    public ProductoRepositorio createProductoRepositorio(){
        EntityManagerFactory emf = (EntityManagerFactory) FacesContext.getCurrentInstance().getExternalContext()
                .getApplicationMap().get("emf");
        EntityManager em = emf.createEntityManager();
        return new ProductoJpaRepositorioImpl().setEntityManager(em);
    }
}
