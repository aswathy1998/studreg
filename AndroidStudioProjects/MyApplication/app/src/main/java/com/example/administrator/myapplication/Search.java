package com.example.administrator.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Search extends AppCompatActivity {
    EditText adno,name,roll,branch;
    Button but;
    String adm,url="http://logixspace.com/mzc/search.php",n,r,b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);;
        setContentView(R.layout.activity_search);
        adno=(EditText)findViewById(R.id.ad);
       name =(EditText)findViewById(R.id.na);
        roll=(EditText)findViewById(R.id.ro);
        branch=(EditText)findViewById(R.id.brch);
        but=(Button)findViewById(R.id.s);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adm=adno.getText().toString();
                searchFromDb();

            }
        });
    }

    private void searchFromDb() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {

                            JSONObject json=new JSONObject(response);
                            String respfromServer=json.getString("status");
                            if(respfromServer.equals("success"))
                            {
                                name.setVisibility(View.VISIBLE);
                                roll.setVisibility(View.VISIBLE);
                                branch.setVisibility(View.VISIBLE);
                                JSONArray jsonArray=json.getJSONArray("data");
                                for(int i=0;i<jsonArray.length();i++)
                                {
                                   JSONObject obj=jsonArray.getJSONObject(i);
                                    n=obj.getString("name");
                                    r=obj.getString("rollno");
                                    b=obj.getString("branch");
                                    name.setText(n);
                                    roll.setText(r);
                                   branch.setText(b);
                                    //Toast.makeText(getApplicationContext(),n,Toast.LENGTH_SHORT).show();
                                    //Toast.makeText(getApplicationContext(),r,Toast.LENGTH_SHORT).show();
                                   // Toast.makeText(getApplicationContext(),b,Toast.LENGTH_SHORT).show();
                                }
                            }
                            else
                            {
                                Toast.makeText(getApplicationContext(),"Invalid admission number",Toast.LENGTH_SHORT).show();
                            }
                            } catch (JSONException e) {
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
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params=new HashMap<>();
                params.put("admno",adm);

                return params;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
