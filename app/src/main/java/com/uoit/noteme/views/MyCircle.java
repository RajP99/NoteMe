package com.uoit.noteme.views;

import android.graphics.Paint;

public class MyCircle {

    private float cx;
    private float cy;
    private float cRadius;
    Paint cPaint;


    public MyCircle(float cx, float cy, float cRadius, Paint cPaint) {
        this.cx = cx;
        this.cy = cy;
        this.cRadius = cRadius;
        this.cPaint = cPaint;
    }

    public float getCx() {
        return cx;
    }

    public void setCx(float cx) {
        this.cx = cx;
    }

    public float getCy() {
        return cy;
    }

    public void setCy(float cy) {
        this.cy = cy;
    }

    public float getcRadius() {
        return cRadius;
    }

    public void setcRadius(float cRadius) {
        this.cRadius = cRadius;
    }
}
