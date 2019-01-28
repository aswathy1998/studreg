package com.example.administrator.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText ed1,ed2;
    Button b;
    String user,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=(Button)findViewById(R.id.ulog);
        ed1=(EditText)findViewById(R.id.uname);
        ed2=(EditText)findViewById(R.id.upass);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user=ed1.getText().toString();
                pass=ed2.getText().toString();

                if(user.equals("admin") && pass.equals("12345"))
                {
                    Intent i=new Intent(getApplicationContext(),Dashboard.class);
                    startActivity(i);

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Invalid username or password",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
