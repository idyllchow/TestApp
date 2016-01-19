package com.sponia.idyll.testapp.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.sponia.idyll.testapp.utils.LogUtil;

/**
 * @author shibo
 * @packageName com.sponia.idyll.testapp.view
 * @description
 * @date 16/1/15
 */
public class DrawLineView extends View {

    private Paint paint;
    private float mX;
    private float mY;
    private TextView tv;

    private final Paint mGesturePaint = new Paint();
    private final Path mPath = new Path();

    public DrawLineView(Context context) {
        super(context);
        init();
    }

    public DrawLineView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DrawLineView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

//        paint = new Paint();
//        paint.setColor(Color.RED);
//        paint.setStrokeJoin(Paint.Join.ROUND);
//        paint.setStrokeCap(Paint.Cap.ROUND);
//        paint.setStrokeWidth(3);


        mGesturePaint.setAntiAlias(true);
        mGesturePaint.setStyle(Paint.Style.STROKE);
        mGesturePaint.setStrokeWidth(35);
        mGesturePaint.setColor(Color.RED);
    }

    int x;
    int y;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
//        int action = event.getAction();
//        if (action != MotionEvent.ACTION_DOWN) {
//            return super.onTouchEvent(event);
//        }
//
//        x = (int) event.getX();
//        y = (int) event.getY();
//        LogUtil.defaultLog("----x--->" + x + "-----y---->" + y);
//        invalidate();

        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                touchDown(event);
                break;
            case MotionEvent.ACTION_MOVE:
                touchMove(event);
        }
        //更新绘制
        invalidate();

        return true;
    }

    //手指点下屏幕时调用
    private void touchDown(MotionEvent event)
    {

        //mPath.rewind();
        //重置绘制路线，即隐藏之前绘制的轨迹
        mPath.reset();
        float x = event.getX();
        float y = event.getY();

        mX = x;
        mY = y;
        //mPath绘制的绘制起点
        mPath.moveTo(x, y);
    }

    float index;
    //手指在屏幕上滑动时调用
    private void touchMove(MotionEvent event)
    {
        final float x = event.getX();
        final float y = event.getY();

        final float previousX = mX;
        final float previousY = mY;

        final float dx = Math.abs(x - previousX);
        final float dy = Math.abs(y - previousY);

        //两点之间的距离大于等于3时，生成贝塞尔绘制曲线
        if (dx >= 3 || dy >= 3)
        {
            //设置贝塞尔曲线的操作点为起点和终点的一半
            float cX = (x + previousX) / 2;
            float cY = (y + previousY) / 2;

            //二次贝塞尔，实现平滑曲线；previousX, previousY为操作点，cX, cY为终点
//            mPath.quadTo(previousX, previousY, cX, cY);
//            mPath.quadTo(previousX, 100, cX, 100);
            if (Math.abs(previousY + 1) < Math.abs(previousY + 100)) {
                index = previousY + 1;
                mPath.quadTo(100, previousY, 100, previousY + 1);

            }

            //第二次执行时，第一次结束调用的坐标值将作为第二次调用的初始坐标值
            mX = x;
            mY = y;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        canvas.drawLine(10, 10, 500, 500, paint);
        LogUtil.defaultLog("-------onDraw------");
        canvas.drawPath(mPath, mGesturePaint);

        canvas.restore();
    }
}
