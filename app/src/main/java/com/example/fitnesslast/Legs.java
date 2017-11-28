package com.example.fitnesslast;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

/**
 * Created by ayush on 4/10/2017.
 */
public class Legs extends AppCompatActivity {
    Button btn1,btn2,btn3;
    RelativeLayout l1 ,l2,l3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.legs);
        btn1 = (Button) findViewById(R.id.button);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        l1 = (RelativeLayout) findViewById(R.id.lay1);
        l2 = (RelativeLayout) findViewById(R.id.lay2);
        l3 = (RelativeLayout) findViewById(R.id.lay3);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                l1.setVisibility(View.VISIBLE);
                l2.setVisibility(View.INVISIBLE);
                l3.setVisibility(View.INVISIBLE);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                l1.setVisibility(View.INVISIBLE);
                l2.setVisibility(View.VISIBLE);
                l3.setVisibility(View.INVISIBLE);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                l1.setVisibility(View.INVISIBLE);
                l3.setVisibility(View.VISIBLE);
                l1.setVisibility(View.INVISIBLE);
            }
        });
    }

    public void ChangeFragment(View view) {
        Fragment fragment1;
        Fragment fragment2;
        Fragment fragment3;

        if ( view == findViewById(R.id.button)) {
            fragment1 = new Fragment();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment1, fragment1);
            ft.commit();
        }
        if ( view == findViewById(R.id.button2)) {
            fragment2 = new Fragment();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment1, fragment2);

            ft.commit();
        }
        if ( view == findViewById(R.id.button3)) {
            fragment3 = new Fragment();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment1, fragment3);

            ft.commit();
        }
    }
}
