package ru.mirea.serebriakovaea.task1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import ru.mirea.serebriakovaea.task1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    String group_num;
    String spisok_num;
    String film;

    String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SharedPreferences sharedPreferences = getSharedPreferences("task1", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        binding.btnSaveInf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                group_num = binding.editTextGoupNum.getText().toString();
                spisok_num = binding.editTextSpisokNumber.getText().toString();
                film = binding.editTextFilm.getText().toString();

                editor.putString("GROUP", group_num);
                editor.putString("NUMBER", spisok_num);
                editor.putString("FILM", film);

                editor.apply();

                Log.d(TAG, sharedPreferences.getString("GROUP", "No inf"));
                Log.d(TAG, sharedPreferences.getString("NUMBER", "No inf"));
                Log.d(TAG, sharedPreferences.getString("FILM", "No inf"));
            }
        });

    }
}