package com.gsi.dagger2.presentation.di.module;

import com.gsi.dagger2.domain.model.Persona;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ronaldo Geldres on 31/01/2018.
 */


@Module
public class FirstModule {

    @Provides
    public Persona providesPersona(){
        return new Persona("Juan Perez");
    }
}
