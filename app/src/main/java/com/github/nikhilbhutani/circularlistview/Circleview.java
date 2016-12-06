package com.github.nikhilbhutani.circularlistview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import static android.R.attr.strokeColor;

/**
 * Created by Nikhil Bhutani on 12/6/2016.
 */

public class Circleview extends View {

    private int circleRadius = 100;
    private int strokeColor = 0xFFFF8C00;
    private int strokeWidth = 15;
    private int fillColor = 0XFFFFAB00;
    private int circleGap = 20;

    public Circleview(Context context) {
        super(context);

        init();
    }



    public Circleview(Context context, AttributeSet attrs)
   {
        this(context, attrs, 0);
        init();
    }


    public Circleview(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CircleView, defStyleAttr, 0);

        strokeColor = typedArray.getColor(R.styleable.CircleView_strokeColor, strokeColor);
        strokeWidth = typedArray.getDimensionPixelSize(R.styleable.CircleView_strokeWidth, strokeWidth);
        fillColor = typedArray.getColor(R.styleable.CircleView_fillColor, fillColor);
        circleRadius = typedArray.getDimensionPixelSize(R.styleable.CircleView_circleRadius, circleRadius);
        circleGap = typedArray.getDimensionPixelSize(R.styleable.CircleView_circleGap, circleGap);

        typedArray.recycle();
        init();
    }

    public Circleview(Context context, int strokeColor, int strokeWidth, int fillColor, int circleRadius, int circleGap) {
        super(context);
        this.strokeColor = strokeColor;
        this.strokeWidth = strokeWidth;
        this.fillColor = fillColor;
        this.circleRadius = circleRadius;
        this.circleGap = circleGap;

        init();
    }

    private void init() {

        this.setMinimumHeight(circleRadius * 2 + strokeWidth);
        this.setMinimumWidth(circleRadius * 2 + strokeWidth);
        this.setSaveEnabled(true);
        }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int w = this.getWidth();
        int h = this.getHeight();

        int ox = w/2;
        int oy = h/2;

        canvas.drawCircle(ox, oy, circleRadius, getStroke());
        canvas.drawCircle(ox, oy, circleRadius - circleGap, getFill());
    }

    private Paint getStroke()
    {
        Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);
        p.setStrokeWidth(strokeWidth);
        p.setColor(strokeColor);
        p.setStyle(Paint.Style.STROKE);
        return p;
    }

    private Paint getFill()
    {
        Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);
        p.setColor(fillColor);
        p.setStyle(Paint.Style.FILL);
        return p;
    }


    public int getCircleRadius() {
        return circleRadius;
    }

    public void setCircleRadius(int circleRadius) {
        this.circleRadius = circleRadius;
    }

    public int getStrokeColor() {
        return strokeColor;
    }

    public void setStrokeColor(int strokeColor) {
        this.strokeColor = strokeColor;
    }

    public int getStrokeWidth() {
        return strokeWidth;
    }

    public void setStrokeWidth(int strokeWidth) {
        this.strokeWidth = strokeWidth;
    }

    public int getFillColor() {
        return fillColor;
    }

    public void setFillColor(int fillColor) {
        this.fillColor = fillColor;
    }

    public int getCircleGap() {
        return circleGap;
    }

    public void setCircleGap(int circleGap) {
        this.circleGap = circleGap;
    }

}
