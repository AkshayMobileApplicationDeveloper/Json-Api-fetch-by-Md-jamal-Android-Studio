package com.app.api_mdjamal;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    public static EditText mainEditTextName;
    public static EditText mainEditTextEmail;
    public static Button mainButtonSend;
    public static TextView mainTextViewMsg;
    //private final static String url ="http://localhost/RestApi/setData.php";

    private final static String url ="http://10.0.2.2/RestApi/setData.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainEditTextName = findViewById(R.id.main_edit_text_name);
        mainEditTextEmail = findViewById(R.id.main_edit_text_email);
        mainButtonSend = findViewById(R.id.main_button_send);
        mainTextViewMsg = findViewById(R.id.main_text_view_msg);

        mainButtonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processData(mainEditTextName.getText().toString(), mainEditTextEmail.getText().toString());
            }
        });
    }

    public void processData(final String name, final String email) {
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                mainEditTextName.setText("");
                mainEditTextEmail.setText("");
                Toast.makeText(MainActivity.this, ""+response, Toast.LENGTH_SHORT).show();
                mainTextViewMsg.setText(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mainEditTextName.setText("");
                mainEditTextEmail.setText("");
                Toast.makeText(MainActivity.this, ""+error, Toast.LENGTH_SHORT).show();
                mainTextViewMsg.setText(error.toString());
                mainTextViewMsg.setTextColor(Color.RED);//set text color set
                mainTextViewMsg.setTextSize(14);
            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put("name", name);
                map.put("email", email);
                return map;
            }
        };

        // Add the request to the Volley request queue
       /*
        Volley.newRequestQueue(this).add(request);
        */
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        queue.add(request);
    }
}
