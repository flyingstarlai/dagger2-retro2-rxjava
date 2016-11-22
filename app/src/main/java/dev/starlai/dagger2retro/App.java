package dev.starlai.dagger2retro;

import android.app.Application;

import dev.starlai.dagger2retro.injection.components.AppComponent;
import dev.starlai.dagger2retro.injection.components.ApiServiceComponent;
import dev.starlai.dagger2retro.injection.components.DaggerApiServiceComponent;
import dev.starlai.dagger2retro.injection.components.DaggerAppComponent;
import dev.starlai.dagger2retro.injection.modules.ApiServiceModule;
import dev.starlai.dagger2retro.injection.modules.AppModule;
import dev.starlai.dagger2retro.injection.modules.NetModule;

/**
 * Created by izayoi on 11/22/2016.
 */

public class App extends Application {
    private AppComponent appComponent;
    private ApiServiceComponent apiComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("http://27.105.130.18:8000/"))
                .build();

        apiComponent = DaggerApiServiceComponent.builder()
                .appComponent(appComponent)
                .apiServiceModule(new ApiServiceModule())
                .build();

    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public ApiServiceComponent getApiComponent() {
        return apiComponent;
    }

}
