package com.idyll.testapp.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by idyll on 16/3/2.
 */
public class LineView extends View {
        private float upX;
        private float upY;
        private float downX;
        private float downY;
        private float moveX;
        private float moveY;
        private Paint paint = null;
        //构造方法用于初始化Paint对象
        public LineView(Context context) {
            super(context);
            paint = new Paint();
            paint.setStrokeWidth(4);
            paint.setAntiAlias(true);
            paint.setColor(Color.YELLOW);
            paint.setStyle(Paint.Style.STROKE);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawLine(downX, downY, moveX, moveY, paint);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    downX = event.getX();
                    downY = event.getY();
                    invalidate();
                    break;
                case MotionEvent.ACTION_MOVE:
                    moveX = event.getX();
                    moveY = event.getY();
                    invalidate();
                    break;
                case MotionEvent.ACTION_UP:
                    upX = event.getX();
                    upY = event.getY();
                    invalidate();
                    break;
            }
            moveX = event.getX();
            moveY = event.getY();
            return true;
        }
}
