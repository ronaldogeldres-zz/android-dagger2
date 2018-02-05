package com.gsi.dagger2.presentation.di.module;

import com.gsi.dagger2.domain.model.Automovil;
import com.gsi.dagger2.domain.model.Motor;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ronaldo Geldres on 31/01/2018.
 */

@Module
public class ParentModule {

    /**
     * Metodo que provee un objeto Motor
     */
    @Provides
    public Motor providesMotorDiesel(){
        return new Motor("diesel");
    }

    /**
     * Metodo que provee un objeto Automovil
     */
    @Provides
    public Automovil providesCoche(Motor motor){
        return new Automovil(motor);
    }
}
