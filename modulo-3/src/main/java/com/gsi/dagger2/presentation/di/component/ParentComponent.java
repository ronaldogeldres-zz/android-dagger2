package com.gsi.dagger2.presentation.di.component;

import com.gsi.dagger2.domain.model.Automovil;
import com.gsi.dagger2.domain.model.Motor;
import com.gsi.dagger2.presentation.di.module.ParentModule;

import dagger.Component;

/**
 * Created by Ronaldo Geldres on 31/01/2018.
 */

@Component(modules = {ParentModule.class})
public interface ParentComponent {

    /**
     * La pregunta que surge aqui es, porque declaro un metodo que tiene como retorno un objeto Motor. El nombre del
     * metodo no importa, importa su valor de retorno. Cuando creas un componente padre, y a su vez tienes un componente hijo, cuyos
     * modulos necesitan un objeto que el padre provee. Tienes que declarar los metodos aqui. Es decir, como vez en este ejemplo, tengo
     * un componente llamado ChildComponent. Este tiene un modulo llamado ChildModule, dentro de el hay un metodo providesMotor que recibe
     * como parametro un objeto Motor, para devolver el tipo de ese motor. Entonces, como vez en el modulo hijo algunos metodos
     * necesitan de un objeto motor. Este es solo proporcionado por el padre, pero para que el padre pueda proporcionar objetos a sus hijos
     * este debe declararlos en su interface componente. ya que aunque poseaa en su modulo un metodo que proporcione un objeto motor. Si no
     * lo declaras en tu interface componente no podras darle esa referencia a tus hijos.
     */
    Motor getMotor();
}
