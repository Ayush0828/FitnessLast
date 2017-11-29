package com.example.fitnesslast;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ExerciseActivity extends AppCompatActivity {

    InsideExer Ex = new InsideExer(38,2,"prout");

    Handler handler;
    //TODO : utiliser trois threads pour charger des donnees
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        this.handler = new Handler();
        this.startLoadingThread();
    }

    private Runnable LOAD_DATA = new Runnable() {
        @Override
        public void run() {
            ExerciseActivity.this.initiate();
        }
    };

    private Runnable REFRESH_UI_TASK = new Runnable() {
        @Override
        public void run() {
            ExerciseActivity.this.refreshUI();
        }
    };

    public void startLoadingThread(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                ExerciseActivity.this.handler.post(REFRESH_UI_TASK);
            }
        }).start();
    }

    public void refreshUI(){
        this.handler.postDelayed(LOAD_DATA,5);
    }

    public void initiate(){
        TextView tvDescript = (TextView) findViewById(R.id.textViewDESCR);
        TextView tvNB = (TextView) findViewById(R.id.textViewNB);
        TextView tvLGT = (TextView) findViewById(R.id.textViewLGTH);

        tvDescript.setText(Ex.getDescription());
        tvNB.setText(Ex.getNbseries());
        tvLGT.setText(Ex.getLengthseries());
    }
}
