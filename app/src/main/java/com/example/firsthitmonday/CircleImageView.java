package com.example.firsthitmonday;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;

public class CircleImageView extends androidx.appcompat.widget.AppCompatImageView {

    public CircleImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Path path = new Path();
        int width = this.getWidth();
        int height = this.getHeight();
        path.addOval(new RectF(0, 0, width, height), Path.Direction.CW);
        canvas.clipPath(path);
        super.onDraw(canvas);
    }
}