package pe.edu.cibertec.service.impl;

import org.modelmapper.ModelMapper;
import pe.edu.cibertec.dominio.Producto;
import pe.edu.cibertec.model.ProductoModel;
import pe.edu.cibertec.producer.ModelMapperProducer;
import pe.edu.cibertec.producer.ProductoRepositorioProducer;
import pe.edu.cibertec.repositorio.impl.ProductoJpaRepositorioImpl;
import pe.edu.cibertec.service.IProductoService;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
    private ProductoJpaRepositorioImpl _productoRepositorio;

    @PersistenceContext(unitName = "labjpa")
    private EntityManager entityManager;

    public  ProductoService(){
        this._productoRepositorio.setEntityManager(this.entityManager);
    }

    @PostConstruct
    public void init(){
        this._productoRepositorio.setEntityManager(this.entityManager);
    }

    @Override
    public Collection<ProductoModel> listar() {
        List<Producto> _productos =this._productoRepositorio.obtenerTodos();
        List<ProductoModel> _productoModels;
        if(_productos == null && _productos.size() == 0)
            return null;
        _productoModels = new ArrayList<>();
        for (Producto p: _productos) {
            _productoModels.add(this.mapper.map(_productos, ProductoModel.class));
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
}
