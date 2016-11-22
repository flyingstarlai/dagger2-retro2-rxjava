package dev.starlai.dagger2retro.injection.components;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Subcomponent;
import dev.starlai.dagger2retro.ApiService;
import dev.starlai.dagger2retro.MainActivity;
import dev.starlai.dagger2retro.injection.modules.ApiServiceModule;
import dev.starlai.dagger2retro.injection.modules.NetModule;
import dev.starlai.dagger2retro.injection.scope.NetScope;

/**
 * Created by izayoi on 11/22/2016.
 */
@NetScope
@Component(dependencies = AppComponent.class, modules = ApiServiceModule.class)
public interface ApiServiceComponent {
    void inject(MainActivity activity);
}
