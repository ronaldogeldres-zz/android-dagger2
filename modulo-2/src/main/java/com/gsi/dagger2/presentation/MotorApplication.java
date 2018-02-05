package com.gsi.dagger2.presentation;

import android.app.Application;

import com.gsi.dagger2.presentation.di.DaggerMotorComponent;
import com.gsi.dagger2.presentation.di.MotorComponent;
import com.gsi.dagger2.presentation.di.MotorModule;

/**
 * Created by Ronaldo Geldres on 31/01/2018.
 */

public class MotorApplication extends Application {

    private MotorComponent motorComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        motorComponent = DaggerMotorComponent.builder().motorModule(new MotorModule()).build();

    }

    public MotorComponent getMotorComponent(){
        return motorComponent;
    }
}
