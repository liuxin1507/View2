package com.bwei.com.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Lenovo on 2017/10/8.
 */

public class CustomView extends View {
    //初始状态圆心坐标
    private PointF startPoint = new PointF(50, 100);
    private PointF endPoint = new PointF(300, 300);


    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //创建画笔
        Paint p = new Paint();
        //设置颜色
        p.setColor(Color.RED);
        //设置实心
        p.setStyle(Paint.Style.FILL);
        //设置画笔的锯齿效果
        p.setAntiAlias(true);

        //1.前两个圆心坐标,半径
        canvas.drawCircle(100, 100, 50, p);
        //7.文本和图片
       /* canvas.drawText("自定义文本",250,300,p);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);
        canvas.drawBitmap(bitmap,250,360,p);*/
    }
    @Override
     public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            //手指按下
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
            case MotionEvent.ACTION_UP:
                endPoint.x = event.getX();
                endPoint.y = event.getY();
                postInvalidate();
            break;
        }

        return true;
     }
}
