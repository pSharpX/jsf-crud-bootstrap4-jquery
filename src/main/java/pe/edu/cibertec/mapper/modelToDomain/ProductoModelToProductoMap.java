package pe.edu.cibertec.mapper.modelToDomain;

import org.modelmapper.PropertyMap;
import pe.edu.cibertec.dominio.Producto;
import pe.edu.cibertec.model.ProductoModel;

import java.math.BigDecimal;

/**
 * Created by CHRISTIAN on 15/04/2018.
 */
public class ProductoModelToProductoMap extends PropertyMap<ProductoModel, Producto> {
    @Override
    protected void configure() {
        this.map().setId(source.getId());
        this.map().setNombre(source.getNombre());
        this.map().setDescripcion(source.getDescripcion());
        this.map().setImagen(source.getImagen());
        this.map().setPrecio(new BigDecimal(source.getPrecio()));
        this.skip().setCategoria(null);
    }
}
