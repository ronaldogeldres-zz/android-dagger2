package com.gsi.dagger2.presentation;

import android.app.Application;

import com.gsi.dagger2.presentation.di.component.DaggerParentComponent;
import com.gsi.dagger2.presentation.di.component.ParentComponent;
import com.gsi.dagger2.presentation.di.module.ParentModule;

/**
 * Created by Ronaldo Geldres on 31/01/2018.
 */

public class MyApplication extends Application {

    private ParentComponent parentComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        parentComponent = DaggerParentComponent.builder().parentModule(new ParentModule()).build();
    }

    public ParentComponent getParentComponent(){
        return parentComponent;
    }
}
