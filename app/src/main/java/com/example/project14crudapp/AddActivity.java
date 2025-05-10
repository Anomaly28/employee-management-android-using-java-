package com.example.project14crudapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddActivity extends AppCompatActivity {

    EditText etAddEid, etAddEname, etAddEsalary;

    Button btnSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

            etAddEid = findViewById(R.id.etAddEid);
            etAddEname = findViewById(R.id.etAddEname);
            etAddEsalary = findViewById(R.id.etAddSalary);
        btnSave = findViewById(R.id.btnSave);  // Initialize the Button here

        btnSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int eid = Integer.parseInt(etAddEid.getText().toString());
                    String ename = etAddEname.getText().toString();
                    double esalary = Double.parseDouble(etAddEsalary.getText().toString());

                    DatabaseHandler db = new DatabaseHandler(getApplicationContext());
                    long res = db.addEmployee(eid, ename, esalary);
                    String msg = "";
                    if (res == -1) {
                        msg = eid + " already exists";
                    Toast.makeText(AddActivity.this, msg, Toast.LENGTH_SHORT).show();
                    etAddEid.setText("");
                    etAddEid.requestFocus();
                }
                    else
                {
                    Toast.makeText(AddActivity.this, "recorded created", Toast.LENGTH_SHORT).show();
                    etAddEid.setText("");
                    etAddEname.setText("");
                    etAddEsalary.setText("");
                    etAddEid.requestFocus();
                }
            }
        });
    }
}