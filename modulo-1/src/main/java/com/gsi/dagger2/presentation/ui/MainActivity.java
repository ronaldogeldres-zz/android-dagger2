package com.gsi.dagger2.presentation.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.gsi.dagger2.R;
import com.gsi.dagger2.domain.model.Automovil;
import com.gsi.dagger2.domain.model.Motor;
import com.gsi.dagger2.presentation.MotorApplication;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Inject
    Motor motor;

    @Inject
    Motor motor2;

    @Inject
    Motor motor3;

    @Inject
    Automovil automovil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((MotorApplication)getApplication()).getMotorComponent().inject(this);

        Toast.makeText(MainActivity.this, motor.getTipoMotor(), Toast.LENGTH_SHORT).show();

        Toast.makeText(MainActivity.this, automovil.getMotor(), Toast.LENGTH_SHORT).show();
    }
}
