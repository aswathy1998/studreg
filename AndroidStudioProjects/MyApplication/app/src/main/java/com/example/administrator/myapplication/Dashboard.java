package com.example.administrator.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Dashboard extends AppCompatActivity {
    ImageView a1,s1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        a1=(ImageView)findViewById(R.id.add);
        s1=(ImageView)findViewById(R.id.search);
        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Toast.makeText(getApplicationContext(),"add button",Toast.LENGTH_SHORT).show();
                Intent i=new Intent(getApplicationContext(),Add.class);
                startActivity(i);
            }
        });
        s1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Toast.makeText(getApplicationContext(),"search button",Toast.LENGTH_SHORT).show();
                Intent i=new Intent(getApplicationContext(),Search.class);
                startActivity(i);
            }
        });

        }
    }

