package com.gsi.dagger2.presentation.di.module;

import com.gsi.dagger2.domain.model.Automovil;
import com.gsi.dagger2.domain.model.Persona;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ronaldo Geldres on 31/01/2018.
 */

@Module
public class SecondModule {

    @Named("nombrePersona")
    @Provides
    public String providesNamePersona(Persona persona){
        return persona.getNombre();
    }

    @Provides
    public Automovil providesPersona(Persona persona){
        return new Automovil(persona);
    }

}
