package com.example.aswathy.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class largeActivity extends AppCompatActivity {
    EditText ed1,ed2,ed3,ed4;
    Button b1,b2;
    String s1,s2,s3;
    int number1,number2,number3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_large);
        ed1=(EditText)findViewById(R.id.f1);
        ed2=(EditText)findViewById(R.id.f2);
        ed3=(EditText)findViewById(R.id.f3);
        ed4=(EditText)findViewById(R.id.fn4);
        b1=(Button)findViewById(R.id.arg);
        b2=(Button)findViewById(R.id.bk5);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1=ed1.getText().toString();
                s2=ed2.getText().toString();
                s3=ed3.getText().toString();
                number1=Integer.parseInt(s1);
                number2=Integer.parseInt(s2);
                number3=Integer.parseInt(s3);

                if ((number1>number2) && (number1>number3))
                {

//                    Toast.makeText(getApplicationContext(),s1,Toast.LENGTH_LONG).show();
                    ed4.setText(s1);
                    ed4.setVisibility(view.VISIBLE);
                }
                else if  ((number2>number1) &&( number2>number3)) {
//                    Toast.makeText(getApplicationContext(), s2, Toast.LENGTH_LONG).show();
                    ed4.setText(s2);
                    ed4.setVisibility(view.VISIBLE);
                }
                 else if ((number3>number1) && (number3>number2)) {
//                    Toast.makeText(getApplicationContext(),s3,Toast.LENGTH_LONG).show();
                    ed4.setVisibility(view.VISIBLE);
                    ed4.setText(s3);
                }
                }

        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });
    }
}
