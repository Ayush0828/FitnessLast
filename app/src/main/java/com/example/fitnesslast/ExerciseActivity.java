package com.example.fitnesslast;

import android.os.AsyncTask;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ExerciseActivity extends AppCompatActivity {

    InsideExer Ex = new InsideExer(2,10,"prout",5000);
    private CountDownTimer ct;
    private int seriesct = 0;

    Handler handler;



    //TODO : utiliser trois threads pour charger des donnees
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        //this.handler = new Handler();
        //this.startLoadingThread();
        thread1.start();
        thread2.start();
        thread3.start();
        threadShow.start();
    }

    private Runnable LOAD_DATA = new Runnable() {
        @Override
        public void run() {
            //ExerciseActivity.this.initiate();
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

    /*public void initiate(){
        TextView tvDescript = (TextView) findViewById(R.id.textViewDESCR);
        TextView tvNB = (TextView) findViewById(R.id.textViewNB);
        TextView tvLGT = (TextView) findViewById(R.id.textViewLGTH);

        tvDescript.setText(Ex.getDescription());
        tvNB.setText(Ex.getNbseries());
        tvLGT.setText(Ex.getLengthseries());
    }*/

    Thread thread1 = new Thread() {
        @Override
        public void run() {
            try { Thread.sleep(100); }
            catch (InterruptedException e) {}

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    TextView tvDescript = (TextView) findViewById(R.id.textViewDESCR);
                    tvDescript.setText(Ex.getDescription());
                }
            });
        }
    };

    Thread thread2 = new Thread() {
        @Override
        public void run() {
            try { Thread.sleep(100); }
            catch (InterruptedException e) {}

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    TextView tvNB = (TextView) findViewById(R.id.textViewNB);
                    tvNB.setText(Integer.toString(Ex.getNbseries()));
                }
            });
        }
    };

    Thread thread3 = new Thread() {
        @Override
        public void run() {
            try { Thread.sleep(100); }
            catch (InterruptedException e) {}

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    TextView tvLGT = (TextView) findViewById(R.id.textViewLGTH);
                    tvLGT.setText(Integer.toString(Ex.getLengthseries()));
                }
            });
        }
    };

    Thread threadShow = new Thread() {
        @Override
        public void run() {
            try { Thread.sleep(100); }
            catch (InterruptedException e) {}

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    TextView tvRest = findViewById(R.id.textViewRest);
                    tvRest.setText(String.format("%02d", Ex.getRest()/60000)+" : "+String.format("%02d", (Ex.getRest()%60000)/1000));
                }
            });
        }
    };

    private Runnable chrono = new Runnable() {

        @Override
        public void run() {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }

            runOnUiThread(new Runnable() {
                public void run() {
                    ct = new CountDownTimer(Ex.getRest(), 100) {
                        TextView tvRest = (TextView) findViewById(R.id.textViewRest);

                        @Override
                        public void onTick(long millisUntilFinished) {
                            String v = String.format("%02d", millisUntilFinished / 60000);
                            int va = (int) ((millisUntilFinished % 60000) / 1000);
                            tvRest.setText(v + " : " + String.format("%02d", va));
                        }

                        @Override
                        public void onFinish() {
                            seriesct++;
                            if(seriesct != Ex.getNbseries()){
                            Button btn = findViewById(R.id.buttonRest);
                            btn.setEnabled(true);
                            }
                            tvRest.setText(String.format("%02d", Ex.getRest()/60000)+" : "+String.format("%02d", (Ex.getRest()%60000)/1000));
                        }
                    }.start();
                }
            });
        }
    };

    public void startClick(View view) {
        new Thread(chrono).start();
        Button btn = findViewById(R.id.buttonRest);
        btn.setEnabled(false);
    }
}
