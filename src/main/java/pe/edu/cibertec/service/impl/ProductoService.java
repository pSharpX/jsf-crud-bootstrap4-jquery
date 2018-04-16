package pe.edu.cibertec.service.impl;

import org.modelmapper.ModelMapper;
import pe.edu.cibertec.dominio.Producto;
import pe.edu.cibertec.mapper.domainToModel.ProductoToProductoModelMap;
import pe.edu.cibertec.mapper.modelToDomain.ProductoModelToProductoMap;
import pe.edu.cibertec.model.ProductoModel;
import pe.edu.cibertec.producer.ModelMapperProducer;
import pe.edu.cibertec.producer.ProductoRepositorioProducer;
import pe.edu.cibertec.repositorio.ProductoRepositorio;
import pe.edu.cibertec.repositorio.impl.ProductoJpaRepositorioImpl;
import pe.edu.cibertec.service.IProductoService;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by CHRISTIAN on 14/04/2018.
 */
@Named("productoService")
public class ProductoService implements IProductoService {

    @Inject
    @ModelMapperProducer
    private ModelMapper mapper;

    @Inject
    @ProductoRepositorioProducer
    private ProductoRepositorio productoRepositorio;

    /*@Inject
    @PersistenceContext(unitName = "labjpa")
    private EntityManager entityManager;*/

    public  ProductoService(){
    }

    @PostConstruct
    public void init(){
        //this.productoRepositorio.setEntityManager(this.entityManager);
        this.mapper.addMappings(new ProductoModelToProductoMap());
        this.mapper.addMappings(new ProductoToProductoModelMap());
    }

    @Override
    public Collection<ProductoModel> listar() {
        EntityManagerFactory emf = (EntityManagerFactory) FacesContext.getCurrentInstance().getExternalContext()
                .getApplicationMap().get("emf");
        EntityManager em = emf.createEntityManager();

        ProductoRepositorio productoRepositorio = new ProductoJpaRepositorioImpl()
                .setEntityManager(em);
        List<Producto> _productos = productoRepositorio.obtenerTodos();
        List<ProductoModel> _productoModels;
        if(_productos == null && _productos.size() == 0)
            return null;
        _productoModels = new ArrayList<>();
        for (Producto p: _productos) {
            _productoModels.add(this.mapper.map(p, ProductoModel.class));
        }
        return _productoModels;
    }

    @Override
    public Collection<ProductoModel> listarPorCategoria(Long idCategoria) {
        return null;
    }

    @Override
    public ProductoModel obtener(Long id) {
        return null;
    }

    public ModelMapper getMapper() {
        return mapper;
    }

    public void setMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public ProductoRepositorio getProductoRepositorio() {
        return productoRepositorio;
    }

    public void setProductoRepositorio(ProductoRepositorio productoRepositorio) {
        this.productoRepositorio = productoRepositorio;
    }
}
