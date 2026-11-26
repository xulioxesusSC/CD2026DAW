package com.xulioxesus;

public class Main {

    public static void matar(Animal a){
        a.morrer();
    }
    public static void main(String[] args) {
        Animal bicho = new Animal();
        bicho.comer();
        matar(bicho);
    
        Perro miPerro = new Perro();
        miPerro.comer(); // Llamada al método heredado de la clase Animal
        miPerro.ladrar(); // Llamada al método específico de la clase Perro 
        matar(miPerro);
    }
}