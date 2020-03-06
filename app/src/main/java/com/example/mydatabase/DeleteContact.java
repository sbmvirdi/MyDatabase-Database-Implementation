package com.example.mydatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class DeleteContact extends AppCompatActivity {

    private EditText name;
    private Button delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_contact);

        name = findViewById(R.id.name);
        delete = findViewById(R.id.delete);



    }
}
