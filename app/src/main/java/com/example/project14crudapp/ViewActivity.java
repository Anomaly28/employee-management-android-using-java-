package com.example.project14crudapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ViewActivity extends AppCompatActivity {
TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        tvResult = findViewById(R.id.tvResult);

        DatabaseHandler databaseHandler = new DatabaseHandler(getApplicationContext());
        String data = databaseHandler.viewEmployee();
        if(data.equals(""))
            tvResult.setText("no employee found");
        else
            tvResult.setText(data);
    }
}