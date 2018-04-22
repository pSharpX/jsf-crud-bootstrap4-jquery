package pe.edu.cibertec.managed;

import pe.edu.cibertec.model.CarritoModel;
import pe.edu.cibertec.model.DetalleCarritoModel;
import pe.edu.cibertec.service.CarritoService;
import pe.edu.cibertec.service.DetalleCarritoService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Collection;

/**
 * Created by CHRISTIAN on 15/04/2018.
 */
@ManagedBean(name = "carritoBean")
@SessionScoped
public class CarritoBean {

    private String mensaje;
    private CarritoModel carritoModel = new CarritoModel();
    private Collection<CarritoModel> carritoModels;
    private Collection<DetalleCarritoModel> detalleCarritoModels;

    @Inject
    @Named("carritoService")
    private CarritoService carritoService;

    @Inject
    @Named("detalleCarritoService")
    private DetalleCarritoService detalleCarritoService;

    @PostConstruct
    public void init() {
    }

    public String listar(){
        return "";
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public CarritoModel getCarritoModel() {
        return carritoModel;
    }

    public void setCarritoModel(CarritoModel carritoModel) {
        this.carritoModel = carritoModel;
    }

    public Collection<CarritoModel> getCarritoModels() {
        return carritoModels;
    }

    public void setCarritoModels(Collection<CarritoModel> carritoModels) {
        this.carritoModels = carritoModels;
    }

    public Collection<DetalleCarritoModel> getDetalleCarritoModels() {
        return detalleCarritoModels;
    }

    public void setDetalleCarritoModels(Collection<DetalleCarritoModel> detalleCarritoModels) {
        this.detalleCarritoModels = detalleCarritoModels;
    }

    public CarritoService getCarritoService() {
        return carritoService;
    }

    public void setCarritoService(CarritoService carritoService) {
        this.carritoService = carritoService;
    }

    public DetalleCarritoService getDetalleCarritoService() {
        return detalleCarritoService;
    }

    public void setDetalleCarritoService(DetalleCarritoService detalleCarritoService) {
        this.detalleCarritoService = detalleCarritoService;
    }
}
