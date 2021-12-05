package com.uoit.noteme.views;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

public class MyRectable {
    private float x;
    private float y;
    RectF myrect;
    Paint myrectPaint;
    public MyRectable (float x, float y, RectF myrect, Paint myrectPaint){
        this.x = x;
        this.y = y;
        this.myrect = myrect;
        this.myrectPaint = myrectPaint;

    }
    public void setX(float x) {
        this.x = x;
    }
    public void setY(float y) {
        this.y = y;
    }
    public float getX(){
        return this.x;
    }
    public float getY(){
        return this.y;
    }
    public RectF getMyrect() {
        return this.myrect;
    }
}
