package pe.edu.cibertec.util;

import org.modelmapper.ModelMapper;

import javax.enterprise.inject.Produces;

/**
 * Created by CHRISTIAN on 15/04/2018.
 */
public class ModelMapperFactory {

    @Produces
    public ModelMapper createModelMapper(){
        return new ModelMapper();
    }
}
