package com.restprueba.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import servicio.AgregarEmpleado;
import servicio.AgregarEmpleadoResponse;
import servicio.Empleado;
import servicio.ObjectFactory;

import javax.xml.bind.JAXBElement;

@Service
@Component("agregarEmpleado")
public class SoapClient extends WebServiceGatewaySupport {

    private String endpoint = "http://localhost:8080/ServicioWebService/ServicioWeb?WSDL";

    public void agregarEmpleado(Empleado empleado){
        AgregarEmpleado request = new AgregarEmpleado();
        request.setArg0(empleado);

        JAXBElement<AgregarEmpleado> jaxbElement = new ObjectFactory().createAgregarEmpleado(request);
        JAXBElement<AgregarEmpleadoResponse> response = (JAXBElement<AgregarEmpleadoResponse>) getWebServiceTemplate().marshalSendAndReceive(endpoint, jaxbElement);
    }
}
