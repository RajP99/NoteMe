package com.uoit.noteme.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;


import java.util.ArrayList;

public class CustomView extends View {

    private ArrayList<MyRectable> rectangleList = new ArrayList<MyRectable>();
    private ArrayList<MyCircle> circleList = new ArrayList<MyCircle>();
    private ArrayList<MyDiamond> diamondList = new ArrayList<MyDiamond>();
    private ArrayList<Lines> lineList = new ArrayList<Lines>();

    private float square_ew = 90;

    private Paint mPaintSquare;
    private Paint mPaintCircle;
    private Paint mPaintLine;
    private Paint mPaintLineEdges;
    private Paint mPaintDiamond;

    private float mSquareX, mSquareY;

    private float mCircleX, mCircleY;
    private float getmCircleRadius = 80f;

    public CustomView(Context context) {
        super(context);
        init(null);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init(@Nullable AttributeSet set){
        mSquareX = 50f;
        mSquareY = 50f;

        mPaintSquare = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintSquare.setColor(Color.parseColor("#DA372A"));

//        rectangleList.add(new MyRectable(mSquareX, mSquareY, new RectF(),mPaintSquare));

        mPaintCircle = new Paint();
        mPaintCircle.setAntiAlias(true);
        mPaintCircle.setColor(Color.parseColor("#00ccff"));

        mPaintLine = new Paint();
        mPaintLine.setAntiAlias(true);
        mPaintLine.setColor(Color.BLACK);
        mPaintLine.setStrokeWidth(10);

        mPaintLineEdges = new Paint();
        mPaintLineEdges.setAntiAlias(true);
        mPaintLineEdges.setColor(Color.GRAY);

        mPaintDiamond = new Paint();
        mPaintDiamond.setAntiAlias(true);
        mPaintDiamond.setColor(Color.parseColor("#4AD3B7"));

//
//        RectF startRecF = new RectF();
//        RectF endRecF = new RectF();
//        Lines line = new Lines(50,50,200, 200,startRecF, endRecF,mPaintLine);
//        lineList.add(line);

    }

    //responsible for adding new rectangles on the screen
    public void addRectangle() {
        rectangleList.add(new MyRectable(mSquareX, mSquareY, new RectF(),mPaintSquare));
        postInvalidate();
    }
    public void addCircle(){
        circleList.add(new MyCircle(100f,100f,getmCircleRadius, mPaintCircle));
        postInvalidate();
    }

    public void addDiamond() {
        diamondList.add(new MyDiamond(100,100,150, mPaintDiamond));
        postInvalidate();
    }
    public void addLine(){
        RectF startRecF = new RectF();
        RectF endRecF = new RectF();
        Lines line = new Lines(50,50,200, 200,startRecF, endRecF,mPaintLine);
        lineList.add(line);
        postInvalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.GRAY);

        for (int i =0; i < lineList.size(); i++) {
            //the Starting square
            lineList.get(i).start_square.left = lineList.get(i).getSx();
            lineList.get(i).start_square.top = lineList.get(i).getSy();
            lineList.get(i).start_square.right = lineList.get(i).getSx() + square_ew;
            lineList.get(i).start_square.bottom = lineList.get(i).getSy() + square_ew;

            //The Ending Square
            lineList.get(i).end_square.left = lineList.get(i).getEx();
            lineList.get(i).end_square.top = lineList.get(i).getEy();
            lineList.get(i).end_square.right = lineList.get(i).getEx()+ square_ew;
            lineList.get(i).end_square.bottom = lineList.get(i).getEy() + square_ew;

            canvas.drawRect(lineList.get(i).start_square,mPaintLineEdges);
            canvas.drawRect(lineList.get(i).end_square,mPaintLineEdges);
            canvas.drawLine(lineList.get(i).getSx()+ square_ew/2, lineList.get(i).getSy()+ square_ew/2, lineList.get(i).getEx()+ square_ew/2, lineList.get(i).getEy()+ square_ew/2, mPaintLine);

        }
//        canvas.drawLine(20, 20,100,100, mPaintLine);



        for( int i =0; i < rectangleList.size(); i++) {
            rectangleList.get(i).myrect.left =  rectangleList.get(i).getX();
            rectangleList.get(i).myrect.top = rectangleList.get(i).getY();
            rectangleList.get(i).myrect.right = rectangleList.get(i).getX() + 400;
            rectangleList.get(i).myrect.bottom = rectangleList.get(i).getY() + 200;
            canvas.drawRect(rectangleList.get(i).myrect,mPaintSquare);
        }
        float cx, cy;
        float radius = 100f;

        cx = 100;
        cy = 100;

        if(mCircleX == 0f || mCircleY == 0f) {
            mCircleX = getWidth() /2;
            mCircleY = getHeight() / 2;
        }

        for (int i=0; i < circleList.size(); i++){
            canvas.drawCircle(circleList.get(i).getCx(),circleList.get(i).getCy(),getmCircleRadius,mPaintCircle);
        }

        for (int i=0; i < diamondList.size(); i++) {
            drawRhombus(canvas,diamondList.get(i).diamondPaint,diamondList.get(i).getX(),diamondList.get(i).getY(),diamondList.get(i).getWidth());
        }


    }

    public void drawRhombus(Canvas canvas, Paint paint, float x, float y, float width) {
        float halfWidth = width / 2;

        Path path = new Path();
        path.moveTo(x, y + halfWidth); // Top
        path.lineTo(x - halfWidth, y); // Left
        path.lineTo(x, y - halfWidth); // Bottom
        path.lineTo(x + halfWidth, y); // Right
        path.lineTo(x, y + halfWidth); // Back to Top
        path.close();

        canvas.drawPath(path, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        boolean value = super.onTouchEvent(event);

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                return true;
            }
            case MotionEvent.ACTION_MOVE: {
                float x = event.getX();
                float y = event.getY();

                for ( int i = 0; i < circleList.size(); i++) {
                    double dx = Math.pow(x - circleList.get(i).getCx(), 2);
                    double dy = Math.pow(y - circleList.get(i).getCy(), 2);

                    if (dx + dy < Math.pow(getmCircleRadius, 2)){
                        mCircleX = x;
                        mCircleY = y;
                        circleList.get(i).setCx(x);
                        circleList.get(i).setCy(y);
                        postInvalidate();
                        return true;
                    }
                }

                for (int i =0; i < rectangleList.size(); i++) {
                    if(rectangleList.get(i).myrect.contains(x, y)) {
                        rectangleList.get(i).setX(x - rectangleList.get(i).myrect.width()/2);
                        rectangleList.get(i).setY(y - rectangleList.get(i).myrect.height()/2);
                        postInvalidate();
                        return true;

                    }
                }


                for (int i=0; i < lineList.size(); i++) {
                    if(lineList.get(i).start_square.contains(x, y)) {
                        lineList.get(i).setSx(x - square_ew/2);
                        lineList.get(i).setSy(y - square_ew/2);
                        postInvalidate();
                        return true;

                    }
                }

                for (int i=0; i < lineList.size(); i++) {
                    if(lineList.get(i).end_square.contains(x, y)) {
                        lineList.get(i).setEx(x - square_ew/2);
                        lineList.get(i).setEy(y - square_ew/2);
                        postInvalidate();
                        return true;

                    }
                }


                for (int i =0; i < diamondList.size(); i++) {
                    if(isContained(x, y, diamondList.get(i).getX(), diamondList.get(i).getY(), diamondList.get(i).getWidth())){
                        diamondList.get(i).setX(x);
                        diamondList.get(i).setY(y);
                        postInvalidate();
                        return true;
                    }
                }


            }
        }

        return value;
    }

    public Boolean isContained(float mx, float my, float dx, float dy, float dw){
        float hw = dw/2;

        if (mx > dx - hw && mx < dx + hw && my < dy + hw && my > dy - hw) {
            return true;
        }
        return false;
    }
}
