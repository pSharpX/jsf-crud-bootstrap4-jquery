package pe.edu.cibertec.util;

import pe.edu.cibertec.producer.UsuarioRepositorioProducer;
import pe.edu.cibertec.repositorio.UsuarioRepositorio;
import pe.edu.cibertec.repositorio.impl.UsuarioJpaRepositorioImpl;

import javax.enterprise.inject.Produces;

/**
 * Created by CHRISTIAN on 15/04/2018.
 */
public class UsuarioRepositorioFactory {

    @Produces
    @UsuarioRepositorioProducer
    public UsuarioRepositorio createUsuarioRepositorio(){
        return new UsuarioJpaRepositorioImpl();
    }
}
