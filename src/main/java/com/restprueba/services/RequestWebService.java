package com.restprueba.services;

import com.restprueba.converter.EmpleadoConverter;
import com.restprueba.dto.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestWebService {

    @Autowired
    private SoapClient soapClient;

    @Autowired
    EmpleadoConverter empleadoConverte ;

    public void enviarSolicituWebService(Empleado empleadoRest){
        soapClient.agregarEmpleado(empleadoConverte.convertirEmpleadoRestAEmpleadoService(empleadoRest));
    }
}
