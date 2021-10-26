package com.example.noteme;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.lang.reflect.Field;
import java.util.List;

public class NoteAdaptor extends ArrayAdapter<new_note> {

    public NoteAdaptor(Context context, List<new_note> notes){
        super(context, 0, notes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        new_note note = getItem(position);
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.note_cell, parent, false);
        }

        TextView title = convertView.findViewById(R.id.titleCell);
        TextView desc = convertView.findViewById(R.id.subtitleCell);
        title.setText(note.getNoteTitle());
        desc.setText(note.getMessage());

        setColour(convertView, note.getColour());



        return convertView;
    }

    public void setColour(View convertView, String string_colour) {
        switch(string_colour) {
            case "RED":
                convertView.setBackgroundColor(Color.RED);
                break;
            case "GREEN":
                convertView.setBackgroundColor(Color.GREEN);
                break;
            case "BLUE":
                convertView.setBackgroundColor(Color.BLUE);
                break;
            case "YELLOW":
                convertView.setBackgroundColor(Color.YELLOW);
                break;
            default:
                break;
        }
    }
}