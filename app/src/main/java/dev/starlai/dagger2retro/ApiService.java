package dev.starlai.dagger2retro;

import java.util.List;

import dev.starlai.dagger2retro.models.Mclass;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by izayoi on 11/22/2016.
 */

public interface ApiService {
    @GET("mclass")
    Observable<List<Mclass>> getMclass();
}
