package pe.edu.cibertec.mapper;

import org.modelmapper.PropertyMap;
import pe.edu.cibertec.dominio.Producto;
import pe.edu.cibertec.dominio.Usuario;
import pe.edu.cibertec.model.ProductoModel;
import pe.edu.cibertec.model.UsuarioModel;

/**
 * Created by CHRISTIAN on 14/04/2018.
 */
public class DomainToModelMapper {

    private PropertyMap<Producto, ProductoModel> fromProductoToProductoModelMap;
    private PropertyMap<Usuario, UsuarioModel> fromUsuarioToUsuarioModelMap;

    public DomainToModelMapper(){
        this.fromProductoToProductoModelMap = new PropertyMap<Producto, ProductoModel>() {
            @Override
            protected void configure() {
                this.map().setId(source.getId());
                this.map().setNombre(source.getNombre());
                this.map().setDescripcion(source.getDescripcion());
                this.map().setImagen(source.getImagen());
                this.map().setPrecio(source.getPrecio().doubleValue());
                this.map().setCategoria(source.getCategoria().getNombre());
            }
        };
        this.fromUsuarioToUsuarioModelMap = new PropertyMap<Usuario, UsuarioModel>() {
            @Override
            protected void configure() {
                this.map().setNombre(source.getNombre());
                this.map().setApellido(source.getApellido());
            }
        };
    }

    public PropertyMap<Producto, ProductoModel> getFromProductoToProductoModelMap() {
        return fromProductoToProductoModelMap;
    }

    public PropertyMap<Usuario, UsuarioModel> getFromUsuarioToUsuarioModelMap() {
        return fromUsuarioToUsuarioModelMap;
    }
}
