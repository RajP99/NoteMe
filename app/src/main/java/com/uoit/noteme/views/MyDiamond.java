package com.uoit.noteme.views;

import android.graphics.Paint;

public class MyDiamond {

    float x;
    float y;
    float width;
    Paint diamondPaint;

    public MyDiamond(float x, float y, float width, Paint diamondPaint) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.diamondPaint = diamondPaint;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }
}
