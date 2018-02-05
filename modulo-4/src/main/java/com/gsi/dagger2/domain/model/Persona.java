package com.gsi.dagger2.domain.model;

/**
 * Created by Ronaldo Geldres on 31/01/2018.
 */

public class Persona {

    private String nombre;

    public Persona(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }
}
