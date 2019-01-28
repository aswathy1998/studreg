package com.example.aswathy.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class addActivity extends AppCompatActivity {

    EditText ed1, ed2, ed3,ed4;
    Button b1, b2;
    String s1, s2, s3, s4;
    int number1, number2, number3, number4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        ed1 = (EditText) findViewById(R.id.an1);
        ed2 = (EditText) findViewById(R.id.an2);
        ed3 = (EditText) findViewById(R.id.an3);
        ed4=(EditText)findViewById(R.id.re);
        b1 = (Button) findViewById(R.id.ad);
        b2 = (Button) findViewById(R.id.bk1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1 = ed1.getText().toString();
                s2 = ed2.getText().toString();
                s3 = ed3.getText().toString();
                number1 = Integer.parseInt(s1);
                number2 = Integer.parseInt(s2);
                number3 = Integer.parseInt(s3);
                number4 = number1 + number2 + number3;
                s4 = String.valueOf(number4);
                ed4.setVisibility(view.VISIBLE);
                ed4.setText(s4);
//                Toast.makeText(getApplicationContext(), s4, Toast.LENGTH_LONG).show();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
    }
}


