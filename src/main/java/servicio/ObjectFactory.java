//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2020.07.19 a las 01:24:30 AM COT 
//


package servicio;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the servicio package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AgregarEmpleado_QNAME = new QName("http://servicio/", "agregarEmpleado");
    private final static QName _AgregarEmpleadoResponse_QNAME = new QName("http://servicio/", "agregarEmpleadoResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: servicio
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AgregarEmpleado }
     * 
     */
    public AgregarEmpleado createAgregarEmpleado() {
        return new AgregarEmpleado();
    }

    /**
     * Create an instance of {@link AgregarEmpleadoResponse }
     * 
     */
    public AgregarEmpleadoResponse createAgregarEmpleadoResponse() {
        return new AgregarEmpleadoResponse();
    }

    /**
     * Create an instance of {@link Empleado }
     * 
     */
    public Empleado createEmpleado() {
        return new Empleado();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AgregarEmpleado }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio/", name = "agregarEmpleado")
    public JAXBElement<AgregarEmpleado> createAgregarEmpleado(AgregarEmpleado value) {
        return new JAXBElement<AgregarEmpleado>(_AgregarEmpleado_QNAME, AgregarEmpleado.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AgregarEmpleadoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicio/", name = "agregarEmpleadoResponse")
    public JAXBElement<AgregarEmpleadoResponse> createAgregarEmpleadoResponse(AgregarEmpleadoResponse value) {
        return new JAXBElement<AgregarEmpleadoResponse>(_AgregarEmpleadoResponse_QNAME, AgregarEmpleadoResponse.class, null, value);
    }

}
