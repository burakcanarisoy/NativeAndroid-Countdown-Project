package com.burakarisoy.countdown;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;
import java.util.Calendar;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ResultPage extends AppCompatActivity {

    public void openMainActivity(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    private TextView countdownTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_page);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.grey)));

        countdownTextView = findViewById(R.id.countdownTextView);

        Random random = new Random();
        int years = random.nextInt(30) + 1;
        int months = random.nextInt(12) + 1;
        int days = random.nextInt(30) + 1;
        int hours = random.nextInt(24);
        int minutes = random.nextInt(60);
        int seconds = random.nextInt(60);


        Calendar futureTime = Calendar.getInstance();
        futureTime.add(Calendar.YEAR, +years);
        futureTime.add(Calendar.MONTH, +months);
        futureTime.add(Calendar.DAY_OF_MONTH, +days);
        futureTime.add(Calendar.HOUR_OF_DAY, +hours);
        futureTime.add(Calendar.MINUTE, +minutes);
        futureTime.add(Calendar.SECOND, +seconds);

        Calendar currentTime = Calendar.getInstance();
        long countdownInMillis = futureTime.getTimeInMillis() - currentTime.getTimeInMillis();


        new CountDownTimer(countdownInMillis, 1000) {
            public void onTick(long millisUntilFinished) {
                String countdown = String.format("YEAR:%02d\nMONTH:%02d\nDAY:%02d\nHOURS:%02d\nMINUTES:%02d\nSECONDS:%02d",
                        TimeUnit.MILLISECONDS.toDays(millisUntilFinished) /365, //yıl
                        TimeUnit.MILLISECONDS.toDays(millisUntilFinished) %12,
                        TimeUnit.MILLISECONDS.toDays(millisUntilFinished)%365%30,
                        TimeUnit.MILLISECONDS.toHours(millisUntilFinished) % 24,
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) % 60,
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) % 60);
                countdownTextView.setText(countdown);
            }

            public void onFinish() {

                countdownTextView.setText("THE TIME IS OVER!");
            }
        }.start();
    }
}