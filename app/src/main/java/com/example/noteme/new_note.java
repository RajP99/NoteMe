package com.example.noteme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class new_note extends AppCompatActivity {

    DatabaseHelper mDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_note);
//        mDatabaseHelper.showtest();
        Log.d("CreatedTest","message");
    }

    public void newHome(View v){

        Intent intent =  new Intent(new_note.this, home.class);
        startActivity(intent);
    }

    public void AddNote(View v){
        String message = ((EditText)findViewById(R.id.notemessage)).getText().toString();
        String noteTitle = ((EditText)findViewById(R.id.noteid)).getText().toString();
        Log.d("TEST",message);

//        if(message.length()!= 0 || noteTitle.length() != 0){
//            boolean insertData = mDatabaseHelper.addData(message);
//            if(insertData){
//                Toast.makeText(this,"Data saved successfully",Toast.LENGTH_LONG).show();
//            }
//        }

    }
}