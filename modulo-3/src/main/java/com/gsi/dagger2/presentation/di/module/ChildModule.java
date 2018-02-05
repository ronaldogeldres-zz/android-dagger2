package com.gsi.dagger2.presentation.di.module;

import com.gsi.dagger2.domain.model.Automovil;
import com.gsi.dagger2.domain.model.Motor;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ronaldo Geldres on 31/01/2018.
 */

@Module
public class ChildModule {

    /**
     * Motor obtenido del componente padre. Este posee un metodo dentro de su modulo que retorna un objeto Motor, pero que
     * si no lo declara dentro de su interface componente, no podra pasarle esa referencia a sus hijos
     */
    @Provides
    public Automovil providesAutomovil(Motor motor){
        return new Automovil(motor);
    }

    /**
     * Motor obtenido del componente padre.
     */
    @Named("tipoMotor")
    @Provides
    public String providesMotor(Motor motor){
        return motor.getTipoMotor();
    }

    @Named("nombre")
    @Provides
    public String providesNombre(){
        return "Nombre";
    }

    @Named("map")
    @Provides
    public Map<String, String> providesMap(){
        Map<String, String> map = new HashMap<>();
        map.put("a", "b");
        map.put("c", "d");
        return map;
    }
}
