package com.xulioxesus;

public class ContaBancaria {

    //Atributos

    private String titular;
    private double saldo;
    private boolean bloqueada;

    //Métodos que definen o comportamento

    public ContaBancaria(String titular){
        this.titular = titular;
    }

    public ContaBancaria(String titular, double saldoInicial) {
        if (titular == null || titular.isBlank()) {
            throw new IllegalArgumentException("Titular non válido");
        }

        if (saldoInicial < 0) {
            throw new IllegalArgumentException("Saldo negativo");
        }

        this.titular = titular;
        this.saldo = saldoInicial;
        this.bloqueada = true;
    }

    public void ingresar(double cantidade) {
        if (bloqueada) {
            throw new IllegalStateException("Conta bloqueada");
        }

        if (cantidade <= 0) {
            throw new IllegalArgumentException("Cantidade non válida");
        }

        saldo += cantidade;
    }

    public void retirar(double cantidade) {
        if (bloqueada) {
            throw new IllegalStateException("Conta bloqueada");
        }

        if (cantidade <= 0) {
            throw new IllegalArgumentException("Cantidade non válida");
        }

        if (cantidade > saldo) {
            throw new IllegalArgumentException("Saldo insuficiente");
        }

        saldo -= cantidade;
    }

    public void transferir(ContaBancaria destino, double cantidade) {
        if (destino == null) {
            throw new IllegalArgumentException("Destino non válido");
        }

        if (destino.bloqueada) {
            throw new IllegalStateException("Conta destino bloqueada");
        }

        retirar(cantidade);
        destino.ingresar(cantidade);
    }

    public void bloquear() {
        bloqueada = true;
    }

    public void desbloquear() {
        bloqueada = false;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTitular() {
        return titular;
    }

    public boolean isBloqueada() {
        return bloqueada;
    }

    public static void main(String[] args) {
        ContaBancaria conta2  = new ContaBancaria("Pepito");
        ContaBancaria conta = new ContaBancaria("Julio", 100);
        conta.ingresar(200);
        conta.retirar(100);
        String kk = "julio";
    }
}