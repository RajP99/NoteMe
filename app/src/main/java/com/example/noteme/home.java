package com.example.noteme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.icu.text.LocaleDisplayNames;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class home extends AppCompatActivity {

    Button button;
    private ListView mListView;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        button = (Button) findViewById(R.id.button);
        mListView = (ListView) findViewById(R.id.listviewId);

        db = new DBHelper(this);

        populateListView();
    }

    public void newNote(View v){
        Intent intent =  new Intent(home.this, new_note.class);
        startActivity(intent);
    }
    private void populateListView() {
        Log.d("ListDataActivity", "populateListView; displaying data..." );
        //getting data and adding it to the list
        Cursor data = db.getData();
        //ArrayList<String> listData = new ArrayList<>();

        while(data.moveToNext())
        {
           new_note note = new new_note(data.getString(0), data.getString(1));
           new_note.noteArrayList.add(note);
//            listData.add(data.getString(0)); //set this to text view title
//            listData.add(data.getString(1)); //set this to text view subtitle
        }
        NoteAdaptor adapter = new NoteAdaptor(home.this, new_note.noteArrayList);
      // NoteAdaptor noteAdaptor = new NoteAdaptor(getApplicationContext(), new_note.);
        mListView.setAdapter(adapter);
    }
}