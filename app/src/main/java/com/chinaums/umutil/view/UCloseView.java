package com.chinaums.umutil.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.widget.Button;

import com.chinaums.umutil.R;

/**
 * 自定义关闭 圆形按钮.
 */

public class UCloseView extends Button {

    private Paint mPaint;
    private float cx;
    private float cy;
    private float radius;
    private float p;
    private float lineWith;
    private int remain;

    public UCloseView(Context var1) {
        super(var1);
        this.setBackgroundColor(0);
        this.mPaint = new Paint();
        this.remain = DensityUtil.dip2px(var1, 1.0F);
        this.lineWith = (float)DensityUtil.dip2px(var1, 2.0F);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.cx = (float)(this.getWidth() / 2);
        this.cy = (float)(this.getHeight() / 2);

        this.radius = (float)(Math.min(this.getHeight(), this.getWidth()) / 2 - this.remain);
        this.p = this.radius / 1.4142F;

        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(getResources().getColor(R.color.colorAccent));
        this.mPaint.setStyle(Paint.Style.FILL);
        // 先画一个圆
        canvas.drawCircle(this.cx, this.cy, this.radius, this.mPaint);
        this.mPaint.setColor(-1);
        this.mPaint.setStrokeWidth(this.lineWith);
        this.mPaint.setStyle(Paint.Style.STROKE);
        // 画的是一个空白的圆
        canvas.drawCircle(this.cx, this.cy, this.radius, this.mPaint);
        // 从左上角 到 右下角 画一条直线
        canvas.drawLine(this.cx - this.p, this.cy - this.p, this.cx + this.p, this.cy + this.p, this.mPaint);
        // 从左下角 到 右上角 画一条直线
        canvas.drawLine(this.cx + this.p, this.cy - this.p, this.cx - this.p, this.cy + this.p, this.mPaint);
    }

}
