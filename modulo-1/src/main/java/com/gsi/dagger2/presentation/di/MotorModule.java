package com.gsi.dagger2.presentation.di;

import com.gsi.dagger2.domain.model.Automovil;
import com.gsi.dagger2.domain.model.Motor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ronaldo Geldres on 31/01/2018.
 */

@Module
public class MotorModule {

    @Singleton
    @Provides
    public Motor providesMotorDiesel(){
        return new Motor("diesel");
    }

    @Provides
    public Automovil providesAutomovil(Motor motor){
        return new Automovil(motor);
    }

    /**
     * NOTA: Basta que un metodo sea singleton y por obligacion el componente que posee este modulo debe ser singleton.
     * En cambio, si colocas la anotacionsingleton al componente, no sucede nada si tus provides dentro del modulo no poseen
     * esa anotacion
     */

    /**
     * NOTA: Cuando colocas un metodo dentro del modulo como @Singleton al momento injectar tus objetocs en este caso motor, todos
     * tendran asisganadas las mismas direcciones de memoria. En caso, no posean el @Singleton, todos tus objetos motor
     * tendran direcciones de memoria diferentes. Ademas, debes leer el texto de abajo para que comprendas que hace exactamnete
     * esta anotacion.
     */

    /**
     * ¿Que hace exactamente la anotacion singleton?
     * @Singleton (and any other scope annotation) makes your class
     * a single instance in your dependencies graph (it means that this instance will be "singleton" as long as Component
     * object exists).
     *
     * In short - everytime you're injecting @Singleton annotated class (with @Inject annotation)
     * it will be the same instance as long as you inject it from the same Component.
     *
     * @Singleton does not really create a Singleton, it is just a Scope, it is advised to not use @Singleton as it is misleading,
     * it gives the impression that we are infact getting a Singleton, but we are not.
     *
     * Let's say you annotate your database dependency with @Singleton and link with a Component,
     * now let's say that you initialise this Component in Activities A and B,
     * you will have different instances of your database in your two Activities which is something most people don't want.
     *
     * How do you overcome this?
     *
     * Initialise your Component once in your Application class and access it statically in other places
     * like Activities or Fragments, now this could soon get out of hand if you have more than 20 Component's as you cannot
     * initialise all of them in your Application class, doing so will also slow down your app launch time.
     *
     * The best solution according to me is to create a real Singleton, either double checked or
     * of other variants and use this statically as getInstance() and use this under @Provides in your Module.
     *
     * I know it breaks my heart too, but please understand that @Singleton is not really a Singleton, it's a Scope.
     */
}
