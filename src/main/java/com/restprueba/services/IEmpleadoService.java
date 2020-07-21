package com.restprueba.services;

import com.restprueba.dto.Empleado;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface IEmpleadoService {
    public ResponseEntity<?> agregarEmpleado(Empleado empleado);
    public List<String> validarCamposEmpleado(Empleado empleado) throws ParseException;
    public int[] calcularTiempo(Date fecha);
    public boolean validarFormatoFecha(Date fechaIngreso);
}
