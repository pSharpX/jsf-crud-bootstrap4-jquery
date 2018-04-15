package pe.edu.cibertec.service.impl;

import pe.edu.cibertec.repositorio.impl.UsuarioJpaRepositorioImpl;
import pe.edu.cibertec.service.IUsuarioService;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by CHRISTIAN on 13/04/2018.
 */
@Named("usuarioService")
public class UsuarioService implements IUsuarioService {

    private UsuarioJpaRepositorioImpl _usuarioRepositorio;
    @PersistenceContext(unitName = "labjpa")
    private EntityManager entityManager;

    public UsuarioService(){
        this._usuarioRepositorio = new UsuarioJpaRepositorioImpl();
        this._usuarioRepositorio.setEm(this.entityManager);
    }

    @Override
    public boolean existe(String username, String password) {
        return false;
    }

}
