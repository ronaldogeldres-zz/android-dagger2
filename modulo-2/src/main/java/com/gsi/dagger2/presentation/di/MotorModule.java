package com.gsi.dagger2.presentation.di;

import com.gsi.dagger2.domain.model.Automovil;
import com.gsi.dagger2.domain.model.Motor;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ronaldo Geldres on 31/01/2018.
 */

@Module
public class MotorModule {

    /**
     * NOTA: En primer lugar, entendamos este punto, aun no veas la anotacion @Named, supongamos que solo existe un metodo
     * que devuelve un objeto Motor, como te das cuenta el metodo providesAutomovil, recibe como parametro un objeto motor,
     * dagger 2 entiende que que ese objeto que necesita(Motor) debe obtenerlo del metodo que lo proporciona. Es decir, providesAutomovil
     * obtendra el argumento Motor del metodo que lo proporciones. En este caso supongamos providesMotorDiesel. Despues, lo utilizara
     * para crear un nuevo objeto Automovil, para luego devolverlo.
     */

    /**
     * NOTA: cuando quieras crear dos metodos que retornen el mismo objeto, se debe utilizar la anotacion @Named, porque? pues
     * debido a que si otro metodo recibe como argumento el objeto Motor, tu debes especificar que motor exactamente necesitas.
     * como podras observar en el metodo providesAutomovil.
     */

    @Named("diesel")
    @Provides
    public Motor providesMotorDiesel(){
        return new Motor("diesel");
    }

    @Named("gasolina")
    @Provides
    public Motor providesMotorGasolina(){
        return new Motor("gasolina");
    }

    @Provides
    public Automovil providesAutomovil(@Named("gasolina") Motor motor){
        return new Automovil(motor);
    }
}
