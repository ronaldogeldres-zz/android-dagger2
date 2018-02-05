package com.gsi.dagger2.presentation.di.component;

import com.gsi.dagger2.presentation.di.module.FirstModule;
import com.gsi.dagger2.presentation.di.module.SecondModule;
import com.gsi.dagger2.presentation.ui.MainActivity;

import dagger.Component;

/**
 * Created by Ronaldo Geldres on 31/01/2018.
 */

@dagger.Component(modules = {FirstModule.class, SecondModule.class})
public interface MainComponent {
    void inject(MainActivity mainActivity);
}
