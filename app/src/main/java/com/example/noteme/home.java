package com.example.noteme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.icu.text.LocaleDisplayNames;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class home extends AppCompatActivity {

    Button button;
    private ListView mListView;
    DBHelper db;
    EditText search_bar;
    NoteAdaptor adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        button = (Button) findViewById(R.id.button);
        mListView = (ListView) findViewById(R.id.listviewId);
        search_bar = (EditText) findViewById(R.id.search_bar);
        db = new DBHelper(this);

        populateListView();

        search_bar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence cs, int i, int i1, int i2) {
                 (home.this).adapter.getFilter().filter(cs.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }

        });


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
        adapter = new NoteAdaptor(home.this, new_note.noteArrayList);
      // NoteAdaptor noteAdaptor = new NoteAdaptor(getApplicationContext(), new_note.);
        mListView.setAdapter(adapter);
    }
}