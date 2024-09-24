package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private TextView matriculaTextView;
    private TextView nombreTextView;
    private TextView edadTextView;
    private ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the TextViews
        matriculaTextView = findViewById(R.id.matriculaTextView);

        // Initialize Retrofit and ApiService
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.10.120:9080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(ApiService.class);

        // Call to getMatricula
        Call<Matricula> call = apiService.getMatricula(2024, 25);
        call.enqueue(new Callback<Matricula>() {
            @Override
            public void onResponse(@NonNull Call<Matricula> call, @NonNull Response<Matricula> response) {
                if (response.isSuccessful()) {
                    Matricula matricula = response.body();
                    if (matricula != null) {
                        Log.d(TAG, "Matricula received: " + matricula.getMatricula());
                        // Display the matricula in the TextView
                        matriculaTextView.setText(matricula.getMatricula());
                    } else {
                        Log.e(TAG, "Matricula is null");
                    }
                } else {
                    Log.e(TAG, "Response not successful: " + response.code());
                }
            }

            @Override
            public void onFailure(@NonNull Call<Matricula> call, @NonNull Throwable t) {
                Log.e(TAG, "API call failed", t);
            }
        });
    }
}
