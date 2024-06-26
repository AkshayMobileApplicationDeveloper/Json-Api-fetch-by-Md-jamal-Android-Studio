package com.app.api_mdjamal;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText mainEditTextName;
    EditText mainEditTextEmail;
    Button mainButtonSend;
    TextView mainTextViewMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        mainEditTextName=findViewById(R.id.main_edit_text_name);
        mainEditTextEmail =findViewById(R.id.main_edit_text_email);
        mainButtonSend=findViewById(R.id.main_button_send);
        mainTextViewMsg = findViewById(R.id.main_text_view_msg);
    }
}