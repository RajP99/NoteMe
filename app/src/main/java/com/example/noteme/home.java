package com.example.noteme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class home extends AppCompatActivity {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        button = (Button) findViewById(R.id.button);




    }

    public void newNote(View v){
        Intent intent =  new Intent(home.this, new_note.class);
        startActivity(intent);
    }




}