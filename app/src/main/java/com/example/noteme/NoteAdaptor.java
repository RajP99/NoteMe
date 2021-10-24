package com.example.noteme;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

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

        return convertView;
    }
}