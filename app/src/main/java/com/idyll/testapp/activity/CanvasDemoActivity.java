package com.idyll.testapp.activity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.idyll.testapp.R;

import java.text.NumberFormat;

/**
 * @author shibo
 * @packageName com.idyll.testapp.activity
 * @description
 * @date 15/12/25
 */
public class CanvasDemoActivity extends Activity  implements View.OnClickListener{

    private TextView tv1;
    private EditText edt2;
    private EditText edt3;
    private TextView tv4;
    private Button btn_submit;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(new CustomView1(this));
//        setContentView(R.layout.demo);
//        initUI();
//        System.out.println(" ============> " + divStr("2", "5", 2));


        setContentView(new com.idyll.testapp.view.DrawLineView(this));
    }

    private void initUI(){
        tv1 = (TextView) findViewById(R.id.tv1);
        edt2 = (EditText) findViewById(R.id.edt2);
        edt3 = (EditText) findViewById(R.id.edt3);
        tv4 = (TextView) findViewById(R.id.tv4);
        btn_submit = (Button) findViewById(R.id.btn_submit);
//        btn_submit.setOnClickListener(this);
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(" ============> ");
                String st2 = edt2.getText().toString().trim();
                String st3 = edt3.getText().toString().trim();
                System.out.println("divStr(st2, st3, 2)) ===> " + divStr(st2, st3, 2));
                if (!TextUtils.isEmpty(divStr(st2, st3, 2))) {
                    tv4.setText(divStr(st2, st3, 2));
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.edt2:
                break;
            case R.id.edt3:
                break;
            case R.id.btn_submit:
                System.out.println(" ============ ");
                String st2 = edt2.getText().toString().trim();
                String st3 = edt3.getText().toString().trim();
                System.out.println("divStr(st2, st3, 2)) == " + divStr(st2, st3, 2));
                if (!TextUtils.isEmpty(divStr(st2, st3, 2))) {
                    tv4.setText(divStr(st2, st3, 2));
                }
                break;
        }
    }

    public String divStr(String v1, String v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        if (TextUtils.isEmpty(v2)) {
            return "0.00%";
        }
        if (TextUtils.isEmpty(v1)) {
            return "0.00%";
        }
//        BigDecimal b1 = new BigDecimal(v1);
//        BigDecimal b2 = new BigDecimal(v2);
        Double d1 = new Double(v1);
        Double d2 = new Double(v2);
        NumberFormat nt = NumberFormat.getPercentInstance();
        nt.setMinimumFractionDigits(2);
//        return (b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP)).doubleValue() * 100 + "%";
        return  nt.format(d1/d2);
    }

    class CustomView1 extends View {

        Paint paint;

        public CustomView1(Context context) {
            super(context);
            //设置画笔
            paint = new Paint();
            paint.setColor(Color.RED);
            paint.setStrokeJoin(Paint.Join.ROUND);
            paint.setStrokeCap(Paint.Cap.ROUND);
            paint.setStrokeWidth(3);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            //绘制圆
//            canvas.drawCircle(100, 100, 90, paint);
            //绘制弧线区域

//            RectF rect = new RectF(0, 0, 200, 200);
//            canvas.drawArc(rect, //弧线使用的矩形区域大小
//                    0, //开始角度
//                    90, //扫过的角度
////                    false, //是否使用中心
//                    true, //是否使用中心
//                    paint);

            //直接填充color
//            canvas.drawColor(Color.BLUE);

            //画一条直线
//            canvas.drawLine(10, 10, 100, 100, paint);

//            //绘制椭圆
//            //定义一个矩形区域
//            RectF rectF = new RectF(0, 0, 200, 300);
//            //矩形区域内切椭圆
//            canvas.drawOval(rectF, paint);

//            //按照既定点 绘制文本内容
//            canvas.drawPosText("SponiaTest", new float[] {
//                    10, 10, //第一个字母坐标
//                    20, 20,
//                    30, 30,
//                    40, 40,
//                    50, 50,
//                    60, 60,
//                    70, 70,
//                    80, 80,
//                    90, 90,
//                    100, 100
//            }, paint);

//            //绘制矩形区域
//            RectF rectF = new RectF(50, 50, 200, 200);
//            canvas.drawRect(rectF, paint);

            //绘制圆角矩形
//            RectF rectF = new RectF(50, 50, 200, 200);
//            canvas.drawRoundRect(rectF,
//                    30, //x轴半径
//                    30, //y轴半径
//                    paint
//            );

            //绘制自定义路径
//            Path path = new Path();
//            path.moveTo(10, 10); //移动到坐标10 10
//            path.lineTo(50, 60);
//            path.lineTo(200, 80);x`
//            path.lineTo(10, 10);
//            canvas.drawPath(path, paint);


//            Path path = new Path();
//            path.moveTo(10, 10);
//            path.lineTo(50, 60);
//            path.lineTo(200, 80);
//            path.lineTo(10, 10);
//            canvas.drawTextOnPath("Sponia ANDROID", path, 10, 10, paint);


            //绘制转换盘
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            //将位置移动画纸的坐标点 150 150
            canvas.translate(canvas.getWidth() / 2, 300);
            //画圆圈
            canvas.drawCircle(0, 0, 100, paint);
            //使用path绘制路径文字
            canvas.save();
            canvas.translate(-75, -75);
            Path path = new Path();
            path.addArc(new RectF(0, 0, 150, 150), -180, 180);
            Paint citePaint = new Paint(paint);
            citePaint.setTextSize(14);
            citePaint.setStrokeWidth(1);
            canvas.drawTextOnPath("http://www.com", path, 28, 0, citePaint);
            canvas.restore();

            //小刻度画笔对象
            Paint tmpPaint = new Paint(paint);
            tmpPaint.setStrokeWidth(1);

            float y = 100;
            //总刻度值
            int count = 60;

            for (int i = 0; i < count; i++) {
                if (i % 5 == 0) {
                    canvas.drawLine(0f, y, 0, y + 12f, paint);
                    canvas.drawText(String.valueOf(i/5 + 1), -4f, y + 25f, tmpPaint);
                } else {
                    canvas.drawLine(0f, y, 0f, y + 5f, tmpPaint);
                }
                //旋转画纸
                canvas.rotate(360/count, 0f, 0f);
            }
            //绘制指针
            tmpPaint.setColor(Color.GRAY);
            tmpPaint.setStrokeWidth(4);
            canvas.drawCircle(0, 0, 7, tmpPaint);
            tmpPaint.setStyle(Paint.Style.FILL);
            tmpPaint.setColor(Color.YELLOW);
            canvas.drawCircle(0, 0, 5, tmpPaint);
            canvas.drawLine(0, 10, 0, -65, paint);
        }
    }


}
