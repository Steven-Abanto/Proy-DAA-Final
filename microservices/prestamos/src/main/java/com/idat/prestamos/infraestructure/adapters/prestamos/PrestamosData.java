package com.idat.prestamos.infraestructure.adapters.prestamos;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "prestamo")
public class PrestamosData {

    public PrestamosData() {}

    public PrestamosData(int uid, String tipoPrestamo,LocalDate fecha) {
        this.uid = uid;
        this.tipoPrestamo = tipoPrestamo;
        this.fecha = fecha;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid;

    @Column(name = "tipo_prestamo", length = 20, nullable = false)
    private String tipoPrestamo;

    @Column(name = "monto", nullable = false)
    private BigDecimal monto;

    @Column(nullable = false)
    private LocalDate fecha;


    // Getters y Setters
    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getTipoPrestamo() {
        return tipoPrestamo;
    }

    public void setTipoPrestamo(String tipoPrestamo) {
        this.tipoPrestamo = tipoPrestamo;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
