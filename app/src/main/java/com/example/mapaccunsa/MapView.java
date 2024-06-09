package com.example.mapaccunsa;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class MapView extends View {
    private Paint paint;
    private Paint textRoom;
    private Paint textPatios;
    private int contentWidth = 1100; // Ancho del contenido
    private int contentHeight = 2200; // Alto del contenido

    public MapView(Context context) {
        super(context);
        init();
    }

    public MapView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.GRAY);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(20);

        textRoom = new Paint();
        textRoom.setColor(Color.RED);
        textRoom.setTextSize(50);
        textRoom.setAntiAlias(true);

        textPatios = new Paint();
        textPatios.setColor(Color.GREEN);
        textPatios.setTextSize(50);
        textPatios.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawMapLayout(canvas);
        drawMarkers(canvas);
        drawNameSpaces(canvas);
    }

    private void drawMapLayout(Canvas canvas) {
        canvas.drawRect(25, 100, 1050, 2160, paint); // Marco

        canvas.drawRect(25, 100, 253, 417, paint); // Baños

        canvas.drawRect(253, 417, 684, 734, paint); // Sala 7
        canvas.drawRect(25, 417, 253, 1051, paint); // Sala 6
        canvas.drawRect(253, 1209, 684, 1526, paint); // Sala 5
        canvas.drawRect(25, 1209, 253, 1526, paint); // Sala 4
        canvas.drawRect(25, 1526, 253, 1843, paint); // Sala 3
        canvas.drawRect(25, 1843, 253, 2160, paint); // Sala 2
        canvas.drawRect(253, 1843, 684, 2160, paint); // Sala 1

        canvas.drawRect(797, 100, 1050, 417, paint); // Baños
        canvas.drawRect(797, 417, 1050, 734, paint); // Administrativo
        canvas.drawRect(797, 734, 1050, 1209, paint); // Espacio libre
        canvas.drawRect(797, 1209, 1050, 1526, paint); // Sala 8
        canvas.drawRect(797, 1526, 1050, 1843, paint); // Sala 9
        canvas.drawRect(797, 1843, 1050, 2160, paint); // Sala 10
    }

    private void drawMarkers(Canvas canvas) {
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(456, 2060, 10, paint); // Marker for Sala 1
    }

    private void drawNameSpaces(Canvas canvas) {
        drawRoom(canvas);
        drawPatiosAndBathroom(canvas);
        drawEntrance(canvas);
    }

    private void drawRoom(Canvas canvas){
        float[][] roomCenters = {
                {410, 2020.5f}, // Sala 1
                {74, 2020.5f}, // Sala 2
                {74, 1707}, // Sala 3
                {74, 1390}, // Sala 4
                {410, 1390}, // Sala 5
                {74, 734}, // Sala 6
                {410, 575.5f}, // Sala 7
                {860, 1390}, // Sala 8
                {860, 1707}, // Sala 9
                {860, 2020.5f}  // Sala 10
        };
        int aux = 1;
        for(float [] array : roomCenters){
            canvas.drawText("Sala " + (aux++), array[0], array[1], textRoom);
        }
    }

    private void drawPatiosAndBathroom(Canvas canvas){
        canvas.drawText("Patio 1", 410, 1707, textPatios);
        canvas.drawText("Patio 2", 410, 983, textPatios);
        canvas.drawText("Patio 3", 410, 278, textPatios);
        canvas.drawText("Baños", 860, 278, textPatios);
    }

    private void drawEntrance(Canvas canvas){
        canvas.save();
        canvas.rotate(270,750,2130);
        canvas.drawText("Ingreso", 750,2130, textPatios);
        canvas.restore();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(contentWidth, contentHeight);
    }
}

