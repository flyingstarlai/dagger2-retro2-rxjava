package dev.starlai.dagger2retro;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dev.starlai.dagger2retro.models.Mclass;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import rx.Observer;
import rx.Scheduler;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.textview_result)
    TextView result;



    @Inject Retrofit.Builder retrofit;
    @Inject ApiService apiService;
    @Inject ServiceInterceptor interceptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ((App)getApplication()).getApiComponent().inject(this);


    }

    @OnClick(R.id.btn_change_url) void change() {
        Log.d("change", "change url..");
        HttpUrl url = HttpUrl.parse("http://27.105.130.18:8001/");
        interceptor.setInterceptor(url.toString());
    }

    @OnClick(R.id.btn_api_call) void submit() {
        Log.d("submit", "call..");

        apiService.getMclass()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Mclass>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        result.setText(e.toString());
                    }

                    @Override
                    public void onNext(List<Mclass> mclasses) {
                        StringBuilder resultHelper = new StringBuilder();
                        for(Mclass mclass : mclasses) resultHelper.append(mclass.getCLASSNA() + " ");
                        result.setText(resultHelper.toString());
                    }
                });
    }
}
