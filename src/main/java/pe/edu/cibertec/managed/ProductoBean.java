package pe.edu.cibertec.managed;

import pe.edu.cibertec.model.ProductoModel;
import pe.edu.cibertec.service.IProductoService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Collection;

/**
 * Created by CHRISTIAN on 15/04/2018.
 */
@ManagedBean(name = "productoBean")
@RequestScoped
public class ProductoBean {

    private ProductoModel producto = new ProductoModel();
    private String mensaje;
    private Collection<ProductoModel> productos;

    @Inject
    @Named("productoService")
    private IProductoService productoService;

    @PostConstruct
    public void init() {
    }

    public String principal() {
        return "home";
    }

    public String mostrar(Long codigo) {
        try {
            producto = productoService.obtener(codigo);
        } catch (Exception ex) {
        }
        return "product_detail";
    }

    public String listar(){
        try {
            productos = productoService.listar();
        } catch (Exception ex) {
        }
        return "product_list";
    }

    public IProductoService getProductoService() {
        return productoService;
    }

    public ProductoModel getProducto() {
        return producto;
    }

    public void setProducto(ProductoModel producto) {
        this.producto = producto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Collection<ProductoModel> getProductos() {
        return productos;
    }

    public void setProductos(Collection<ProductoModel> productos) {
        this.productos = productos;
    }

    public void setProductoService(IProductoService productoService) {
        this.productoService = productoService;
    }
}
