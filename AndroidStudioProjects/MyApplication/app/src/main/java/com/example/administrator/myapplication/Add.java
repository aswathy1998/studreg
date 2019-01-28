package com.example.administrator.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Add extends AppCompatActivity {
    EditText ed1,ed2,ed3,ed4;
    Button b1;
    String n,r,a,b ,url="http://logixspace.com/mzc/add.php";
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        ed1=(EditText)findViewById(R.id.name);
        ed2=(EditText)findViewById(R.id.rollno);
        ed3=(EditText)findViewById(R.id.admno);
        ed4=(EditText)findViewById(R.id.branch);
        progressBar=(ProgressBar)findViewById(R.id.pb);
        b1=(Button)findViewById(R.id.submit);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n=ed1.getText().toString();
                r=ed2.getText().toString();
                a=ed3.getText().toString();
                b=ed4.getText().toString();
               // Toast.makeText(getApplicationContext(),n,Toast.LENGTH_SHORT).show();
                //Toast.makeText(getApplicationContext(),r,Toast.LENGTH_SHORT).show();
               // Toast.makeText(getApplicationContext(),a,Toast.LENGTH_SHORT).show();
               // Toast.makeText(getApplicationContext(),b,Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.VISIBLE);
                addToDb();
            }
        });

    }

    private void addToDb() {
        //define
       // Toast.makeText(getApplicationContext(),"add",Toast.LENGTH_SHORT).show();
        StringRequest stringRequest=new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                    //response

                        try {
                            JSONObject jsonObject=new JSONObject(response);
                            String responseFromServer=jsonObject.getString("status");
                            progressBar.setVisibility(View.GONE);
                            if (responseFromServer.equals("success"))
                            {

                                Toast.makeText(getApplicationContext(),"Successfully Registered",Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                Toast.makeText(getApplicationContext(),"Error in Registered",Toast.LENGTH_SHORT).show();
                            }


                        } catch (JSONException e) {
                            Toast.makeText(getApplicationContext(),"exception here"+e,Toast.LENGTH_SHORT).show();
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                })
        {
           //data to be send

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params=new HashMap<String, String>() ;
                params.put("name",n);
                params.put("rollno",r);
                params.put("admno",a);
                params.put("branch",b);
                return params;
            }
        };
        //sending data
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);



    }
}
