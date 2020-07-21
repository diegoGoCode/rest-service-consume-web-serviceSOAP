package com.restprueba.converter;

import org.springframework.stereotype.Component;
import servicio.Empleado;

@Component
public class EmpleadoConverter {

    public Empleado convertirEmpleadoRestAEmpleadoService(com.restprueba.dto.Empleado empleadoServicioRest){
        Empleado empleadoServicioSOAP = new Empleado();
        empleadoServicioSOAP.setNombres(empleadoServicioRest.getNombres());
        empleadoServicioSOAP.setApellidos(empleadoServicioRest.getApellidos());
        empleadoServicioSOAP.setTipoDocumento(empleadoServicioRest.getTipo_documento());
        empleadoServicioSOAP.setNumeroDocumento(empleadoServicioRest.getNumero_documento());
        empleadoServicioSOAP.setFechaNacimiento(empleadoServicioRest.getFecha_nacimiento());
        empleadoServicioSOAP.setFechaVinculacion(empleadoServicioRest.getFecha_vinculacion());
        empleadoServicioSOAP.setCargo(empleadoServicioRest.getCargo());
        empleadoServicioSOAP.setSalario(empleadoServicioRest.getSalario());
        return empleadoServicioSOAP;
    }
}
