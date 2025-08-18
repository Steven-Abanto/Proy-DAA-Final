package com.idat.prestamos.infraestructure.adapters.prestamos;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
@Table(name = "prestamo_detalle")
public class PrestamoDetalleData {

    public PrestamoDetalleData() {}

    public PrestamoDetalleData(Integer uid, Integer uid_prestamo, String uidCuenta, BigDecimal montoPrestamo, BigDecimal tasaInt, int cuotas, BigDecimal deuda_cuota, BigDecimal deuda_total, LocalDate fecha) {
        this.uid = uid;
        this.uid_prestamo = uid_prestamo;
        this.uidCuenta = uidCuenta;
        this.montoPrestamo = montoPrestamo;
        this.tasaInt = tasaInt;
        this.cuotas = cuotas;
        this.deuda_cuota = deuda_cuota;
        this.deuda_total = deuda_total;
        this.fecha = fecha;

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;

    @Column(name = "uid_prestamo", nullable = false)
    private Integer uid_prestamo;

    @Column(name = "uid_cuenta", nullable = false)
    private String uidCuenta;

    @Column(name = "monto_prestamo", nullable = false)
    private BigDecimal montoPrestamo;

    @Column(name = "tasa_int", nullable = false, precision = 5, scale = 2)
    private BigDecimal tasaInt;

    @Column(nullable = false)
    private int cuotas;

    @Column(name = "deuda_cuota", nullable = false)
    private BigDecimal deuda_cuota;

    @Column(name = "deuda_total", nullable = false)
    private BigDecimal deuda_total;

    @Column(nullable = false)
    private LocalDate fecha;

    //Getters y Setters
    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getUid_prestamo() {
        return uid_prestamo;
    }

    public void setUid_prestamo(Integer uid_prestamo) {
        this.uid_prestamo = uid_prestamo;
    }

    public String getUidCuenta() {
        return uidCuenta;
    }

    public void setUidCuenta(String uidCuenta) {
        this.uidCuenta = uidCuenta;
    }

    public BigDecimal getMontoPrestamo() {
        return montoPrestamo;
    }

    public void setMontoPrestamo(BigDecimal montoPrestamo) {
        this.montoPrestamo = montoPrestamo;
    }

    public BigDecimal getTasaInt() {
        return tasaInt;
    }

    public void setTasaInt(BigDecimal tasaInt) {
        this.tasaInt = tasaInt;
    }

    public int getCuotas() {
        return cuotas;
    }

    public void setCuotas(int cuotas) {
        this.cuotas = cuotas;
    }

    public BigDecimal getDeuda_cuota() {
        return deuda_cuota;
    }

    public void setDeuda_cuota(BigDecimal deuda_cuota) {
        this.deuda_cuota = deuda_cuota;
    }

    public BigDecimal getDeuda_total() {
        return deuda_total;
    }

    public void setDeuda_total(BigDecimal deuda_total) {
        this.deuda_total = deuda_total;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
