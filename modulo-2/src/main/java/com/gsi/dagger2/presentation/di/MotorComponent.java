package com.gsi.dagger2.presentation.di;

import com.gsi.dagger2.presentation.ui.MainActivity;

import dagger.Component;

/**
 * Created by Ronaldo Geldres on 31/01/2018.
 */

@Component(modules = {MotorModule.class})
public interface MotorComponent {

    void inject(MainActivity mainActivity);
}
