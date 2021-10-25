package com.example.noteme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class new_note extends AppCompatActivity {

    DBHelper db;
    String noteTitle;
    String message;
    String colour;

    public static ArrayList<new_note> noteArrayList = new ArrayList<>();

    public new_note(String noteTitle, String message, String colour) {
        this.noteTitle = noteTitle;
        this.message = message;
        this.colour = colour;
    }
    public new_note() {
    }
    public String toString() {
        return noteTitle;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getColour() {return colour;}

    public void setColor(String colour) {this.colour = colour;}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_note);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.colours, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        db = new DBHelper(this);
    }

    public void newHome(View v){
        Intent intent =  new Intent(new_note.this, home.class);
        startActivity(intent);
    }

    public void AddNote(View v) {
        noteTitle = ((EditText) findViewById(R.id.noteid)).getText().toString();
        message = ((EditText) findViewById(R.id.notemessage)).getText().toString();
        colour = ((Spinner)findViewById(R.id.spinner)).getSelectedItem().toString();

        if (TextUtils.isEmpty(noteTitle)) {
            Toast.makeText(this, "Empty note title not allowed!", Toast.LENGTH_SHORT).show();
        } else {
            Boolean checkInsert = db.insertData(noteTitle, message, colour);
            if (checkInsert) {
                Toast.makeText(this, "Your note has been saved!", Toast.LENGTH_SHORT).show();
                newHome(v);
            } else {
                Toast.makeText(this, "You already have a note with the same name!", Toast.LENGTH_SHORT).show();
            }
        }
    }

}