package com.example.fitnesslast;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by ayush on 4/10/2017.
 */
public class Exercises extends Activity {
    Button btn1,btn2,btn3;
    String items[];
    ArrayList<InsideExer> listEx;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercises);
        btn1 = (Button) findViewById(R.id.btnbuh);

        btn2 = (Button) findViewById(R.id.btnhevlii);

        btn3 = (Button) findViewById(R.id.btnhul);

        listEx = new ArrayList<InsideExer>();
        this.listEx.add(new InsideExer(2,2,"Exer1",50000));
        this.listEx.add(new InsideExer(5,4,"Exer2",100000));

        items = new String[this.listEx.size()];
        for(int i= 0;i<listEx.size();i++)
            items[i] = listEx.get(i).getDescription();
        final ListView listView = (ListView) findViewById(R.id.listview);

        ArrayAdapter<String> adpt = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,items);
        listView.setAdapter(adpt);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getBaseContext(),ExerciseActivity.class);
                InsideExer ex = listEx.get(position);
                intent.putExtra("desc",ex.getDescription());
                intent.putExtra("nbS",ex.getNbseries());
                intent.putExtra("lgS",ex.getLengthseries());
                intent.putExtra("rTime",ex.getRest());
                startActivity(intent);
            }
        });
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


}
