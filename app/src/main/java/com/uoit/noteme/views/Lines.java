package com.uoit.noteme.views;

import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

public class Lines {

    float sx;
    float sy;
    float ex;
    float ey;
    RectF start_square;
    RectF end_square;
    Paint paint;

    public Lines(float sx, float sy, float ex, float ey, RectF sq, RectF eq, Paint paint) {
        this.sx = sx;
        this.sy = sy;
        this.ex = ex;
        this.ey = ey;
        this.start_square = sq;
        this.end_square = eq;
    }

    public float getSx() {
        return sx;
    }

    public void setSx(float sx) {
        this.sx = sx;
    }

    public float getSy() {
        return sy;
    }

    public void setSy(float sy) {
        this.sy = sy;
    }

    public float getEx() {
        return ex;
    }

    public void setEx(float ex) {
        this.ex = ex;
    }

    public float getEy() {
        return ey;
    }

    public void setEy(float ey) {
        this.ey = ey;
    }
}
