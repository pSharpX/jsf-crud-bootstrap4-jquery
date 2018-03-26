/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.managed;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;
import javax.inject.Named;
import pe.edu.cibertec.dao.DaoCliente;
import pe.edu.cibertec.model.Cliente;

/**
 *
 * @author Java-LM
 */
//@Named("clienteBean")
@ManagedBean(name = "clienteBean")
@SessionScoped
public class ClienteBean {
    
    private Cliente cliente = new Cliente();
    private String mensaje;
    private List<Cliente> clientes;
    
    @Inject
    @Named("mockDaoCliente")
    private DaoCliente dao;
    
    @PostConstruct
    public void init(){
    }
    
    public String principal(){
        return "home";
    }
    
    public String mostrar(Integer codigo){
        cliente = dao.obtenerCliente(codigo);
        return "customer_detail";
    }
    
    public String crear(){
        cliente = new Cliente();
        return "customer_create";
    }    
    
    public String guardar(Cliente cliente){
        return "result";
    }
    
    public String listar(){
        clientes = dao.listarCliente();
        return "customer_list";
    }
    
    public String editar(Integer codigo ){
        cliente = dao.obtenerCliente(codigo);
        return "customer_edit";
    }
    
    public String actualizar(Cliente cliente){
        return "result";
    }
    
    public String eliminar(Integer codigo){
        cliente = dao.obtenerCliente(codigo);
        return "customer_delete";
    }
    
    
    public void mensajeProfesion(ValueChangeEvent e){
        String valor = (String)e.getNewValue();
        if("001".equals(valor)){
            setMensaje("Tenemos los mejores cursos de arquitectura");
        }
        if("002".equals(valor)){
            setMensaje("Grandes eventos esperan por ti");
        }
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public DaoCliente getDao() {
        return dao;
    }

    public void setDao(DaoCliente dao) {
        this.dao = dao;
    }    
}
