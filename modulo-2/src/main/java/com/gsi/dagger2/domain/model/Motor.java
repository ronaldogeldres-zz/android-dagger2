package com.gsi.dagger2.domain.model;

/**
 * Created by Ronaldo Geldres on 31/01/2018.
 */

public class Motor {

    private String tipoMotor;

    public Motor(String tipoMotor){
        this.tipoMotor = tipoMotor;
    }

    public String getTipoMotor(){
        return ("Motor: " + tipoMotor);
    }
}
