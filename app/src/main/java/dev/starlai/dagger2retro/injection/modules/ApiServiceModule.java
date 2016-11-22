package dev.starlai.dagger2retro.injection.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dev.starlai.dagger2retro.ApiService;
import dev.starlai.dagger2retro.injection.scope.NetScope;
import retrofit2.Retrofit;

/**
 * Created by izayoi on 11/22/2016.
 */

@Module
public class ApiServiceModule {

    @Provides
    @NetScope
    public ApiService provideApiService(Retrofit.Builder retrofit) {
        return retrofit.build().create(ApiService.class);
    }
}
