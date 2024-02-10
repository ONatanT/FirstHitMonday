package com.example.firsthitmonday;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;

public class CircleImageView extends androidx.appcompat.widget.AppCompatImageView{

        public static float radius = 18.0f;
        public static float margin = 0.0f;

        public CircleImageView(Context context) {
            super(context);
        }

        public CircleImageView(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        public CircleImageView(Context context, AttributeSet attrs, int defStyle) {
            super(context, attrs, defStyle);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            Path clipPath = new Path();
            RectF rect = new RectF(margin, margin, this.getWidth()-margin, this.getHeight()-margin);
            clipPath.addRoundRect(rect, radius, radius, Path.Direction.CW);
            canvas.clipPath(clipPath);
            super.onDraw(canvas);
        }
}
