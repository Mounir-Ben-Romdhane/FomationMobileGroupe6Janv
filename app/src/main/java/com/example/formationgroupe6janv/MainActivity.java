package com.example.formationgroupe6janv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText val1,val2;
    private Button btnPlus,btnDiv;
    private TextView res;

    private String v1,v2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        val1 = findViewById(R.id.val1);
        val2 = findViewById(R.id.val2);
        btnPlus = findViewById(R.id.btnPlus);
        btnDiv = findViewById(R.id.btnDiv);
        res = findViewById(R.id.res);

        btnPlus.setOnClickListener(v -> {
            v1 = val1.getText().toString();
            v2 = val2.getText().toString();
            res.setText(Integer.toString(Integer.parseInt(v1) + Integer.parseInt(v2)));
        });

        btnDiv.setOnClickListener(v -> {
            v1 = val1.getText().toString();
            v2 = val2.getText().toString();
            res.setText(Integer.toString(Integer.parseInt(v1) / Integer.parseInt(v2)));
        });

    }
}