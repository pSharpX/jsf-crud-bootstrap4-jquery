package pe.edu.cibertec.service.impl;

import org.modelmapper.ModelMapper;
import pe.edu.cibertec.dominio.Usuario;
import pe.edu.cibertec.mapper.domainToModel.UsuarioToUsuarioModelMap;
import pe.edu.cibertec.mapper.modelToDomain.UsuarioModelToUsuarioMap;
import pe.edu.cibertec.producer.ModelMapperProducer;
import pe.edu.cibertec.producer.UsuarioRepositorioProducer;
import pe.edu.cibertec.repositorio.UsuarioRepositorio;
import pe.edu.cibertec.repositorio.impl.UsuarioJpaRepositorioImpl;
import pe.edu.cibertec.service.IUsuarioService;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;

/**
 * Created by CHRISTIAN on 13/04/2018.
 */
@Named("usuarioService")
public class UsuarioService implements IUsuarioService {

    @Inject
    @ModelMapperProducer
    private ModelMapper mapper;

    @Inject
    @UsuarioRepositorioProducer
    private UsuarioRepositorio usuarioRepositorio;

    /*@Inject
    @PersistenceContext(unitName = "labjpa")
    private EntityManager entityManager;*/

    public UsuarioService(){
    }

    @PostConstruct
    public void init(){
        //this.usuarioRepositorio.setEntityManager(this.entityManager);
        this.mapper.addMappings(new UsuarioModelToUsuarioMap());
        this.mapper.addMappings(new UsuarioToUsuarioModelMap());
    }

    @Override
    public boolean existe(String username, String password) {
        EntityManagerFactory emf = (EntityManagerFactory) FacesContext.getCurrentInstance().getExternalContext()
                .getApplicationMap().get("emf");
        EntityManager em = emf.createEntityManager();
        try {
            UsuarioRepositorio usuarioRepositorio = new UsuarioJpaRepositorioImpl()
                    .setEntityManager(em);
            Usuario usuario = usuarioRepositorio.buscar(username, password);
            em.close();
            if(usuario == null)
                return false;
            return true;
        }catch (NoResultException ex){
            if(em != null && em.isOpen())
                em.close();
            return false;
        }
    }

    public ModelMapper getMapper() {
        return mapper;
    }

    public void setMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public UsuarioRepositorio getUsuarioRepositorio() {
        return usuarioRepositorio;
    }

    public void setUsuarioRepositorio(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }
}
