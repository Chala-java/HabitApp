package com.example.backend_Habit_App.domain.application.dto;

import com.example.backend_Habit_App.domain.model.ApartamentoEnum;
import java.time.LocalDate;

public class ContratoDTO {

    private Long id;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String estado;
    private double valorRenta;
    private String frecuenciaPago;
    private double deposito;

    // Propietario
    private Long idPropietario;
    private String nombrePropietario;
    private String apellidoPropietario;
    private Long cedulaPropietario;
    private String correoPropietario;
    private String telefonoPropietario;
    private Long numeroCuentaPropietario;
    private String metodoPagoPropietario;

    // Inquilino
    private Long idInquilino;
    private String nombreInquilino;
    private String apellidoInquilino;
    private Long cedulaInquilino;
    private String correoInquilino;
    private String telefonoInquilino;

    //Apartamento

    private Integer numeroApartamento;
    private ApartamentoEnum estadoApartamento;
    private Integer piso;
    private  double valorDeRenta;
    private String descripcion;


    public ContratoDTO(){}

    public ContratoDTO(Long id, LocalDate fechaInicio, LocalDate fechaFin, String estado, double valorRenta, String frecuenciaPago, double deposito, Long idPropietario, String nombrePropietario, String apellidoPropietario, Long cedulaPropietario, String correoPropietario, String telefonoPropietario, Long numeroCuentaPropietario, String metodoPagoPropietario, Long idInquilino, String nombreInquilino, String apellidoInquilino, Long cedulaInquilino, String correoInquilino, String telefonoInquilino, Integer numeroApartamento, ApartamentoEnum estadoApartamento, Integer piso, double valorDeRenta, String descripcion) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
        this.valorRenta = valorRenta;
        this.frecuenciaPago = frecuenciaPago;
        this.deposito = deposito;
        this.idPropietario = idPropietario;
        this.nombrePropietario = nombrePropietario;
        this.apellidoPropietario = apellidoPropietario;
        this.cedulaPropietario = cedulaPropietario;
        this.correoPropietario = correoPropietario;
        this.telefonoPropietario = telefonoPropietario;
        this.numeroCuentaPropietario = numeroCuentaPropietario;
        this.metodoPagoPropietario = metodoPagoPropietario;
        this.idInquilino = idInquilino;
        this.nombreInquilino = nombreInquilino;
        this.apellidoInquilino = apellidoInquilino;
        this.cedulaInquilino = cedulaInquilino;
        this.correoInquilino = correoInquilino;
        this.telefonoInquilino = telefonoInquilino;
        this.numeroApartamento = numeroApartamento;
        this.estadoApartamento = estadoApartamento;
        this.piso = piso;
        this.valorDeRenta = valorDeRenta;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getValorRenta() {
        return valorRenta;
    }

    public void setValorRenta(double valorRenta) {
        this.valorRenta = valorRenta;
    }

    public String getFrecuenciaPago() {
        return frecuenciaPago;
    }

    public void setFrecuenciaPago(String frecuenciaPago) {
        this.frecuenciaPago = frecuenciaPago;
    }

    public double getDeposito() {
        return deposito;
    }

    public void setDeposito(double deposito) {
        this.deposito = deposito;
    }

    public Long getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(Long idPropietario) {
        this.idPropietario = idPropietario;
    }

    public String getNombrePropietario() {
        return nombrePropietario;
    }

    public void setNombrePropietario(String nombrePropietario) {
        this.nombrePropietario = nombrePropietario;
    }

    public String getApellidoPropietario() {
        return apellidoPropietario;
    }

    public void setApellidoPropietario(String apellidoPropietario) {
        this.apellidoPropietario = apellidoPropietario;
    }

    public Long getCedulaPropietario() {
        return cedulaPropietario;
    }

    public void setCedulaPropietario(Long cedulaPropietario) {
        this.cedulaPropietario = cedulaPropietario;
    }

    public String getCorreoPropietario() {
        return correoPropietario;
    }

    public void setCorreoPropietario(String correoPropietario) {
        this.correoPropietario = correoPropietario;
    }

    public String getTelefonoPropietario() {
        return telefonoPropietario;
    }

    public void setTelefonoPropietario(String telefonoPropietario) {
        this.telefonoPropietario = telefonoPropietario;
    }

    public Long getNumeroCuentaPropietario() {
        return numeroCuentaPropietario;
    }

    public void setNumeroCuentaPropietario(Long numeroCuentaPropietario) {
        this.numeroCuentaPropietario = numeroCuentaPropietario;
    }

    public String getMetodoPagoPropietario() {
        return metodoPagoPropietario;
    }

    public void setMetodoPagoPropietario(String metodoPagoPropietario) {
        this.metodoPagoPropietario = metodoPagoPropietario;
    }

    public Long getIdInquilino() {
        return idInquilino;
    }

    public void setIdInquilino(Long idInquilino) {
        this.idInquilino = idInquilino;
    }

    public String getNombreInquilino() {
        return nombreInquilino;
    }

    public void setNombreInquilino(String nombreInquilino) {
        this.nombreInquilino = nombreInquilino;
    }

    public String getApellidoInquilino() {
        return apellidoInquilino;
    }

    public void setApellidoInquilino(String apellidoInquilino) {
        this.apellidoInquilino = apellidoInquilino;
    }

    public Long getCedulaInquilino() {
        return cedulaInquilino;
    }

    public void setCedulaInquilino(Long cedulaInquilino) {
        this.cedulaInquilino = cedulaInquilino;
    }

    public String getCorreoInquilino() {
        return correoInquilino;
    }

    public void setCorreoInquilino(String correoInquilino) {
        this.correoInquilino = correoInquilino;
    }

    public String getTelefonoInquilino() {
        return telefonoInquilino;
    }

    public void setTelefonoInquilino(String telefonoInquilino) {
        this.telefonoInquilino = telefonoInquilino;
    }

    public Integer getNumeroApartamento() {
        return numeroApartamento;
    }

    public void setNumeroApartamento(Integer numeroApartamento) {
        this.numeroApartamento = numeroApartamento;
    }

    public ApartamentoEnum getEstadoApartamento() {
        return estadoApartamento;
    }

    public void setEstadoApartamento(ApartamentoEnum estadoApartamento) {
        this.estadoApartamento = estadoApartamento;
    }

    public Integer getPiso() {
        return piso;
    }

    public void setPiso(Integer piso) {
        this.piso = piso;
    }

    public double getValorDeRenta() {
        return valorDeRenta;
    }

    public void setValorDeRenta(double valorDeRenta) {
        this.valorDeRenta = valorDeRenta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
