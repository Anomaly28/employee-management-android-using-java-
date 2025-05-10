package com.example.project14crudapp;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DeleteActivity extends AppCompatActivity {

    EditText etDeleteEid;
    Button btnRemove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
       etDeleteEid = findViewById(R.id.etDeleteEid);
       btnRemove = findViewById(R.id.btnRemove);

       btnRemove.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               DatabaseHandler db = new DatabaseHandler(getApplicationContext());
               long res = db.deleteEmployee(Integer.parseInt(etDeleteEid.getText().toString()));
               String msg = res+"records deleted";
               Toast.makeText(DeleteActivity.this, msg, Toast.LENGTH_SHORT).show();
           }
       });
    }
}