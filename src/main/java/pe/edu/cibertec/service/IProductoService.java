package pe.edu.cibertec.service;

import pe.edu.cibertec.model.ProductoModel;

import java.util.Collection;

/**
 * Created by CHRISTIAN on 14/04/2018.
 */
public interface IProductoService {
    Collection<ProductoModel> listar();
    Collection<ProductoModel> listarPorCategoria(Long idCategoria);
    ProductoModel obtener(Long id);
}
