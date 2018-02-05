package com.gsi.dagger2.presentation.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.gsi.dagger2.R;
import com.gsi.dagger2.domain.model.Automovil;
import com.gsi.dagger2.domain.model.Motor;
import com.gsi.dagger2.presentation.MyApplication;
import com.gsi.dagger2.presentation.di.component.DaggerChildComponent;
import com.gsi.dagger2.presentation.di.component.DaggerParentComponent;
import com.gsi.dagger2.presentation.di.module.ChildModule;

import javax.inject.Inject;
import javax.inject.Named;

public class MainActivity extends AppCompatActivity {

    /**
     * NOTA: como puedes observar, los tres objetos de abajo pertencen al modulo ChildModule del componente
     * ChildComponent. Ademas, el objeto Automovil, para ser creado necesit de un objeto Motor, que en este escenario
     * es proporcionado por el ParentComponent
     */
    @Inject
    Automovil automovil;

    @Named("tipoMotor")
    @Inject
    String tipoMotor;

    @Named("nombre")
    @Inject
    String nombre;

    /**
     * NOTA: como puedes observar no solo puedo utilizar el objeto que me proporciona el padre en mis modulos, si no tambien
     * en donde lo estoy infectando, ya que motor es un objeto que lo da el ParentComponent.
     */
    @Inject
    Motor motor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * NOTA: no olvides colocar tu clase que extiende de aplicacion en tu AndroidManifest, o te saldra error de casteo.
         */
        /*DaggerChildComponent
                .builder()
                .parentComponent(((MyApplication)getApplication()).getParentComponent())
                .childModule(new ChildModule())
                .build()
                .inject(this);*/

        DaggerChildComponent
                .builder()
                .parentComponent(((MyApplication)getApplication()).getParentComponent())
                .build()
                .inject(this);

        /**
         * NOTA: las dos formas de inyectar que estan arriba son validas
         */


        /*DaggerChildComponent
                .builder()
                .childModule(new ChildModule())
                .build()
                .inject(this); - Esto dara error ya que solo creas el modulo del hijo y este modulo tiene dependencias del padre*/

        Toast.makeText(this, automovil.getMotor(), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, tipoMotor, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, nombre, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, motor.getTipoMotor(), Toast.LENGTH_SHORT).show();

    }
}
