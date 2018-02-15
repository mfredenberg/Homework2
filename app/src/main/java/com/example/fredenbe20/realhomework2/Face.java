package com.example.fredenbe20.realhomework2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

import java.util.Random;

/**
 * Created by fredenbe20 on 2/14/2018.
 * Mason Fredenberg
 */

public class Face extends SurfaceView {
    protected int skinColor;
    protected int eyeColor;
    protected int hairColor;
    protected int hairStyle;
    protected int radioNum;
    Random gen = new Random();

    public Face(Context context) {
        super(context);
        setWillNotDraw(false);
        this.randomize();
    }

    public Face(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);
        this.randomize();

    }

    public Face(Context context, AttributeSet attrs, int defStyleAttrs) {
        super(context, attrs, defStyleAttrs);
        setWillNotDraw(false);
        this.randomize();

    }

    //implements random attributes
    public void randomize(){
        setSkinColor(gen.nextInt(255), gen.nextInt(255), gen.nextInt(255));
        setHairColor(gen.nextInt(255), gen.nextInt(255), gen.nextInt(255));
        setEyeColor(gen.nextInt(255), gen.nextInt(255), gen.nextInt(255));
        hairStyle = gen.nextInt(3);
        setRadioNum(gen.nextInt(3));
    }

    public void onDraw(Canvas canvas){
        drawFace(canvas);
        drawEyes(canvas);
        drawHair(canvas);
    }


    //drawing helper methods
    public void drawFace(Canvas canvas){
        Paint skinPaint = new Paint();
        skinPaint.setColor(skinColor);
        canvas.drawCircle(300.0f, 300.0f, 200.0f, skinPaint);
        invalidate();
    }
    public void drawHair(Canvas canvas){
        Paint hairPaint = new Paint();
        hairPaint.setColor(hairColor);
        //draws based on hair style
        if(hairStyle == 0) {
            canvas.drawRect(100.0f, 100.0f, 500.0f, 200.0f, hairPaint);

        }
        if(hairStyle == 1) {
            canvas.drawCircle(200.0f, 150.0f, 50.0f, hairPaint);
            canvas.drawCircle(400.0f, 150.0f, 50.0f, hairPaint);
        }
        if(hairStyle == 2) {
            canvas.drawRect(250.0f, 50.0f, 350.0f, 150.0f, hairPaint);
        }
        invalidate();

    }
    public void drawEyes(Canvas canvas){
        Paint myPaint = new Paint();
        myPaint.setColor(Color.WHITE);
        canvas.drawCircle(250.0f, 275.0f, 60.0f, myPaint);
        canvas.drawCircle(350.0f,275.0f, 60.0f, myPaint);
        myPaint.setColor(eyeColor);
        canvas.drawCircle(250.0f, 275.0f, 30.0f, myPaint);
        canvas.drawCircle(350.0f, 275.0f, 30.0f, myPaint);
        myPaint.setColor(Color.BLACK);
        canvas.drawCircle(250.0f, 275.0f, 10.0f, myPaint);
        canvas.drawCircle(350.0f, 275.0f, 10.0f, myPaint);
        invalidate();
    }

    //setting methods
    public void setEyeColor(int r, int g, int b) {
        this.eyeColor = Color.rgb(r, g, b);
        invalidate();
    }
    public void setSkinColor(int r, int g, int b){
        this.skinColor = Color.rgb(r, g, b);
    }
    public void setHairColor(int r, int g, int b){
        this.hairColor = Color.rgb(r, g, b);
    }
    public void setHairStyle(int style) {
        this.hairStyle = style;
    }
    public void setRadioNum(int choice){
        this.radioNum = choice;
    }

    //getting methods
    public int getSkinColor() {return skinColor;}
    public int getEyeColor() {return eyeColor;}
    public int getHairColor() {return hairColor;}
    public int getHairStyle() {return hairStyle;}
    public int getRadioNum() {return radioNum;}

}
