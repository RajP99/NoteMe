package com.uoit.noteme.activites;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.uoit.noteme.R;
import com.uoit.noteme.views.CustomView;

public class Flowchart extends AppCompatActivity {

    private CustomView mCustomView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flowchart);

//        CustomView customView = new CustomView(this);
        mCustomView = (CustomView) findViewById(R.id.customView);


        findViewById(R.id.btn_newrectable).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCustomView.addRectangle();
            }
        });

        findViewById(R.id.btn_newcircle).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mCustomView.addCircle();
            }
        });

        findViewById(R.id.btn_newdiamond).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                mCustomView.addDiamond();
            }
        });

        findViewById(R.id.btn_line).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mCustomView.addLine();
            }
        });
    }
}