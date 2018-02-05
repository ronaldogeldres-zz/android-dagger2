package com.gsi.dagger2.domain.model;

/**
 * Created by Ronaldo Geldres on 31/01/2018.
 */

public class Automovil {

    private Persona persona;

    public Automovil(Persona persona){
        this.persona = persona;
    }

    public Persona getPersona(){
        return persona;
    }
}
