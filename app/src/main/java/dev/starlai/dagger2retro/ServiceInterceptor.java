package dev.starlai.dagger2retro;

import android.util.Log;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * An interceptor that allows runtime changes to the API Base URL in Retrofit.
 * The Base URL is set by calling the {@link ServiceInterceptor#setInterceptor(String)} method.
 * */
@Singleton
public class ServiceInterceptor implements Interceptor {
    private static ServiceInterceptor interceptor;
    private String mScheme;
    private String mHost;
    private int mPort;

//    @Inject
//    public static ServiceInterceptor get() {
//        if (sInterceptor == null) {
//            sInterceptor = new ServiceInterceptor();
//        }
//        return sInterceptor;
//    }

    private ServiceInterceptor() {
        // Intentionally blank
    }

    public static ServiceInterceptor getInterceptor() {
        if (interceptor == null) {
            interceptor = new ServiceInterceptor();
        }
        return interceptor;
    }

    public void setInterceptor(String url) {
        HttpUrl httpUrl = HttpUrl.parse(url);
        mScheme = httpUrl.scheme();
        Log.d("scheme",mScheme.toString() );
        mHost = httpUrl.host();
        Log.d("host",mHost.toString() );
        mPort = httpUrl.port();
        Log.d("port", mPort + "" );
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();

        // If new Base URL is properly formatted than replace with old one
        if (mScheme != null && mHost != null) {
            HttpUrl newUrl = original.url().newBuilder()
                    .scheme(mScheme)
                    .host(mHost)
                    .port(mPort)
                    .build();
            original = original.newBuilder()
                    .url(newUrl)
                    .build();
        }
        return chain.proceed(original);
    }
}
