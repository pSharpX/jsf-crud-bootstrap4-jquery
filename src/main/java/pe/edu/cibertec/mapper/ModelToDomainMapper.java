package pe.edu.cibertec.mapper;

import org.modelmapper.PropertyMap;
import pe.edu.cibertec.dominio.Producto;
import pe.edu.cibertec.dominio.Usuario;
import pe.edu.cibertec.model.ProductoModel;
import pe.edu.cibertec.model.UsuarioModel;

import java.math.BigDecimal;

/**
 * Created by CHRISTIAN on 14/04/2018.
 */
public class ModelToDomainMapper {

    private PropertyMap<ProductoModel, Producto> fromProductoModelToProductoMap;
    private PropertyMap<UsuarioModel, Usuario> fromUsuarioModelToUsuarioMap;

    public ModelToDomainMapper(){
        this.fromProductoModelToProductoMap = new PropertyMap<ProductoModel, Producto>() {
            @Override
            protected void configure() {
                this.map().setId(source.getId());
                this.map().setNombre(source.getNombre());
                this.map().setDescripcion(source.getDescripcion());
                this.map().setImagen(source.getImagen());
                this.map().setPrecio(new BigDecimal(source.getPrecio()));
                this.skip().setCategoria(null);
            }
        };
        this.fromUsuarioModelToUsuarioMap = new PropertyMap<UsuarioModel, Usuario>() {
            @Override
            protected void configure() {
                this.skip().setId(null);
                this.map().setNombre(source.getNombre());
                this.map().setApellido(source.getApellido());
                this.skip().setFechaNacimiento(null);
            }
        };
    }

    public PropertyMap<ProductoModel, Producto> getFromProductoModelToProductoMap() {
        return fromProductoModelToProductoMap;
    }

    public PropertyMap<UsuarioModel, Usuario> getFromUsuarioModelToUsuarioMap() {
        return fromUsuarioModelToUsuarioMap;
    }
}
