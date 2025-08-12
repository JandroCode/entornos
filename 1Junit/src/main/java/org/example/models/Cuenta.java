package org.example.models;

import org.example.exceptions.DineroInsuficienteException;

import java.math.BigDecimal;

public class Cuenta {

    private String persona;
    private BigDecimal saldo;
    private Banco banco;

    public  Cuenta(){}

    public Cuenta(String persona, BigDecimal saldo) {
        this.persona = persona;
        this.saldo = saldo;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public void debito(BigDecimal cantidad){
        // this.saldo = this.saldo.subtract(cantidad);

        BigDecimal nuevoSaldo = this.saldo.subtract(cantidad);
        if(nuevoSaldo.compareTo(BigDecimal.ZERO) < 0){
            throw new DineroInsuficienteException("Dinero insuficiente");
        }

        this.saldo = nuevoSaldo;

    }

    public void credito(BigDecimal cantidad){
        this.saldo = this.saldo.add(cantidad);
    }


}
