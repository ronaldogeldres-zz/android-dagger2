package com.gsi.dagger2.presentation.di.component;

import com.gsi.dagger2.presentation.di.module.ChildModule;
import com.gsi.dagger2.presentation.ui.MainActivity;

import dagger.Component;

/**
 * Created by Ronaldo Geldres on 31/01/2018.
 */

@Component(dependencies = {ParentComponent.class}, modules = {ChildModule.class})
public interface ChildComponent {

    void inject(MainActivity mainActivity);
}
