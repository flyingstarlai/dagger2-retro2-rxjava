package dev.starlai.dagger2retro.injection.components;

import javax.inject.Singleton;

import dagger.Component;
import dev.starlai.dagger2retro.MainActivity;
import dev.starlai.dagger2retro.ServiceInterceptor;
import dev.starlai.dagger2retro.injection.modules.AppModule;
import dev.starlai.dagger2retro.injection.modules.NetModule;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by izayoi on 11/22/2016.
 */
@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface AppComponent {
    Retrofit.Builder retrofit();
    OkHttpClient okHttpClient();
    ServiceInterceptor interceptor();

}
