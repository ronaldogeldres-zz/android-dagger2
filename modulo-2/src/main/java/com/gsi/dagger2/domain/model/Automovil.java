package com.gsi.dagger2.domain.model;

/**
 * Created by Ronaldo Geldres on 31/01/2018.
 */

public class Automovil {

    private Motor motor;

    public Automovil(Motor motor){
        this.motor = motor;
    }

    public String getMotor(){
        return ("coche con " + motor.getTipoMotor());
    }
}
