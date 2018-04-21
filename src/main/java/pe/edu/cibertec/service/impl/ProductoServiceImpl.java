package pe.edu.cibertec.service.impl;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import pe.edu.cibertec.dominio.Producto;
import pe.edu.cibertec.mapper.domainToModel.ProductoToProductoModelMap;
import pe.edu.cibertec.mapper.modelToDomain.ProductoModelToProductoMap;
import pe.edu.cibertec.model.ProductoModel;
import pe.edu.cibertec.producer.ModelMapperProducer;
import pe.edu.cibertec.producer.ProductoRepositorioProducer;
import pe.edu.cibertec.repositorio.ProductoRepositorio;
import pe.edu.cibertec.service.ProductoService;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by CHRISTIAN on 14/04/2018.
 */
@Named("productoService")
public class ProductoServiceImpl implements ProductoService {

    @Inject
    @ModelMapperProducer
    private ModelMapper mapper;

    @Inject
    @ProductoRepositorioProducer
    private ProductoRepositorio productoRepositorio;

    /*@Inject
    @PersistenceContext(unitName = "labjpa")
    private EntityManager entityManager;*/

    public ProductoServiceImpl(){
    }

    @PostConstruct
    public void init(){
        this.mapper.addMappings(new ProductoModelToProductoMap());
        this.mapper.addMappings(new ProductoToProductoModelMap());
        this.mapper.validate();
    }

    @Override
    public Collection<ProductoModel> listar() {
        List<Producto> _productos = this.productoRepositorio.obtenerTodos();
        if(_productos == null || _productos.size() == 0)
            return null;
        Type type = new TypeToken<List<ProductoModel>>(){}.getType();
        List<ProductoModel> _productoModels = this.mapper.map(_productos, type);
        return _productoModels;
    }

    @Override
    public Collection<ProductoModel> listarPorCategoria(Long idCategoria) {
        List<Producto> _productos = this.productoRepositorio.obtenerPorCategoriaCriteriaApi(idCategoria);
        if(_productos == null || _productos.size() == 0)
            return null;
        Type type = new TypeToken<List<ProductoModel>>(){}.getType();
        List<ProductoModel> _productoModels = this.mapper.map(_productos, type);
        return _productoModels;
    }

    @Override
    public ProductoModel obtener(Long id) {
        return null;
    }

    @Override
    public ProductoModel crear(ProductoModel producto) {
        return null;
    }

    @Override
    public ProductoModel actualizar(ProductoModel producto) {
        return null;
    }

    @Override
    public boolean eliminar(ProductoModel producto) {
        return false;
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