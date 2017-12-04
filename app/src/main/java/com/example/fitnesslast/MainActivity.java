package com.example.fitnesslast;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn1,btn2,btn3,btn4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click_exercises(View view) {
        Intent intent = new Intent(this,Exercises.class);
        startActivity(intent);
    }

    public void click_run (View view) {

    }

    public void click_weather (View view) {
        Intent intent = new Intent(this, Weather.class);
        startActivity(intent);
    }

    public void click_push (View view) {
        Intent intent = new Intent(this, Pushup.class);
        startActivity(intent);
    }

    public void click_exit (View view) {
        finish();
        System.exit(0);
    }

}
