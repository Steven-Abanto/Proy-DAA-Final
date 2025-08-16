package com.idat.movimiento.infraestructure.adapters.movimiento;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "movimiento")
public class MovimientoData {

    public MovimientoData() {}

    public MovimientoData(int uid, String cuentaOrigen, String cuentaDestin, double monto, LocalDate fecha) {
        this.uid = uid;
        this.cuentaOrigen = cuentaOrigen;
        this.cuentaDestin = cuentaDestin;
        this.monto = monto;
        this.fecha = fecha;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid;

    @Column(name = "cuenta_origen", length = 18, nullable = false)
    private String cuentaOrigen;

    @Column(name = "cuenta_destin", length = 18, nullable = false)
    private String cuentaDestin;

    @Column(nullable = false)
    private double monto;

    @Column(nullable = false)
    private LocalDate fecha;

    // Getters y Setters
    public int getUid() {
        return uid;
    }
    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getCuentaOrigen() {
        return cuentaOrigen;
    }
    public void setCuentaOrigen(String cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
    }

    public String getCuentaDestin() {
        return cuentaDestin;
    }
    public void setCuentaDestin(String cuentaDestin) {
        this.cuentaDestin = cuentaDestin;
    }

    public double getMonto() {
        return monto;
    }
    public void setMonto(double monto) {
        this.monto = monto;
    }

    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
