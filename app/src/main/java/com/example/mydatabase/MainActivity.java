package com.example.mydatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button create,update,search,delete,view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        create = findViewById(R.id.add);
        update = findViewById(R.id.update);
        view = findViewById(R.id.view);
        delete = findViewById(R.id.delete);
        search = findViewById(R.id.search);


        create.setOnClickListener(v->{
            Intent i = new Intent(MainActivity.this,AddContact.class);
            startActivity(i);
        });

        update.setOnClickListener(v->{
            Intent i = new Intent(MainActivity.this,UpdateContact.class);
            startActivity(i);
        });

        view.setOnClickListener(v->{
            Intent i = new Intent(MainActivity.this,ViewContact.class);
            startActivity(i);
        });
        delete.setOnClickListener(v->{
            Intent i = new Intent(MainActivity.this,DeleteContact.class);
            startActivity(i);
        });
        search.setOnClickListener(v->{
            Intent i = new Intent(MainActivity.this,SearchActivity.class);
            startActivity(i);
        });

    }
}
