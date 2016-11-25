package com.appweava.androidstarter;

import android.app.Application;

import com.appweava.androidstarter.internal.di.component.AppComponent;
import com.appweava.androidstarter.internal.di.component.AppGraph;

import javax.inject.Inject;

/**
 * StarterApp
 * <p>
 * Application class for setting up all necessary dependencies throughout application.
 *
 * @author <a href="mailto:aaron@appweava.com">Aaron Weaver</a>
 * @date 6/25/16
 * @since 1.0.0
 */
public class StarterApp extends Application {

    @Inject AppInitializer appInitializer;

    protected AppGraph appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        initAppComponent();

        initApp();
    }

    /**
     * Initialize application DI component.
     * Protected visibility level for mock application overriding.
     *
     * @return
     *      Initialized {@link AppGraph}
     */
    protected void initAppComponent() {
        appComponent = AppComponent.Initializer.init(this);
        appComponent.inject(this);
    }

    /**
     * Initialize app with build type dependencies.
     * Protected visibility level for mock application overriding.
     */
    protected void initApp() {
        appInitializer.initAppDependencies(this);
    }

    /**
     * Provide app component as a dependency to other components.
     *
     * @return
     *      {@link AppGraph} to provide for dependent components
     */
    public AppGraph getAppComponent() {
        return this.appComponent;
    }
}
