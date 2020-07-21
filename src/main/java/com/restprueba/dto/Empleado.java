package com.restprueba.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Empleado {
    private String nombres;
    private String apellidos;
    private String tipo_documento;
    private String numero_documento;
    private Date fecha_nacimiento;
    private Date fecha_vinculacion;
    private String cargo;
    private Double salario;

    public Empleado() {
    }

    public Empleado(String nombres, String apellidos, String tipo_documento, String numero_documento, String fecha_nacimiento, String fecha_vinculacion, String cargo, Double salario) throws ParseException {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        formatoFecha.setLenient(false);
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.tipo_documento = tipo_documento;
        this.numero_documento = numero_documento;
        this.fecha_nacimiento =  (fecha_nacimiento.isEmpty()) ? null : formatoFecha.parse(fecha_nacimiento);
        this.fecha_vinculacion = (fecha_vinculacion.isEmpty()) ? null : formatoFecha.parse(fecha_vinculacion);
        this.cargo = cargo;
        this.salario = salario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getNumero_documento() {
        return numero_documento;
    }

    public void setNumero_documento(String numero_documento) {
        this.numero_documento = numero_documento;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Date getFecha_vinculacion() {
        return fecha_vinculacion;
    }

    public void setFecha_vinculacion(Date fecha_vinculacion) {
        this.fecha_vinculacion = fecha_vinculacion;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }
}
