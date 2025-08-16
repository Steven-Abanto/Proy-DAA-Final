package com.idat.cuenta.infraestructure.adapters.cuenta;

import jakarta.persistence.*;

@Entity
@Table(name = "cuenta")
public class CuentaData {

    public CuentaData() {}

    public CuentaData(Integer uid, String nroCuenta, String tipoCuenta, int saldo, boolean compraInt) {
        this.uid = uid;
        this.nroCuenta = nroCuenta;
        this.tipoCuenta = tipoCuenta;
        this.saldo = saldo;
        this.compraInt = compraInt;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;

    @Column(name = "nro_cuenta", length = 18, nullable = false, unique = true)
    private String nroCuenta;

    @Column(name = "tipo_cuenta", length = 20, nullable = false)
    private String tipoCuenta;

    @Column(name = "saldo", nullable = false)
    private double saldo;

    @Column(name = "compra_int", nullable = false)
    private boolean compraInt;

    // getters y setters
    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getNroCuenta() {
        return nroCuenta;
    }

    public void setNroCuenta(String nroCuenta) {
        this.nroCuenta = nroCuenta;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public boolean isCompraInt() {
        return compraInt;
    }

    public void setCompraInt(boolean compraInt) {
        this.compraInt = compraInt;
    }
}
