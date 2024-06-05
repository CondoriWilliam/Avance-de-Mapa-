package com.example.mapaccunsa;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class MapView extends View {
    private Paint paint;
    private Paint textPaint;

    public MapView(Context context) {
        super(context);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(20);

        textPaint = new Paint();
        textPaint.setColor(Color.RED);
        textPaint.setTextSize(40);
        textPaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawMapLayout(canvas);
        drawMarkers(canvas);
        drawRoomNames(canvas);
    }

    private void drawMapLayout(Canvas canvas) {
        canvas.drawRect(25, 100, 1050, 2160, paint); // Marco

        canvas.drawRect(253, 417, 684, 734, paint); // Sala 7
        canvas.drawRect(25, 417, 253, 1051, paint); // Sala 6
        canvas.drawRect(25, 1209, 253, 2160, paint); // Sala 2,3,4
        canvas.drawRect(25, 1209, 684, 1526, paint); // Sala 4,5
        canvas.drawRect(25, 1843, 684, 2160, paint); // Sala 1,2
        canvas.drawRect(25, 1843, 684, 2160, paint); // Sala 1,2
        canvas.drawRect(797, 100, 797, 2160, paint); // Linea divisoria
        canvas.drawRect(797, 417, 1050, 734, paint); // Sala del personal
        canvas.drawRect(797, 1209, 1050, 1526, paint); // Sala
        canvas.drawRect(797, 1843, 1050, 2160, paint); // Sala 10
    }

    private void drawMarkers(Canvas canvas) {
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(456, 2060, 10, paint); // Marker for Sala 1
        canvas.drawCircle(450, 225, 10, paint); // Marker for Sala 2
    }

    private void drawRoomNames(Canvas canvas) {
        float[][] roomCenters = {
                {354.5f, 2091.5f}, // Sala 1
                {110, 1684.5f}, // Sala 3
                {354.5f, 1367.5f}, // Sala 4
                {110, 734}, // Sala 6
                {468.5f, 575.5f}, // Sala 7
                {923.5f, 1367.5f}, // Sala 8
                {110, 2091.5f}, // Sala 9
                {923.5f, 2001.5f}  // Sala 10
        };

        // Escribir los nombres de las salas
        for (int i = 0; i < roomCenters.length; i++) {
            canvas.drawText("Sala " + (i + 1), roomCenters[i][0], roomCenters[i][1], textPaint);
        }
    }
}

