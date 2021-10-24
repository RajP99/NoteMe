package com.example.noteme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class new_note extends AppCompatActivity {

    DBHelper db;
    String title;
    String messege;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_note);

        db = new DBHelper(this);
    }

    public void newHome(View v){
        Intent intent =  new Intent(new_note.this, home.class);
        startActivity(intent);
    }

    public void AddNote(View v){
        title = ((EditText)findViewById(R.id.noteTitle)).getText().toString();
        messege = ((EditText)findViewById(R.id.noteMessage)).getText().toString();

        Boolean checkInsert = db.insertData(title, messege);
        if (checkInsert) {
            Toast.makeText(this, "Inserted", Toast.LENGTH_SHORT).show();
            newHome(v);
        } else {
            Toast.makeText(this, "Not inserted", Toast.LENGTH_SHORT).show();
        }
    }

}