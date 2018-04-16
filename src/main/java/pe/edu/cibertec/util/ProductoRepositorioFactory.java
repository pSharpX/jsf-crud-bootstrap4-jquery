package pe.edu.cibertec.util;

import pe.edu.cibertec.producer.ProductoRepositorioProducer;
import pe.edu.cibertec.repositorio.ProductoRepositorio;
import pe.edu.cibertec.repositorio.impl.ProductoJpaRepositorioImpl;

import javax.enterprise.inject.Produces;

/**
 * Created by CHRISTIAN on 15/04/2018.
 */
public class ProductoRepositorioFactory {

    @Produces
    @ProductoRepositorioProducer
    public ProductoRepositorio createProductoRepositorio(){
        return new ProductoJpaRepositorioImpl();
    }
}
