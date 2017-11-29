package com.example.fitnesslast;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by ayush on 4/10/2017.
 */
public class Exercises extends Activity {
    Button btn1,btn2,btn3;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercises);
        btn1 = (Button) findViewById(R.id.btnbuh);

        btn2 = (Button) findViewById(R.id.btnhevlii);

        btn3 = (Button) findViewById(R.id.btnhul);
    }

    public void Click(View view) {
        startActivity(new Intent(this,Fullbody.class));
    }
    public void Click2(View view) {
        startActivity(new Intent(this,Abs.class));
    }
    public void Click3(View view) {
        startActivity(new Intent(this,Legs.class));
    }

    public void clickExercise(View view) {
        /*AlertDialog.Builder uib = new AlertDialog.Builder(this);
        AlertDialog ui = uib.create();
        ui.show();*/
        startActivity(new Intent(this,ExerciseActivity.class));
    }
}
