/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.managed;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
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
        return "principal.xhtml";
    }
    
    public String mostrar(){
        return "pages/cliente/detalle";
    }
    
    public String crear(){
        return "nuevo.xhtml";
    }    
    
    public String guardar(Cliente cliente){
        return "resultado.xhtml";
    }
    
    public String listar(){
        clientes = dao.listarCliente();
        return "pages/cliente/listar.xhtml";
    }
    
    public String editar(){
        return "pages/cliente/editar.xhtml";
    }
    
    public String actualizar(Cliente cliente){
        return "pages/cliente/editar.xhtml";
    }
    
    public String eliminar(){
        return "pages/cliente/eliminar.xhtml";
    }
    
    
    public void mensajeProfesion(ValueChangeEvent e){
        String valor = (String)e.getNewValue();
        if(valor.equals("001")){
            setMensaje("Tenemos los mejores cursos de arquitectura");
        }
        if(valor.equals("002")){
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
