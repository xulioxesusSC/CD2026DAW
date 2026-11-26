package com.xulioxesus;

public class Animal {
    
    private String especie;

    public void definirEspecie(String especie){
        especie = this.especie;
    }

    void comer() {
        System.out.println("Este animal come.");
    }

    void morrer() {
        System.out.println("morro...");
    }
}