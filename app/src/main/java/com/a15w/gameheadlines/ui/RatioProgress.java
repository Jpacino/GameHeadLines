package com.a15w.gameheadlines.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.a15w.gameheadlines.R;

/**
 * Created by Jpacino on 2016/9/9.
 */
class RatioProgress extends View {

    // Sizes (with defaults)
    private int layout_height = 0;

    private int layout_width = 0;

    // Colors (with defaults)
    private int bgColor = Color.TRANSPARENT;

    //private int progressColor = 0xFF339933;

    // Paints
    private Paint progressPaint = new Paint();

    private Paint bgPaint = new Paint();

    // Rectangles
    private RectF rectBgBounds = new RectF();

    private RectF rectProgressBounds = new RectF();

    int progress = 0;

    boolean isProgress;

    private String direction;

    /**
     * progress的颜色
     */
    private int progressColor;

    boolean running;

    int sleepDelay;


    public int getSleepDelay() {
        return sleepDelay;
    }

    public void setSleepDelay(int sleepDelay) {
        this.sleepDelay = sleepDelay;
    }

    private Handler spinHandler = new Handler() {
        /**
         * This is the code that will increment the progress variable and so
         * spin the wheel
         */
        @Override
        public void handleMessage(Message msg) {
            invalidate();
        }
    };

    /**
     * @param context
     */
    public RatioProgress(Context context) {
        this(context, null);
    }

    /**
     * @param context
     * @param attrs
     */
    public RatioProgress(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public RatioProgress(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        /**
         * 获得我们所定义的自定义样式属性
         */
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.RatioProgress, defStyleAttr, 0);
        int n = a.getIndexCount();
        for (int i = 0; i < n; i++)
        {
            int attr = a.getIndex(i);
            switch (attr)
            {
                case R.styleable.RatioProgress_direction:
                    direction = a.getString(attr);

                    break;
                case R.styleable.RatioProgress_progressColor:
                    progressColor = a.getColor(attr, Color.TRANSPARENT);
                    break;
            }

        }
        a.recycle();

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        // Share the dimensions
        layout_width = w;
        Log.i("layout_width", layout_width + "");

        layout_height = h;
        Log.i("layout_height", layout_height + "");
        setupBounds();
        setupPaints();
        invalidate();

    }

    private void setupPaints() {
        bgPaint.setColor(bgColor);
        bgPaint.setAntiAlias(true);
        bgPaint.setStyle(Paint.Style.FILL);

        progressPaint.setColor(progressColor);
        progressPaint.setAntiAlias(true);
        progressPaint.setStyle(Paint.Style.FILL);

    }

    private void setupBounds() {
        int width = getWidth(); // this.getLayoutParams().width;
        Log.i("width", width + "");
        int height = getHeight(); // this.getLayoutParams().height;
        Log.i("height", height + "");
        rectBgBounds = new RectF(0, 0, width, height);
        start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawRect(rectBgBounds, bgPaint);

        Log.i("progress", progress + "");
        if (TextUtils.equals(direction, "left")) {
            rectProgressBounds = new RectF(0, 0, progress, layout_height);
        } else if (TextUtils.equals(direction, "right")) {
            rectProgressBounds = new RectF(getWidth() - progress, 0, getWidth(), layout_height);
        }else{
            rectProgressBounds = new RectF(0, 0, progress, layout_height);
        }
        canvas.drawRect(rectProgressBounds, progressPaint);

    }

    /**
     * Increment the progress by 1 (of 100)
     */
    public void incrementProgress() {
        isProgress = true;
        progress++;
        /*
         * if (progress > 200) progress = 100;
         */
        spinHandler.sendEmptyMessage(0);
    }

    /**
     * Increment the progress by 1 (of 100)
     */
    public void unIncrementProgress() {
        isProgress = true;
        progress--;
        /*
         * if (progress < 1) progress = 100;
         */
        spinHandler.sendEmptyMessage(0);
    }

    /**
     * Set the progress to a specific value
     */
    public void setProgress(int i) {

        progress = i;
        spinHandler.sendEmptyMessage(0);
    }

    final Runnable r = new Runnable() {
        public void run() {
            running = true;
            Log.e("thread", "progress="+progress);
            Log.e("thread", "getWidth()="+getWidth());
            while (progress < getWidth()) {
                incrementProgress();
                //progress++;
                try {
                    Thread.sleep(sleepDelay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            running = false;
        }
    };

    public void start(){
        if (!running) {
            progress = 0;
            Thread s = new Thread(r);
            s.start();
        }
    }
}
