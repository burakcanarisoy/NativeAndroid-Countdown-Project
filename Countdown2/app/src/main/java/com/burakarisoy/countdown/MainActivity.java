package com.burakarisoy.countdown;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.content.Intent;
import android.media.MediaPlayer;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private Button button;
    private EditText editTextTextPersonName;
    private EditText editTextDate;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer = MediaPlayer.create(this, R.raw.horror);
        mediaPlayer.start();
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.grey)));

        editTextTextPersonName = findViewById(R.id.editTextTextPersonName);
        editTextDate = findViewById(R.id.editTextDate);
        button = findViewById(R.id.button);

        button.setOnClickListener(v -> {
            String text1 = editTextTextPersonName.getText().toString().trim();
            String text2 = editTextDate.getText().toString().trim();

            if (!text1.isEmpty() && !text2.isEmpty()) {
                Intent intent = new Intent(MainActivity.this, ResultPage.class);
                startActivity(intent);

            } else {
                Toast.makeText(MainActivity.this, "Fill in all fields!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
