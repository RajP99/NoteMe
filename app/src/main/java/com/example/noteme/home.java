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
    DatabaseHelper mDatabaseHelper;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        button = (Button) findViewById(R.id.button);
        mListView = (ListView) findViewById(R.id.listviewId);
        mDatabaseHelper = new DatabaseHelper(this);

        populateListView();

    }

    public void newNote(View v){
        Intent intent =  new Intent(home.this, new_note.class);
        startActivity(intent);
    }
    private void populateListView() {
        Log.d("ListDataActivity", "populateListView; displaying data..." );
        //getting data and adding it to the list
        Cursor data = mDatabaseHelper.getData();
        ArrayList<String> listData = new ArrayList<>();

        while(data.moveToNext())
        {
            listData.add(data.getString(1));
        }
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listData);
        mListView.setAdapter(adapter);
    }



}