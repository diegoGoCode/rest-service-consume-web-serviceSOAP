package com.restprueba.controllers;

import com.restprueba.dto.Empleado;
import com.restprueba.services.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
public class EmpleadoRestController {

    @Autowired
    IEmpleadoService empleadoService;

    @RequestMapping(value = "/agregarEmpleado", method = RequestMethod.GET)
    public ResponseEntity<?> agregarEmpleado(@RequestParam(value = "nombres") String nombres, @RequestParam(value = "apellidos") String apellidos,
                                         @RequestParam(value = "tipo_documento") String tipoDocumento, @RequestParam(value = "numero_documento") String numeroDocumento,
                                         @RequestParam(value = "fecha_nacimiento") String fechaNacimiento, @RequestParam(value = "fecha_vinculacion") String fechaVinculacion,
                                         @RequestParam(value = "cargo") String cargo, @RequestParam(value = "salario") Double salario) throws ParseException {

        Empleado empleado = new Empleado(nombres,apellidos,tipoDocumento,numeroDocumento,fechaNacimiento,fechaVinculacion,cargo,salario);
        return empleadoService.agregarEmpleado(empleado);
    }
}
