package com.restprueba.services;

import com.restprueba.dto.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService {

    @Autowired
    RequestWebService request;

    @Override
    public ResponseEntity<?> agregarEmpleado(Empleado empleado) {
        List<String> errores = validarCamposEmpleado(empleado);
        Map<String, Object> response = new HashMap<>();

        if(errores.size() > 0){
            response.put("errors", errores);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        if(errores.size() == 0){
            request.enviarSolicituWebService(empleado);
        }

        response.put("tiempo_vinculacion(Años,Meses,Dias)", calcularTiempo(empleado.getFecha_vinculacion()));
        response.put("edad_actual_empleado(Años,Meses,Dias)", calcularTiempo(empleado.getFecha_nacimiento()));

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @Override
    public List<String> validarCamposEmpleado(Empleado empleado)  {
        List<String> errors = new ArrayList<>();
        Date fechaActual = new Date(System.currentTimeMillis());
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");

        if(empleado.getNombres().isEmpty()){
            errors.add("Los nombres son requeridos");
        }
        if (empleado.getApellidos().isEmpty()){
            errors.add("Los apellidos son requeridos");
        }
        if (empleado.getTipo_documento().isEmpty()){
            errors.add("El tipo de documento es requerido");
        }
        if(empleado.getNumero_documento().isEmpty()){
            errors.add("El numero de documento es requerido");
        }
        if(empleado.getFecha_nacimiento() == null){
            errors.add("La fecha de nacimiento es requerida");
        }
        if(empleado.getFecha_vinculacion() == null){
            errors.add("La fecha de vinculacion a la empresa es requerida");
        }
        if(empleado.getCargo().isEmpty()){
            errors.add("El cargo es requerido");
        }
        if(empleado.getSalario() == null){
            errors.add("El salario es requerido");
        }

        if(empleado.getFecha_nacimiento() != null) {
            if (this.calcularTiempo(empleado.getFecha_nacimiento())[0] < 18 && empleado.getFecha_nacimiento().after(fechaActual)) {
                errors.add("La fecha de nacimiento no puede superar la fecha actual: " + formatoFecha.format(fechaActual));
            }
            if ((this.calcularTiempo(empleado.getFecha_nacimiento()))[0] < 18){
                errors.add("El empleado debe ser mayor de edad");
            }
        }

        if(empleado.getFecha_nacimiento() != null){
            if(this.validarFormatoFecha(empleado.getFecha_nacimiento()) == false){
                errors.add("El formato de la fecha de nacimiento es invalido, debe ser: yyyy-MM-dd");
            }
        }

        if (empleado.getFecha_vinculacion() != null) {
            if (this.validarFormatoFecha(empleado.getFecha_vinculacion()) == false) {
                errors.add("El formato de la fecha de vinculacion es invalido, debe ser: yyyy-MM-dd");
            }
        }

        if(empleado.getFecha_vinculacion() != null) {
            if (empleado.getFecha_vinculacion().after(fechaActual)) {
                errors.add("La fecha de vinculacion del empleado no puede superar la fecha actual: " + formatoFecha.format(fechaActual));
            }
        }

        return errors;
    }

    @Override
    public int[] calcularTiempo(Date fecha){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fechaComoCadena = sdf.format(fecha);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaNac = LocalDate.parse(fechaComoCadena,fmt);
        LocalDate ahora = LocalDate.now();

        Period periodo = Period.between(fechaNac, ahora);
        int[] fechaNumeros = new int[3];

        fechaNumeros[0] = periodo.getYears();
        fechaNumeros[1] = periodo.getMonths();
        fechaNumeros[2] = periodo.getDays();

        return fechaNumeros;
    }

    @Override
    public boolean validarFormatoFecha(Date fechaIngreso) {
        String fecha = new SimpleDateFormat("yyyy-MM-dd").format(fechaIngreso);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            format.parse(fecha);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}
