package com.gsi.dagger2.presentation.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.gsi.dagger2.R;
import com.gsi.dagger2.domain.model.Automovil;
import com.gsi.dagger2.presentation.di.component.DaggerMainComponent;
import com.gsi.dagger2.presentation.di.module.FirstModule;
import com.gsi.dagger2.presentation.di.module.SecondModule;

import javax.inject.Inject;
import javax.inject.Named;


public class MainActivity extends AppCompatActivity {

    /**
     * Como te daras cuenta, los objetos que inyectas aqui abajo son proporcionados por el SecondModule, pero este
     * necesita un parametro Persona, que es proporcionado por el FirstModulo. Es decir que entre modulos se puede pasar referencias
     * si lo necesitan
     */
    @Named("nombrePersona")
    @Inject
    String nombrePersona;

    @Inject
    Automovil automovil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * A diferencia cuando inyectas un componente hijo que depende de un componente padre, cuando se trata de un componente
         * tiene varios modulos. Cualquiera de las formas que ves abajo, servira para inyectar las referencias de todos modulos.
         */

        /*DaggerMainComponent
                .builder()
                .firstModule(new FirstModule())
                .secondModule(new SecondModule())
                .build()
                .inject(this);*/

        /*DaggerMainComponent
                .builder()
                .secondModule(new SecondModule())
                .build()
                .inject(this);*/

        DaggerMainComponent
                .builder()
                .firstModule(new FirstModule())
                .build()
                .inject(this);

        Toast.makeText(this, nombrePersona, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Automovil pertenece a: " + automovil.getPersona().getNombre(), Toast.LENGTH_SHORT).show();
    }
}
